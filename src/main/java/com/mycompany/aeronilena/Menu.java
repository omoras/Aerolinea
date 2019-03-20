/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aeronilena;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author orlan
 */
public class Menu {

    ArrayList<Avion> aviones;
    Scanner sc = new Scanner(System.in);

    public void Iniciar() {
        aviones = new ArrayList<>();
        CrearAviones();
        SillasCM();
        SillasA();
        SillasCG();
        
    }

    public void Menu() {

    }

    public void CrearAviones() {
        aviones.add(new Avion("Cartagena", "Avion Comercial"));
        aviones.add(new Avion("Villavicencio", "Avioneta"));
        aviones.add(new Avion("Ciudad de Mexico", "Avion Comercial"));
    }

    public void SillasCM() {
        //creacion de 6 sillas en Primera clase 
        aviones.get(0).getSillas().add(new Silla('A', 1, "Primera Clase", 400000, false));
        aviones.get(0).getSillas().add(new Silla('B', 1, "Primera Clase", 400000, false));
        aviones.get(0).getSillas().add(new Silla('A', 2, "Primera Clase", 400000, false));
        aviones.get(0).getSillas().add(new Silla('B', 2, "Primera Clase", 400000, false));
        aviones.get(0).getSillas().add(new Silla('A', 3, "Primera Clase", 400000, false));
        aviones.get(0).getSillas().add(new Silla('B', 3, "Primera Clase", 400000, false));
        //Creacion de 36 sillas Turista
        aviones.get(0).getSillas().add(new Silla('A', 4, "Turismo", 400000, false));
        aviones.get(0).getSillas().add(new Silla('B', 4, "Turismo", 400000, false));
        aviones.get(0).getSillas().add(new Silla('C', 4, "Turismo", 400000, false));
        aviones.get(0).getSillas().add(new Silla('D', 4, "Turismo", 400000, false));
        aviones.get(0).getSillas().add(new Silla('A', 5, "Turismo", 400000, false));
        aviones.get(0).getSillas().add(new Silla('B', 5, "Turismo", 400000, false));
        aviones.get(0).getSillas().add(new Silla('C', 5, "Turismo", 400000, false));
        aviones.get(0).getSillas().add(new Silla('D', 5, "Turismo", 400000, false));
        aviones.get(0).getSillas().add(new Silla('A', 6, "Turismo", 400000, false));
        aviones.get(0).getSillas().add(new Silla('B', 6, "Turismo", 400000, false));
        aviones.get(0).getSillas().add(new Silla('C', 6, "Turismo", 400000, false));
        aviones.get(0).getSillas().add(new Silla('D', 6, "Turismo", 400000, false));
        aviones.get(0).getSillas().add(new Silla('A', 7, "Turismo", 400000, false));
        aviones.get(0).getSillas().add(new Silla('B', 7, "Turismo", 400000, false));
        aviones.get(0).getSillas().add(new Silla('C', 7, "Turismo", 400000, false));
        aviones.get(0).getSillas().add(new Silla('D', 7, "Turismo", 400000, false));
        aviones.get(0).getSillas().add(new Silla('A', 8, "Turismo", 400000, false));
        aviones.get(0).getSillas().add(new Silla('B', 8, "Turismo", 400000, false));
        aviones.get(0).getSillas().add(new Silla('C', 8, "Turismo", 400000, false));
        aviones.get(0).getSillas().add(new Silla('D', 8, "Turismo", 400000, false));
        aviones.get(0).getSillas().add(new Silla('A', 9, "Turismo", 400000, false));
        aviones.get(0).getSillas().add(new Silla('B', 9, "Turismo", 400000, false));
        aviones.get(0).getSillas().add(new Silla('C', 9, "Turismo", 400000, false));
        aviones.get(0).getSillas().add(new Silla('D', 9, "Turismo", 400000, false));
        aviones.get(0).getSillas().add(new Silla('A', 10, "Turismo", 400000, false));
        aviones.get(0).getSillas().add(new Silla('B', 10, "Turismo", 400000, false));
        aviones.get(0).getSillas().add(new Silla('C', 10, "Turismo", 400000, false));
        aviones.get(0).getSillas().add(new Silla('D', 10, "Turismo", 400000, false));
        aviones.get(0).getSillas().add(new Silla('A', 11, "Turismo", 400000, false));
        aviones.get(0).getSillas().add(new Silla('B', 11, "Turismo", 400000, false));
        aviones.get(0).getSillas().add(new Silla('C', 11, "Turismo", 400000, false));
        aviones.get(0).getSillas().add(new Silla('D', 11, "Turismo", 400000, false));
        aviones.get(0).getSillas().add(new Silla('A', 12, "Turismo", 400000, false));
        aviones.get(0).getSillas().add(new Silla('B', 12, "Turismo", 400000, false));
        aviones.get(0).getSillas().add(new Silla('C', 12, "Turismo", 400000, false));
        aviones.get(0).getSillas().add(new Silla('D', 12, "Turismo", 400000, false));

    }

