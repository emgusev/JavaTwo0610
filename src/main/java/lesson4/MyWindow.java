package lesson4;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MyWindow extends JFrame {

    public MyWindow() throws HeadlessException {
        setTitle("My title");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(200,200, 400,400);
        setVisible(true);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

        JTextArea textArea = new JTextArea();
        textArea.setBounds(10,10, 150, 150);
        add(textArea);
        JButton button = new JButton("Кнопка");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(textArea.getText() +" нажали");
            }
        });
        add(button);

    }

    public static void main(String[] args) {
        new MyWindow();
    }
}
