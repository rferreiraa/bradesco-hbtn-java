import java.util.LinkedList;
import java.util.Queue;

public class Fila {
    private final Queue<Integer> fila = new LinkedList<>();
    private final int capacidade;

    public Fila(int capacidade) {
        this.capacidade = capacidade;
    }

    public synchronized void adicionar(int item) throws InterruptedException {
        while (fila.size() == capacidade) {
            wait();
        }
        fila.add(item);
        System.out.println("Produtor produziu: " + item);
        notifyAll();
    }

    public synchronized int retirar() throws InterruptedException {
        while (fila.isEmpty()) {
            wait();
        }
        int item = fila.poll();
        System.out.println("Consumidor consumiu: " + item);
        notifyAll();
        return item;
    }
}
