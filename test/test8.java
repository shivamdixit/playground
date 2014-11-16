import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

class test8
{
    JButton btn = new JButton("First");
    JButton btn2 = new JButton("Second");

    test8() {

        JFrame f = new JFrame("bOO");
        f.setLayout(new GridLayout(1, 0));
        f.setSize(500, 900);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn.setText("Hell");
            }
        });

        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn2.setText("Hell2");
            }
        });

        f.add(btn);
        f.add(btn2);
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new test8();
            }
        });
    }
}