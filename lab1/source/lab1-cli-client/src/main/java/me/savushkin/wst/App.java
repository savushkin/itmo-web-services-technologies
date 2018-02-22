package me.savushkin.wst;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhsot:8080/music-album-service?wsdl");
        } catch (MalformedURLException e) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
