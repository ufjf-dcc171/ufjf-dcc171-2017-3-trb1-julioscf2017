package trab1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class JanelaPrincipal extends JFrame{
    
    private final List<Pedido> pedidos;
    private String numeroMesa;
    private final JList<Pedido> lstPedidos = new JList<>(new DefaultListModel<>());
    private final JList<Item> lstItens = new JList<>(new DefaultListModel<>());
    
    private final JButton novoPedido = new JButton("Novo Pedido");
    private final JanelaNovoPedido incluirPedido = new JanelaNovoPedido();

    public JanelaPrincipal() throws HeadlessException {        
        super("CONTROLE DE PEDIDOS");
        setMinimumSize(new Dimension(800, 600));
        
        this.pedidos = new ArrayList<>();
        Item i = new Item("Presunto","01");
        Pedido p = new Pedido("01");
        p.getItens().add(i);
        pedidos.add(p);
        lstPedidos.updateUI();
        
        lstPedidos.setModel(new PedidosListModel(pedidos));
        
        
        add(new JScrollPane(lstPedidos), BorderLayout.WEST);
        add(new JScrollPane(lstItens), BorderLayout.CENTER);
        
        
        lstPedidos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);        
        lstPedidos.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Pedido selecionada;
                selecionada = lstPedidos.getSelectedValue();
                if(selecionada != null){
                    lstItens.setModel(new ItensListModel(selecionada.getItens()));
                } else{
                    lstItens.setModel(new DefaultListModel<>());
                }
            }            
        });
        
        JPanel botoes = new JPanel(new GridLayout(1, 1));               
        botoes.add(novoPedido);
        add(botoes, BorderLayout.SOUTH);

        novoPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                numeroMesa = JOptionPane.showInputDialog("Número da mesa");
                if (numeroMesa != null && !numeroMesa.isEmpty()) {
                    incluirPedido.solicitaNovoPedido(numeroMesa);
                }
            }
        });
    }  

    void atualizar(List<Item> itens, Pedido ped) {
        Pedido p = new Pedido(numeroMesa);
            for(int i = 0; i < itens.size(); i++) {
                p.getItens().add(itens.get(i));
            }
            pedidos.add(p);
            lstPedidos.updateUI();
            lstItens.updateUI();
    }
}
