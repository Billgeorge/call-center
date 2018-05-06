package almundo.com.call.center.entities;

/**
 * @author Jorge Leonardo Espinosa Tovar
 * @apiNote Clase hija que representa el operador
 *
 */
public class Operator extends Employee {

    public Operator(String name) {
        super(name);
        this.levelEmployee=0;
    }
}
