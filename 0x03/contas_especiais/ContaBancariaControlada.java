public class ContaBancariaControlada extends ContaBancariaBasica{
    private double saldoMinimo;
    private double valorPenalidade;


    public ContaBancariaControlada(String numeracao, double taxaJurosAnual, double saldoMinimo, double valorPenalidade) {
        super(numeracao, taxaJurosAnual);
        this.saldoMinimo = saldoMinimo;
        this.valorPenalidade = valorPenalidade;
    }

    @Override
    void aplicarAtualizacaoMensal() {
        super.aplicarAtualizacaoMensal();

        if(super.saldo < this.saldoMinimo){
            super.saldo -= valorPenalidade;
        }

    }
}
