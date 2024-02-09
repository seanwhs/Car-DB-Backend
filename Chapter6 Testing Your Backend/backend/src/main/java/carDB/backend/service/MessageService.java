//MessageService.java
package carDB.backend.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import carDB.backend.model.Message;

@Service
public class MessageService {
 private List<Message> messages = new ArrayList<>();
 
 public Message addMsg(String msg) {
    Message newMsg = new Message(msg);
    messages.add(newMsg);
    return newMsg;
 }
}