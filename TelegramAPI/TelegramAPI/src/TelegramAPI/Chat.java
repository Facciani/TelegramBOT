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
public class Chat {
    private long id;
    private String first_name;
    private String type;

    public Chat() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    public void popola(long id, String first_name,String type){
        this.id = id;
        this.first_name = first_name;
        this.type = type;
    }
}
