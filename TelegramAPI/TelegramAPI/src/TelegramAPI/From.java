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
    private long id;
    private boolean is_bot;
    private String first_name;
    private String language_code;

    public From() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isIs_bot() {
        return is_bot;
    }

    public void setIs_bot(boolean is_bot) {
        this.is_bot = is_bot;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLanguage_code() {
        return language_code;
    }

    public void setLanguage_code(String language_code) {
        this.language_code = language_code;
    }

    
    
    public void popola(long id, boolean is_bot, String first_name, String language_code) {
        this.id = id;
        this.is_bot = is_bot;
        this.first_name = first_name;
        this.language_code = language_code;
    }
}
