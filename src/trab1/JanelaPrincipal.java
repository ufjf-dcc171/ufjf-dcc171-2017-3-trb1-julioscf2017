package trab1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class JanelaPrincipal extends JFrame{
    
    private List<Mesa> mesas;
    private final JList<Mesa> lstMesas = new JList<>(new DefaultListModel<>());
    private final JList<Item> lstItens = new JList<>(new DefaultListModel<>());
    
    private final JButton novoPedido = new JButton("Novo Pedido");
    
    private final JLabel colunaNovoPedido = new JLabel("CADASTRAR NOVO PEDIDO");
    private final JLabel colunaPedidosRealizados = new JLabel("PEDIDOS REALIZADOS");
    private final JLabel teste = new JLabel("PEDIDOS REALIZADOS");
    private final JLabel mesa = new JLabel("Mesa do cliente");
    
    private final JTextField numeroMesa = new JTextField(3);
    
    private final JanelaPedido pedido = new JanelaPedido();
    
    

    public JanelaPrincipal() throws HeadlessException {
        super("Controle de Pedidos");
        setLayout(new GridLayout(1, 3));
        
        lstMesas.setModel(new MesasListModel(mesas));
        
        add(new JScrollPane(lstItens), BorderLayout.WEST);
        add(new JScrollPane(lstMesas), BorderLayout.CENTER);
        JPanel boxMesa = new JPanel(new GridLayout(1, 2));
        boxMesa.add(mesa);
        boxMesa.add(numeroMesa);
        JPanel boxNovoPedido = new JPanel(new GridLayout(3, 1));
        boxNovoPedido.add(colunaNovoPedido);
        boxNovoPedido.add(boxMesa);        
        boxNovoPedido.add(novoPedido);
        add(boxNovoPedido, BorderLayout.EAST);
        
        lstMesas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        lstMesas.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Mesa selecionada;
                selecionada = lstMesas.getSelectedValue();
                if(selecionada != null){
                    lstItens.setModel(new ItensListModel(selecionada.getItens()));
                } else{
                    lstItens.setModel(new DefaultListModel<>());
                }
            }            
        });

        novoPedido.addActionListener(new cliqueNovoPedido());
    }

    private class cliqueNovoPedido implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            pedido.solicitaNovoPedido(numeroMesa.getText());
        }
    }
    
}
