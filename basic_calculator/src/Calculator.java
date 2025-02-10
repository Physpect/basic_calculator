public class Calculator {
    public double calculate(double num1, double num2, String operator) {
        switch (operator) {
            case "+": return num1 + num2;
            case "-": return num1 - num2;
            case "*": return num1 * num2;
            case "/": return num2 != 0 ? num1 / num2 : 0;
            case "^": return Math.pow(num1, num2);
            case "%": return num1 % num2;
            default: throw new IllegalArgumentException("Invalid operator");
        }
    }

    public double sqrt(double num) {
        return Math.sqrt(num);
    }
}