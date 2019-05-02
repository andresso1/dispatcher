package com.demo.democall.controller;

import com.demo.democall.entity.Agent;
import com.demo.democall.entity.Call;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Andres Sotelo
 */
public class Dispatcher {

    private String llamada;
    
    private int randomTime=0;
    
    /*numero maximo de concurrencia*/
    public int maxNumCalls;
    
    public ArrayList<Agent> agents; 

    // Constructor, getter y setter
    public Dispatcher() {
        
    }

    public Dispatcher(int maxNumCallsFree) {
        this.llamada = llamada;
        this.maxNumCalls = maxNumCallsFree;
    }
    
    public String getLlamada() {
        return llamada;
    }

    public void setLlamada(String llamada) {
        this.llamada = llamada;
    }

    public boolean dispachCall(Call llamada) {
        
        this.maxNumCalls--;
        
        Agent ag = searhAgentFree();
        
        if (this.maxNumCalls != 0 && ag != null) {
            
            this.randomTimeCall();
            
            System.out.println("El Agente " + ag.getNameAgent()
                + " realiza la atencion del llamada " + llamada.getLlamada()
                +" Duracion de llamada ->Tiempo: " + this.randomTime + "seg");
            
            freeAgent(ag);
            
            this.maxNumCalls++;
            
            return false;
        } else {
            System.out.println("Llamada no asignada numero maximo superado reintentando");
            return true;
        }

        

    }

    public void randomTimeCall() {
        Random r = new Random();
        int min = 5, max=10;        
        this.randomTime = r.nextInt((max - min) + 1) + min;        
        try {
            Thread.sleep(Duration.ofSeconds(this.randomTime).toMillis());
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    
    private void freeAgent(Agent ag){
        int i;
        for(i=0;i<this.agents.size();i++){
            if(ag.getCodAgent() == this.agents.get(i).getCodAgent()){
            this.agents.get(i).setStatus(0);
            }
        }
    
    }
    
    
    private Agent searhAgentFree(){
        int i;
        Agent  ag = null;
        for(i=0;i<this.agents.size();i++){
            if(this.agents.get(i).getStatus() == 0 && this.agents.get(i).getTypeAgent()=="OPERADOR"){
                this.agents.get(i).setStatus(1);
                return ag = this.agents.get(i);
            }
            if(this.agents.get(i).getStatus() == 0 && this.agents.get(i).getTypeAgent()=="SUPERVISOR"){
                this.agents.get(i).setStatus(1);
                return ag = this.agents.get(i);
            }
            if(this.agents.get(i).getStatus() == 0 && this.agents.get(i).getTypeAgent()=="DIRECTOR"){
                this.agents.get(i).setStatus(1);
                return ag = this.agents.get(i);
            }
        }
        return ag;
    }

}
