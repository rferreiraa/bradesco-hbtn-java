package atividades;

public class EnviarEmail implements Atividade{
    @Override
    public void executar() {
        System.out.print("enviando email com video\n");
    }
}
