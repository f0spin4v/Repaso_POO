package Modelo;
import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Concesionario {

    private String nombre;
    private ArrayList <Vehiculo> listaVehiculosDisponibles;
    private ArrayList <Administrador> listaAdministrador;
    private ArrayList <Vehiculo> listaVehiculosVendidos;

    //________________________________METODOS SET AND GET_______________________________________________
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public ArrayList<Vehiculo> getListaVehiculosDisponibles() {
        return listaVehiculosDisponibles;
    }
    public void setListaVehiculosDisponibles(ArrayList<Vehiculo> listaVehiculosDisponibles) {
        this.listaVehiculosDisponibles = listaVehiculosDisponibles;
    }
    public ArrayList<Administrador> getListaAdministrador() {
        return listaAdministrador;
    }
    public void setListaAdministrador(ArrayList<Administrador> listaAdministrador) {
        this.listaAdministrador = listaAdministrador;
    }
    public ArrayList<Vehiculo> getListaVehiculosVendidos() {
        return listaVehiculosVendidos;
    }
    public void setListaVehiculosVendidos(ArrayList<Vehiculo> listaVehiculosVendidos) {
        this.listaVehiculosVendidos = listaVehiculosVendidos;
    }
    //________________________________________METODO CONSTRUCTOR________________________________________________________
    public Concesionario(String nombre) {
        this.nombre = nombre;
        this.listaVehiculosDisponibles = new ArrayList<Vehiculo>();
        this.listaAdministrador = new ArrayList<Administrador>();
        this.listaVehiculosVendidos =new ArrayList<Vehiculo>();
    }
    //_________________________________metodo que me añade un administrador a la lista__________________________________
    public void agregarAdministrador (Administrador administrador){
        listaAdministrador.add(administrador);
    }
    //__________________________________Metodo que elimina un vehiculo disponible_______________________________________
    public void eliminarVehiculo (){
        listarVehiculosDisponibles();
        String placa = JOptionPane.showInputDialog("ingresa la placa del vehiculo que quiere Eliminar:");
        Vehiculo vehiculoEliminado = buscarVehiculoPlaca(placa);
        int pocisionFinal=0,pocision=0;
        for (Vehiculo vehiculo:listaVehiculosDisponibles) {
            if(vehiculo.getPlaca().equalsIgnoreCase(vehiculoEliminado.getPlaca())){
                pocisionFinal=pocision;
            }else {
                pocision++;
            }
        }
        listaVehiculosDisponibles.remove(pocisionFinal);
    }
    //__________________________________Metodo que genera reporte de ventas_____________________________________________
    public void ventasTotales (){
        double ventasTotales=0;
        for (Vehiculo vehiculo:listaVehiculosVendidos) {
            ventasTotales=ventasTotales + vehiculo.getPrecio();
        }
        JOptionPane.showMessageDialog(null,"Las ventas totales son de: $"+ventasTotales);
        System.out.println("------------------REGRISTRO DE VENTAS------------------\n\n\nLas ventas totales son: $ "
                +ventasTotales);
        listarVehiculosVendido();
    }
    //__________________________________Metodo que Actualiza un vehiculo disponible_____________________________________
    public void actualizarVehiculo(String placa){
        boolean existe= false;
        Vehiculo vehiculoAux=null;
        int pocisionFinal=0,pocision=0;
        for (Vehiculo vehiculo:listaVehiculosDisponibles) {
            if (placa.equalsIgnoreCase(vehiculo.getPlaca())) {
                existe = true;
                vehiculoAux=vehiculo;
                pocisionFinal=pocision;
            }else {
                pocision++;
            }
        }
        if (existe = true){
            boolean bandera = false;
            do {
                Scanner scannerActualizarVehiculo = new Scanner(System.in);
                System.out.println("Indique que quiere actualizar 1) Placa, 2)Marca, 3)Referencia, 4)Modelo, 5)Precio");
                int actualizacion = scannerActualizarVehiculo.nextInt();
                String auxtexto= " ";
                String actualizacionNueva ="";
                switch (actualizacion){
                    case 1:
                        auxtexto=vehiculoAux.getPlaca();
                        System.out.println("Ingresa la nueva Plca");
                        String nuevaPlaca = scannerActualizarVehiculo.next();
                        vehiculoAux.setPlaca(nuevaPlaca);
                        System.out.println("Se actualiza la informacion de placa anterior \n"+auxtexto+"\n la nueva placa es: "+nuevaPlaca);
                        System.out.println("Desea actualizar algun otro dato, Ingrese Si  o No");
                        actualizacionNueva=scannerActualizarVehiculo.next();
                        if(actualizacionNueva.equalsIgnoreCase("Si")){
                            bandera=true;
                        }else{
                            bandera=false;
                        }
                        break;
                    case 2:
                        auxtexto=vehiculoAux.getMarca();
                        System.out.println("Ingresa la nueva Marca");
                        String nuevaMarca = scannerActualizarVehiculo.next();
                        vehiculoAux.setMarca(nuevaMarca);
                        System.out.println("Se actualiza la informacion de marca anterior \n"+auxtexto+"\n la nueva marca es: "+nuevaMarca);
                        System.out.println("Desea actualizar algun otro dato, Ingrese Si  o No");
                        actualizacionNueva=scannerActualizarVehiculo.next();
                        if(actualizacionNueva.equalsIgnoreCase("Si")){
                            bandera=true;
                        }else{
                            bandera=false;
                        }
                        break;
                    case 3:
                        auxtexto=vehiculoAux.getReferencia();
                        System.out.println("Ingresa la nueva Referencia");
                        String nuevaReferencia = scannerActualizarVehiculo.next();
                        vehiculoAux.setReferencia(nuevaReferencia);
                        System.out.println("Se actualiza la informacion de Referencia anterior \n"+auxtexto+"\n la nueva referencia es: "+nuevaReferencia);
                        System.out.println("Desea actualizar algun otro dato, Ingrese Si  o No");
                        actualizacionNueva=scannerActualizarVehiculo.next();
                        if(actualizacionNueva.equalsIgnoreCase("Si")){
                            bandera=true;
                        }else{
                            bandera=false;
                        }
                        break;
                    case 4:
                        auxtexto=vehiculoAux.getModelo();
                        System.out.println("Ingresa el nuevo modelo");
                        String nuevaModelo = scannerActualizarVehiculo.next();
                        vehiculoAux.setModelo(nuevaModelo);
                        System.out.println("Se actualiza la informacion de Modelo anterior \n"+auxtexto+"\n el nuevo modelo es: "+nuevaModelo);
                        System.out.println("Desea actualizar algun otro dato, Ingrese Si  o No");
                        actualizacionNueva=scannerActualizarVehiculo.next();
                        if(actualizacionNueva.equalsIgnoreCase("Si")){
                            bandera=true;
                        }else{
                            bandera=false;
                        }
                        break;
                    case 5:
                        auxtexto=vehiculoAux.getPlaca();
                        System.out.println("Ingresa el nuevo precio");
                        int nuevaPrecio = scannerActualizarVehiculo.nextInt();
                        vehiculoAux.setPrecio(nuevaPrecio);
                        System.out.println("Se actualiza la informacion de precio anterior \n"+auxtexto+"\n el nuevo precio es: "+nuevaPrecio);
                        System.out.println("Desea actualizar algun otro dato, Ingrese Si  o No");
                        actualizacionNueva=scannerActualizarVehiculo.next();
                        if(actualizacionNueva.equalsIgnoreCase("Si")){
                            bandera=true;
                        }else{
                            bandera=false;
                        }
                        break;
                    default:
                        System.out.println("La operacion no es posible");
                        break;
                }
            }while (bandera==true);
        }
    }
    //__________________________________Metodo que me indica el stock actual____________________________________________
    public void stockVehiculos(){

        int numCamiones=0, numAutos=0, numMotos=0;
        for (Vehiculo vehiculos:listaVehiculosDisponibles) {
            switch (vehiculos.obtenerTipoVehiculo()){
                case "MOTO":
                    numMotos ++;
                    break;
                case "AUTO":
                    numAutos ++;
                    break;
                case "CAMION":
                    numCamiones ++;
                    break;
                default:
                    break;
            }

        }
        System.out.println("Tenemos registrad@s actualmente: \nMotos : "+numMotos+"\nAutos : "+numAutos+"\n Camiones : "
                +numCamiones);
        mostrarVehiculosDisponibles();
    }
    //__________________________________Metodo para vender el vehiculo__________________________________________________
    public void venderVehiculo (){
        listarVehiculosDisponibles();
        System.out.println();
        String placa = JOptionPane.showInputDialog("Ingresa la placa del vehiculo a comprar: ");
        Vehiculo vehiculoVenta = buscarVehiculoPlaca(placa);
        listaVehiculosVendidos.add(vehiculoVenta);
        int pocisionFinal=0,pocision=0;
        for (Vehiculo vehiculo:listaVehiculosDisponibles) {
            if(vehiculo.getPlaca().equalsIgnoreCase(vehiculoVenta.getPlaca())){
                pocisionFinal=pocision;
            }else {
                pocision++;
            }
        }
        listaVehiculosDisponibles.remove(pocisionFinal);
    }
    //__________________________________Metodo para mostrar vehiculos disponibles_______________________________________
    public void mostrarVehiculosDisponibles(){
        for (Vehiculo vehiculo:listaVehiculosDisponibles) {
            mostrarVehiculo(vehiculo);
        }
    }
    //__________________________________Metodo que muestra vehiculos vendidos___________________________________________
    public void listarVehiculosVendido (){
        System.out.println("____________________ESTOS SON LOS VEHICULOS VENDIDOS____________________");
        for ( Vehiculo vehiculo:this.listaVehiculosVendidos){
            mostrarVehiculo(vehiculo);
        }
    }
    //__________________________________Metodo para agregar vehiculo a la lista de disponibles__________________________
    public void agregarVehiculo (Vehiculo vehiculo){
        this.listaVehiculosDisponibles.add(vehiculo);
    }
    //__________________________________Metodo menu para registro de vehiculos__________________________
    public void registroVehiculo (){
        Vehiculo vehiculo;
        String tipoVehiculo = JOptionPane.showInputDialog("Que tipo de vehiculo vas a registrar: \n (MOTO-AUTO-CAMION)");
        switch (tipoVehiculo.toUpperCase()){
            case "MOTO":
                vehiculo = registrarMoto();
                listaVehiculosDisponibles.add(vehiculo);
                break;
            case "AUTO":
                vehiculo = registrarAuto();
                listaVehiculosDisponibles.add(vehiculo);
                break;
            case "CAMION":
                vehiculo = registrarCamion();
                listaVehiculosDisponibles.add(vehiculo);
                break;
            default:
                JOptionPane.showInputDialog(null,"El vehiculo no se encuentra: ");
        }
    }
    //________________________________________________Metodo para registrar un Camion___________________________________
    private Camion registrarCamion() {
        String valor_placa = JOptionPane.showInputDialog("ingresa la placa:");
        String valor_marca = JOptionPane.showInputDialog("Ingresa la marca: ");
        String valor_referencia = JOptionPane.showInputDialog("Ingresa la referencia: ");
        String valor_modelo = JOptionPane.showInputDialog("Ingresa la modelo: ");
        System.out.println("Ingresa la precio: ");
        String valor_precioTex = JOptionPane.showInputDialog("Ingresa la modelo: ");
        double valor_precio = Double.parseDouble(valor_precioTex);
        String valor_ruedasTex = JOptionPane.showInputDialog("Ingresa el numero de ruedas: ");
        int valor_ruedas = Integer.valueOf(valor_ruedasTex);
        String valor_cargaTex = JOptionPane.showInputDialog("Ingresa la capacidad de carga: ");
        double valor_carga = Double.parseDouble(valor_cargaTex);
        Camion camion_aux = new Camion(valor_placa,valor_marca,valor_referencia,valor_modelo,valor_precio,valor_ruedas,false,valor_carga);
        return camion_aux;
    }
    //________________________________________________Metodo para registrar una Moto____________________________________
    public Moto registrarMoto(){
        String valor_placa = JOptionPane.showInputDialog("ingresa la placa: ");
        String valor_marca = JOptionPane.showInputDialog("Ingresa la marca: ");
        String valor_referencia = JOptionPane.showInputDialog("Ingresa la referencia: ");
        String valor_modelo = JOptionPane.showInputDialog("Ingresa la modelo: ");
        System.out.println("Ingresa la precio: ");
        String valor_precioTex = JOptionPane.showInputDialog("Ingresa el precio: ");
        double valor_precio = Double.parseDouble(valor_precioTex);
        String valor_ruedasTex = JOptionPane.showInputDialog("Ingresa el numero de ruedas: ");
        int valor_ruedas = Integer.valueOf(valor_ruedasTex);
        String valor_cilindrajeTex = JOptionPane.showInputDialog("Ingresa el Cilindraje: ");
        int valor_cilindraje = Integer.valueOf(valor_cilindrajeTex);
        String valor_tanqueTex = JOptionPane.showInputDialog("Ingresa el tamaño del tanque ");
        double valor_tanque = Double.parseDouble(valor_tanqueTex);
        Moto motoAux = new Moto(valor_placa,valor_marca,valor_referencia,valor_modelo,valor_precio,valor_ruedas,false,valor_cilindraje,valor_tanque);
        return motoAux;
    }
    //________________________________________________Metodo para registrar un Auto_____________________________________
    public Auto registrarAuto(){
        String valor_placa = JOptionPane.showInputDialog("ingresa la placa:");
        String valor_marca = JOptionPane.showInputDialog("Ingresa la marca: ");
        String valor_referencia = JOptionPane.showInputDialog("Ingresa la referencia: ");
        String valor_modelo = JOptionPane.showInputDialog("Ingresa la modelo: ");
        System.out.println("Ingresa la precio: ");
        String valor_precioTex = JOptionPane.showInputDialog("Ingresa la modelo: ");
        double valor_precio = Double.parseDouble(valor_precioTex);
        String valor_ruedasTex = JOptionPane.showInputDialog("Ingresa el numero de ruedas: ");
        int valor_ruedas = Integer.valueOf(valor_ruedasTex);
        String valor_puertasTex = JOptionPane.showInputDialog("Ingresa el numero de Puertas: ");
        int valor_puertas = Integer.valueOf(valor_puertasTex);
        String valor_gasolinaTex = JOptionPane.showInputDialog("Tu carro es a gasolina, escribe SI o NO: ");
        boolean valor_gasolina= false;
        if(valor_gasolinaTex.equalsIgnoreCase("SI")){
            valor_gasolina = true;
        }
        Auto auto_aux = new Auto(valor_placa,valor_marca,valor_referencia,valor_modelo,valor_precio,valor_ruedas,false,valor_puertas,valor_gasolina);
        return auto_aux;
    }
    //_____________________________Metodo que muestra vehiculos disponibles_____________________________________________
    public void listarVehiculosDisponibles (){
        System.out.println("____________________ESTOS SON LOS VEHICULOS DISPONIBLES____________________");
        for ( Vehiculo vehiculo:this.listaVehiculosDisponibles){
            mostrarVehiculo(vehiculo);
        }
    }
    //_______________________________________Metodo menu para buscar el vehiculo________________________________________
    public void buscarVehiculo (){
        String valor_busqueda = JOptionPane.showInputDialog("Por cual itemdeseas realizar la busqueda: \nIndique " +
                "1) Placa, 2)Marca, 3)Referencia, 4)Modelo, 5)Precio");

        switch (valor_busqueda){
            case "1":
                String placa= JOptionPane.showInputDialog("Ingresa la Placa del vehiculo");
                Vehiculo vehiculo = buscarVehiculoPlaca(placa);
                if(vehiculo != null){
                    mostrarVehiculo(vehiculo);
                }else {
                    JOptionPane.showMessageDialog(null,"El vehiculo no fue encontrado ");

                }
                break;
            case "2":

                String marca = JOptionPane.showInputDialog("Ingresa la Marca del vehiculo");
                ArrayList <Vehiculo> listaVehiculoAuxiliarMarca = buscarVehiculoMarca(marca);
                for (Vehiculo vehiculoT:listaVehiculoAuxiliarMarca) {
                    if(vehiculoT != null){
                        mostrarVehiculo(vehiculoT);
                    }
                }
                break;

            case "3":

                String referencia= JOptionPane.showInputDialog("Ingresa la Referencia del vehiculo");
                ArrayList <Vehiculo> listaVehiculoAuxiliarReferencia = buscarVehiculoReferencia(referencia);
                for (Vehiculo vehiculoT:listaVehiculoAuxiliarReferencia) {
                    if(vehiculoT != null){
                        mostrarVehiculo(vehiculoT);
                    }
                }
                break;

            case "4":

                String modelo= JOptionPane.showInputDialog("Ingresa la Modelo del vehiculo");
                ArrayList <Vehiculo> listaVehiculoAuxiliarModelo = buscarVehiculoModelo(modelo);
                for (Vehiculo vehiculoT:listaVehiculoAuxiliarModelo) {
                    if(vehiculoT != null){
                        mostrarVehiculo(vehiculoT);
                    }
                }
                break;

            case "5":
                String precio_tex= JOptionPane.showInputDialog("Ingresa la Precio del vehiculo");
                double precio = Double.parseDouble(precio_tex);
                ArrayList <Vehiculo> listaVehiculoAuxiliarPrecio = buscarVehiculoPrecio(precio);
                for (Vehiculo vehiculoT:listaVehiculoAuxiliarPrecio) {
                    if(vehiculoT != null){
                        mostrarVehiculo(vehiculoT);
                    }
                }
                break;
        }
    }
    //_____________________________SubMetodo que permiten buscar el vehiculo por Precio_________________________________
    public ArrayList<Vehiculo> buscarVehiculoPrecio(double precio){
        ArrayList <Vehiculo> listaVehiculosPrecios= new ArrayList<Vehiculo>();
        System.out.println("____________________ESTOS SON LOS VEHICULOS DISPONIBLES POR PRECIO____________________");
        for (Vehiculo vehiculoT : listaVehiculosDisponibles) {
            if (precio== vehiculoT.getPrecio()){
                listaVehiculosPrecios.add(vehiculoT);
            }
        }
        return listaVehiculosPrecios;
    }
    //_____________________________SubMetodo que permiten buscar el vehiculo por Referencia_____________________________
    public ArrayList<Vehiculo> buscarVehiculoReferencia(String referencia){
        ArrayList <Vehiculo> listaVehiculosReferencia= new ArrayList<Vehiculo>();
        System.out.println("____________________ESTOS SON LOS VEHICULOS DISPONIBLES POR REFERENCIA____________________");
        for (Vehiculo vehiculoT: listaVehiculosDisponibles) {
            if (referencia.equalsIgnoreCase(vehiculoT.getReferencia())){
                listaVehiculosReferencia.add(vehiculoT);
            }
        }
        return listaVehiculosReferencia;
    }
    //_____________________________SubMetodo que permiten buscar el vehiculo por Modelo_________________________________
    public ArrayList <Vehiculo> buscarVehiculoModelo(String modelo){
        ArrayList <Vehiculo> listaVehiculosModelo= new ArrayList<Vehiculo>();
        System.out.println("____________________ESTOS SON LOS VEHICULOS DISPONIBLES POR MODELO____________________");
        for (Vehiculo vehiculoT: listaVehiculosDisponibles) {
            if (modelo.equalsIgnoreCase(vehiculoT.getModelo())){
                listaVehiculosModelo.add(vehiculoT);
            }
        }
        return listaVehiculosModelo;
    }
    //_____________________________SubMetodo que permiten buscar el vehiculo por Marca__________________________________
    public ArrayList <Vehiculo> buscarVehiculoMarca(String marca){
         ArrayList <Vehiculo> listaVehiculosMarca= new ArrayList<Vehiculo>();
        System.out.println("____________________ESTOS SON LOS VEHICULOS DISPONIBLES POR MARCA____________________");
        for (Vehiculo vehiculoT: listaVehiculosDisponibles) {
            if (marca.equalsIgnoreCase(vehiculoT.getMarca())){
               listaVehiculosMarca.add(vehiculoT);
            }
        }
        return listaVehiculosMarca;
    }
    //_____________________________SubMetodo que permiten buscar el vehiculo por Placa__________________________________
    public Vehiculo buscarVehiculoPlaca(String placa){
        Vehiculo vehiculo = null;
        System.out.println("____________________VEHICULO ENCONTRADO POR PLACA____________________");
        for (Vehiculo vehiculoT: listaVehiculosDisponibles) {
            if (placa.equalsIgnoreCase(vehiculoT.getPlaca())){
                vehiculo = vehiculoT;
                return vehiculo;
            }
        }
        return null;
    }
    //_______________________________________Metodo que permite mostrar el vehiculo_____________________________________
    public void mostrarVehiculo (Vehiculo vehiculo){
        JOptionPane.showMessageDialog(null,"El vehiculo es: "+vehiculo.obtenerTipoVehiculo()+
                "\nLa placa es: "+ vehiculo.getPlaca()+"\nLa marca es: "+ vehiculo.getMarca()+
                "\nEl modelo es: "+vehiculo.getModelo()+"\nEl precio es: $"+vehiculo.getPrecio());

        //___________________ esto es de verificacion en consola________________________________________________________
        System.out.println("Este Vehivulo es: "+vehiculo.obtenerTipoVehiculo()+"________________________________________");
        System.out.println("La placa es: "+vehiculo.getPlaca());
        System.out.println("La marca es: "+vehiculo.getMarca());
        System.out.println("El modelo es: "+vehiculo.getModelo());
        System.out.println("Tiene un precio de: $"+vehiculo.getPrecio());
    }


}