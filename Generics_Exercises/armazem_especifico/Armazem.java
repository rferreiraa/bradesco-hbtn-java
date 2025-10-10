import java.util.*;

public abstract class Armazem<T> implements Armazenavel<T> {
    protected Map<String, T> itens;

    public Armazem() {
        this.itens = new HashMap<>();
    }

    @Override
    public void adicionarAoInventario(String nome, T valor) {
        itens.put(nome, valor);
    }

    @Override
    public T obterDoInventario(String nome) {
        return itens.get(nome);
    }
}
