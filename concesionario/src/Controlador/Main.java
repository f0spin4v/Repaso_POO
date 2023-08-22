package Controlador;

import Modelo.*;

import javax.swing.*;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static Concesionario c = new Concesionario("AUTO_AHORA");
    public static void main(String[] args) {
        iniciarDatos();
        System.out.println("cantidad de vehiculos"+c.getListaVehiculosDisponibles().size());
        String idUser = JOptionPane.showInputDialog(c.getNombre()+" \n Ingrese su Identificacion");
        mostrarMenu(validarAdmin(idUser));
    }
    public static void iniciarDatos (){
        Administrador admin_general = new Administrador("ANDRES","177343");
        c.agregarAdministrador(admin_general);
        Vehiculo moto1 =new Moto("abc12","akt","ve","2414",100,2,false,130,124);
        Vehiculo Auto1 =new Auto("de3","bmw","go","2023",400,4,false,4,true);
        Vehiculo moto2 =new Moto("kkkk","akt","ve","2414",100,2,false,130,124);
        Vehiculo Auto2 =new Auto("jjjj","bmw","go","2023",400,4,false,4,true);
        c.agregarVehiculo(moto1);
        c.agregarVehiculo(moto2);
        c.agregarVehiculo(Auto1);
        c.agregarVehiculo(Auto2);
    }

    public static boolean validarAdmin(String admin){
        for (Administrador a: c.getListaAdministrador()) {
            if(admin.equalsIgnoreCase(a.getId())){
                return true;
            }
        }
        return false;
    }
    public static void mostrarMenu(boolean isAdmin){
        boolean bandera = true;

        Scanner scannermensaje = new Scanner(System.in);
        do {
            String mensaje = "Ingresa la accion a realizar: \n1)REGISTRAR\n2)CONSULTAR\n3)VENDER\n4)CONSULTAR VEHICULOS DISPONIBLES";
            if (isAdmin == true){
                mensaje= mensaje+"\n5)ACTUALIZAR\n6)ELIMINAR VEHICULO\n7)LISTADO VEHICULOS VENDIDOS\n8)REPORTE DE VENTAS)"+
                        "\n9)INVENTARIO";
            }
            mensaje=mensaje+"\n0)SALIR\n------RECUERDA INGRESAR SOLO UN NUMERO------";
            String respuesta = JOptionPane.showInputDialog(mensaje);
            switch (respuesta){
                case "1":
                    c.registroVehiculo();
                    break;
                case "2":
                    c.buscarVehiculo();
                    break;
                case "3":
                    c.venderVehiculo();
                    break;
                case"4":
                    c.mostrarVehiculosDisponibles();
                    break;
                case"5":
                    if (isAdmin==true){
                        String placa = JOptionPane.showInputDialog("ingresa la placa del vehiculo que quiere actualizar)") ;
                        c.actualizarVehiculo(placa);
                    }
                    break;
                case"6":
                    c.eliminarVehiculo();
                    break;
                case"7":
                    c.listarVehiculosVendido();
                    break;
                case"8":
                    c.ventasTotales();
                    break;
                case"9":
                    c.stockVehiculos();
                    break;
                case "0":
                    bandera=false;
                    break;
                default:
                    break;
            }
        }while (bandera==true);

    }
}