import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounterApp extends JFrame {
    private JTextArea textArea;
    private JButton countButton;
    private JLabel wordCountLabel;

    public WordCounterApp() {
        setTitle("Word Counter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        textArea = new JTextArea();
        countButton = new JButton("Count Words");
        wordCountLabel = new JLabel("Word Count: 0");

        // Set layout and add components
        setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(countButton, BorderLayout.CENTER);
        bottomPanel.add(wordCountLabel, BorderLayout.SOUTH);
        add(bottomPanel, BorderLayout.SOUTH);

        // Add action listener to the button
        countButton.addActionListener(new CountButtonListener());
    }

    private class CountButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String text = textArea.getText();
            int wordCount = countWords(text);
            wordCountLabel.setText("Word Count: " + wordCount);
        }

        private int countWords(String text) {
            if (text == null || text.isEmpty()) {
                return 0;
            }
            String[] words = text.trim().split("\\s+");
            return words.length;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WordCounterApp app = new WordCounterApp();
            app.setVisible(true);
        });
    }
}
