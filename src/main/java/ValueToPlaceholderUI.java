import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class ValueToPlaceholderUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ValueToPlaceholderUI::createUI);
    }

    private static void createUI() {

        JFrame frame = new JFrame("Value To Placeholder");
        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        Font font = new Font("Consolas", Font.PLAIN, 14);

        // 🔹 INPUT AREA
        JTextArea input = new JTextArea();
        input.setFont(font);
        input.setBackground(new Color(230, 240, 255));
        input.setBorder(
                BorderFactory.createTitledBorder("Input JSON")
        );

        // 🔹 OUTPUT AREA
        JTextArea output = new JTextArea();
        output.setFont(font);
        output.setEditable(false);
        output.setBackground(new Color(30, 30, 30));
        output.setForeground(Color.GREEN);
        output.setBorder(
                BorderFactory.createTitledBorder("Placeholder Output")
        );

        // 🔹 BUTTON
        JButton btn = new JButton("Convert To Placeholder");
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));

        btn.addActionListener(e -> {

            try {

                ObjectMapper mapper = new ObjectMapper();

                JsonNode node =
                        mapper.readTree(input.getText());

                // 🔥 Extract values
                Set<String> values =
                        new LinkedHashSet<>();

                extractValues(node, values);

                // 🔥 Popup panel
                JPanel panel = new JPanel(
                        new GridLayout(0, 4, 10, 10)
                );

                panel.add(new JLabel("Value"));
                panel.add(new JLabel("Action"));
                panel.add(new JLabel("Placeholder"));
                panel.add(new JLabel("Type"));

                Map<String, JTextField> textFields =
                        new LinkedHashMap<>();

                Map<String, JComboBox<String>> dropdowns =
                        new LinkedHashMap<>();

                for (String value : values) {

                    JLabel valueLabel =
                            new JLabel(value);

                    JComboBox<String> combo =
                            new JComboBox<>(
                                    new String[]{
                                            "Convert",
                                            "Keep"
                                    }
                            );

                    JTextField placeholderField =
                            new JTextField(15);

                    JLabel typeLabel =
                            new JLabel(
                                    detectType(value)
                            );

                    textFields.put(
                            value,
                            placeholderField
                    );

                    dropdowns.put(
                            value,
                            combo
                    );

                    panel.add(valueLabel);
                    panel.add(combo);
                    panel.add(placeholderField);
                    panel.add(typeLabel);
                }

                JScrollPane scrollPane =
                        new JScrollPane(panel);

                scrollPane.setPreferredSize(
                        new Dimension(850, 500)
                );

                int result =
                        JOptionPane.showConfirmDialog(
                                frame,
                                scrollPane,
                                "Enter Placeholder Names",
                                JOptionPane.OK_CANCEL_OPTION,
                                JOptionPane.PLAIN_MESSAGE
                        );

                if (result != JOptionPane.OK_OPTION) {
                    return;
                }

                // 🔥 Build maps
                Map<String, String> placeholderMap =
                        new LinkedHashMap<>();

                Set<String> keepValues =
                        new LinkedHashSet<>();

                Set<String> nonStringPlaceholders =
                        new LinkedHashSet<>();

                for (String actualValue :
                        textFields.keySet()) {

                    JComboBox<String> combo =
                            dropdowns.get(actualValue);

                    String action =
                            combo.getSelectedItem()
                                    .toString();

                    // 🔹 KEEP
                    if (action.equals("Keep")) {

                        keepValues.add(actualValue);

                    }

                    // 🔹 CONVERT
                    else {

                        String placeholder =
                                textFields.get(actualValue)
                                        .getText()
                                        .trim();

                        if (placeholder.isEmpty()) {

                            placeholder = "value";
                        }

                        placeholderMap.put(
                                actualValue,
                                placeholder
                        );
                        // 🔥 Store INTEGER / BOOLEAN / DECIMAL placeholders
                        String type = detectType(actualValue);

                        if (!type.equals("STRING")) {

                            nonStringPlaceholders.add(placeholder);
                        }
                    }
                }

                // 🔥 Replace values
                replaceValues(
                        node,
                        placeholderMap,
                        keepValues
                );

                String formatted =
                        mapper.writerWithDefaultPrettyPrinter()
                                .writeValueAsString(node);

                // 🔥 Restore STRING placeholders
                formatted = formatted.replace(
                        "\"__STRING__",
                        "\""
                );

                // 🔥 Remove quotes ONLY for
                // numeric / boolean placeholders
                formatted = formatted.replaceAll(
                        "\"\\{\\{(.*?)}}\"",
                        "\\{\\{$1}}"
                );

                output.setText(formatted);

            } catch (Exception ex) {

                output.setText(
                        "Error:\n" + ex.getMessage()
                );
            }
        });

        // 🔹 SPLIT
        JSplitPane split =
                new JSplitPane(
                        JSplitPane.VERTICAL_SPLIT,
                        new JScrollPane(input),
                        new JScrollPane(output)
                );

        split.setDividerLocation(320);

        frame.add(split, BorderLayout.CENTER);
        frame.add(btn, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    // 🔥 Detect datatype
    private static String detectType(String value) {

        if (value.equalsIgnoreCase("true")
                || value.equalsIgnoreCase("false")) {

            return "BOOLEAN";
        }

        try {

            Integer.parseInt(value);
            return "INTEGER";

        } catch (Exception ignored) {
        }

        try {

            Double.parseDouble(value);
            return "DECIMAL";

        } catch (Exception ignored) {
        }

        return "STRING";
    }

    // 🔥 Extract all primitive values
    private static void extractValues(
            JsonNode node,
            Set<String> values
    ) {

        if (node.isObject()) {

            node.fields().forEachRemaining(
                    entry -> extractValues(
                            entry.getValue(),
                            values
                    )
            );
        }

        else if (node.isArray()) {

            for (JsonNode item : node) {

                extractValues(item, values);
            }
        }

        else if (node.isValueNode()) {

            values.add(node.asText());
        }
    }

    // 🔥 Replace recursively
    private static void replaceValues(
            JsonNode node,
            Map<String, String> placeholderMap,
            Set<String> keepValues
    ) {

        if (node.isObject()) {

            ObjectNode obj =
                    (ObjectNode) node;

            obj.fieldNames().forEachRemaining(
                    field -> {

                        JsonNode child =
                                obj.get(field);

                        if (child.isValueNode()) {

                            String actualValue =
                                    child.asText();

                            // 🔹 KEEP ORIGINAL
                            if (keepValues.contains(
                                    actualValue
                            )) {

                                return;
                            }

                            String placeholder =
                                    placeholderMap
                                            .getOrDefault(
                                                    actualValue,
                                                    field
                                            );

                            String ph =
                                    "{{" + placeholder + "}}";

                            // 🔥 STRING
                            if (child.isTextual()) {

                                obj.put(
                                        field,
                                        "__STRING__" + ph
                                );
                            }

                            // 🔥 NUMBER / BOOLEAN
                            else {

                                obj.put(field, ph);
                            }

                        } else {

                            replaceValues(
                                    child,
                                    placeholderMap,
                                    keepValues
                            );
                        }
                    }
            );
        }

        else if (node.isArray()) {

            for (JsonNode item : node) {

                replaceValues(
                        item,
                        placeholderMap,
                        keepValues
                );
            }
        }
    }
}