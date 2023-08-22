package Modelo;

public class Moto extends Vehiculo {

    private int cilindraje;
    private double tam_tanque;

    public Moto(String placa, String marca,String referencia,String modelo, double precio, int num_ruedas, boolean isVendido,int cilindraje, double tam_tanque) {
        super(placa, marca, referencia, modelo, precio, num_ruedas, isVendido);
        this.cilindraje = cilindraje;
        this.tam_tanque = tam_tanque;
    }
    public int getCilindraje() {
        return cilindraje;
    }
    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }
    public double getTam_tanque() {
        return tam_tanque;
    }
    public void setTam_tanque(double tam_tanque) {
        this.tam_tanque = tam_tanque;
    }
    @Override
    public String obtenerTipoVehiculo() {
        return " UNA MOTO";
    }
}
