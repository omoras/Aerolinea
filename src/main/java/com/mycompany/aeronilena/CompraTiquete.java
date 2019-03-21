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
public class CompraTiquete {
Scanner sc = new Scanner(System.in);
    ArrayList<Avion>avion;
    int i;
    public ArrayList<Avion> CompraTiquete(ArrayList<Avion> avion){
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
                break;
            case 1:
                pintaSillas(opcion);
                break;
            case 2:
                pintaSillas(opcion);
                break;
        }
        }while(opcion!=0);
        return avion;
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
