package almundo.com.call.center.entities;

/**
 * @author Jorge Leonardo Espinosa Tovar
 * @apiNote Clase hija que representa el supervisor
 *
 */
public class Supervisor extends Employee {

    public Supervisor(String name) {

        super(name);
        this.levelEmployee=1;
    }
}
