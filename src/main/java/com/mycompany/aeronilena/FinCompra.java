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
 * @author OrlandoMora
 */
public class FinCompra {

    ArrayList<Avion> avion;
    Scanner sc = new Scanner(System.in);

    public ArrayList<Avion> FinCompra(ArrayList<Avion> avion) {
        this.avion = avion;
        int opcion = -1;
        do {
            System.out.println("Vuelos Disponibles:");
            for (int i = 0; i < avion.size(); i++) {
                if (avion.get(i).getEstado()) {
                    System.out.println(i + ". Destino: " + avion.get(i).getDestino() + ", Tipo Avion: " + avion.get(i).getTipoAvion());
                }
            }
            System.out.println("-1. Salir");
            try {
                System.out.println("Seleccione el Vuelo Para Finalizar las ventas");
                opcion = Integer.parseInt(sc.next());
                switch (opcion) {
                    case 0:
                        cambiarEstado(opcion);
                        opcion = -1;
                        break;
                    case 1:
                        cambiarEstado(opcion);
                        opcion = -1;
                        break;
                    case 2:
                        cambiarEstado(opcion);
                        opcion = -1;
                        break;
                    default:
                        System.out.println("El vuelo que digito no existe.");
                }

            } catch (NumberFormatException e) {
                System.out.println("lo que digito no es un numero.");
            }catch(Exception e){
                System.out.println("no entiendo lo que dice.");
            }

        } while (opcion != -1);
        return avion;
    }

    public void cambiarEstado(int vuelo) {
        avion.get(vuelo).setEstado(false);
    }
}
