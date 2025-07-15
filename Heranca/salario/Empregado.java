public class Empregado {
    double salarioFixo;

    public Empregado(double salarioFixo) {
        this.salarioFixo = salarioFixo;
    }

    public double getSalarioFixo() {
        return salarioFixo;
    }

    public double calcularBonus(Departamento departamento){
        if(departamento.alcancouMeta()){
            return this.salarioFixo * 0.10;
        }else return 0.0;
    }
    public double calcularSalarioTotal(Departamento departamento){
        return this.salarioFixo + calcularBonus(departamento);
    }
}