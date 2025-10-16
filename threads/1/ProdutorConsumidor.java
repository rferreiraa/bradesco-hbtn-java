public class ProdutorConsumidor {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        Thread produtor = new Produtor(buffer);
        Thread consumidor = new Consumidor(buffer);

        produtor.start();
        consumidor.start();

        try {
            produtor.join();
            consumidor.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
