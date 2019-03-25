/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aeronilena;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author orlan
 */
public class Menu {

    ArrayList<Avion> aviones;
    Scanner sc = new Scanner(System.in);
CompraTiquete compra = new CompraTiquete();
FinCompra fin=new FinCompra();
Reportes report=new Reportes();
    public void Iniciar() {
        aviones = new ArrayList<>();
        CrearAviones();
        SillasCM();
        SillasA();
        SillasCG();
        Menu();

    }

    public void Menu() {
        
        int opcion = 0;
        do {
            try {

                System.out.println("Aerolinea UDEC");
                System.out.println("1.Comprar Tiquete");
                System.out.println("2.Finalizar Compras");
                System.out.println("3.Ver Reporte de Ventas");
                opcion = Integer.parseInt(sc.next());
                switch (opcion) {
                    case 1:
                        aviones = compra.CompraTiquete(aviones);
                        break;
                    case 2:
                        aviones=fin.FinCompra(aviones);
                        break;
                    case 3:
                        aviones=report.reportes(aviones);
                }

            }catch(NumberFormatException e){
                System.err.println("No digito un Numero");
                opcion=-1;
            } catch (NullPointerException e) {
                System.err.println(" No ha digitado un numero por favor intente de nuevo");
                opcion=-1;
            }
        } while (opcion != 0);
    }

    public void CrearAviones() {
        aviones.add(new Avion("Cartagena", "Avion Comercial"));
        aviones.add(new Avion("Villavicencio", "Avioneta"));
        aviones.add(new Avion("Ciudad de Mexico", "Avion Comercial"));
    }

    public void SillasCM() {
        //creacion de 6 sillas en Primera clase 
        aviones.get(0).getSillas().add(new Silla('A', 1, "Primera Clase", 400000, true));
        aviones.get(0).getSillas().add(new Silla('B', 1, "Primera Clase", 400000, true));
        aviones.get(0).getSillas().add(new Silla('A', 2, "Primera Clase", 400000, true));
        aviones.get(0).getSillas().add(new Silla('B', 2, "Primera Clase", 400000, true));
        aviones.get(0).getSillas().add(new Silla('A', 3, "Primera Clase", 400000, true));
        aviones.get(0).getSillas().add(new Silla('B', 3, "Primera Clase", 400000, true));
        //Creacion de 36 sillas Turista
        aviones.get(0).getSillas().add(new Silla('A', 4, "Turismo", 200000, true));
        aviones.get(0).getSillas().add(new Silla('B', 4, "Turismo", 200000, true));
        aviones.get(0).getSillas().add(new Silla('C', 4, "Turismo", 200000, true));
        aviones.get(0).getSillas().add(new Silla('D', 4, "Turismo", 200000, true));
        aviones.get(0).getSillas().add(new Silla('A', 5, "Turismo", 200000, true));
        aviones.get(0).getSillas().add(new Silla('B', 5, "Turismo", 200000, true));
        aviones.get(0).getSillas().add(new Silla('C', 5, "Turismo", 200000, true));
        aviones.get(0).getSillas().add(new Silla('D', 5, "Turismo", 200000, true));
        aviones.get(0).getSillas().add(new Silla('A', 6, "Turismo", 200000, true));
        aviones.get(0).getSillas().add(new Silla('B', 6, "Turismo", 200000, true));
        aviones.get(0).getSillas().add(new Silla('C', 6, "Turismo", 200000, true));
        aviones.get(0).getSillas().add(new Silla('D', 6, "Turismo", 200000, true));
        aviones.get(0).getSillas().add(new Silla('A', 7, "Turismo", 200000, true));
        aviones.get(0).getSillas().add(new Silla('B', 7, "Turismo", 200000, true));
        aviones.get(0).getSillas().add(new Silla('C', 7, "Turismo", 200000, true));
        aviones.get(0).getSillas().add(new Silla('D', 7, "Turismo", 200000, true));
        aviones.get(0).getSillas().add(new Silla('A', 8, "Turismo", 200000, true));
        aviones.get(0).getSillas().add(new Silla('B', 8, "Turismo", 200000, true));
        aviones.get(0).getSillas().add(new Silla('C', 8, "Turismo", 200000, true));
        aviones.get(0).getSillas().add(new Silla('D', 8, "Turismo", 200000, true));
        aviones.get(0).getSillas().add(new Silla('A', 9, "Turismo", 200000, true));
        aviones.get(0).getSillas().add(new Silla('B', 9, "Turismo", 200000, true));
        aviones.get(0).getSillas().add(new Silla('C', 9, "Turismo", 200000, true));
        aviones.get(0).getSillas().add(new Silla('D', 9, "Turismo", 200000, true));
        aviones.get(0).getSillas().add(new Silla('A', 10, "Turismo", 200000, true));
        aviones.get(0).getSillas().add(new Silla('B', 10, "Turismo", 200000, true));
        aviones.get(0).getSillas().add(new Silla('C', 10, "Turismo", 200000, true));
        aviones.get(0).getSillas().add(new Silla('D', 10, "Turismo", 200000, true));
        aviones.get(0).getSillas().add(new Silla('A', 11, "Turismo", 200000, true));
        aviones.get(0).getSillas().add(new Silla('B', 11, "Turismo", 200000, true));
        aviones.get(0).getSillas().add(new Silla('C', 11, "Turismo", 200000, true));
        aviones.get(0).getSillas().add(new Silla('D', 11, "Turismo", 200000, true));
        aviones.get(0).getSillas().add(new Silla('A', 12, "Turismo", 200000, true));
        aviones.get(0).getSillas().add(new Silla('B', 12, "Turismo", 200000, true));
        aviones.get(0).getSillas().add(new Silla('C', 12, "Turismo", 200000, true));
        aviones.get(0).getSillas().add(new Silla('D', 12, "Turismo", 200000, true));

    }

