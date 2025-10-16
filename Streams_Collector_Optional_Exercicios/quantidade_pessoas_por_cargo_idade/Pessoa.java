import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class Pessoa implements Comparable<Pessoa> {
    private Integer codigo;
    private String nome;
    private String cargo;
    private Integer idade;
    private BigDecimal salario;

    public Pessoa(Integer codigo, String nome, String cargo, Integer idade, double salario) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargo = cargo;
        this.idade = idade;
        this.salario = BigDecimal.valueOf(salario);
    }

    public String getCargo() {
        return cargo;
    }

    public Integer getIdade() {
        return idade;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public String getSalarioFormatado() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setGroupingSeparator('\0');
        symbols.setDecimalSeparator(',');

        DecimalFormat df = new DecimalFormat("0.000000", symbols);
        return df.format(salario);
    }

    @Override
    public String toString() {
        return String.format("[%d] %s %s %d R$ %s", codigo, nome, cargo, idade, getSalarioFormatado());
    }

    @Override
    public int compareTo(Pessoa other) {
        return this.nome.compareTo(other.nome);
    }
}
