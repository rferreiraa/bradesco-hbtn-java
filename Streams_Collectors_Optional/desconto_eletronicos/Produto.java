public class Produto {
    private int codigo;
    private String nome;
    private CategoriaProduto categoria;
    private Double preco;

    public Produto(int codigo, String nome, CategoriaProduto categoria, Double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public CategoriaProduto getCategoria() {
        return categoria;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s %s R$ %.2f", codigo, nome, categoria, preco);
    }
}
