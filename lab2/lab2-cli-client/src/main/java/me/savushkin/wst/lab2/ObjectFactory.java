
package me.savushkin.wst.lab2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the me.savushkin.wst.lab2 package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAlbums_QNAME = new QName("http://lab2.wst.savushkin.me/", "get-albums");
    private final static QName _CreateAlbum_QNAME = new QName("http://lab2.wst.savushkin.me/", "create-album");
    private final static QName _FindAlbums_QNAME = new QName("http://lab2.wst.savushkin.me/", "find-albums");
    private final static QName _DeleteAlbumResponse_QNAME = new QName("http://lab2.wst.savushkin.me/", "delete-albumResponse");
    private final static QName _CreateAlbumResponse_QNAME = new QName("http://lab2.wst.savushkin.me/", "create-albumResponse");
    private final static QName _GetAlbumsResponse_QNAME = new QName("http://lab2.wst.savushkin.me/", "get-albumsResponse");
    private final static QName _FindAlbumsResponse_QNAME = new QName("http://lab2.wst.savushkin.me/", "find-albumsResponse");
    private final static QName _DeleteAlbum_QNAME = new QName("http://lab2.wst.savushkin.me/", "delete-album");
    private final static QName _UpdateAlbumResponse_QNAME = new QName("http://lab2.wst.savushkin.me/", "update-albumResponse");
    private final static QName _UpdateAlbum_QNAME = new QName("http://lab2.wst.savushkin.me/", "update-album");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: me.savushkin.wst.lab2
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateAlbumResponse }
     */
    public CreateAlbumResponse createCreateAlbumResponse() {
        return new CreateAlbumResponse();
    }

    /**
     * Create an instance of {@link GetAlbumsResponse }
     */
    public GetAlbumsResponse createGetAlbumsResponse() {
        return new GetAlbumsResponse();
    }

    /**
     * Create an instance of {@link DeleteAlbumResponse }
     */
    public DeleteAlbumResponse createDeleteAlbumResponse() {
        return new DeleteAlbumResponse();
    }

    /**
     * Create an instance of {@link FindAlbums }
     */
    public FindAlbums createFindAlbums() {
        return new FindAlbums();
    }

    /**
     * Create an instance of {@link UpdateAlbum }
     */
    public UpdateAlbum createUpdateAlbum() {
        return new UpdateAlbum();
    }

    /**
     * Create an instance of {@link DeleteAlbum }
     */
    public DeleteAlbum createDeleteAlbum() {
        return new DeleteAlbum();
    }

    /**
     * Create an instance of {@link UpdateAlbumResponse }
     */
    public UpdateAlbumResponse createUpdateAlbumResponse() {
        return new UpdateAlbumResponse();
    }

    /**
     * Create an instance of {@link FindAlbumsResponse }
     */
    public FindAlbumsResponse createFindAlbumsResponse() {
        return new FindAlbumsResponse();
    }

    /**
     * Create an instance of {@link GetAlbums }
     */
    public GetAlbums createGetAlbums() {
        return new GetAlbums();
    }

    /**
     * Create an instance of {@link CreateAlbum }
     */
    public CreateAlbum createCreateAlbum() {
        return new CreateAlbum();
    }

    /**
     * Create an instance of {@link MusicAlbum }
     */
    public MusicAlbum createMusicAlbum() {
        return new MusicAlbum();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAlbums }{@code >}}
     */
    @XmlElementDecl(namespace = "http://lab2.wst.savushkin.me/", name = "get-albums")
    public JAXBElement<GetAlbums> createGetAlbums(GetAlbums value) {
        return new JAXBElement<GetAlbums>(_GetAlbums_QNAME, GetAlbums.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateAlbum }{@code >}}
     */
    @XmlElementDecl(namespace = "http://lab2.wst.savushkin.me/", name = "create-album")
    public JAXBElement<CreateAlbum> createCreateAlbum(CreateAlbum value) {
        return new JAXBElement<CreateAlbum>(_CreateAlbum_QNAME, CreateAlbum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAlbums }{@code >}}
     */
    @XmlElementDecl(namespace = "http://lab2.wst.savushkin.me/", name = "find-albums")
    public JAXBElement<FindAlbums> createFindAlbums(FindAlbums value) {
        return new JAXBElement<FindAlbums>(_FindAlbums_QNAME, FindAlbums.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAlbumResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "http://lab2.wst.savushkin.me/", name = "delete-albumResponse")
    public JAXBElement<DeleteAlbumResponse> createDeleteAlbumResponse(DeleteAlbumResponse value) {
        return new JAXBElement<DeleteAlbumResponse>(_DeleteAlbumResponse_QNAME, DeleteAlbumResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateAlbumResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "http://lab2.wst.savushkin.me/", name = "create-albumResponse")
    public JAXBElement<CreateAlbumResponse> createCreateAlbumResponse(CreateAlbumResponse value) {
        return new JAXBElement<CreateAlbumResponse>(_CreateAlbumResponse_QNAME, CreateAlbumResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAlbumsResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "http://lab2.wst.savushkin.me/", name = "get-albumsResponse")
    public JAXBElement<GetAlbumsResponse> createGetAlbumsResponse(GetAlbumsResponse value) {
        return new JAXBElement<GetAlbumsResponse>(_GetAlbumsResponse_QNAME, GetAlbumsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAlbumsResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "http://lab2.wst.savushkin.me/", name = "find-albumsResponse")
    public JAXBElement<FindAlbumsResponse> createFindAlbumsResponse(FindAlbumsResponse value) {
        return new JAXBElement<FindAlbumsResponse>(_FindAlbumsResponse_QNAME, FindAlbumsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAlbum }{@code >}}
     */
    @XmlElementDecl(namespace = "http://lab2.wst.savushkin.me/", name = "delete-album")
    public JAXBElement<DeleteAlbum> createDeleteAlbum(DeleteAlbum value) {
        return new JAXBElement<DeleteAlbum>(_DeleteAlbum_QNAME, DeleteAlbum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateAlbumResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "http://lab2.wst.savushkin.me/", name = "update-albumResponse")
    public JAXBElement<UpdateAlbumResponse> createUpdateAlbumResponse(UpdateAlbumResponse value) {
        return new JAXBElement<UpdateAlbumResponse>(_UpdateAlbumResponse_QNAME, UpdateAlbumResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateAlbum }{@code >}}
     */
    @XmlElementDecl(namespace = "http://lab2.wst.savushkin.me/", name = "update-album")
    public JAXBElement<UpdateAlbum> createUpdateAlbum(UpdateAlbum value) {
        return new JAXBElement<UpdateAlbum>(_UpdateAlbum_QNAME, UpdateAlbum.class, null, value);
    }

}
