public class Pedido {
    private double percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[]itens) {
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }

    public double calcularTotal(){
        double valorTotal = 0.0;

        for (ItemPedido item : itens) {
            valorTotal += item.getProduto().obterPrecoLiquido() * item.getQuantidade();
        }
        valorTotal = valorTotal * (1 - this.percentualDesconto / 100);
        return valorTotal;
    }
}