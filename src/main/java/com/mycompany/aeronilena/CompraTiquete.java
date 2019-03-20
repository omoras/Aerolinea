/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aeronilena;

import java.util.ArrayList;

/**
 *
 * @author orlan
 */
public class CompraTiquete {

    public ArrayList<Avion> CompraTiquete(ArrayList<Avion> avion){
        System.out.println("Vuelos Disponibles:");
        for(int i=0;i<avion.size();i++){
            System.out.println(i+". Destino: "+avion.get(i).getDestino()+", Tipo Avion: "+avion.get(i).getTipoAvion());            
        }
        return avion;
    } 
}
