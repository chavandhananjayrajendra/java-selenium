import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AutoJsonPayloadConverter {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AutoJsonPayloadConverter::createUI);
    }

    private static void createUI() {
        JFrame frame = new JFrame("Auto JSON Payload Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);

        JTextArea inputArea = new JTextArea();
        inputArea.setLineWrap(true);

        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);

        JButton convertButton = new JButton("Convert");

        convertButton.addActionListener(e -> {
            try {
                String inputJson = inputArea.getText();

                // ✅ Supports {key} AND {{key}}
                Pattern pattern = Pattern.compile("\\{\\{?(\\w+)\\}\\}?");
                Matcher matcher = pattern.matcher(inputJson);

                Map<String, String> values = new LinkedHashMap<>();

                // Collect placeholders
                while (matcher.find()) {
                    values.putIfAbsent(matcher.group(1), "");
                }

                // Input dialog
                if (!values.isEmpty()) {
                    JPanel panel = new JPanel(new GridLayout(values.size(), 2));
                    Map<String, JTextField> fields = new LinkedHashMap<>();

                    for (String key : values.keySet()) {
                        panel.add(new JLabel(key + ":"));
                        JTextField field = new JTextField(15);
                        fields.put(key, field);
                        panel.add(field);
                    }

                    int result = JOptionPane.showConfirmDialog(frame, panel,
                            "Enter values", JOptionPane.OK_CANCEL_OPTION);

                    if (result == JOptionPane.OK_OPTION) {
                        for (Map.Entry<String, JTextField> entry : fields.entrySet()) {
                            values.put(entry.getKey(), entry.getValue().getText());
                        }
                    }
                }

                // Replace placeholders
                matcher = pattern.matcher(inputJson);
                StringBuffer sb = new StringBuffer();

                while (matcher.find()) {
                    String key = matcher.group(1);
                    String replacement = values.getOrDefault(key, "UNKNOWN");

                    int start = matcher.start();
                    int end = matcher.end();

                    // Check if inside quotes
                    boolean insideQuotes =
                            start > 0 &&
                                    end < inputJson.length() &&
                                    inputJson.charAt(start - 1) == '"' &&
                                    inputJson.charAt(end) == '"';

                    String replacementStr;

                    if (insideQuotes) {
                        replacementStr = replacement;
                    } else {
                        // Detect number
                        if (replacement.matches("-?\\d+")) {
                            replacementStr = replacement;
                        } else if (replacement.matches("-?\\d+\\.\\d+")) {
                            replacementStr = replacement;
                        } else if (replacement.equalsIgnoreCase("true") || replacement.equalsIgnoreCase("false")) {
                            replacementStr = replacement.toLowerCase();
                        } else {
                            replacementStr = "\"" + replacement + "\"";
                        }
                    }

                    matcher.appendReplacement(sb, Matcher.quoteReplacement(replacementStr));
                }
                matcher.appendTail(sb);

                String replacedJson = sb.toString();
                System.out.println("Replaced JSON: " + replacedJson);

                ObjectMapper mapper = new ObjectMapper();
                JsonNode node = mapper.readTree(replacedJson);

                String formatted = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(node);
                outputArea.setText(formatted);

            } catch (Exception ex) {
                outputArea.setText("Error: " + ex.getMessage());
            }
        });

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                new JScrollPane(inputArea),
                new JScrollPane(outputArea));

        splitPane.setDividerLocation(250);

        frame.add(splitPane, BorderLayout.CENTER);
        frame.add(convertButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}