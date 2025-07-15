public class Gerente extends Empregado {

    public Gerente(double salarioFixo) {
        super(salarioFixo);
    }

    @Override
    public double calcularBonus(Departamento departamento) {
        if(departamento.alcancouMeta()){
          double diferencaMeta = departamento.getValorAtingidoMeta() - departamento.getValorMeta();
          return (this.salarioFixo * 0.20) + (diferencaMeta * 0.01);
        }return 0.0;

    }
}