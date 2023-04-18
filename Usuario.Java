import java.util.List;
import java.util.Scanner;

public class Usuario {
    private String nome;
    private List<Pedido> pedidos;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public static Usuario criarUsuario(Scanner scanner) {
        System.out.print("Digite o nome do usuário: ");
        String nome = scanner.nextLine();

        return new Usuario(nome);
    }

    public void adicionarPedido(Scanner scanner) {
        System.out.print("Digite o nome do produto: ");
        String nomeProduto = scanner.nextLine();

        System.out.print("Digite a quantidade do produto: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o preço unitário do produto: ");
        double precoUnitario = scanner.nextDouble();
        scanner.nextLine();

        pedidos.add(new Pedido(nomeProduto, quantidade, precoUnitario));
    }

    public double calcularValorTotalPedidos() {
        double valorTotal = 0;

        for (Pedido pedido : pedidos) {
            valorTotal += pedido.calcularValorTotal();
        }

        return valorTotal;
    }

    public void exibirPedido() {
        System.out.println(nome + " - R$ " + calcularValorTotal
