import javax.swing.*;
import java.awt.*;

public class JsonToolLauncher {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JsonToolLauncher::createUI);
    }

    private static void createUI() {

        JFrame frame = new JFrame("JSON Utility Tool");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // 🔹 Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(245, 247, 250));
        mainPanel.setLayout(new BorderLayout(10, 10));

        // 🔹 Title
        JLabel title = new JLabel("Select any tool", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));

        // 🔹 Buttons panel
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 15, 15));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 80, 20, 80));
        buttonPanel.setBackground(new Color(245, 247, 250));

        // 🔹 Buttons
        JButton btn1 = createStyledButton("Placeholder Tool");
        JButton btn2 = createStyledButton("Comparator Tool");
        JButton btn3 = createStyledButton("Auto Mapper");
        JButton btn4 = createStyledButton("Value → Placeholder");

        // 🔥 Actions (NO CHANGE)
        btn1.addActionListener(e -> AutoJsonPayloadConverter.main(new String[]{}));
        btn2.addActionListener(e -> JsonKeyComparatorUI.main(new String[]{}));
        btn3.addActionListener(e -> JsonAutoMapperUI.main(new String[]{}));
        btn4.addActionListener(e -> ValueToPlaceholderUI.main(new String[]{}));

        buttonPanel.add(btn1);
        buttonPanel.add(btn2);
        buttonPanel.add(btn3);
        buttonPanel.add(btn4);

        mainPanel.add(title, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    // 🔥 Styled Button
    private static JButton createStyledButton(String text) {

        JButton btn = new JButton(text);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setBackground(new Color(52, 152, 219));
        btn.setForeground(Color.WHITE);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 🔹 Hover effect
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(new Color(41, 128, 185));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBackground(new Color(52, 152, 219));
            }
        });

        return btn;
    }
}