package trab1;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;


class JanelaPedido extends JFrame{
    private final JButton confirmar = new JButton("Confirmar Pedido");

    public JanelaPedido() throws HeadlessException {
        super("Novo Pedidos");
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        add(confirmar);
        confirmar.addActionListener(new cliqueConfirmarPedido());
    }

    private static class cliqueConfirmarPedido implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            
        }
    }
    
}
