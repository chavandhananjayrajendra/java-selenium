import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JsonKeyComparatorUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JsonKeyComparatorUI::createUI);
    }
    private static void createUI() {

        JFrame frame = new JFrame("JSON Key Comparator");
        frame.setSize(1100, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        Font font = new Font("Consolas", Font.PLAIN, 14);

        // 🔹 JSON 1
        JTextArea json1 = new JTextArea();
        json1.setFont(font);
        json1.setBackground(new Color(230, 240, 255));
        json1.setBorder(BorderFactory.createTitledBorder("Old JSON (Build 65)"));

        // 🔹 JSON 2
        JTextArea json2 = new JTextArea();
        json2.setFont(font);
        json2.setBackground(new Color(255, 235, 235));
        json2.setBorder(BorderFactory.createTitledBorder("New JSON (Build 66)"));

        // 🔹 RESULT
        JTextArea result = new JTextArea();
        result.setFont(font);
        result.setEditable(false);
        result.setBackground(new Color(30, 30, 30));
        result.setForeground(new Color(0, 255, 120));
        result.setBorder(BorderFactory.createTitledBorder("Comparison Result"));

        // 🔹 BUTTON
        JButton compareBtn = new JButton("Compare Keys");
        compareBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        compareBtn.setBackground(new Color(52, 152, 219));
        compareBtn.setForeground(Color.WHITE);
        compareBtn.setFocusPainted(false);
        compareBtn.setPreferredSize(new Dimension(160, 40));

        // Hover effect
        compareBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                compareBtn.setBackground(new Color(41, 128, 185));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                compareBtn.setBackground(new Color(52, 152, 219));
            }
        });

        compareBtn.addActionListener(e -> {
            try {
                ObjectMapper mapper = new ObjectMapper();

                JsonNode node1 = mapper.readTree(json1.getText());
                JsonNode node2 = mapper.readTree(json2.getText());

                Set<String> keys1 = new HashSet<>();
                Set<String> keys2 = new HashSet<>();

                extractKeys("", node1, keys1);
                extractKeys("", node2, keys2);

                StringBuilder output = new StringBuilder();

                Set<String> removed = new HashSet<>(keys1);
                removed.removeAll(keys2);

                Set<String> added = new HashSet<>(keys2);
                added.removeAll(keys1);

                List<String> renameHints = detectRenames(removed, added);

                if (added.isEmpty() && removed.isEmpty()) {
                    output.append("✅ No key changes\n");
                }

                if (!added.isEmpty()) {
                    output.append("\n🟢 Added Keys:\n");
                    added.forEach(k -> output.append("  + ").append(k).append("\n"));
                }

                if (!removed.isEmpty()) {
                    output.append("\n🔴 Removed Keys:\n");
                    removed.forEach(k -> output.append("  - ").append(k).append("\n"));
                }

                if (!renameHints.isEmpty()) {
                    output.append("\n🟡 Possible Renamed Keys:\n");
                    renameHints.forEach(r -> output.append("  ").append(r).append("\n"));
                }

                result.setText(output.toString());

            } catch (Exception ex) {
                result.setText("Error:\n" + ex.getMessage());
            }
        });

        // 🔹 SCROLL PANES
        JScrollPane scroll1 = new JScrollPane(json1);
        JScrollPane scroll2 = new JScrollPane(json2);
        JScrollPane scroll3 = new JScrollPane(result);

        scroll1.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 5));
        scroll2.setBorder(BorderFactory.createEmptyBorder(10, 5, 5, 10));
        scroll3.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));

        // 🔹 SPLIT PANELS
        JSplitPane topSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scroll1, scroll2);
        topSplit.setDividerLocation(550);
        topSplit.setResizeWeight(0.5);
        topSplit.setDividerSize(6);
        topSplit.setBorder(null);

        JSplitPane mainSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topSplit, scroll3);
        mainSplit.setDividerLocation(350);
        mainSplit.setResizeWeight(0.5);
        mainSplit.setDividerSize(6);
        mainSplit.setBorder(null);

        // 🔹 BUTTON PANEL
        JPanel bottomPanel = new JPanel(new GridBagLayout());
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 10, 0));
        bottomPanel.add(compareBtn);

        frame.setLayout(new BorderLayout());
        frame.add(mainSplit, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
    // 🔹 Extract full key paths
    private static void extractKeys(String path, JsonNode node, Set<String> keys) {
        if (node.isObject()) {
            node.fieldNames().forEachRemaining(field -> {
                String newPath = path + "/" + field;
                keys.add(newPath);
                extractKeys(newPath, node.get(field), keys);
            });
        } else if (node.isArray()) {
            for (JsonNode item : node) {
                extractKeys(path + "[]", item, keys);
            }
        }
    }

    // 🔹 Detect rename using similarity
    private static List<String> detectRenames(Set<String> removed, Set<String> added) {
        List<String> result = new ArrayList<>();

        for (String r : removed) {
            for (String a : added) {
                if (similar(r, a)) {
                    result.add(r + "  →  " + a);
                }
            }
        }
        return result;
    }

    // 🔹 Simple similarity logic (can improve later)
    private static boolean similar(String a, String b) {
        String x = a.toLowerCase();
        String y = b.toLowerCase();

        return x.contains(y) || y.contains(x) || levenshtein(x, y) <= 3;
    }

    // 🔹 Levenshtein distance (for typo detection)
    private static int levenshtein(String a, String b) {
        int[][] dp = new int[a.length()+1][b.length()+1];

        for (int i = 0; i <= a.length(); i++) dp[i][0] = i;
        for (int j = 0; j <= b.length(); j++) dp[0][j] = j;

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                int cost = a.charAt(i-1) == b.charAt(j-1) ? 0 : 1;

                dp[i][j] = Math.min(
                        Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1),
                        dp[i-1][j-1] + cost
                );
            }
        }
        return dp[a.length()][b.length()];
    }
}