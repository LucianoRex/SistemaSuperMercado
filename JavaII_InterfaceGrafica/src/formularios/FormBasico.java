package formularios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class FormBasico extends JFrame {

    public FormBasico() {
        System.out.println("Iniciando programa...");
    }

    JButton btnOk = new JButton("OK");

    public void init() {
        this.setSize(800, 600);
        this.setVisible(true);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        btnOk.setBounds(10, 10, 200, 50);
        this.add(btnOk);

        JTextField text = new JTextField();
        text.setBounds(10, 60, 200, 50);
        this.add(text);

        btnOk.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("O usuario clicou!");
            }
        }
        );
    }

    public static void main(String[] args) {
        System.out.println("Metodo main...");
        FormBasico f = new FormBasico();
        f.init();
    }
}
