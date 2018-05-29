package me.savushkin.wst.lab3;

import javax.xml.ws.WebFault;

@WebFault(faultBean = "me.savushkin.wst.lab3.WSTFaultException", name = "WSTException")
public class WSTException extends Exception {
    private final WSTFaultException wstFaultException;

    public WSTException() {
        super();
        this.wstFaultException = WSTFaultException.defaultInstance();
    }

    public WSTException(String message) {
        super(message);
        this.wstFaultException = WSTFaultException.defaultInstance();
    }

    public WSTException(String message, WSTFaultException wstFaultException) {
        super(message);
        this.wstFaultException = wstFaultException;
    }

    public WSTException(String message, WSTFaultException wstFaultException, Throwable cause) {
        super(message, cause);
        this.wstFaultException = wstFaultException;
    }
}
