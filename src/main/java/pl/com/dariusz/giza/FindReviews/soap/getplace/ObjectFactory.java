//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.10.29 at 12:17:40 PM CET 
//


package pl.com.dariusz.giza.FindReviews.soap.getplace;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pl.com.dariusz.giza.findreviews.getplace package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pl.com.dariusz.giza.findreviews.getplace
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetPlaceRequest }
     * 
     */
    public GetPlaceRequest createGetPlaceRequest() {
        return new GetPlaceRequest();
    }

    /**
     * Create an instance of {@link GetPlaceResponse }
     * 
     */
    public GetPlaceResponse createGetPlaceResponse() {
        return new GetPlaceResponse();
    }

    /**
     * Create an instance of {@link Place }
     * 
     */
    public Place createPlace() {
        return new Place();
    }

    /**
     * Create an instance of {@link Reviews }
     * 
     */
    public Reviews createReviews() {
        return new Reviews();
    }

    /**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new Address();
    }

}