import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PedidoDAO {
    private static final String FILENAME = "pedidos.txt";

    public static void cadastrarPedido(String nomeUsuario, List<Pedido> pedidos) throws IOException {
        FileWriter fileWriter = new FileWriter(new File(FILENAME), true);

        fileWriter.write(nomeUsuario + "\n");

        for (Pedido pedido : pedidos) {
            fileWriter.write(pedido.toString() + "\n");
        }

        fileWriter.close();
    }

    public static List<String> obterPedidos() throws FileNotFoundException {
        List<String> pedidos = new ArrayList<>();
        Scanner fileScanner = new Scanner(new File(FILENAME));

        while (fileScanner.hasNextLine()) {
            pedidos.add(fileScanner.nextLine());
        }

        fileScanner.close();

        return pedidos;
    }
}
