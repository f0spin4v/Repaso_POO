package Modelo;

public abstract class Vehiculo {
    private String placa;
    private String marca;
    private String referencia;
    private String modelo;
    private double precio;
    private int num_ruedas;

    private boolean isVendido;

    public Vehiculo(String placa, String marca,String referencia,String modelo, double precio, int num_ruedas,
                    boolean isVendido) {
        this.placa = placa;
        this.marca = marca;
        this.referencia =referencia;
        this.modelo = modelo;
        this.precio = precio;
        this.num_ruedas = num_ruedas;
        this.isVendido = isVendido;
    }
    public abstract String obtenerTipoVehiculo();
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public int getNum_ruedas() {
        return num_ruedas;
    }
    public void setNum_ruedas(int num_ruedas) {
        this.num_ruedas = num_ruedas;
    }
    public boolean isVendido() {
        return isVendido;
    }
    public void setVendido(boolean vendido) {
        isVendido = vendido;
    }
    public String getReferencia() {
        return referencia;
    }
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
}
