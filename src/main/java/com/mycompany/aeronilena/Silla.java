/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aeronilena;

/**
 *
 * @author orlan
 */
public class Silla {

    private char posicionX;
    private int posicionY;
    private String tipoSilla;
    private int precio;
    private boolean estado;
    private Persona persona;

    public Silla(char posicionX, int posicionY, String tipoSilla, int precio, boolean estado) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.tipoSilla = tipoSilla;
        this.precio = precio;
        this.estado = estado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public char getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(char posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    public String getTipoSilla() {
        return tipoSilla;
    }

    public void setTipoSilla(String tipoSilla) {
        this.tipoSilla = tipoSilla;
    }

}
