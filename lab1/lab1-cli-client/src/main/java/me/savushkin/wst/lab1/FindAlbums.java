
package me.savushkin.wst.lab1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for find-albums complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="find-albums">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="artist" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="releaseYear" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="genre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="trackCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "find-albums", propOrder = {
        "title",
        "artist",
        "releaseYear",
        "genre",
        "trackCount"
})
public class FindAlbums {

    protected String title;
    protected String artist;
    protected Long releaseYear;
    protected String genre;
    protected Long trackCount;

    /**
     * Gets the value of the title property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the artist property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Sets the value of the artist property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArtist(String value) {
        this.artist = value;
    }

    /**
     * Gets the value of the releaseYear property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getReleaseYear() {
        return releaseYear;
    }

    /**
     * Sets the value of the releaseYear property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setReleaseYear(Long value) {
        this.releaseYear = value;
    }

    /**
     * Gets the value of the genre property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets the value of the genre property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenre(String value) {
        this.genre = value;
    }

    /**
     * Gets the value of the trackCount property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTrackCount() {
        return trackCount;
    }

    /**
     * Sets the value of the trackCount property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTrackCount(Long value) {
        this.trackCount = value;
    }

}
