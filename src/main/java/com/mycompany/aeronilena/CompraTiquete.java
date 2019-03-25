/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aeronilena;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author orlan
 */
public class CompraTiquete {

    Scanner sc = new Scanner(System.in);
    ArrayList<Avion> avion;
    int i;

    public ArrayList<Avion> CompraTiquete(ArrayList<Avion> avion) throws InputMismatchException {
        this.avion = avion;
        int opcion;
        int precio;
        do {
            System.out.println("Vuelos Disponibles:");
            for (int i = 0; i < avion.size(); i++) {
                System.out.println(i + ". Destino: " + avion.get(i).getDestino() + ", Tipo Avion: " + avion.get(i).getTipoAvion());
            }
            System.out.println("Seleccione un vuelo: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 0:
                    pintaSillas(opcion);
                    System.out.println("Seleccione una Silla: ");
                    String silla = sc.next();
                    precio = validarSilla(silla, opcion);
                    if (precio > 0) {
                        menuCompras(precio, silla, opcion);
                    } else {
                        System.out.println("La silla no se encuentra disponible.");
                    }

                    //comprar(opcion);
                    break;
                case 1:
                    pintaSillas(opcion);
                    //comprar(opcion);
                    break;
                case 2:
                    pintaSillas(opcion);
                    //comprar(opcion);
                    break;
            }
        } while (opcion != 0);
        return avion;
    }

    public void menuCompras(int precio, String silla,int vuelo) {
        char opcion;
        String tipo=tipoSilla(silla, vuelo);
        System.out.println("La silla es de tipo "+tipo+" y tiene un de: " + precio);
        System.out.println("Desea Comprar la silla s/n: ");
        opcion=sc.next().charAt(0);
        if(opcion=='s'||opcion=='S'){
            Persona p=solicitaDatos();
            cambiaEstado(p,silla,vuelo);
        }
        
    }

