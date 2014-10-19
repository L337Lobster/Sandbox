/*
Changelog
=====================
19 October 2014
    -1400 hours
        *initial creation
*/
package credits;

import sandbox.XML_240;

/**
 * Java class for creating the credits in our IST 240 final project game.
 * @author Jackson
 * @version 1.00
 */
public class Credits {
    
    /**
     * Creates multiple contributors based on an XML document.
     */
    public Credits()
    {
        /* ====================================================
         * This section creates the new instances of the contributors and the XML_240 class
         * ====================================================
         */
        Contributor jack = new Contributor();
        Contributor michelle = new Contributor();
        Contributor nick = new Contributor();   
        XML_240 x2 = new XML_240();
        
        /* ====================================================
         * This section reads from the Credits.xml to give values to the contributors.
         * ====================================================
         */
        x2.openReaderXML("Credits.xml");
        jack = (Contributor)x2.ReadObject();
        michelle = (Contributor)x2.ReadObject();
        nick = (Contributor)x2.ReadObject();
        x2.closeReaderXML();
    }
    
    
}
