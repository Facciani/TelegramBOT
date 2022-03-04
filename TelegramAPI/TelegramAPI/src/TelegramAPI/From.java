/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TelegramAPI;

/**
 *"ok":true,
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
      },
 * @author User
 */
public class From {
    private int id;
    private boolean is_bot;
    private String first_name;
    private String username;
    private String language_code;

    public From() {
    }

    
    
    public void popola(int id, boolean is_bot, String first_name, String username, String language_code) {
        this.id = id;
        this.is_bot = is_bot;
        this.first_name = first_name;
        this.username = username;
        this.language_code = language_code;
    }
}
