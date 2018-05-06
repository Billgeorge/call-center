package almundo.com.call.center.entities;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Jorge Leonardo Espinosa Tovar
 * @apiNote Clase que representa el call center,
 * contiene el listado de empleados que pertenecen al call center
 * en disposición para atender llamadas. En el constructor se inicializan
 * los empleados con diferentes nombres y bajo sus propios rangos (0,1,2).
 * Para un total de 10 empleados : 8 operadores, 1 supervisor, 1 director.
 */

public class CallCenter {


    List<Employee> employees;

    public CallCenter() {

        employees = new ArrayList<Employee>();

        for (int i = 0; i < 8; i++) {
            employees.add(new Operator("name " + i));
        }

        for (int i = 0; i < 1; i++) {
            employees.add(new Supervisor("supervisor " + i));
        }

        for (int i = 0; i < 1; i++) {
            employees.add(new Director("director  " + i));
        }
    }

    /**
     * Este método será accedido por varios hilos en paralelo, por esto se utiliza synchronized
     *
     * @return Optional de employee, retorna el empleado de menor rango disponible para atender la llamada
     */
    public synchronized Optional<Employee> getAvailableHandler() {

        List<Employee> availableEmployee = employees.stream()
                .filter(Employee::isFree)
                .sorted(Comparator.comparingInt(Employee::getLevelEmployee))
                .collect(Collectors.toList());

        if (!availableEmployee.isEmpty()) {

            return Optional.of(availableEmployee.get(0));
        }
        return Optional.empty();
    }

    /**
     * Este método se encarga de poner mensaje a caller en espera y
     * será accedido por varios hilos en paralelo, por esto se utiliza synchronized
     */
    public synchronized void putInWait(Call call) {

        System.out.println("llamada puesta en espera id " + call.getCaller().getNameCaller());
    }


}
