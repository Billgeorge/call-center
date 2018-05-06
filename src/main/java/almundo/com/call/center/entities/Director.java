package almundo.com.call.center.entities;

/**
 * @author Jorge Leonardo Espinosa Tovar
 * @apiNote Clase hija que representa el director
 *
 */
public class Director extends Employee {

    public Director(String name) {

        super(name);
        this.levelEmployee=2;
    }
}
