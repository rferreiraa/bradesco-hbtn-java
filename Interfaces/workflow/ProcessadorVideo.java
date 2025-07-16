import java.util.ArrayList;
import java.util.List;

public class ProcessadorVideo {
    private List<CanalNotificacao> canais = new ArrayList<>();

    public void registrarCanal(CanalNotificacao canalNotificacao){
        this.canais.add(canalNotificacao);
    }

    public void processar(Video video){
        Mensagem mensagem = new Mensagem(video.getArquivo(), video.getFormato(), TipoMensagem.LOG);
        for (CanalNotificacao canal : canais) {
            canal.notificar(mensagem);
        }
    }

}
