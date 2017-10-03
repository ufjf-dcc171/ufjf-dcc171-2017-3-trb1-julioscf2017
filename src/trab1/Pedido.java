package trab1;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private String numeroMesa;
    private List<Item> itens;

    public Pedido(String numeroMesa) {
        this.numeroMesa = numeroMesa;
        this.itens = new ArrayList<>();
    }

    public Pedido() {
        this(null);
    }

    public String getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(String numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "Mesa = " + numeroMesa;
    }
    
    
}
