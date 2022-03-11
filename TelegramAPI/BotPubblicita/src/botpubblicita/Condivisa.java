/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botpubblicita;

import TelegramAPI.Info;
import TelegramAPI.sendMessages;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author facciani_alessandro
 */
public class Condivisa {
    List<Info> list = new ArrayList<Info>();
    sendMessages m = new sendMessages();
    
    public void add(Info f) throws IOException{
        list.add(f);
        send(f);
    }  
    
    
    public void send(Info f) throws IOException{
        m.send(f);
    }
}
