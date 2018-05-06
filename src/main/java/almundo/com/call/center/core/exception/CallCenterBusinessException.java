package almundo.com.call.center.core.exception;

import almundo.com.call.center.core.exception.Constants.Code;
import almundo.com.call.center.core.exception.Constants.Messages;

/**
 * @author Jorge Leonardo Espinosa Tovar
 * @apiNote Excepción de negocio
 *
 */
public class CallCenterBusinessException extends Exception {


    public String getCode() {

        return Code.UNKNOWN_ERROR;
    }

    public CallCenterBusinessException() {

        super(Messages.UNKNOWN_ERROR);
    }

    public CallCenterBusinessException(Throwable e) {

        super(Messages.UNKNOWN_ERROR, e);
    }

    public CallCenterBusinessException(String message, Throwable e) {

        super(message, e);
    }

}
