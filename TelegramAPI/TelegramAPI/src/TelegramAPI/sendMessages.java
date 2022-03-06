/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TelegramAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class sendMessages {
    
    public List<Info> list=new ArrayList<Info>();  
    String message;
    
    public void add(Info i) throws IOException{
        list.add(i);
        send();
    }
 
    public void send() throws IOException{
        this.message = getStringJson("https://api.telegram.org/bot5204845607:AAE6xBiiH10eZpHTje9jICsSDNfACYyzwSU/sendMessage?chat_id="+list.get(list.size() - 1).getChatId()+"&text="+list.get(list.size() - 1).getText());
    }
    
    
    public String getStringJson(String url) throws MalformedURLException, IOException {
        URL website = new URL(url);
        InputStream stream = website.openStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String s = "";
        String line = "";
        while ((line = reader.readLine()) != null) {
            s += line + "\n";
        }
        return s;
    }
}
