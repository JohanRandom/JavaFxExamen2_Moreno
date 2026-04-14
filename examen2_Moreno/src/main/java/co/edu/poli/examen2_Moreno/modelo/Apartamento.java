package co.edu.poli.examen2_Moreno.modelo;

public class Apartamento extends Inmueble {
    private int numeroPiso;

    public Apartamento(int numero, String fechaCompra, String estado, Propietario propietario, int numeroPiso) {
        super(numero, fechaCompra, estado, propietario);
        this.numeroPiso = numeroPiso;
    }

    public int getNumeroPiso() {
        return numeroPiso;
    }

    public void setNumeroPiso(int numeroPiso) {
        this.numeroPiso = numeroPiso;
    }
}