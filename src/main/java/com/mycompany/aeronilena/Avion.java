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
public class Avion {
    private String destino;
    private String tipoAvion;
    ArrayList<Sillas> sillas; 

    public Avion(String destino, String tipoAvion) {
        this.destino = destino;
        this.tipoAvion = tipoAvion;
        sillas=new ArrayList<>();
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getTipoAvion() {
        return tipoAvion;
    }

    public void setTipoAvion(String tipoAvion) {
        this.tipoAvion = tipoAvion;
    }

    public ArrayList<Sillas> getSillas() {
        return sillas;
    }

    public void setSillas(ArrayList<Sillas> sillas) {
        this.sillas = sillas;
    }
    
    
    
}
