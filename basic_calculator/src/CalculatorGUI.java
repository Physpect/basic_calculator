import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame implements ActionListener {
    private JTextField display;
    private Calculator calculator;
    private String operator;
    private double num1, num2;

    public CalculatorGUI() {
        calculator = new Calculator();
        operator = "";
        num1 = num2 = 0;

        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE); // Arka plan beyaz yapılmıştır
        setContentPane(panel);

        display = new JTextField();
        display.setEditable(false);
        panel.add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4));

        String[] buttons = { "C", "√", "^", "%", "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+" };
        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        panel.add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.matches("\\d") || command.equals(".")) {
            display.setText(display.getText() + command);
        } else if (command.equals("C")) {
            display.setText("");
            num1 = num2 = 0;
            operator = "";
        } else if (command.equals("√")) {
            num1 = Double.parseDouble(display.getText());
            display.setText(String.valueOf(calculator.sqrt(num1)));
        } else if (command.equals("=")) {
            num2 = Double.parseDouble(display.getText());
            display.setText(String.valueOf(calculator.calculate(num1, num2, operator)));
        } else {
            num1 = Double.parseDouble(display.getText());
            operator = command;
            display.setText("");
        }
    }

    class Calculator {
        public double sqrt(double num) {
            return Math.sqrt(num);
        }

        public double calculate(double num1, double num2, String operator) {
            switch (operator) {
                case "+":
                    return num1 + num2;
                case "-":
                    return num1 - num2;
                case "*":
                    return num1 * num2;
                case "/":
                    if (num2 != 0) {
                        return num1 / num2;
                    } else {
                        return 0;
                    }
                case "^":
                    return Math.pow(num1, num2);
                case "%":
                    return num1 % num2;
                default:
                    return 0;
            }
        }
    }
}
