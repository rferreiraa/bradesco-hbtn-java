import java.util.List;
import java.util.stream.Collectors;

public class Consulta {

    public static List<Produto> aplicar15PorcentoDescontoEletronicos(List<Produto> produtos) {
        return produtos.stream()
                .map(produto -> {
                    if (produto.getCategoria() == CategoriaProduto.ELETRONICO) {
                        return new Produto(
                                produto.getCodigo(),
                                produto.getNome(),
                                produto.getCategoria(),
                                produto.getPreco() * 0.85
                        );
                    } else {
                        return produto;
                    }
                })
                .collect(Collectors.toList());
    }
}
