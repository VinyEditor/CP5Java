public class Pedido {
    private String nomeProduto;
    private int quantidade;
    private double precoUnitario;

    public Pedido(String nomeProduto, int quantidade, double precoUnitario) {
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public double calcularValorTotal() {
        return quantidade * precoUnitario;
    }

    @Override
    public String toString() {
        return nomeProduto + "," + quantidade + "," + precoUnitario;
    }
}
