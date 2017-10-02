package trab1;

import javax.swing.JFrame;

public class Trab1 {

    public static void main(String[] args) {
        JanelaPrincipal janela = new JanelaPrincipal();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(700, 450);
        janela.setResizable(false);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
    }
    
}
