import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
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
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setGroupingSeparator('\0');
        symbols.setDecimalSeparator(',');

        DecimalFormat df = new DecimalFormat("0.000000", symbols); // 6 casas decimais
        return df.format(salario);
    }

    @Override
    public String toString() {
        return String.format("[%d] %s %s %d R$ %s", codigo, nome, cargo, idade, getSalarioFormatado());
    }
}