    public Persona solicitaDatos() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Persona p=null;
        try{
        System.out.println("Por favor digite su nombre: ");
        String nombre=sc.next();
        System.out.println("Por favot digite su apellido: ");
        String apellido=sc.next();
        System.out.println("Por favor digite su Documento: ");
        int documento=sc.nextInt();
        System.out.println("Por favor digite su Fecha de nacimiento yyyy-MM-dd:");
        String nacimiento=sc.next();
        Date fecha = sdf.parse(nacimiento);
        p=new Persona(nombre, apellido, documento, fecha);
        
        }catch(NullPointerException e){
            System.out.println("No ha digitado nada.");
        } catch (ParseException ex) {
            System.out.println("La fecha Ingresada no es valida");
        }
        return p;
                        
     }

    public void cambiaEstado(Persona p,String silla, int vuelo) {
        String sillaAvion;
        for (i = 0; i < avion.get(vuelo).getSillas().size(); i++) {
            sillaAvion = avion.get(vuelo).getSillas().get(i).getPosicionX() + "" + avion.get(vuelo).getSillas().get(i).getPosicionY();
            if ((sillaAvion.equals(silla))) {
                avion.get(vuelo).getSillas().get(i).setPersona(p);
                avion.get(vuelo).getSillas().get(i).setEstado(false);
            }
        }
    }

    public String tipoSilla(String silla, int vuelo) {
        String sillaAvion="";
        for (i = 0; i < avion.get(vuelo).getSillas().size(); i++) {
            sillaAvion = avion.get(vuelo).getSillas().get(i).getPosicionX() + "" + avion.get(vuelo).getSillas().get(i).getPosicionY();
            if ((sillaAvion.equals(silla))) {
                sillaAvion=avion.get(vuelo).getSillas().get(i).getTipoSilla();
                break;
            }
        }
        return sillaAvion;
    }
    
    public int validarSilla(String silla, int vuelo) {
        String sillaAvion;
        int precio = 0;
        for (i = 0; i < avion.get(vuelo).getSillas().size(); i++) {
            sillaAvion = avion.get(vuelo).getSillas().get(i).getPosicionX() + "" + avion.get(vuelo).getSillas().get(i).getPosicionY();
            if ((sillaAvion.equals(silla))) {
                if (avion.get(vuelo).getSillas().get(i).isEstado()) {
                    precio = avion.get(vuelo).getSillas().get(i).getPrecio();
                    break;
                } else {
                    precio = -1;
                }

            }
        }
        return precio;
    }

    /*
    public void comprar(int vuelo) throws InputMismatchException {
        int opcion = 0;
        do {
            if (vuelo == 1 || vuelo == 0 || vuelo == 2) {
                System.out.println("Seleccione la clase de silla que desea comprar");
                System.out.println("1.Primera Clase");
                if (vuelo == 0 || vuelo == 2) {
                    System.out.println("2.Turista");
                    if (vuelo == 2) {
                        System.out.println("3.Busines");
                    }
                }
            }
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    costoSillas(vuelo, "Primera Clase");
                    break;
                case 2:
                    costoSillas(vuelo, "Turismo");
                    break;
                case 3:
                    costoSillas(vuelo, "Businesss");
                    break;
            }

        } while (opcion != 0);
    }

    public void costoSillas(int vuelo, String clase) throws InputMismatchException {
        int silla;
        for (i = 0; i < avion.get(vuelo).getSillas().size(); i++) {
            if (avion.get(vuelo).getSillas().get(i).getTipoSilla().equals(clase) && avion.get(vuelo).getSillas().get(i).isEstado() == false) {
                System.out.println(i + " el costo de la silla " + clase + " es de: " + avion.get(vuelo).getSillas().get(i).getPrecio() + " " + avion.get(vuelo).getSillas().get(i).getPosicionX()
                        + avion.get(vuelo).getSillas().get(i).getPosicionY());
                if (avion.get(vuelo).getSillas().get(i).getPosicionY() > 9 && avion.get(vuelo).getSillas().get(i).isEstado() == false) {
                    System.out.println(i + " el costo de la silla " + clase + " es de: " + avion.get(vuelo).getSillas().get(i).getPrecio() + " " + avion.get(vuelo).getSillas().get(i).getPosicionX()
                            + avion.get(vuelo).getSillas().get(i).getPosicionY());
                }
            }
        }
        System.out.println("Seleccione la clase de silla que desea comprar: ");
        silla = sc.nextInt();
        //System.out.println(avion.get(vuelo).getSillas().get(silla).setEstado(true));
    }
     */
    public void pintaSillas(int vuelo) {

        System.out.println("                       * *            ");
        System.out.println("                      * * *            ");
        System.out.println("                   *         *         ");
        System.out.println("                  *           *        ");
        pintarPrimera(vuelo);
        pintarBusiness(vuelo);
        pintarTurismo(vuelo);
        System.out.println("                  *-----------*        ");
        System.out.println("                   *---------*        ");
        System.out.println("                     *-----*        ");
        System.out.println("                      *-^-*        ");

    }

    public void pintarPrimera(int vuelo) {
        for (i = 0; i < avion.get(vuelo).getSillas().size(); i++) {
            if (avion.get(vuelo).getSillas().get(i).getTipoSilla().equals("Primera Clase")) {
                if (avion.get(vuelo).getSillas().get(i).getPosicionY() > 9) {
                    if (avion.get(vuelo).getSillas().get(i).isEstado()) {
                        System.out.print("                 *   \033[32m" + avion.get(vuelo).getSillas().get(i).getPosicionX() + "" + avion.get(vuelo).getSillas().get(i).getPosicionY() + "\033[30m  ");
                    } else {
                        System.out.print("                 *   \033[31m" + avion.get(vuelo).getSillas().get(i).getPosicionX() + "" + avion.get(vuelo).getSillas().get(i).getPosicionY() + "\033[30m  ");
                    }
                    if (avion.get(vuelo).getSillas().get(i + 1).isEstado()) {
                        System.out.println("\033[32m" + avion.get(vuelo).getSillas().get(i + 1).getPosicionX() + avion.get(vuelo).getSillas().get(i + 1).getPosicionY() + "\033[30m   *        ");
                    } else {
                        System.out.println("\033[31m" + avion.get(vuelo).getSillas().get(i + 1).getPosicionX() + avion.get(vuelo).getSillas().get(i + 1).getPosicionY() + "\033[30m   *        ");
                    }

                    i += 1;
                } else {
                    if (avion.get(vuelo).getSillas().get(i).isEstado()) {
                        System.out.print("                 *   \033[32m" + avion.get(vuelo).getSillas().get(i).getPosicionX() + "" + avion.get(vuelo).getSillas().get(i).getPosicionY() + "\033[30m  ");
                    } else {
                        System.out.print("                 *   \033[31m" + avion.get(vuelo).getSillas().get(i).getPosicionX() + "" + avion.get(vuelo).getSillas().get(i).getPosicionY() + "\033[30m  ");
                    }
                    if (avion.get(vuelo).getSillas().get(i + 1).isEstado()) {
                        System.out.println("\033[32m" + avion.get(vuelo).getSillas().get(i + 1).getPosicionX() + avion.get(vuelo).getSillas().get(i + 1).getPosicionY() + "\033[30m   *        ");
                    } else {
                        System.out.println("\033[31m" + avion.get(vuelo).getSillas().get(i + 1).getPosicionX() + avion.get(vuelo).getSillas().get(i + 1).getPosicionY() + "\033[30m   *        ");
                    }

                    i += 1;
                }
            }
        }
    }

    public void pintarBusiness(int vuelo) {
        for (i = 0; i < avion.get(vuelo).getSillas().size(); i++) {
            if (avion.get(vuelo).getSillas().get(i).getTipoSilla().equals("Business")) {
                if (avion.get(vuelo).getSillas().get(i).getPosicionY() > 9) {
                    if (avion.get(vuelo).getSillas().get(i).isEstado()) {
                        System.out.print("                 *  \033[32m" + avion.get(vuelo).getSillas().get(i).getPosicionX() + avion.get(vuelo).getSillas().get(i).getPosicionY() + "\033[30m ");
                    } else {
                        System.out.print("                 *  \033[31m" + avion.get(vuelo).getSillas().get(i).getPosicionX() + avion.get(vuelo).getSillas().get(i).getPosicionY() + "\033[30m ");
                    }
                    if (avion.get(vuelo).getSillas().get(i + 1).isEstado()) {
                        System.out.print("\033[32m" + avion.get(vuelo).getSillas().get(i + 1).getPosicionX() + avion.get(vuelo).getSillas().get(i + 1).getPosicionY() + "\033[30m ");
                    } else {
                        System.out.print("\033[31m" + avion.get(vuelo).getSillas().get(i + 1).getPosicionX() + avion.get(vuelo).getSillas().get(i + 1).getPosicionY() + "\033[30m ");
                    }
                    if (avion.get(vuelo).getSillas().get(i + 2).isEstado()) {
                        System.out.println("\033[32m" + avion.get(vuelo).getSillas().get(i + 2).getPosicionX() + avion.get(vuelo).getSillas().get(i + 2).getPosicionY() + "\033[30m   *        ");
                    } else {
                        System.out.println("\033[31m" + avion.get(vuelo).getSillas().get(i + 2).getPosicionX() + avion.get(vuelo).getSillas().get(i + 2).getPosicionY() + "\033[30m   *        ");
                    }
                    i += 2;
                } else {
                    if (avion.get(vuelo).getSillas().get(i).isEstado()) {
                        System.out.print("                 *  \033[32m" + avion.get(vuelo).getSillas().get(i).getPosicionX() + avion.get(vuelo).getSillas().get(i).getPosicionY() + "\033[30m ");
                    } else {
                        System.out.print("                 *  \033[31m" + avion.get(vuelo).getSillas().get(i).getPosicionX() + avion.get(vuelo).getSillas().get(i).getPosicionY() + "\033[30m ");
                    }
                    if (avion.get(vuelo).getSillas().get(i + 1).isEstado()) {
                        System.out.print("\033[32m" + avion.get(vuelo).getSillas().get(i + 1).getPosicionX() + avion.get(vuelo).getSillas().get(i + 1).getPosicionY() + "\033[30m ");
                    } else {
                        System.out.print("\033[31m" + avion.get(vuelo).getSillas().get(i + 1).getPosicionX() + avion.get(vuelo).getSillas().get(i + 1).getPosicionY() + "\033[30m ");
                    }
                    if (avion.get(vuelo).getSillas().get(i + 2).isEstado()) {
                        System.out.println("\033[32m" + avion.get(vuelo).getSillas().get(i + 2).getPosicionX() + avion.get(vuelo).getSillas().get(i + 2).getPosicionY() + "\033[30m   *        ");
                    } else {
                        System.out.println("\033[31m" + avion.get(vuelo).getSillas().get(i + 2).getPosicionX() + avion.get(vuelo).getSillas().get(i + 2).getPosicionY() + "\033[30m   *        ");
                    }
                    i += 2;

                }
            }
        }
    }

    public void pintarTurismo(int vuelo) {
        for (i = 0; i < avion.get(vuelo).getSillas().size(); i++) {
            if (avion.get(vuelo).getSillas().get(i).getTipoSilla().equals("Turismo")) {
                if (avion.get(vuelo).getSillas().get(i).getPosicionY() > 9) {
                    if (avion.get(vuelo).getSillas().get(i).isEstado()) {
                        System.out.print("                 *\033[32m" + avion.get(vuelo).getSillas().get(i).getPosicionX() + avion.get(vuelo).getSillas().get(i).getPosicionY() + "\033[30m");
                    } else {
                        System.out.print("                 *\033[31m" + avion.get(vuelo).getSillas().get(i).getPosicionX() + avion.get(vuelo).getSillas().get(i).getPosicionY() + "\033[30m");
                    }
                    if (avion.get(vuelo).getSillas().get(i + 1).isEstado()) {
                        System.out.print("\033[32m" + avion.get(vuelo).getSillas().get(i + 1).getPosicionX() + avion.get(vuelo).getSillas().get(i + 1).getPosicionY() + "\033[30m ");
                    } else {
                        System.out.print("\033[31m" + avion.get(vuelo).getSillas().get(i + 1).getPosicionX() + avion.get(vuelo).getSillas().get(i + 1).getPosicionY() + "\033[30m ");
                    }
                    if (avion.get(vuelo).getSillas().get(i + 2).isEstado()) {
                        System.out.print("\033[32m" + avion.get(vuelo).getSillas().get(i + 2).getPosicionX() + avion.get(vuelo).getSillas().get(i + 2).getPosicionY() + "\033[30m");
                    } else {
                        System.out.print("\033[31m" + avion.get(vuelo).getSillas().get(i + 2).getPosicionX() + avion.get(vuelo).getSillas().get(i + 2).getPosicionY() + "\033[30m");
                    }
                    if (avion.get(vuelo).getSillas().get(i + 3).isEstado()) {
                        System.out.println("\033[32m" + avion.get(vuelo).getSillas().get(i + 3).getPosicionX() + avion.get(vuelo).getSillas().get(i + 3).getPosicionY() + "\033[30m*        ");
                    } else {
                        System.out.println("\033[31m" + avion.get(vuelo).getSillas().get(i + 3).getPosicionX() + avion.get(vuelo).getSillas().get(i + 3).getPosicionY() + "\033[30m*        ");
                    }
                    i += 3;
                } else {
                    if (avion.get(vuelo).getSillas().get(i).isEstado()) {
                        System.out.print("                 * \033[32m" + avion.get(vuelo).getSillas().get(i).getPosicionX() + avion.get(vuelo).getSillas().get(i).getPosicionY() + "\033[30m");
                    } else {
                        System.out.print("                 * \033[31m" + avion.get(vuelo).getSillas().get(i).getPosicionX() + avion.get(vuelo).getSillas().get(i).getPosicionY() + "\033[30m");
                    }
                    if (avion.get(vuelo).getSillas().get(i + 1).isEstado()) {
                        System.out.print("\033[32m" + avion.get(vuelo).getSillas().get(i + 1).getPosicionX() + avion.get(vuelo).getSillas().get(i + 1).getPosicionY() + "\033[30m  ");
                    } else {
                        System.out.print("\033[31m" + avion.get(vuelo).getSillas().get(i + 1).getPosicionX() + avion.get(vuelo).getSillas().get(i + 1).getPosicionY() + "\033[30m  ");
                    }
                    if (avion.get(vuelo).getSillas().get(i + 2).isEstado()) {
                        System.out.print("\033[32m" + avion.get(vuelo).getSillas().get(i + 2).getPosicionX() + avion.get(vuelo).getSillas().get(i + 2).getPosicionY() + "\033[30m");
                    } else {
                        System.out.print("\033[31m" + avion.get(vuelo).getSillas().get(i + 2).getPosicionX() + avion.get(vuelo).getSillas().get(i + 2).getPosicionY() + "\033[30m");
                    }
                    if (avion.get(vuelo).getSillas().get(i + 3).isEstado()) {
                        System.out.println("\033[32m" + avion.get(vuelo).getSillas().get(i + 3).getPosicionX() + avion.get(vuelo).getSillas().get(i + 3).getPosicionY() + "\033[30m  *        ");
                    } else {
                        System.out.println("\033[31m" + avion.get(vuelo).getSillas().get(i + 3).getPosicionX() + avion.get(vuelo).getSillas().get(i + 3).getPosicionY() + "\033[30m  *        ");
                    }
                    i += 3;
                }
            }
        }
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
