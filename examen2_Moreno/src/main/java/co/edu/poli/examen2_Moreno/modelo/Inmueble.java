package co.edu.poli.examen2_Moreno.modelo;

public abstract class Inmueble {
    protected int numero;
    protected String fechaCompra;
    protected String estado;
    protected Propietario propietario;

    public Inmueble(int numero, String fechaCompra, String estado, Propietario propietario) {
        this.numero = numero;
        this.fechaCompra = fechaCompra;
        this.estado = estado;
        this.propietario = propietario;
    }

    public int getNumero() {
        return numero;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public String getEstado() {
        return estado;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }
    
    @Override
    public String toString() {
        return "Numero: " + numero +
               ", Fecha: " + fechaCompra +
               ", Estado: " + estado +
               ", Propietario: " + propietario;
    }
}