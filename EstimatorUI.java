// This is the Estimator, which will be used to print the user's estimated pay 
// check with information provided by the user.
package practice.work;
import javax.swing.*;
import java.awt.*;

public class EstimatorUI extends JFrame {
    private final JTextField hoursField;
    private final JTextField payRateField;
    private final JTextArea resultArea;

    public EstimatorUI() {
        setTitle("Paycheck Estimator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(new JLabel("Hours Worked:"));
        hoursField = new JTextField();
        inputPanel.add(hoursField);

        inputPanel.add(new JLabel("Hourly Pay Rate:"));
        payRateField = new JTextField();
        inputPanel.add(payRateField);

        JButton calculateButton = new JButton("Calculate Paycheck");
        calculateButton.addActionListener(e -> calculatePaycheck());
        inputPanel.add(new JLabel()); // Empty cell
        inputPanel.add(calculateButton);

        add(inputPanel, BorderLayout.NORTH);

        // Results Panel
        resultArea = new JTextArea(12, 30);
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Paycheck Details"));
        add(scrollPane, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null); // Center on screen
    }

    private void calculatePaycheck() {
        try {
            double hours = Double.parseDouble(hoursField.getText());
            double payRate = Double.parseDouble(payRateField.getText());

            if (hours < 0 || payRate < 0) {
                JOptionPane.showMessageDialog(this,
                        "Please enter positive numbers only.",
                        "Invalid Input",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Use your existing Taxes class
            StringBuilder results = getResults(hours, payRate);

            resultArea.setText(results.toString());

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter valid numbers.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private static StringBuilder getResults(double hours, double payRate) {
        Taxes taxes = new Taxes(hours, payRate);

        // Format the results
        StringBuilder results = new StringBuilder();
        results.append("----------------\n");
        results.append(String.format("Hours Worked: %.2f\n", hours));
        results.append(String.format("Pay Rate: $%.2f\n", payRate));
        results.append("----------------\n\n");
        results.append(String.format("Gross Pay: $%.2f\n", taxes.getCheck()));
        results.append(String.format("Federal Tax: $%.2f\n", taxes.getFedTax()));
        results.append(String.format("State Tax: $%.2f\n", taxes.getStateTax()));
        results.append(String.format("Social Security: $%.2f\n", taxes.getSS()));
        results.append(String.format("Medicare: $%.2f\n", taxes.getMedicare()));
        results.append(String.format("Total Deductions: $%.2f\n", taxes.getDeductions()));
        results.append("----------------\n");
        results.append(String.format("Net Pay: $%.2f\n", taxes.getCheck() - taxes.getDeductions()));
        return results;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EstimatorUI().setVisible(true);
        });
    }
}