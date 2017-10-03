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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

class JanelaNovoPedido extends JFrame{
    
    private final JComboBox <String> saborPizza;    
    
    private final JLabel infQtdPizzas = new JLabel("Informar quantidade:", SwingConstants.CENTER);
    private final JTextField qtdPizzas = new JTextField(1);  
    
    private final JLabel infoMesa;
    private Pedido novoPedido;   
    
    private final JButton incluir = new JButton("Incluir no Pedido");
    private final JButton cancelar = new JButton("Cancelar Pedido");
    private final JButton finalizar = new JButton("Finalizar Pedido");  
    
    private final List<Item> itens = new ArrayList<>();
    private final JList<Item> lstItens = new JList<>(new DefaultListModel<>());
    
    private JanelaPrincipal atualizarControle;

    public JanelaNovoPedido() throws HeadlessException {
        super("NOVO PEDIDO");
        this.infoMesa = new JLabel("",SwingConstants.CENTER);
        this.novoPedido = new Pedido();
        
        setSize(700, 400);
        setMinimumSize(new Dimension(700, 400));
        setLocationRelativeTo(null);
        
        JPanel infoPedido = new JPanel(new GridLayout(1, 5));        
        String [] pizzas = {"Muçarela","Calabresa","Presunto","Marguerita","Palmito","Pepperone","Napolitana"};
        saborPizza = new JComboBox<>(pizzas);
        infoPedido.add(infoMesa);
        infoPedido.add(saborPizza);
        infoPedido.add(infQtdPizzas);
        infoPedido.add(qtdPizzas);
        infoPedido.add(incluir); 
        add(infoPedido, BorderLayout.NORTH);
        
        add(new JScrollPane(lstItens), BorderLayout.CENTER);
        
        JPanel botoes = new JPanel(new GridLayout(1, 2));
        botoes.add(cancelar);
        botoes.add(finalizar);
        add(botoes, BorderLayout.SOUTH);
        
        lstItens.setModel(new ItensListModel(itens));
        
        incluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!qtdPizzas.getText().isEmpty()) {
                    Item p;
                    p = new Item((String) saborPizza.getSelectedItem(), qtdPizzas.getText());
                    novoPedido.getItens().add(p);
                    itens.add(p);
                    lstItens.updateUI();
                    qtdPizzas.setText("");
                }
            }
        });
        
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                itens.clear();
                setVisible(false);
            }
        });
        finalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                atualizarControle.atualizar(itens, novoPedido);
                setVisible(false);
            }
        });
    }

    void solicitaNovoPedido(String numeroMesa) {
        itens.clear();
        novoPedido.setNumeroMesa(numeroMesa);
        //novoPedido.setItens(itens);
        qtdPizzas.setText("");
        setVisible(true);
        this.infoMesa.setText("MESA" + " " + novoPedido.getNumeroMesa());
  
    }

}