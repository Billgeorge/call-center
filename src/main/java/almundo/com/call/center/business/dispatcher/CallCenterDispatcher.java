package almundo.com.call.center.business.dispatcher;

import almundo.com.call.center.entities.Call;
import almundo.com.call.center.entities.CallCenter;
import almundo.com.call.center.entities.Employee;

import java.util.Optional;

/**
 * @author Jorge Leonardo Espinosa Tovar
 * @apiNote Clase encargada de asignar una llamada a un empleado disponible
 */


public class CallCenterDispatcher {

    public Call currentCall;
    public CallCenter callCenter;
    public Employee currentOperator;

    public CallCenterDispatcher(Call call, CallCenter callCenter) {

        this.currentCall = call;
        this.callCenter = callCenter;
    }


    public void dispatchCall() {


        Optional<Employee> employee = this.callCenter.getAvailableHandler();
        if (!employee.isPresent()) {
            this.callCenter.putInWait(currentCall);
            System.out.println("all ours employees are busy");
            return;
        }
        currentCall.setEmployee(employee.get());
        employee.get().delegateCall(currentCall);
        this.currentOperator = employee.get();
    }
}
