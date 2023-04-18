import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TotalPedidosDAO {

    private static final String ARQUIVO_TOTAL_PEDIDOS = "total_pedidos.txt";

    public static void gerarTotalPedidos(List<Usuario> usuarios) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_TOTAL_PEDIDOS))) {
            for (Usuario usuario : usuarios) {
                double valorTotal = 0;
                for (Pedido pedido : usuario.getPedidos()) {
                    valorTotal += pedido.getQuantidade() * pedido.getPrecoUnitario();
                }
                writer.write(usuario.getNome() + " - R$ " + String.format("%.2f", valorTotal));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao gravar arquivo de total de pedidos.");
        }
    }

    public static List<String> obterTotalPedidos() {
        return ArquivoUtil.lerArquivo(ARQUIVO_TOTAL_PEDIDOS);
    }
}
