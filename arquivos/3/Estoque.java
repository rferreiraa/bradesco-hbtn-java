import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Produto> produtos;
    private String arquivoCsv;

    public Estoque(String arquivoCsv) {
        this.arquivoCsv = arquivoCsv;
        this.produtos = new ArrayList<>();
        carregarDoArquivo();
    }

    // Carregar os produtos do arquivo CSV
    private void carregarDoArquivo() {
        produtos.clear();
        File arquivo = new File(arquivoCsv);
        if (!arquivo.exists()) {
            return; // Se não existe ainda, começa com lista vazia
        }

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty()) continue; // ignora linhas vazias
                String[] partes = linha.split(",");
                if (partes.length == 4) {
                    int id = Integer.parseInt(partes[0]);
                    String nome = partes[1];
                    int quantidade = Integer.parseInt(partes[2]);
                    double preco = Double.parseDouble(partes[3]);
                    produtos.add(new Produto(id, nome, quantidade, preco));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Erro ao carregar arquivo: " + e.getMessage());
        }
    }

    // Salvar os produtos no arquivo CSV
    private void salvarNoArquivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoCsv))) {
            for (Produto p : produtos) {
                bw.write(p.toCsv());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }

    // Gerar próximo ID disponível
    private int gerarProximoId() {
        int maxId = 0;
        for (Produto p : produtos) {
            if (p.getId() > maxId) {
                maxId = p.getId();
            }
        }
        return maxId + 1;
    }

    // Adicionar produto
    public void adicionarProduto(String nome, int quantidade, double preco) {
        int novoId = gerarProximoId();
        Produto novo = new Produto(novoId, nome, quantidade, preco);
        produtos.add(novo);
        salvarNoArquivo();
        System.out.println("Produto adicionado com sucesso! ID: " + novoId);
    }

    // Excluir produto
    public void excluirProduto(int id) {
        boolean removido = produtos.removeIf(p -> p.getId() == id);
        if (removido) {
            salvarNoArquivo();
            System.out.println("Produto excluído com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    // Exibir estoque
    public void exibirEstoque() {
        if (produtos.isEmpty()) {
            System.out.println("Estoque vazio!");
        } else {
            for (Produto p : produtos) {
                System.out.println(p);
            }
        }
    }

    // Atualizar quantidade
    public void atualizarQuantidade(int id, int novaQuantidade) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                p.setQuantidade(novaQuantidade);
                salvarNoArquivo();
                System.out.println("Quantidade atualizada com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado!");
    }
}
