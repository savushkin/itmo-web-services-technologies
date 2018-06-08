package me.savushkin.wst.lab7;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        try {
            UddiInteraction publishWebService =
                    new UddiInteraction("META-INF/uddi.xml");
            String URL = "http://0.0.0.0:8080/music-album-service?wsdl";
            String serviceKey = publishWebService.publish("MusicAlbums", "MusicAlbums characteristic", URL);

            publishWebService.getServiceListByName("");

            publishWebService.logOut();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
