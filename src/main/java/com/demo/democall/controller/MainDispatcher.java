package com.demo.democall.controller;

import com.demo.democall.entity.Agent;
import com.demo.democall.entity.Call;

import java.util.ArrayList;

/**
 *
 * @author Andres Sotelo
 */
public class MainDispatcher implements Runnable {

    private final Call call;
    private final Dispatcher dp;
    private static ArrayList<Agent> listAgent;

    /*numero maximo de concurrencia permitidas*/
    private static int maxNumCalls = 10;

    public MainDispatcher(Call call, Dispatcher dp) {
        this.dp = dp;
        this.call = call;

    }

    public static void main(String[] args) {
        int i;
        ArrayList<Call> listCall = new ArrayList();

        ArrayList<Dispatcher> listDispachers = new ArrayList();

        
        /*Stack de Agentes*/
        listAgent = new ArrayList();
        
        Agent agent1 = new Agent("OPERADOR 1", "OPERADOR", 0,1);
        listAgent.add(agent1);
        Agent agent2 = new Agent("OPERADOR 2", "OPERADOR", 0,2);
        listAgent.add(agent2);
        Agent agent3 = new Agent("OPERADOR 3", "OPERADOR", 0,3);
        listAgent.add(agent3);
        Agent agent4 = new Agent("OPERADOR 4", "OPERADOR", 0,4);
        listAgent.add(agent4);
        Agent agent5 = new Agent("OPERADOR 5", "OPERADOR", 0,5);
        listAgent.add(agent5);
        Agent agent6 = new Agent("OPERADOR 6", "OPERADOR", 0,6);
        listAgent.add(agent6);
        Agent agent7 = new Agent("OPERADOR 7", "OPERADOR", 0,7);
        listAgent.add(agent7);
        Agent agent8 = new Agent("OPERADOR 8", "OPERADOR", 0,8);
        listAgent.add(agent8);
        Agent agent9 = new Agent("SUPERVISOR", "OPERADOR", 0,9);
        listAgent.add(agent9);
        Agent agent10 = new Agent("DIRECTOR", "DIRECTOR", 0,10);
        listAgent.add(agent10);

        /*lista de 11 llamadas*/

        for (i = 0; i < 11; i++) {
            Call call = new Call("Llamada " + i);
            listCall.add(call);
        }

        /*lista de dispatcers para cada llamada*/
        for (i = 0; i < listCall.size(); i++) {
            Dispatcher dpcall = new Dispatcher();
            listDispachers.add(dpcall);
        }

        /*Creacion de hilos por la duracion de  cada llamada
         */
        for (i = 0; i < listDispachers.size(); i++) {
            Runnable calling = new MainDispatcher(listCall.get(i), listDispachers.get(i));
            new Thread(calling).start();
        }
        
    }

    /*
    * sobreescribiendo unicamente el metodo para que se cree un hilo en cada llamada 
     */
    @Override
    public void run() {
        this.dp.maxNumCalls = maxNumCalls--;
        
        this.dp.agents = this.listAgent;
        
        /*Bucle infinito para realizar la llamada Cuando el numero de concurrencia es superado*/
        
        while (this.dp.dispachCall(this.call)) {
            /*Espera un tiempo entre 5 y 10 segundos para volver a intentar la llamada*/
            this.dp.randomTimeCall();
        }

    }

}
