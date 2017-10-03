package trab1;

class Item {
    private String sabor;
    private String qtde;

    public Item(String sabor, String qtde) {
        this.sabor = sabor;
        this.qtde = qtde;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getQtde() {
        return qtde;
    }

    public void setQtde(String qtde) {
        this.qtde = qtde;
    }   
}
