/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aeronilena;

import java.lang.invoke.MethodHandles;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author orlan
 */
public class CompraTiquete {

    Scanner sc = new Scanner(System.in);
    ArrayList<Avion> avion;
    int i;
    boolean valida;

    public ArrayList<Avion> CompraTiquete(ArrayList<Avion> avion) {
        this.avion = avion;
        int opcion;
        int precio;

        do {
            System.out.println("Vuelos Disponibles:");
            for (int i = 0; i < avion.size(); i++) {
                if (avion.get(i).getEstado()) {
                    System.out.println(i + ". Destino: " + avion.get(i).getDestino() + ", Tipo Avion: " + avion.get(i).getTipoAvion());
                }
            }
            System.out.println("-1. Salir");
            try {
                System.out.print("Seleccione un vuelo: ");
                opcion = Integer.parseInt(sc.next());
                switch (opcion) {
                    case -1:
                        break;
                    case 0:
                        do {
                            pintaSillas(opcion);
                            valida = seleccionar(opcion);
                        } while (!valida);
                        opcion = -1;
                        break;
                    case 1:
                        do {
                            pintaSillas(opcion);
                            valida = seleccionar(opcion);
                        } while (!valida);
                        opcion = -1;
                        break;
                    case 2:
                        do {
                            pintaSillas(opcion);
                            valida = seleccionar(opcion);
                        } while (!valida);
                        opcion = -1;
                        break;
                    default:
                        System.out.println("El vuelo que digito no existe.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("\033[31m Lo que digito no es un Numero\033[30m");
                opcion = 0;
            }
        } while (opcion != -1);
        return avion;
    }

    public boolean seleccionar(int vuelo) {
        try {
            System.out.println("Seleccione una Silla: ");
            String silla = sc.next();
            int precio = validarSilla(silla, vuelo);
            if (precio > 0) {
                valida = menuCompras(precio, silla, vuelo);
                return valida;
            } else {
                if (precio == -1) {
                    System.out.println("La silla no se encuentra disponible.");
                }
                if (precio == 0) {
                    System.out.println("la silla no Existe.");
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Debe digitar algo.");
        } catch (Exception e) {
            System.out.println("\033[31mNo entido lo que digito\033[30m");
        }
        return false;
    }

    public boolean menuCompras(int precio, String silla, int vuelo) {
        char opcion;
        try {
            String tipo = tipoSilla(silla, vuelo);
            System.out.println("La silla es de tipo " + tipo + " y tiene un precio de: " + precio);
            System.out.print("Desea Comprar la silla s/n: ");
            opcion = sc.next().charAt(0);
            if (opcion == 's' || opcion == 'S') {
                Persona p = solicitaDatos();
                if (p != null) {
                    cambiaEstado(p, silla, vuelo);
                    return true;
                } else {
                    System.out.println("Datos Erroneos");
                    return false;
                }
            } else {
                return false;
            }
        } catch (NullPointerException e) {
            System.err.println("Debe digitar Algo");
        } catch (Exception e) {
            System.out.println("\033[31mNo entido lo que digito\033[30m");
        }
        return false;

    }

    public Persona solicitaDatos() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Persona p = null;
        boolean valida;
        String nombre, apellido, nacimiento;
        int documento;
        Date fecha;

        do {
            System.out.println("Por favor digite su nombre: ");
            nombre = sc.next();
            valida = validadarCadena(nombre, "nombre");
        } while (valida);
        do {
            System.out.println("Por favot digite su apellido: ");
            apellido = sc.next();
            valida = validadarCadena(apellido, "apellido");
        } while (valida);
        do {
            System.out.println("Por favor digite su Documento: ");
            documento = validarInt(sc.next(), "documento");
        } while (documento == -1);
        do {
            System.out.println("Por favor digite su Fecha de nacimiento yyyy-MM-dd:");
            nacimiento = sc.next();
            fecha = validarDate(nacimiento, "Fecha Nacimiento.");
        } while (fecha == null);

        p = new Persona(nombre, apellido, documento, fecha);

        return p;

    }

    public int validarInt(String numero, String tipo) {
        int documento = -1;
        try {
            documento = Integer.parseInt(numero);
            return documento;
        } catch (NumberFormatException e) {
            System.out.println("Lo que digito no es valido para" + tipo);
            return documento;
        }
    }

    public Date validarDate(String fecha1, String tipo) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
        try {
            fecha = sdf.parse(fecha1);
            return fecha;
        } catch (ParseException ex) {
            System.err.println("Lo que digito no es valido para" + tipo);
            return fecha;
        }

    }

    public boolean validadarCadena(String cadena, String tipo) {
        for (i = 0; i < cadena.length(); i++) {
            if (!Character.isAlphabetic(cadena.charAt(i))) {
                System.err.println(cadena.charAt(i) + " no es un caracter valido para " + tipo + ".");
                return true;
            }
        }
        return false;
    }

    public void cambiaEstado(Persona p, String silla, int vuelo) {
        String sillaAvion;
        for (i = 0; i < avion.get(vuelo).getSillas().size(); i++) {
            sillaAvion = avion.get(vuelo).getSillas().get(i).getPosicionX() + "" + avion.get(vuelo).getSillas().get(i).getPosicionY();
            if ((sillaAvion.equals(silla))) {
                avion.get(vuelo).getSillas().get(i).setPersona(p);
                avion.get(vuelo).getSillas().get(i).setEstado(false);
                System.out.println("Compra Realizada");
            }
        }
    }

    public String tipoSilla(String silla, int vuelo) {
        String sillaAvion = "";
        for (i = 0; i < avion.get(vuelo).getSillas().size(); i++) {
            sillaAvion = avion.get(vuelo).getSillas().get(i).getPosicionX() + "" + avion.get(vuelo).getSillas().get(i).getPosicionY();
            if ((sillaAvion.equals(silla))) {
                sillaAvion = avion.get(vuelo).getSillas().get(i).getTipoSilla();
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

}
