package trab1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

class JanelaPrincipal extends JFrame{
    private final JLabel colunaNovoPedido = new JLabel("CADASTRAR NOVO PEDIDO");
    private final JLabel colunaPedidosRealizados = new JLabel("PEDIDOS REALIZADOS");
    private final JLabel teste = new JLabel("PEDIDOS REALIZADOS");
    private final JLabel mesa = new JLabel("Mesa do cliente");
    private final JTextField numeroMesa = new JTextField(3);
    private final JButton novoPedido = new JButton("Novo Pedido");
    private final JanelaPedido pedido = new JanelaPedido();
    private final JList<Mesa> lstMesas = new JList<>(new DefaultListModel<>());
    private final JList<Pedido> lstPedidos = new JList<>(new DefaultListModel<>());

    public JanelaPrincipal() throws HeadlessException {
        super("Controle de Pedidos");
        setLayout(new GridLayout(1, 3));
        
        add(new JScrollPane(lstPedidos), BorderLayout.WEST);
        add(new JScrollPane(lstMesas), BorderLayout.CENTER);   
        
        JPanel boxMesa = new JPanel(new GridLayout(1, 2));
        
        boxMesa.add(mesa);
        boxMesa.add(numeroMesa);
        
        
        
        JPanel boxNovoPedido = new JPanel(new GridLayout(3, 1));
        
        boxNovoPedido.add(colunaNovoPedido);
        boxNovoPedido.add(boxMesa);        
        boxNovoPedido.add(novoPedido);
        
        
        
        add(boxNovoPedido, BorderLayout.EAST);

        novoPedido.addActionListener(new cliqueNovoPedido());
    }

    private class cliqueNovoPedido implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            pedido.solicitaNovoPedido(numeroMesa.getText());
        }
    }
    
}
