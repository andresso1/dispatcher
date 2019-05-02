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
public class Agent {
    
    private String nameAgent;
    private String typeAgent;
    private int status;
    private int codAgent;

    public Agent() {
    }

    public Agent(String nameAgent, String typeAgent, int status, int codAgent) {
        this.nameAgent = nameAgent;
        this.typeAgent = typeAgent;
        this.status = status;
        this.codAgent = codAgent;
    }

    public String getNameAgent() {
        return nameAgent;
    }

    public void setNameAgent(String nameAgent) {
        this.nameAgent = nameAgent;
    }

    public String getTypeAgent() {
        return typeAgent;
    }

    public void setTypeAgent(String typeAgent) {
        this.typeAgent = typeAgent;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCodAgent() {
        return codAgent;
    }

    public void setCodAgent(int codAgent) {
        this.codAgent = codAgent;
    }
    
    
    
}
