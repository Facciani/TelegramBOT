/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TelegramAPI;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Messages {
    public List<Info> list=new ArrayList<Info>();  

    public Messages() {
    }
    
    public void add(Info i){
        list.add(i);
    }
    
}
