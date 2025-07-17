import exceptions.OperacaoInvalidaException;

public class ContaBancariaTarifada extends ContaBancariaBasica {
    private int quantidadeTransacoes;

    public ContaBancariaTarifada(String numeracao, double taxaJurosAnual) {
        super(numeracao, taxaJurosAnual);
    }

    public int getQuantidadeTransacoes() {
        return quantidadeTransacoes;
    }

    @Override
    void sacar(double valor) throws OperacaoInvalidaException {
        super.sacar(valor);
        super.saldo -= 0.10;

    }

    @Override
    void depositar(double valor) throws OperacaoInvalidaException {
        super.depositar(valor);
        super.saldo -= 0.10;
    }
}
