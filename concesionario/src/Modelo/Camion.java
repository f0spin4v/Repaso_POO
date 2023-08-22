package Modelo;

public class Camion extends Vehiculo{
    private double cap_carga;

    public Camion(String placa, String marca,String referencia,String modelo, double precio, int num_ruedas,
                  boolean isVendido,double cap_carga) {
        super(placa, marca, referencia, modelo, precio, num_ruedas, isVendido);
        this.cap_carga = cap_carga;
    }

    public double getCap_carga() {
        return cap_carga;
    }

    public void setCap_carga(double cap_carga) {
        this.cap_carga = cap_carga;
    }

    @Override
    public String obtenerTipoVehiculo() {
        return "UN CAMION";
    }
}
