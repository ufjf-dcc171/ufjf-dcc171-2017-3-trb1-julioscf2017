package trab1;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

class JanelaPrincipal extends JFrame{
    private final JButton novoPedido = new JButton("Novo Pedido");
    private final JanelaPedido pedido = new JanelaPedido();

    public JanelaPrincipal() throws HeadlessException {
        super("Cadastro de Pedidos");
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        add(novoPedido);
        novoPedido.addActionListener(new cliqueNovoPedido());
    }

    private class cliqueNovoPedido implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            pedido.setSize(400, 300);
            pedido.setLocationRelativeTo(null);
            pedido.setVisible(true);
           
        }
    }
    
}
