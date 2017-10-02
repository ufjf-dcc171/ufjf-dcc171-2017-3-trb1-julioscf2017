package trab1;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


class JanelaPedido extends JFrame{
    private final JComboBox <String> saborPizza;
    private final JLabel infQtdPizzas = new JLabel("Informar quantidade: ");
    private final JTextField qtdPizzas = new JTextField(3);
    private final JButton confirmar = new JButton("Confirmar Sabor");
    private final JButton cancelar = new JButton("Cancelar Pedido");
    private final JButton finalizar = new JButton("Finalizar Pedido");

    public JanelaPedido() throws HeadlessException {
        super("Novo Pedidos");
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        
        String [] pizzas = {"Muçarela","Calabresa","Presunto","Marguerita","Palmito","Pepperone","Napolitana"};
        saborPizza = new JComboBox<>(pizzas);
        add(saborPizza);
        add(infQtdPizzas);
        add(qtdPizzas);
        
        
        add(confirmar);
        add(cancelar);
        add(finalizar);
        confirmar.addActionListener(new cliqueConfirmarSabor());
        cancelar.addActionListener(new cliqueCancelarPedido());
        finalizar.addActionListener(new cliqueFinalizarPedido());
    }

    void realizarPedido() {
        
    }

    void solicitaNovoPedido(String mesa) {
        String saborEscolhido;
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        setSize(600, 450);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        saborEscolhido = (String) saborPizza.getSelectedItem();
    }

    
    
    
    
    
    private class cliqueConfirmarSabor implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String sabor = (String) saborPizza.getSelectedItem();
            String quantidade = qtdPizzas.getText();
        }
    }
        
    
    
    
    
    
    private static class cliqueCancelarPedido implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
    
    
    
    
    
    
    private class cliqueFinalizarPedido implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            setVisible(false);
        }
    }
    

    
}
