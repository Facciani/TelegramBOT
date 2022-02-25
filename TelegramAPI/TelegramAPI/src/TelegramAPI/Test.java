/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelegramAPI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.*;
/**
 *
 * @author facciani_alessandro
 */
public class Test {
    
    public String getStringJson(String url) throws MalformedURLException, IOException
    {
        URL website = new URL(url);
        InputStream stream=website.openStream();
        BufferedReader reader=new BufferedReader(new InputStreamReader(stream));
        String s="";
        String line="";
        while((line=reader.readLine())!=null){
            s+=line+"\n";
        }
        return s;
    }
    
    
    public void getUpdate() throws IOException{
        String jsonString = getStringJson("https://api.telegram.org/bot5204845607:AAE6xBiiH10eZpHTje9jICsSDNfACYyzwSU/getUpdates");
        
        JSONObject obj = new JSONObject(jsonString);
        String pageName = obj.getString("nome");
        
        JSONArray arr = obj.getJSONArray("messaggi");
        for (int i = 0; i < arr.length(); i++)
        {
            String post = arr.getString(i);
            System.out.println(post);
        }
    }
    
}
