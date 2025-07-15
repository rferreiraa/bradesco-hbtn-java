public class PersonagemGame {
    public int getSaudeAtual() {
        return saudeAtual;
    }

    public void setSaudeAtual(int saudeAtual) {
        this.saudeAtual = saudeAtual;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private int saudeAtual;
    private String nome;

    public void tomarDano(int quantidadeDeDano) {
        saudeAtual -= quantidadeDeDano;
        if (saudeAtual < 0) {
            saudeAtual = 0;
        }
    }

    public void receberCura(int quantidadeDeCura) {
        saudeAtual += quantidadeDeCura;
        if (saudeAtual > 100) {
            saudeAtual = 100;
        }
    }
}