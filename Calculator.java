
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

public class Calculator implements ActionListener {

    boolean isOperatorClicked = false;
    String oldValues;
    String operator;

    JLabel displayLabel;
    RoundedButton btnSeven;
    RoundedButton btnEight;
    RoundedButton btnNine;
    RoundedButton btnFour;
    RoundedButton btnFive;
    RoundedButton btnSix;
    RoundedButton btnOne;
    RoundedButton btnTwo;
    RoundedButton btnThree;
    RoundedButton btnClear;
    RoundedButton btnDot;
    RoundedButton btnZero;
    RoundedButton btnEqual;
    RoundedButton btnDivision;
    RoundedButton btnAdd;
    RoundedButton btnSubstraction;
    RoundedButton btnMultiplication;

    Calculator() {
        lableFunction();
        buttonsFunction();
        frameFunction();
    }

    // Frame Function
    void frameFunction() {
        // set Frame
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
        jf.add(btnSubstraction);
        jf.add(btnDot);
        jf.add(btnZero);
        jf.add(btnEqual);
        jf.add(btnAdd);
        jf.add(btnClear);
    }

    // Lable function
    void lableFunction() {
        // set Label
        displayLabel = new JLabel();
        displayLabel.setBounds(30, 50, 460, 40);
        displayLabel.setBackground(Color.gray);
        displayLabel.setForeground(Color.white);
        displayLabel.setHorizontalAlignment(SwingConstants.RIGHT);  
        displayLabel.setFont(new Font("Serif", Font.BOLD, 20));
        displayLabel.setOpaque(true);
    }

