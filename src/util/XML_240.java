package util;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JButton;
import javax.swing.JPanel;


/**
 * This class reads and writes XML files based on Java Beans DTD.
 * <br>It uses the standard Java classes:
 * <ul>
 * <li>XMLEncoder
 * <li>XMLDecoder
 * </ul>
 * <h3>Use: create the class XML_240 x = new XML_240();</h3>
 * <h4>READER</h4>
 * <br>Open a XML file to read: x.openReader(filename);.
 * <br>Close a XML reader file: x.closeReader();.
 * <br>Read an Object: x.readObject();.
 * <br>You need to know what TYPE of Object you are reading.
 * <br>String s = (String) x.readObject();.
 * <h4>WRITER</h4>
 * <br>Open a XML file to write: x.openWriter(filename);.
 * <br>Close a XML writer file: x.closeWriter();.
 * <br>Write an Object: x.writeObject(ANY JAVA OBJECT/INSTANCE HERE).
 * <br>String s = "fred";.
 * <br>x.writeObject(s);.
 * @author fredfonseca
 */
public class XML_240 
{
    
    XMLEncoder xe;
    XMLDecoder de;
/**
 * Constructor for class
 */
public XML_240()
{
    
    
}
//==========================================================================
    /**
     * Opens an XML reader using the XML file defined in the String filename
     * @param filename filename in the format document.ext
     */
    public void openReaderXML(String filename)
    {
        try 
        {
           de = new XMLDecoder(new BufferedInputStream(new FileInputStream(filename)));
        }
        catch(Exception xx) 
        {
            xx.printStackTrace();
        }
    }
//==========================================================================
    /**
     * Opens an XML writer using the XML file defined in the String filename
     * @param filename  filename in the format document.ext
     */
    public void openWriterXML(String filename)
    {
        try 
        {
           xe = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename)));
        }
        catch(Exception xx) 
        {
            xx.printStackTrace();
        }
      }
//==========================================================================
    /**
     * Writes the Object o to file
     * @param o Object to be written
     */
    public void writeObject(Object o)
    {
        try 
        {
            xe.writeObject(o);
        }
        catch(Exception xx) 
        {
            xx.printStackTrace();
        }
    }
//==========================================================================
    /**
     * Reads the Object o from file
     * @return o
     */
    public Object ReadObject()
    {
        Object o = new Object();
        try 
        {
            o = de.readObject();
        }
        catch(Exception xx) 
        {
            xx.printStackTrace();
        }
          return o;
    }
//==========================================================================
    /**
     * Closes the currently opened XML reader
     */
    public void closeReaderXML()
    {
        try 
        {
           de.close();
        }
        catch(Exception xx) 
        {
            xx.printStackTrace();
        }
    }
//==========================================================================
    /**
     * Closes the currently opened XML writer
     */
    public void closeWriterXML()
    {
        try 
        {
            xe.close();
        }
        catch(Exception xx) 
        {
            xx.printStackTrace();
        }
    }
}