    public void SillasA() {
        aviones.get(1).getSillas().add(new Silla('A', 1, "Primera Clase", 80000, false));
        aviones.get(1).getSillas().add(new Silla('B', 1, "Primera Clase", 80000, false));
        aviones.get(1).getSillas().add(new Silla('A', 2, "Primera Clase", 80000, false));
        aviones.get(1).getSillas().add(new Silla('B', 2, "Primera Clase", 80000, false));
        aviones.get(1).getSillas().add(new Silla('A', 3, "Primera Clase", 80000, false));
        aviones.get(1).getSillas().add(new Silla('B', 3, "Primera Clase", 80000, false));
        aviones.get(1).getSillas().add(new Silla('A', 4, "Primera Clase", 80000, false));
        aviones.get(1).getSillas().add(new Silla('B', 4, "Primera Clase", 80000, false));
        aviones.get(1).getSillas().add(new Silla('A', 5, "Primera Clase", 80000, false));
        aviones.get(1).getSillas().add(new Silla('B', 5, "Primera Clase", 80000, false));
    }

    public void SillasCG() {
        //creacion de 4 sillas en Primera clase 
        aviones.get(2).getSillas().add(new Silla('A', 1, "Primera Clase", 1200000, false));
        aviones.get(2).getSillas().add(new Silla('B', 1, "Primera Clase", 1200000, false));
        aviones.get(2).getSillas().add(new Silla('A', 2, "Primera Clase", 1200000, false));
        aviones.get(2).getSillas().add(new Silla('B', 2, "Primera Clase", 1200000, false));
        aviones.get(2).getSillas().add(new Silla('A', 3, "Primera Clase", 1200000, false));
        aviones.get(2).getSillas().add(new Silla('B', 3, "Primera Clase", 1200000, false));
        //Creacion de 6 sillas Bussines
        aviones.get(2).getSillas().add(new Silla('A', 4, "Business", 2400000, false));
        aviones.get(2).getSillas().add(new Silla('B', 4, "Business", 2400000, false));
        aviones.get(2).getSillas().add(new Silla('C', 4, "Business", 2400000, false));
        aviones.get(2).getSillas().add(new Silla('A', 5, "Business", 2400000, false));
        aviones.get(2).getSillas().add(new Silla('B', 5, "Business", 2400000, false));
        aviones.get(2).getSillas().add(new Silla('C', 5, "Business", 2400000, false));
        //Creacion de 28 sillas Turista
        aviones.get(2).getSillas().add(new Silla('A', 6, "Turismo", 3000000, false));
        aviones.get(2).getSillas().add(new Silla('B', 6, "Turismo", 3000000, false));
        aviones.get(2).getSillas().add(new Silla('C', 6, "Turismo", 3000000, false));
        aviones.get(2).getSillas().add(new Silla('D', 6, "Turismo", 3000000, false));
        aviones.get(2).getSillas().add(new Silla('A', 7, "Turismo", 3000000, false));
        aviones.get(2).getSillas().add(new Silla('B', 7, "Turismo", 3000000, false));
        aviones.get(2).getSillas().add(new Silla('C', 7, "Turismo", 3000000, false));
        aviones.get(2).getSillas().add(new Silla('D', 7, "Turismo", 3000000, false));
        aviones.get(2).getSillas().add(new Silla('A', 8, "Turismo", 3000000, false));
        aviones.get(2).getSillas().add(new Silla('B', 8, "Turismo", 3000000, false));
        aviones.get(2).getSillas().add(new Silla('C', 8, "Turismo", 3000000, false));
        aviones.get(2).getSillas().add(new Silla('D', 8, "Turismo", 3000000, false));
        aviones.get(2).getSillas().add(new Silla('A', 9, "Turismo", 3000000, false));
        aviones.get(2).getSillas().add(new Silla('B', 9, "Turismo", 3000000, false));
        aviones.get(2).getSillas().add(new Silla('C', 9, "Turismo", 3000000, false));
        aviones.get(2).getSillas().add(new Silla('D', 9, "Turismo", 3000000, false));
        aviones.get(2).getSillas().add(new Silla('A', 10, "Turismo", 3000000, false));
        aviones.get(2).getSillas().add(new Silla('B', 10, "Turismo", 3000000, false));
        aviones.get(2).getSillas().add(new Silla('C', 10, "Turismo", 3000000, false));
        aviones.get(2).getSillas().add(new Silla('D', 10, "Turismo", 3000000, false));
        aviones.get(2).getSillas().add(new Silla('A', 11, "Turismo", 3000000, false));
        aviones.get(2).getSillas().add(new Silla('B', 11, "Turismo", 3000000, false));
        aviones.get(2).getSillas().add(new Silla('C', 11, "Turismo", 3000000, false));
        aviones.get(2).getSillas().add(new Silla('D', 11, "Turismo", 3000000, false));
        aviones.get(2).getSillas().add(new Silla('A', 12, "Turismo", 3000000, false));
        aviones.get(2).getSillas().add(new Silla('B', 12, "Turismo", 3000000, false));
        aviones.get(2).getSillas().add(new Silla('C', 12, "Turismo", 3000000, false));
        aviones.get(2).getSillas().add(new Silla('D', 12, "Turismo", 3000000, false));
        aviones.get(2).getSillas().add(new Silla('A', 13, "Turismo", 3000000, false));
        aviones.get(2).getSillas().add(new Silla('B', 13, "Turismo", 3000000, false));
        aviones.get(2).getSillas().add(new Silla('C', 13, "Turismo", 3000000, false));
        aviones.get(2).getSillas().add(new Silla('D', 13, "Turismo", 3000000, false));
        aviones.get(2).getSillas().add(new Silla('A', 14, "Turismo", 3000000, false));
        aviones.get(2).getSillas().add(new Silla('B', 14, "Turismo", 3000000, false));
        aviones.get(2).getSillas().add(new Silla('C', 14, "Turismo", 3000000, false));
        aviones.get(2).getSillas().add(new Silla('D', 14, "Turismo", 3000000, false));
    }

    public void pintar() {
        System.out.println("           **          ");
        System.out.println("         *    *         ");
        System.out.println("        *      *        ");
        System.out.println("       *[A1][B1]*       ");
        System.out.println("       *[A2][B2]*       ");
        System.out.println("       *[A3][B3]*       ");
        System.out.println("  ******     ******  ");
        System.out.println(" *                 * ");
        System.out.println("  ******     ******  ");
        System.out.println("       *     *       ");
        System.out.println("       *     *       ");
        System.out.println("       *     *       ");
        System.out.println("       *     *       ");
        System.out.println("        *   *        ");
        System.out.println("         *_*         ");

    }
}
