import java.util.ArrayList;

public class Pedido {
    private ArrayList<PedidoCookie> cookies;

    public Pedido() {
        this.cookies = new ArrayList<PedidoCookie>();
    }

    public void adicionarPedidoCookie(PedidoCookie pedido) {
        cookies.add(pedido);
    }

    public int obterTotalCaixas() {
        int total = 0;
        for (PedidoCookie c : cookies) {
            total += c.getQuantidadeCaixas();
        }
        return total;
    }

    public int removerSabor(String sabor) {
        int totalRemovido = 0;

        // usa removeIf com contagem manual
        ArrayList<PedidoCookie> paraRemover = new ArrayList<PedidoCookie>();
        for (PedidoCookie c : cookies) {
            if (c.getSabor().equals(sabor)) {
                totalRemovido += c.getQuantidadeCaixas();
                paraRemover.add(c);
            }
        }

        cookies.removeAll(paraRemover);
        return totalRemovido;
    }
}
