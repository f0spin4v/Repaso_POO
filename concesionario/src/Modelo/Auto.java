package Modelo;

public class Auto extends Vehiculo {

    private int num_puertas;
    private boolean is_gasolina;


    public Auto(String placa, String marca,String referencia, String modelo, double precio, int num_ruedas,
                boolean isVendido,int num_puertas, boolean is_gasolina) {
        super(placa, marca, referencia, modelo, precio, num_ruedas, isVendido);
        this.num_puertas = num_puertas;
        this.is_gasolina = is_gasolina;
    }

    public int getNum_puertas() {
        return num_puertas;
    }
    public void setNum_puertas(int num_puertas) {
        this.num_puertas = num_puertas;
    }
    public boolean isIs_gasolina() {
        return is_gasolina;
    }
    public void setIs_gasolina(boolean is_gasolina) {
        this.is_gasolina = is_gasolina;
    }

    @Override
    public String obtenerTipoVehiculo() {
        return "UN AUTO";
    }
}
