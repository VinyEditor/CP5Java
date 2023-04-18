import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Usuario> usuarios = new ArrayList<>();

        do {
            Usuario usuario = Usuario.criarUsuario(scanner);

            List<Pedido> pedidos = new ArrayList<>();

            System.out.print("Digite a quantidade de produtos que deseja comprar: ");
            int quantidadeProdutos = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < quantidadeProdutos; i++) {
                usuario.adicionarPedido(scanner);
            }

            try {
                PedidoDAO.cadastrarPedido(usuario.getNome(), usuario.getPedidos());
            } catch (IOException e) {
                System.err.println("Erro ao gravar pedido no arquivo.");
            }

            usuarios.add(usuario);

            System.out.print("Deseja cadastrar outro pedido? (S/N): ");
        } while (scanner.nextLine().equalsIgnoreCase("S"));

        try {
            List<String> linhasPedidos = PedidoDAO.obterPedidos();

            for (Usuario usuario : usuarios) {
                double valorTotalPedidos = 0;

                for (String linhaPedido : linhasPedidos) {
                    String[] dadosPedido = linhaPedido.split(",");

                    if (dadosPedido[0].equalsIgnoreCase(usuario.getNome())) {
                        String nomeProduto = dadosPedido[1];
                        int quantidade = Integer.parseInt(dadosPedido[2]);
                        double precoUnitario = Double.parseDouble(dadosPedido[3]);

                        usuario.getPedidos().add(new Pedido(nomeProduto, quantidade, precoUnitario));
                        valorTotalPedidos += quantidade * precoUnitario;
                    }
                }

                System.out.println(usuario.toString() + " - R$ " + valorTotalPedidos);
            }
        } catch (Exception e) {
            System.err.println("Erro ao ler arquivo de pedidos.");
        }
    }
}
