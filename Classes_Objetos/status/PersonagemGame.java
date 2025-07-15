public class PersonagemGame {
    private int saudeAtual;
    private String nome;
    private String status;

    public int getSaudeAtual() {
        return saudeAtual;
    }

    public void setSaudeAtual(int saudeAtual) {
        if (saudeAtual <= 0) {
            saudeAtual = 0;
            status = "morto";
        }else {
            status = "vivo";
        }
        if (saudeAtual > 100) {
            saudeAtual = 100;
        }
        this.saudeAtual = saudeAtual;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void tomarDano(int quantidadeDeDano) {
        int saude = getSaudeAtual() - quantidadeDeDano;
        setSaudeAtual(saude);
    }

    public void receberCura(int quantidadeDeCura) {
        int saude = getSaudeAtual() + quantidadeDeCura;
        setSaudeAtual(saude);
    }
}