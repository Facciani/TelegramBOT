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
        
        Chat c;
        c = new Chat();
        From f;
        f = new From();
        Info inf;
        inf = new Info();
        Messages m;
        m = new Messages();
        
        String jsonString = getStringJson("https://api.telegram.org/bot5204845607:AAE6xBiiH10eZpHTje9jICsSDNfACYyzwSU/getUpdates");
        
        JSONObject obj = new JSONObject(jsonString);
        
        boolean result = obj.getBoolean("ok");

        /*"result":[
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
        }*/
        
        if(result)
        {
            JSONArray arr = obj.getJSONArray("result"); // notice that `"posts": [...]`
            for (int i = 0; i < arr.length(); i++)
            {
                int update_id =  arr.getJSONObject(i).getInt("update_id");

                JSONObject arrmess = arr.getJSONObject(i).getJSONObject("message");
                String text = arrmess.getString("text");
                int date =  arrmess.getInt("date");


                JSONObject arrFrom = arr.getJSONObject(i).getJSONObject("message").getJSONObject("from");
                int idFrom = arrFrom.getInt("id");
                boolean is_botFrom = arrFrom.getBoolean("is_bot");
                String first_nameFrom = arrFrom.getString("first_name");
                String usernameFrom = arrFrom.getString("username");
                String language_codeFrom = arrFrom.getString("language_code");
                f.popola(i, is_botFrom, first_nameFrom, usernameFrom, language_codeFrom);

                JSONObject arrChat = arr.getJSONObject(i).getJSONObject("message").getJSONObject("chat");;
                int idChat = arrChat.getInt("id");
                String first_nameChat = arrChat.getString("first_name");
                String usernameChat = arrChat.getString("username");
                String type = arrChat.getString("type");
                c.popola(i, first_nameChat, usernameFrom, type);


                inf.popola(update_id, update_id, idChat, text, inf, c);
                System.out.println(inf.toString());
                //m.add(inf);
            }
        }
        

        
        
        
        
        
        /*JSONArray arr = obj.getJSONArray("messaggi");
        for (int i = 0; i < arr.length(); i++)
        {
            String post = arr.getString(i);
            System.out.println(post);
        }*/
    }
    
}
