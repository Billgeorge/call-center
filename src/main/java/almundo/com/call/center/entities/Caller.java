package almundo.com.call.center.entities;

import almundo.com.call.center.business.dispatcher.CallCenterDispatcher;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author Jorge Leonardo Espinosa Tovar
 * @apiNote Clase que representa la persona que llama,
 * para este caso cada llamador (caller) representa un hilo.
 * Para solucionar el problema de las llamadas concurrentes,
 * se implementa un semaforo, que permite establecer
 * el número máximo de hilos en paralelo, en caso de que
 * se haya llegado al número máximo de hilos se pone en espera el
 * llamador y una vez se desocupe un hilo, el llamador
 * es atendido.
 * @implNote Esta clase debe ser instanciada compartiendo un sólo
 * semaforo, para que el mismo pueda llevar control del conteo
 * del número de hilos que ya esta en ejecución
 */
public class Caller extends Thread {

    private Semaphore operators;
    private String name;
    private CallCenter callCenter;

    public Caller(Semaphore operators,
                  String name, CallCenter callCenter) {

        this.operators = operators;
        this.name = name;
        this.callCenter = callCenter;
        this.start();

    }

    public String getNameCaller() {
        return name;
    }


    @Override
    public void run() {

        long durationCall = ThreadLocalRandom.current().nextLong(5, 15);
        try {
            System.out.println("new Call of user  " + this.name);
            Call currentCall = new Call(this);

            if (operators.availablePermits() == 0) {

                callCenter.putInWait(currentCall); //caller en espera
            }
            operators.acquire();
            CallCenterDispatcher callCenterDispatcher = new CallCenterDispatcher(currentCall, callCenter);
            callCenterDispatcher.dispatchCall();
            Thread.sleep(TimeUnit.SECONDS.toMillis(durationCall));
            callCenterDispatcher.currentOperator.freeAgain();

            System.out.println("call finished user " + this.name);
            operators.release();

        } catch (InterruptedException e) {

            System.err.println(e);
        }
    }
}
