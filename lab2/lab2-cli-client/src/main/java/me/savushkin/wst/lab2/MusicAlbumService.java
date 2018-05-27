
package me.savushkin.wst.lab2;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 */
@WebServiceClient(name = "music-album-service", targetNamespace = "http://lab2.wst.savushkin.me/", wsdlLocation = "http://0.0.0.0:8080/music-album-service?wsdl")
public class MusicAlbumService
        extends Service {

    private final static URL MUSICALBUMSERVICE_WSDL_LOCATION;
    private final static WebServiceException MUSICALBUMSERVICE_EXCEPTION;
    private final static QName MUSICALBUMSERVICE_QNAME = new QName("http://lab2.wst.savushkin.me/", "music-album-service");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://0.0.0.0:8080/music-album-service?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MUSICALBUMSERVICE_WSDL_LOCATION = url;
        MUSICALBUMSERVICE_EXCEPTION = e;
    }

    public MusicAlbumService() {
        super(__getWsdlLocation(), MUSICALBUMSERVICE_QNAME);
    }

    public MusicAlbumService(WebServiceFeature... features) {
        super(__getWsdlLocation(), MUSICALBUMSERVICE_QNAME, features);
    }

    public MusicAlbumService(URL wsdlLocation) {
        super(wsdlLocation, MUSICALBUMSERVICE_QNAME);
    }

    public MusicAlbumService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MUSICALBUMSERVICE_QNAME, features);
    }

    public MusicAlbumService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MusicAlbumService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (MUSICALBUMSERVICE_EXCEPTION != null) {
            throw MUSICALBUMSERVICE_EXCEPTION;
        }
        return MUSICALBUMSERVICE_WSDL_LOCATION;
    }

    /**
     * @return returns MusicAlbumWebService
     */
    @WebEndpoint(name = "MusicAlbumWebServicePort")
    public MusicAlbumWebService getMusicAlbumWebServicePort() {
        return super.getPort(new QName("http://lab2.wst.savushkin.me/", "MusicAlbumWebServicePort"), MusicAlbumWebService.class);
    }

    /**
     * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns MusicAlbumWebService
     */
    @WebEndpoint(name = "MusicAlbumWebServicePort")
    public MusicAlbumWebService getMusicAlbumWebServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://lab2.wst.savushkin.me/", "MusicAlbumWebServicePort"), MusicAlbumWebService.class, features);
    }

}
