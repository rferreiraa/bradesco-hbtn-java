public class Mensagem {
    private String texto;
    private TipoMensagem tipoMensagem;

    public Mensagem(String arquivo, FormatoVideo formatoVideo, TipoMensagem tipoMensagem) {
        this.texto = arquivo + " - " + formatoVideo.toString();
        this.tipoMensagem = tipoMensagem;
    }

    public String getTexto() {
        return texto;
    }

    public TipoMensagem getTipoMensagem() {
        return tipoMensagem;
    }
}
