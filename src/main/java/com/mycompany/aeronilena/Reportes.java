/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aeronilena;

import java.util.ArrayList;

/**
 *
 * @author OrlandoMora
 */
public class Reportes {
     ArrayList<Avion> avion;
    public ArrayList<Avion> reportes(ArrayList<Avion> avion){
        this.avion=avion;
        int valorTotal=0;
        for(int i =0;i<avion.size();i++){
            if(!avion.get(i).getEstado()){
                for(int j=0;j<avion.get(i).getSillas().size();j++){
                    if(!avion.get(i).getSillas().get(j).isEstado()){
                        System.out.println(avion.get(i).getSillas().get(j).getPosicionX()+avion.get(i).getSillas().get(j).getPosicionY()+
                                " nombre:"+avion.get(i).getSillas().get(j).getPersona().getNombre()+" "+avion.get(i).getSillas().get(j).getPersona().getApellido()+
                                " con numero de documento: "+avion.get(i).getSillas().get(j).getPersona().getDocumento()+
                                " nacido en: "+avion.get(i).getSillas().get(j).getPersona().getFechaNacimiento());
                        valorTotal+=avion.get(i).getSillas().get(j).getPrecio();
                    }
                }
                System.out.println("El Valor Total Vendido del Avion con destino a "+avion.get(i).getDestino()+" es de:"
                +valorTotal);
            }
        }
        
        return avion;
    }
}
