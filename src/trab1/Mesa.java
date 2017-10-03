package trab1;

import java.util.ArrayList;
import java.util.List;

public class Mesa {
    private String numeroMesa;
    private List<Item> itens;

    public Mesa(String numeroMesa) {
        this.numeroMesa = numeroMesa;
        this.itens = new ArrayList<>();
    }

    public Mesa() {
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
    
}
