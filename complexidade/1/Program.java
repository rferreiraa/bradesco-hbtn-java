public class Program {

    public static void main(String[] args) throws Exception {
        long inicio  = System.nanoTime();
            PessoasArray p = new PessoasArray();
            p.buscaLinear("Otavio");
            p.buscaLinear("Isabela");
            p.buscaLinear("Anderson");

    }
}