    void buttonsFunction() {
        // Set 7 Button
        btnSeven = new RoundedButton("7");
        btnSeven.addActionListener(this);
        btnSeven.setBounds(30, 110, 100, 50);
        btnSeven.setBorderPainted(false);
        btnSeven.setOpaque(false);
        btnSeven.setBackground(Color.white);
        btnSeven.setFont(new Font("Arial", Font.PLAIN, 20));

        // Set 8 Button
        btnEight = new RoundedButton("8");
        btnEight.addActionListener(this);
        btnEight.setBounds(150, 110, 100, 50);
        btnEight.setBorderPainted(false);
        btnEight.setOpaque(false);
        btnEight.setBackground(Color.white);
        btnEight.setFont(new Font("Arial", Font.PLAIN, 20));

        // Set 9 Button
        btnNine = new RoundedButton("9");
        btnNine.addActionListener(this);
        btnNine.setBounds(270, 110, 100, 50);
        btnNine.setBorderPainted(false);
        btnNine.setOpaque(false);
        btnNine.setBackground(Color.white);
        btnNine.setFont(new Font("Arial", Font.PLAIN, 20));

        // Set division Button
        btnDivision = new RoundedButton("/");
        btnDivision.addActionListener(this);
        btnDivision.setBounds(390, 110, 100, 50);
        btnDivision.setBorderPainted(false);
        btnDivision.setOpaque(false);
        btnDivision.setBackground(Color.lightGray);
        btnDivision.setFont(new Font("Arial", Font.PLAIN, 20));

        // Set 4 Button
        btnFour = new RoundedButton("4");
        btnFour.addActionListener(this);
        btnFour.setBounds(30, 170, 100, 50);
        btnFour.setBorderPainted(false);
        btnFour.setOpaque(false);
        btnFour.setBackground(Color.white);
        btnFour.setFont(new Font("Arial", Font.PLAIN, 20));

        // Set 5 Button
        btnFive = new RoundedButton("5");
        btnFive.addActionListener(this);
        btnFive.setBounds(150, 170, 100, 50);
        btnFive.setBorderPainted(false);
        btnFive.setOpaque(false);
        btnFive.setBackground(Color.white);
        btnFive.setFont(new Font("Arial", Font.PLAIN, 20));

        // Set 6 Button
        btnSix = new RoundedButton("6");
        btnSix.addActionListener(this);
        btnSix.setBounds(270, 170, 100, 50);
        btnSix.setBorderPainted(false);
        btnSix.setOpaque(false);
        btnSix.setBackground(Color.white);
        btnSix.setFont(new Font("Arial", Font.PLAIN, 20));

        // Set Multiplication Button
        btnMultiplication = new RoundedButton("x");
        btnMultiplication.addActionListener(this);
        btnMultiplication.setBounds(390, 170, 100, 50);
        btnMultiplication.setBorderPainted(false);
        btnMultiplication.setOpaque(false);
        btnMultiplication.setBackground(Color.lightGray);
        btnMultiplication.setFont(new Font("Arial", Font.PLAIN, 20));

        // Set 1 Button
        btnOne = new RoundedButton("1");
        btnOne.addActionListener(this);
        btnOne.setBounds(30, 230, 100, 50);
        btnOne.setBorderPainted(false);
        btnOne.setOpaque(false);
        btnOne.setBackground(Color.white);
        btnOne.setFont(new Font("Arial", Font.PLAIN, 20));

        // Set 2 Button
        btnTwo = new RoundedButton("2");
        btnTwo.addActionListener(this);
        btnTwo.setBounds(150, 230, 100, 50);
        btnTwo.setBorderPainted(false);
        btnTwo.setOpaque(false);
        btnTwo.setBackground(Color.white);
        btnTwo.setFont(new Font("Arial", Font.PLAIN, 20));

        // Set 3 Button
        btnThree = new RoundedButton("3");
        btnThree.addActionListener(this);
        btnThree.setBounds(270, 230, 100, 50);
        btnThree.setBorderPainted(false);
        btnThree.setOpaque(false);
        btnThree.setBackground(Color.white);
        btnThree.setFont(new Font("Arial", Font.PLAIN, 20));

        // Set Substraction Button
        btnSubstraction = new RoundedButton("-");
        btnSubstraction.addActionListener(this);
        btnSubstraction.setBounds(390, 230, 100, 50);
        btnSubstraction.setBorderPainted(false);
        btnSubstraction.setOpaque(false);
        btnSubstraction.setBackground(Color.lightGray);
        btnSubstraction.setFont(new Font("Arial", Font.PLAIN, 20));

        // Set dot Button
        btnDot = new RoundedButton(".");
        btnDot.addActionListener(this);
        btnDot.setBounds(30, 290, 100, 50);
        btnDot.setBorderPainted(false);
        btnDot.setOpaque(false);
        btnDot.setBackground(Color.white);
        btnDot.setFont(new Font("Arial", Font.PLAIN, 20));

        // Set zero Button
        btnZero = new RoundedButton("0");
        btnZero.addActionListener(this);
        btnZero.setBounds(150, 290, 100, 50);
        btnZero.setBorderPainted(false);
        btnZero.setOpaque(false);
        btnZero.setBackground(Color.white);
        btnZero.setFont(new Font("Arial", Font.PLAIN, 20));

        // Set Equal Button
        btnEqual = new RoundedButton("=");
        btnEqual.addActionListener(this);
        btnEqual.setBounds(270, 290, 100, 50);
        btnEqual.setBorderPainted(false);
        btnEqual.setOpaque(false);
        btnEqual.setBackground(Color.lightGray);
        btnEqual.setFont(new Font("Arial", Font.PLAIN, 20));

        // Set Addition Button
        btnAdd = new RoundedButton("+");
        btnAdd.addActionListener(this);
        btnAdd.setBounds(390, 290, 100, 50);
        btnAdd.setBorderPainted(false);
        btnAdd.setOpaque(false);
        btnAdd.setBackground(Color.lightGray);
        btnAdd.setFont(new Font("Arial", Font.PLAIN, 20));

        // Set clear Button
        btnClear = new RoundedButton("CLEAR");
        btnClear.addActionListener(this);
        btnClear.setBounds(30, 350, 100, 50);
        btnClear.setBorderPainted(false);
        btnClear.setOpaque(false);
        btnClear.setBackground(Color.white);
        btnClear.setFont(new Font("Arial", Font.PLAIN, 20));
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

    // action to be perfomed when btn press
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSeven) {
            if (isOperatorClicked) {
                displayLabel.setText("7");
                isOperatorClicked = false;
            } else {
                displayLabel.setText(displayLabel.getText() + "7");
            }
        } else if (e.getSource() == btnEight) {
            if (isOperatorClicked) {
                displayLabel.setText("8");
                isOperatorClicked = false;
            } else {
                displayLabel.setText(displayLabel.getText() + "8");
            }
        } else if (e.getSource() == btnNine) {
            if (isOperatorClicked) {
                displayLabel.setText("9");
                isOperatorClicked = false;
            } else {
                displayLabel.setText(displayLabel.getText() + "9");
            }
        } else if (e.getSource() == btnFour) {
            if (isOperatorClicked) {
                displayLabel.setText("4");
                isOperatorClicked = false;
            } else {
                displayLabel.setText(displayLabel.getText() + "4");
            }
        } else if (e.getSource() == btnFive) {
            if (isOperatorClicked) {
                displayLabel.setText("5");
                isOperatorClicked = false;
            } else {
                displayLabel.setText(displayLabel.getText() + "5");
            }
        } else if (e.getSource() == btnSix) {
            if (isOperatorClicked) {
                displayLabel.setText("6");
                isOperatorClicked = false;
            } else {
                displayLabel.setText(displayLabel.getText() + "6");
            }
        } else if (e.getSource() == btnOne) {
            if (isOperatorClicked) {
                displayLabel.setText("1");
                isOperatorClicked = false;
            } else {
                displayLabel.setText(displayLabel.getText() + "1");
            }
        } else if (e.getSource() == btnTwo) {
            if (isOperatorClicked) {
                displayLabel.setText("2");
                isOperatorClicked = false;
            } else {
                displayLabel.setText(displayLabel.getText() + "2");
            }
        } else if (e.getSource() == btnThree) {
            if (isOperatorClicked) {
                displayLabel.setText("3");
                isOperatorClicked = false;
            } else {
                displayLabel.setText(displayLabel.getText() + "3");
            }
        } else if (e.getSource() == btnClear) {
            displayLabel.setText("");
        } else if (e.getSource() == btnDot) {
            if (isOperatorClicked) {
                displayLabel.setText(".");
                isOperatorClicked = false;
            } else {
                displayLabel.setText(displayLabel.getText() + ".");
            }
        } else if (e.getSource() == btnZero) {
            if (isOperatorClicked) {
                displayLabel.setText("0");
                isOperatorClicked = false;
            } else {
                displayLabel.setText(displayLabel.getText() + "0");
            }
        } else if (e.getSource() == btnDivision) {
            operator = "div";
            isOperatorClicked = true;
            oldValues = displayLabel.getText();
            displayLabel.setText(displayLabel.getText() + "/");

        } else if (e.getSource() == btnSubstraction) {
            operator = "sub";
            isOperatorClicked = true;
            oldValues = displayLabel.getText();
            displayLabel.setText(displayLabel.getText() + "-");

        } else if (e.getSource() == btnAdd) {
            operator = "add";
            isOperatorClicked = true;
            oldValues = displayLabel.getText();
            displayLabel.setText(displayLabel.getText() + "+");
        } else if (e.getSource() == btnMultiplication) {
            operator = "mul";
            isOperatorClicked = true;
            oldValues = displayLabel.getText();
            displayLabel.setText(displayLabel.getText() + "x");
        } else if (e.getSource() == btnEqual) {
            String newValue = displayLabel.getText();
            float oldValuesF = Float.parseFloat(oldValues);
            float newValueF = Float.parseFloat(newValue);
            float result = 0;
            switch (operator) {
                case "div":
                    result = oldValuesF / newValueF;
                    break;
                case "add":
                    result = oldValuesF + newValueF;
                    break;
                case "mul":
                    result = oldValuesF * newValueF;
                    break;
                case "sub":
                    result = oldValuesF - newValueF;
                    break;
                default:
                    System.out.println("Invalid operator");
                    break;
            }
            displayLabel.setText(result + "");
        }

    }

}