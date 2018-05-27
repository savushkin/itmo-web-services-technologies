package me.savushkin.wst.lab3;

import javax.xml.ws.WebFault;

@WebFault(faultBean = "me.savushkin.wst.lab3.WSTFaultException", name = "WSTException")
public class WSTException extends Exception {

    public WSTException() {
        super();
    }

    public WSTException(String message) {
        super(message);
    }
}
