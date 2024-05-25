import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.util.Stack;

public class Calculator implements ActionListener {

    JLabel displayLabel;
    RoundedButton btnSeven, btnEight, btnNine, btnFour, btnFive, btnSix;
    RoundedButton btnOne, btnTwo, btnThree, btnClear, btnDot, btnZero;
    RoundedButton btnEqual, btnDivision, btnAdd, btnSubtraction, btnMultiplication;

    Calculator() {
        labelFunction();
        buttonsFunction();
        frameFunction();
    }

    // Frame Function
    void frameFunction() {
        // Set Frame
        JFrame jf = new JFrame("Calculator");
        jf.setLayout(null);
        jf.setSize(520, 500);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
        jf.getContentPane().setBackground(Color.darkGray);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(displayLabel);
        jf.add(btnSeven);
        jf.add(btnEight);
        jf.add(btnNine);
        jf.add(btnDivision);
        jf.add(btnFour);
        jf.add(btnFive);
        jf.add(btnSix);
        jf.add(btnMultiplication);
        jf.add(btnOne);
        jf.add(btnTwo);
        jf.add(btnThree);
        jf.add(btnSubtraction);
        jf.add(btnDot);
        jf.add(btnZero);
        jf.add(btnEqual);
        jf.add(btnAdd);
        jf.add(btnClear);
    }

    // Label function
    void labelFunction() {
        // Set Label
        displayLabel = new JLabel();
        displayLabel.setBounds(30, 50, 460, 40);
        displayLabel.setBackground(Color.gray);
        displayLabel.setForeground(Color.white);
        displayLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        displayLabel.setFont(new Font("Serif", Font.BOLD, 20));
        displayLabel.setOpaque(true);
    }

    void buttonsFunction() {
        // Initialize buttons
        btnSeven = new RoundedButton("7");
        btnEight = new RoundedButton("8");
        btnNine = new RoundedButton("9");
        btnDivision = new RoundedButton("/");
        btnFour = new RoundedButton("4");
        btnFive = new RoundedButton("5");
        btnSix = new RoundedButton("6");
        btnMultiplication = new RoundedButton("x");
        btnOne = new RoundedButton("1");
        btnTwo = new RoundedButton("2");
        btnThree = new RoundedButton("3");
        btnSubtraction = new RoundedButton("-");
        btnDot = new RoundedButton(".");
        btnZero = new RoundedButton("0");
        btnEqual = new RoundedButton("=");
        btnAdd = new RoundedButton("+");
        btnClear = new RoundedButton("CLEAR");

        // Set button properties and add action listeners
        setButtonProperties(btnSeven, 30, 110);
        setButtonProperties(btnEight, 150, 110);
        setButtonProperties(btnNine, 270, 110);
        setButtonProperties(btnDivision, 390, 110);
        setButtonProperties(btnFour, 30, 170);
        setButtonProperties(btnFive, 150, 170);
        setButtonProperties(btnSix, 270, 170);
        setButtonProperties(btnMultiplication, 390, 170);
        setButtonProperties(btnOne, 30, 230);
        setButtonProperties(btnTwo, 150, 230);
        setButtonProperties(btnThree, 270, 230);
        setButtonProperties(btnSubtraction, 390, 230);
        setButtonProperties(btnDot, 30, 290);
        setButtonProperties(btnZero, 150, 290);
        setButtonProperties(btnEqual, 270, 290);
        setButtonProperties(btnAdd, 390, 290);
        setButtonProperties(btnClear, 30, 350);
    }

    void setButtonProperties(RoundedButton button, int x, int y) {
        button.addActionListener(this);
        button.setBounds(x, y, 100, 50);
        button.setBorderPainted(false);
        button.setOpaque(false);
        button.setBackground(Color.white);
        button.setFont(new Font("Arial", Font.PLAIN, 20));
    }

    // main function
    public static void main(String[] args) {
        new Calculator();
    }

    // Custom RoundedButton class
    class RoundedButton extends JButton {
        private static final long serialVersionUID = 1L;

        public RoundedButton(String label) {
            super(label);
            setContentAreaFilled(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Button background
            g2.setColor(getBackground());
            g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 30, 30));

            // Button label
            super.paintComponent(g2);
            g2.dispose();
        }

        @Override
        public void paintBorder(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getForeground());
            g2.draw(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 15, 15)); // Smaller radius for a subtle
                                                                                        // curve
            g2.dispose();
        }
    }

    // action to be performed when button pressed
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = ((JButton) e.getSource()).getText();
        if (command.equals("CLEAR")) {
            displayLabel.setText("");
        } else if (command.equals("=")) {
            try {
                String result = evaluate(displayLabel.getText());
                displayLabel.setText(result);
            } catch (Exception ex) {
                displayLabel.setText("Error");
            }
        } else {
            displayLabel.setText(displayLabel.getText() + command);
        }
    }

    // Method to evaluate the expression
    private String evaluate(String expression) {
        char[] tokens = expression.toCharArray();
        Stack<Float> values = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] >= '0' && tokens[i] <= '9' || tokens[i] == '.') {
                StringBuilder sbuf = new StringBuilder();
                while (i < tokens.length && (tokens[i] >= '0' && tokens[i] <= '9' || tokens[i] == '.')) {
                    sbuf.append(tokens[i++]);
                }
                values.push(Float.parseFloat(sbuf.toString()));
                i--;
            } else if (tokens[i] == '(') {
                ops.push(tokens[i]);
            } else if (tokens[i] == ')') {
                while (ops.peek() != '(') {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.pop();
            } else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == 'x' || tokens[i] == '/') {
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek())) {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.push(tokens[i]);
            }
        }
        while (!ops.empty()) {
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        }
        return String.valueOf(values.pop());
    }

    private boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        if ((op1 == 'x' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        }
        return true;
    }

    private float applyOp(char op, float b, float a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case 'x':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new UnsupportedOperationException("Cannot divide by zero");
                }
                return a / b;
        }
        return 0;
    }
}
