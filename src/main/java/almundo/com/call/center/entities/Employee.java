package almundo.com.call.center.entities;

/**
 * @author Jorge Leonardo Espinosa Tovar
 * @apiNote Clase hija que representa un empleado,
 * para el presente diseño, se tienen 3 níveles de empleado
 *  0-> operador
 *  1-> supervisor
 *  2-> director
 */
public class Employee {

    private String name;
    private Call currentCall;
    protected int levelEmployee;

    public Employee(String name) {

        this.name=name;
    }

    public void delegateCall(Call call) {

        this.currentCall= call;
        System.out.println(call.getCaller().getNameCaller()+ " call attended by "+this.name);
    }

    public Boolean isFree() {

        return this.currentCall==null;
    }

    public void freeAgain(){

        this.currentCall=null;
    }


    public int getLevelEmployee() {
        return levelEmployee;
    }

}
