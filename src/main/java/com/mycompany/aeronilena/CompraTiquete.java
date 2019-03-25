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
public class CompraTiquete {
Scanner sc = new Scanner(System.in);
    ArrayList<Avion>avion;
    int i;
    public ArrayList<Avion> CompraTiquete(ArrayList<Avion> avion) throws InputMismatchException{
        this.avion=avion;
            int opcion;
            do{
            System.out.println("Vuelos Disponibles:");
            for(int i=0;i<avion.size();i++){
                System.out.println(i+". Destino: "+avion.get(i).getDestino()+", Tipo Avion: "+avion.get(i).getTipoAvion());            
            }
            System.out.print("Seleccione un vuelo: ");
                opcion=sc.nextInt();
                switch (opcion){
                    case 0:
                        pintaSillas(opcion);
                        comprar(opcion);
                        break;
                    case 1:
                        pintaSillas(opcion);
                        comprar(opcion);
                        break;
                    case 2:
                        pintaSillas(opcion);
                        comprar(opcion);
                        break;
                }
            }while(opcion!=0); 
        return avion;
    } 
    public void comprar(int vuelo)throws InputMismatchException{
         int opcion=0;
            do {
                if (vuelo==1 || vuelo==0 || vuelo==2){
                    System.out.println("Seleccione la clase de silla que desea comprar");
                    System.out.println("1.Primera Clase");
                    if (vuelo==0 || vuelo==2){
                        System.out.println("2.Turista");
                        if (vuelo==2){
                            System.out.println("3.Busines");
                        }
                    }    
                }
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        costoSillas(vuelo,"Primera Clase");
                        break;
                    case 2:
                        costoSillas(vuelo,"Turismo");
                        break;
                    case 3:
                        costoSillas(vuelo,"Business");
                        break;
                }

            } while (opcion != 0);
    }
    public void costoSillas(int vuelo, String clase){
        String silla;
        for( i=0;i<avion.get(vuelo).getSillas().size();i++){
            if(avion.get(vuelo).getSillas().get(i).getTipoSilla().equals(clase) && avion.get(vuelo).getSillas().get(i).isEstado()==false){
                System.out.println("El costo de la silla "+ clase +" es de: "+avion.get(vuelo).getSillas().get(i).getPrecio()+" "+avion.get(vuelo).getSillas().get(i).getPosicionX()+
                                        avion.get(vuelo).getSillas().get(i).getPosicionY());
                if(avion.get(vuelo).getSillas().get(i).getPosicionY()>9 && avion.get(vuelo).getSillas().get(i).isEstado()==false){
                    System.out.println("El costo de la silla "+ clase +" es de: "+avion.get(vuelo).getSillas().get(i).getPrecio()+" "+avion.get(vuelo).getSillas().get(i).getPosicionX()+
                                        avion.get(vuelo).getSillas().get(i).getPosicionY());
                }
            }
        }
        System.out.println("Por favor digite la silla que desea comprar");
        silla=sc.next();
    }
    public void pintaSillas(int vuelo){
        
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
    
    public void pintarPrimera(int vuelo){
        for( i=0;i<avion.get(vuelo).getSillas().size();i++){
            if(avion.get(vuelo).getSillas().get(i).getTipoSilla().equals("Primera Clase")){
                if(avion.get(vuelo).getSillas().get(i).getPosicionY()>9){
                    System.out.println("                 *   "+avion.get(vuelo).getSillas().get(i).getPosicionX()+avion.get(vuelo).getSillas().get(i).getPosicionY()+"   "
                                       +avion.get(vuelo).getSillas().get(i+1).getPosicionX()+avion.get(vuelo).getSillas().get(i+1).getPosicionY()+"   *        ");
                    i+=1;
                }else{
                    System.out.println("                 *   "+avion.get(vuelo).getSillas().get(i).getPosicionX()+""+avion.get(vuelo).getSillas().get(i).getPosicionY()+"   "
                                       +avion.get(vuelo).getSillas().get(i+1).getPosicionX()+avion.get(vuelo).getSillas().get(i+1).getPosicionY()+"   *        ");
                    i+=1;
                }
            }
        }
    }
    public void pintarBusiness(int vuelo){
        for( i=0;i<avion.get(vuelo).getSillas().size();i++){
            if(avion.get(vuelo).getSillas().get(i).getTipoSilla().equals("Business")){
                if(avion.get(vuelo).getSillas().get(i).getPosicionY()>9){
                    System.out.println("                 *  "+avion.get(vuelo).getSillas().get(i).getPosicionX()+avion.get(vuelo).getSillas().get(i).getPosicionY()+" "
                                       +avion.get(vuelo).getSillas().get(i+1).getPosicionX()+avion.get(vuelo).getSillas().get(i+1).getPosicionY()+" "
                                       +avion.get(vuelo).getSillas().get(i+2).getPosicionX()+avion.get(vuelo).getSillas().get(i+2).getPosicionY()+"   *        ");
                    i+=2;
                }else{
                    System.out.println("                 *  "+avion.get(vuelo).getSillas().get(i).getPosicionX()+""+avion.get(vuelo).getSillas().get(i).getPosicionY()+" "
                                       +avion.get(vuelo).getSillas().get(i+1).getPosicionX()+avion.get(vuelo).getSillas().get(i+1).getPosicionY()+" "
                                       +avion.get(vuelo).getSillas().get(i+2).getPosicionX()+avion.get(vuelo).getSillas().get(i+2).getPosicionY()+"   *        ");
                    i+=2;
                }
            }
        }
    }
    public void pintarTurismo(int vuelo){
        for( i=0;i<avion.get(vuelo).getSillas().size();i++){
            if(avion.get(vuelo).getSillas().get(i).getTipoSilla().equals("Turismo")){
                if(avion.get(vuelo).getSillas().get(i).getPosicionY()>9){
                    System.out.println("                 *"+avion.get(vuelo).getSillas().get(i).getPosicionX()+avion.get(vuelo).getSillas().get(i).getPosicionY()+""
                                       +avion.get(vuelo).getSillas().get(i+1).getPosicionX()+avion.get(vuelo).getSillas().get(i+1).getPosicionY()+" "
                                       +avion.get(vuelo).getSillas().get(i+2).getPosicionX()+avion.get(vuelo).getSillas().get(i+2).getPosicionY()+""
                                       +avion.get(vuelo).getSillas().get(i+3).getPosicionX()+avion.get(vuelo).getSillas().get(i+3).getPosicionY()+"*        ");
                    i+=3;
                }else{
                    System.out.println("                 * "+avion.get(vuelo).getSillas().get(i).getPosicionX()+avion.get(vuelo).getSillas().get(i).getPosicionY()+""
                                       +avion.get(vuelo).getSillas().get(i+1).getPosicionX()+avion.get(vuelo).getSillas().get(i+1).getPosicionY()+"  "
                                       +avion.get(vuelo).getSillas().get(i+2).getPosicionX()+avion.get(vuelo).getSillas().get(i+2).getPosicionY()+""
                                       +avion.get(vuelo).getSillas().get(i+3).getPosicionX()+avion.get(vuelo).getSillas().get(i+3).getPosicionY()+"  *        ");
                    i+=3;
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
