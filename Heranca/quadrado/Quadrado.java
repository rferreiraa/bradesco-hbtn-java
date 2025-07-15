public class Quadrado extends Retangulo {
    private double lado;

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        if(lado < 0){
            throw new IllegalArgumentException("Largura deve ser maior ou igual a 0");
        }
        this.lado = lado;
        this.altura = lado;
        this.largura = lado;
    }

    @Override
    public String toString() {
        return "[Quadrado] " +
                + String.format("%.1f", lado);
    }
}