package trab1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


class JanelaPedido extends JFrame{
    private final Mesa novaMesa;
    private final JComboBox <String> saborPizza;
    private final JLabel infQtdPizzas = new JLabel("Informar quantidade: ");
    private final JTextField qtdPizzas = new JTextField(3);
    private final JButton incluir = new JButton("Incluir no Pedido");
    private final JButton cancelar = new JButton("Cancelar Pedido");
    private final JButton finalizar = new JButton("Finalizar Pedido");
    private final JList<Item> novoPedido = new JList<>(new DefaultListModel<>());

    public JanelaPedido() throws HeadlessException {
        super("Novo Pedidos");
        this.novaMesa = new Mesa();
        setSize(600, 450);
        setResizable(false);
        setLocationRelativeTo(null);
        add(new JScrollPane(novoPedido), BorderLayout.WEST);
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        String [] pizzas = {"Muçarela","Calabresa","Presunto","Marguerita","Palmito","Pepperone","Napolitana"};
        saborPizza = new JComboBox<>(pizzas);
        add(saborPizza);
        add(infQtdPizzas);
        add(qtdPizzas);
        
        add(incluir);
        add(cancelar);
        add(finalizar);
        
        incluir.addActionListener(new cliqueIncluirSabor());
        cancelar.addActionListener(new cliqueCancelarPedido());
        finalizar.addActionListener(new cliqueFinalizarPedido());
    }

    void solicitaNovoPedido(String numeroMesa) {
        this.novaMesa.setNumeroMesa(numeroMesa);
        setVisible(true);
        qtdPizzas.setText("");
    }
    
    private class cliqueIncluirSabor implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(!qtdPizzas.getText().isEmpty()){
                Item p;
                p = new Item((String) saborPizza.getSelectedItem(),qtdPizzas.getText());
                //novoPedido.get
                //novaMesa.getItens().add(p);
                
                qtdPizzas.setText("");
            }            
        }
    }
    
    private class cliqueCancelarPedido implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            setVisible(false);
        }
    }
    
    private class cliqueFinalizarPedido implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            setVisible(false);
        }
    }
}