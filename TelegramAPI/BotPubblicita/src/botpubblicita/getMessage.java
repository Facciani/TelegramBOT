/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botpubblicita;

import TelegramAPI.Info;
import TelegramAPI.getUpdate;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author facciani_alessandro
 */
public class getMessage extends Thread{

    getUpdate p = new getUpdate();
     List<Info> list = new ArrayList<Info>();
    Condivisa c = new Condivisa();
    
    @Override
    public void run() {
        while(true){
            list = p.get();
            for(int i = 0;i<list.size();i++){
                try {
                    c.add(list.get(i));
                } catch (IOException ex) {
                    Logger.getLogger(getMessage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            

            try {
                Thread.sleep(150);
            } catch (InterruptedException ex) {
                Logger.getLogger(getMessage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