    public void SillasA() {
        aviones.get(1).getSillas().add(new Silla('A', 1, "Primera Clase", 80000, true));
        aviones.get(1).getSillas().add(new Silla('B', 1, "Primera Clase", 80000, true));
        aviones.get(1).getSillas().add(new Silla('A', 2, "Primera Clase", 80000, true));
        aviones.get(1).getSillas().add(new Silla('B', 2, "Primera Clase", 80000, true));
        aviones.get(1).getSillas().add(new Silla('A', 3, "Primera Clase", 80000, true));
        aviones.get(1).getSillas().add(new Silla('B', 3, "Primera Clase", 80000, true));
        aviones.get(1).getSillas().add(new Silla('A', 4, "Primera Clase", 80000, true));
        aviones.get(1).getSillas().add(new Silla('B', 4, "Primera Clase", 80000, true));
        aviones.get(1).getSillas().add(new Silla('A', 5, "Primera Clase", 80000, true));
        aviones.get(1).getSillas().add(new Silla('B', 5, "Primera Clase", 80000, true));
    }

    public void SillasCG() {
        //creacion de 4 sillas en Primera clase 
        aviones.get(2).getSillas().add(new Silla('A', 1, "Primera Clase", 1200000, true));
        aviones.get(2).getSillas().add(new Silla('B', 1, "Primera Clase", 1200000, true));
        aviones.get(2).getSillas().add(new Silla('A', 2, "Primera Clase", 1200000, true));
        aviones.get(2).getSillas().add(new Silla('B', 2, "Primera Clase", 1200000, true));
        aviones.get(2).getSillas().add(new Silla('A', 3, "Primera Clase", 1200000, true));
        aviones.get(2).getSillas().add(new Silla('B', 3, "Primera Clase", 1200000, true));
        //Creacion de 6 sillas Bussines
        aviones.get(2).getSillas().add(new Silla('A', 4, "Business", 2400000, true));
        aviones.get(2).getSillas().add(new Silla('B', 4, "Business", 2400000, true));
        aviones.get(2).getSillas().add(new Silla('C', 4, "Business", 2400000, true));
        aviones.get(2).getSillas().add(new Silla('A', 5, "Business", 2400000, true));
        aviones.get(2).getSillas().add(new Silla('B', 5, "Business", 2400000, true));
        aviones.get(2).getSillas().add(new Silla('C', 5, "Business", 2400000, true));
        //Creacion de 28 sillas Turista
        aviones.get(2).getSillas().add(new Silla('A', 6, "Turismo", 3000000, true));
        aviones.get(2).getSillas().add(new Silla('B', 6, "Turismo", 3000000, true));
        aviones.get(2).getSillas().add(new Silla('C', 6, "Turismo", 3000000, true));
        aviones.get(2).getSillas().add(new Silla('D', 6, "Turismo", 3000000, true));
        aviones.get(2).getSillas().add(new Silla('A', 7, "Turismo", 3000000, true));
        aviones.get(2).getSillas().add(new Silla('B', 7, "Turismo", 3000000, true));
        aviones.get(2).getSillas().add(new Silla('C', 7, "Turismo", 3000000, true));
        aviones.get(2).getSillas().add(new Silla('D', 7, "Turismo", 3000000, true));
        aviones.get(2).getSillas().add(new Silla('A', 8, "Turismo", 3000000, true));
        aviones.get(2).getSillas().add(new Silla('B', 8, "Turismo", 3000000, true));
        aviones.get(2).getSillas().add(new Silla('C', 8, "Turismo", 3000000, true));
        aviones.get(2).getSillas().add(new Silla('D', 8, "Turismo", 3000000, true));
        aviones.get(2).getSillas().add(new Silla('A', 9, "Turismo", 3000000, true));
        aviones.get(2).getSillas().add(new Silla('B', 9, "Turismo", 3000000, true));
        aviones.get(2).getSillas().add(new Silla('C', 9, "Turismo", 3000000, true));
        aviones.get(2).getSillas().add(new Silla('D', 9, "Turismo", 3000000, true));
        aviones.get(2).getSillas().add(new Silla('A', 10, "Turismo", 3000000, true));
        aviones.get(2).getSillas().add(new Silla('B', 10, "Turismo", 3000000, true));
        aviones.get(2).getSillas().add(new Silla('C', 10, "Turismo", 3000000, true));
        aviones.get(2).getSillas().add(new Silla('D', 10, "Turismo", 3000000, true));
        aviones.get(2).getSillas().add(new Silla('A', 11, "Turismo", 3000000, true));
        aviones.get(2).getSillas().add(new Silla('B', 11, "Turismo", 3000000, true));
        aviones.get(2).getSillas().add(new Silla('C', 11, "Turismo", 3000000, true));
        aviones.get(2).getSillas().add(new Silla('D', 11, "Turismo", 3000000, true));
        aviones.get(2).getSillas().add(new Silla('A', 12, "Turismo", 3000000, true));
        aviones.get(2).getSillas().add(new Silla('B', 12, "Turismo", 3000000, true));
        aviones.get(2).getSillas().add(new Silla('C', 12, "Turismo", 3000000, true));
        aviones.get(2).getSillas().add(new Silla('D', 12, "Turismo", 3000000, true));
        aviones.get(2).getSillas().add(new Silla('A', 13, "Turismo", 3000000, true));
        aviones.get(2).getSillas().add(new Silla('B', 13, "Turismo", 3000000, true));
        aviones.get(2).getSillas().add(new Silla('C', 13, "Turismo", 3000000, true));
        aviones.get(2).getSillas().add(new Silla('D', 13, "Turismo", 3000000, true));
        aviones.get(2).getSillas().add(new Silla('A', 14, "Turismo", 3000000, true));
        aviones.get(2).getSillas().add(new Silla('B', 14, "Turismo", 3000000, true));
        aviones.get(2).getSillas().add(new Silla('C', 14, "Turismo", 3000000, true));
        aviones.get(2).getSillas().add(new Silla('D', 14, "Turismo", 3000000, true));
    }

}
