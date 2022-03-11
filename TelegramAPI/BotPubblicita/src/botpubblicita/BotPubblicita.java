/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botpubblicita;

import org.json.*;
import TelegramAPI.*;
import java.io.IOException;
/**
 *
 * @author facciani_alessandro
 */
public class BotPubblicita {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        clearUpdates c = new clearUpdates();
        getMessage m = new getMessage();
        m.start();
        /*Test t = new Test();
        t.getUpdate();*/
    }
    
}
