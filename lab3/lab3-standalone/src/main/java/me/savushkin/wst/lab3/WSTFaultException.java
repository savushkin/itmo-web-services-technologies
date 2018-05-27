package me.savushkin.wst.lab3;

import lombok.Getter;

@Getter
public class WSTFaultException {
    protected static String DEFAULT_MESSAGE = "При выполнении операции произошла непредвиденная ошибка";
    protected String message;

    public WSTFaultException() {
        this.message = DEFAULT_MESSAGE;
    }

    public WSTFaultException(String message) {
        this.message = message;
    }

    public static WSTFaultException defaultInstance() {
        WSTFaultException faultException = new WSTFaultException();
        faultException.message = DEFAULT_MESSAGE;
        return faultException;
    }
}
