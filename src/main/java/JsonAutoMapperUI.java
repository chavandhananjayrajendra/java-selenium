import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

public class JsonAutoMapperUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JsonAutoMapperUI::createUI);
    }

    private static void createUI() {

        JFrame frame = new JFrame("Auto Map Build 65 → 66");
        frame.setSize(1300, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("Consolas", Font.PLAIN, 14);

        // 🔹 OLD JSON
        JTextArea oldJson = new JTextArea();
        oldJson.setFont(font);
        oldJson.setBackground(new Color(220, 235, 255));
        oldJson.setBorder(BorderFactory.createTitledBorder("Build 65 (Old Payload)"));

        // 🔹 NEW JSON
        JTextArea newJson = new JTextArea();
        newJson.setFont(font);
        newJson.setBackground(new Color(255, 230, 230));
        newJson.setBorder(BorderFactory.createTitledBorder("Build 66 (New Schema)"));

        // 🔹 OUTPUT
        JTextArea output = new JTextArea();
        output.setFont(font);
        output.setEditable(false);
        output.setBackground(new Color(30, 30, 30));
        output.setForeground(Color.GREEN);
        output.setBorder(BorderFactory.createTitledBorder("Mapped Output"));

        // 🔹 BUTTON
        JButton mapBtn = new JButton("Auto Map");
        mapBtn.setFont(new Font("Arial", Font.BOLD, 14));
        mapBtn.setPreferredSize(new Dimension(150, 40));

        mapBtn.addActionListener(e -> {
            try {
                ObjectMapper mapper = new ObjectMapper();

                JsonNode oldNode = mapper.readTree(oldJson.getText());
                JsonNode newNode = mapper.readTree(newJson.getText());

                JsonNode result = mapNode(oldNode, newNode);

                output.setText(
                        mapper.writerWithDefaultPrettyPrinter()
                                .writeValueAsString(result)
                );

            } catch (Exception ex) {
                output.setText("Error:\n" + ex.getMessage());
            }
        });

        // 🔹 SCROLL PANES WITH PADDING
        JScrollPane oldScroll = new JScrollPane(oldJson);
        JScrollPane newScroll = new JScrollPane(newJson);
        JScrollPane outputScroll = new JScrollPane(output);

        oldScroll.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 5));
        newScroll.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 10));
        outputScroll.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));

        // 🔹 TOP PANEL (SIDE BY SIDE)
        JSplitPane topSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, oldScroll, newScroll);
        topSplit.setDividerLocation(650);
        topSplit.setResizeWeight(0.5);
        topSplit.setBorder(null);

        // 🔹 MAIN SPLIT (TOP + OUTPUT)
        JSplitPane mainSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topSplit, outputScroll);
        mainSplit.setDividerLocation(350);
        mainSplit.setResizeWeight(0.55);
        mainSplit.setBorder(null);

        // 🔹 BUTTON PANEL (CENTERED)
        JPanel bottomPanel = new JPanel(new GridBagLayout());
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        bottomPanel.add(mapBtn);

        // 🔹 FRAME LAYOUT
        frame.setLayout(new BorderLayout());
        frame.add(mainSplit, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    // 🔥 CORE MAPPING ENGINE
    private static JsonNode mapNode(JsonNode oldNode, JsonNode newNode) {

        if (newNode.isObject()) {
            ObjectNode result = JsonNodeFactory.instance.objectNode();

            newNode.fields().forEachRemaining(entry -> {

                String newKey = entry.getKey();

                JsonNode match = findBestMatch(oldNode, newKey);

                if (match != null && match.isValueNode()) {
                    result.set(newKey, match);
                }
                else if (match != null) {
                    result.set(newKey, mapNode(match, entry.getValue()));
                }
                else {
                    result.set(newKey, entry.getValue()); // keep default
                }
            });

            return result;
        }

        else if (newNode.isArray()) {

            ArrayNode result = JsonNodeFactory.instance.arrayNode();

            JsonNode oldArray = findArray(oldNode);

            if (oldArray != null && oldArray.isArray() && newNode.size() > 0) {

                JsonNode template = newNode.get(0);

                for (JsonNode item : oldArray) {
                    result.add(mapNode(item, template));
                }
            }

            return result;
        }

        return newNode;
    }

    // 🔥 SMART MATCHING (FIXED)
    private static JsonNode findBestMatch(JsonNode oldNode, String newKey) {

        if (oldNode == null || !oldNode.isObject()) return null;

        String newNorm = normalize(newKey);

        JsonNode best = null;
        int bestScore = Integer.MAX_VALUE;

        Iterator<String> fields = oldNode.fieldNames();

        while (fields.hasNext()) {
            String oldKey = fields.next();
            String oldNorm = normalize(oldKey);

            if (newNorm.equals(oldNorm)) {
                return oldNode.get(oldKey);
            }

            int dist = levenshtein(newNorm, oldNorm);

            if (dist < bestScore && dist <= 4) {
                bestScore = dist;
                best = oldNode.get(oldKey);
            }
        }

        return best;
    }

    // 🔍 FIND ARRAY
    private static JsonNode findArray(JsonNode node) {

        if (node == null) return null;

        if (node.isArray()) return node;

        if (node.isObject()) {
            for (JsonNode child : node) {
                if (child.isArray()) return child;
            }
        }

        return null;
    }

    // 🔧 NORMALIZE
    private static String normalize(String s) {
        return s.toLowerCase().replaceAll("[-_]", "");
    }

    // 🔧 LEVENSHTEIN
    private static int levenshtein(String a, String b) {

        int[][] dp = new int[a.length()+1][b.length()+1];

        for (int i=0;i<=a.length();i++) dp[i][0]=i;
        for (int j=0;j<=b.length();j++) dp[0][j]=j;

        for (int i=1;i<=a.length();i++) {
            for (int j=1;j<=b.length();j++) {

                int cost = a.charAt(i-1)==b.charAt(j-1)?0:1;

                dp[i][j] = Math.min(
                        Math.min(dp[i-1][j]+1, dp[i][j-1]+1),
                        dp[i-1][j-1]+cost
                );
            }
        }

        return dp[a.length()][b.length()];
    }
}