import exceptions.OperacaoInvalidaException;

public class ContaBancariaBasica {
    private String numeracao;
    private double saldo;
    private double taxaJurosAnual;

    public ContaBancariaBasica(String numeracao, double taxaJurosAnual) {
        this.numeracao = numeracao;
        this.taxaJurosAnual = taxaJurosAnual;
        this.saldo = 0;
    }

    public String getNumeracao() {
        return numeracao;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    void depositar(double valor) throws OperacaoInvalidaException {
        if(valor <= 0){
            throw new OperacaoInvalidaException("Valor para deposito deve ser maior que 0");
        } saldo += valor;
    }

    void sacar(double valor) throws OperacaoInvalidaException {
        if(valor <= 0){
            throw new OperacaoInvalidaException("Valor de saque deve ser maior que 0");
        }if(valor > saldo){
            throw new OperacaoInvalidaException("Valor de saque deve ser menor que o saldo atual");
        } saldo -= valor;
    }

    double calcularTarifaMensal(){
        double tarifaSaldoConta = saldo * 0.10;
        if(tarifaSaldoConta < 10){
            return tarifaSaldoConta;
        } return 10;
    }

    double calcularJurosMensal(){
        return saldo * ((this.taxaJurosAnual / 12) / 100);
    }

    void aplicarAtualizacaoMensal(){
        double tarifaMensal = calcularTarifaMensal();
        double jurosMensal = calcularJurosMensal();
        this.saldo = saldo - tarifaMensal + jurosMensal;
    }
}
