import produtos.Livro;

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

    public void apresentarResumoPedido(){

        double valorTotal = calcularTotal();
        double valorSemDesconto = valorTotal / (1 - percentualDesconto / 100);
        double valorDesconto = valorTotal - valorSemDesconto;

        System.out.print("------- RESUMO PEDIDO -------\n");
        for (ItemPedido item : itens) {
            double valorTotalProduto = item.getQuantidade() * item.getProduto().obterPrecoLiquido();
            if(item.getProduto() instanceof Livro){
                System.out.printf("Tipo: Livro  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f\n", item.getProduto().getTitulo(), item.getProduto().obterPrecoLiquido(), item.getQuantidade(), valorTotalProduto);
            }else{
                System.out.printf("Tipo: Dvd  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f\n", item.getProduto().getTitulo(), item.getProduto().obterPrecoLiquido(), item.getQuantidade(), valorTotalProduto);
            }
        }
        System.out.print("----------------------------\n");
        System.out.printf("DESCONTO: %.2f\n", Math.abs(valorDesconto));
        System.out.printf("TOTAL PRODUTOS: %.2f\n", valorSemDesconto);
        System.out.print("----------------------------\n");
        System.out.printf("TOTAL PEDIDO: %.2f\n", valorTotal);
        System.out.print("----------------------------\n");
    }
}