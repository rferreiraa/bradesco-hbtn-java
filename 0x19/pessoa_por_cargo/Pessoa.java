import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class Pessoa {
    private int codigo;
    private String nome;
    private String cargo;
    private int idade;
    private double salario;

    public Pessoa(Integer codigo, String nome, String cargo, Integer idade, double salario) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargo = cargo;
        this.idade = idade;
        this.salario = salario;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public Integer getIdade() {
        return idade;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getSalarioFormatado() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        nf.setMinimumFractionDigits(6);
        nf.setMaximumFractionDigits(6);
        return nf.format(salario);
    }

    @Override
    public String toString() {
        return String.format("[%d] %s %s %d %s", codigo, nome, cargo, idade, getSalarioFormatado());
    }
}
