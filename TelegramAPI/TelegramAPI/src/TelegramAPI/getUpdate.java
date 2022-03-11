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
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author User
 */
public class getUpdate extends Thread{

    public Chat c;
    public From f;
    public Info inf;
    public sendMessages m;
    int arrl;

    public getUpdate() {
        c = new Chat();
        f = new From();
        inf = new Info();
        m = new sendMessages();
        arrl = 0;
    }
    
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
    
    
    public List<Info> get() {
        
            List<Info> listInfo = new ArrayList<Info>();
        
            
            String jsonString = "";
            try {
                jsonString = getStringJson("https://api.telegram.org/bot5204845607:AAE6xBiiH10eZpHTje9jICsSDNfACYyzwSU/getUpdates");
            } catch (IOException ex) {
                Logger.getLogger(getUpdate.class.getName()).log(Level.SEVERE, null, ex);
            }

            JSONObject obj = new JSONObject(jsonString);

            boolean result = obj.getBoolean("ok");

            /*"ok":true,
                "result":[
                   {
                      "update_id":78290423,
                      "message":{
                         "message_id":5,
                         "from":{
                            "id":5238155445,
                            "is_bot":false,
                            "first_name":"Facc",
                            "username":"Fackc",
                            "language_code":"it"
                         },
                         "chat":{
                            "id":5238155445,
                            "first_name":"Facc",
                            "username":"Fackc",
                            "type":"private"
                         },
                         "date":1646387697,
                         "text":"ciao"
                      }
                   }
            }*/

            if(result)
            {
                JSONArray arr = obj.getJSONArray("result"); // notice that `"posts": [...]`
                
                
                if(arr.length()>arrl)
                {
                    for (int i = arrl; i < arr.length(); i++)
                    {
                        int update_id =  arr.getJSONObject(i).getInt("update_id");

                        JSONObject arrmess = arr.getJSONObject(i).getJSONObject("message");
                        int message_id = arrmess.getInt("message_id");
                        String text = arrmess.getString("text");
                        int date =  arrmess.getInt("date");


                        JSONObject arrFrom = arr.getJSONObject(i).getJSONObject("message").getJSONObject("from");
                        long idFrom = arrFrom.getLong("id");
                        boolean is_botFrom = arrFrom.getBoolean("is_bot");
                        String first_nameFrom = arrFrom.getString("first_name");
                        String language_codeFrom = arrFrom.getString("language_code");
                        f.popola(idFrom, is_botFrom, first_nameFrom, language_codeFrom);

                        JSONObject arrChat = arr.getJSONObject(i).getJSONObject("message").getJSONObject("chat");;
                        long idChat = arrChat.getLong("id");
                        String first_nameChat = arrChat.getString("first_name");
                        String type = arrChat.getString("type");
                        c.popola(idChat, first_nameChat, type);
                        

                        inf.popola(update_id, message_id, date, text, f, c);
                        listInfo.add(inf);
                        System.out.println(inf.toString());
                    }
                }
            arrl = arr.length();
            }
            return listInfo;
    }
       
}
