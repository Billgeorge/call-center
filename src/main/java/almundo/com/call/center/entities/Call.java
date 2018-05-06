package almundo.com.call.center.entities;

import java.util.Random;

/**
 * @author Jorge Leonardo Espinosa Tovar
 * @apiNote Clase que representa una llamada
 *
 */
public class Call {

    private Long idCall;
    private Caller caller;
    private Employee employee;

    public Call(){

        Random random = new Random();
        this.idCall = (long) random.nextLong()+1;
    }

    public Call(Caller caller){

        this.caller=caller;
    }

    public Caller getCaller() {
        return caller;
    }

    public void setCaller(Caller caller) {
        this.caller = caller;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Long getIdCall() {
        return idCall;
    }

}
