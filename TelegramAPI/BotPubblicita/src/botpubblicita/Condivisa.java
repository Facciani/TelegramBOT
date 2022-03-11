/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botpubblicita;

import TelegramAPI.Info;
import TelegramAPI.sendMessages;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author facciani_alessandro
 */
public class Condivisa {
    List<Info> list = new ArrayList<Info>();
    XMLDom d = new XMLDom();
    sendMessages m = new sendMessages();
    
    public void add(Info f) throws IOException{
        list.add(f);
        send(f);
    }  
    
    
    public void send(Info f) throws IOException{
        String[] command;
        String format = "";
        command = f.getText().split(" ");
        if(command[0].equals("/citta")){
            for(int i = 1; i < command.length; i++){
                if(i == command.length-1){
                    format += command[i].substring(0, 1).toUpperCase() + command[i].substring(1);
                }else{
                    format += command[i].substring(0, 1).toUpperCase() + command[i].substring(1) + "+";
                }
            }
            try {
                XMLSerialized(format);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Condivisa.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(Condivisa.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(Condivisa.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SAXException ex) {
                Logger.getLogger(Condivisa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    private void XMLSerialized(String format) throws FileNotFoundException, MalformedURLException, IOException, ParserConfigurationException, SAXException, SAXException{
        
        URL url = new URL("https://nominatim.openstreetmap.org/search?q="+format+"&format=xml&addressdetails=1"); 
        Scanner inRemote = new Scanner(url.openStream());
        inRemote.useDelimiter("\u001a");
        String content = inRemote.next();

        PrintWriter wr = new PrintWriter("document.xml");
        wr.write(content);
        wr.close();
        inRemote.close();
        String csv = d.parseDocument("document.xml");
    }
    
    
    
}
