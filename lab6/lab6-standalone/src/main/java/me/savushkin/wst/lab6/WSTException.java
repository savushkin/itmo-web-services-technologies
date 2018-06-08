package me.savushkin.wst.lab6;

public class WSTException extends Exception {
    private static final String DEFAULT_MESSSAGE = "Произошла ошибка при обращении к базе данных";

    public WSTException(String message) {
        super(message);
    }

    public WSTException getInstance() {
        return new WSTException(DEFAULT_MESSSAGE);
    }
}
