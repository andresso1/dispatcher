/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.democall.entity;

/**
 *
 * @author Andres Sotelo
 */
public class Call {

	private String llamada;
	

	// Constructor, getter y setter

    public Call() {
    }

    public Call(String llamada) {
        this.llamada = llamada;
        
    }

    public String getLlamada() {
        return this.llamada;
    }

    public void setLlamada(String llamada) {
        this.llamada = llamada;
    }
        
}
