package almundo.com.call.center.main;


import almundo.com.call.center.entities.CallCenter;
import almundo.com.call.center.entities.Caller;

import java.util.concurrent.Semaphore;

/**
 * @author Jorge Leonardo Espinosa Tovar
 * @apiNote Clase utilizada para enviar 21 llamadas concurrentes,
 * en donde dichas llamadas serán atendidas por los 10 empleados
 * del call center, adicionalmente se control el número de hilos
 * concurrentes utilizando un semaforo inicializado para 10 hilos concurrentes.
 * Por lo que cuando dicho límite sea alcanzado, el caller es puesto en espera.
 *
 */
public class MainClass {


    public static void main(String... args) {

        Semaphore operators = new Semaphore(10);  // 10 hilos que representan 10 empleados que pueden atender llamadas al tiempo
        System.out.println("Call center starts...");

        CallCenter callCenter = new CallCenter();  // 1 sólo call center con 10 empleados para atender

        new Caller(operators, " caller 1", callCenter);
        new Caller(operators, " caller 2", callCenter);
        new Caller(operators, " caller 3", callCenter);
        new Caller(operators, " caller 4", callCenter);
        new Caller(operators, " caller 5", callCenter);
        new Caller(operators, " caller 6", callCenter);
        new Caller(operators, " caller 7", callCenter);
        new Caller(operators, " caller 8", callCenter);
        new Caller(operators, " caller 9", callCenter);
        new Caller(operators, " caller 10", callCenter);
        new Caller(operators, " caller 11", callCenter);
        new Caller(operators, " caller 12", callCenter);
        new Caller(operators, " caller 13", callCenter);
        new Caller(operators, " caller 14", callCenter);
        new Caller(operators, " caller 15", callCenter);
        new Caller(operators, " caller 16", callCenter);
        new Caller(operators, " caller 17", callCenter);
        new Caller(operators, " caller 18", callCenter);
        new Caller(operators, " caller 19", callCenter);
        new Caller(operators, " caller 20", callCenter);
        new Caller(operators, " caller 21", callCenter);
    }
}
