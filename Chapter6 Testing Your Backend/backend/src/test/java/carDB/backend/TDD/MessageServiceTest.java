//MessageServiceTest.java
package carDB.backend.TDD;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import carDB.backend.model.Message;
import carDB.backend.service.MessageService;

@SpringBootTest
public class MessageServiceTest {
    @Test
    public void testAddMessage() {
        MessageService messageService = new MessageService();
        String msg = "Hello world";
        Message newMsg = messageService.addMsg(msg);
        assertEquals(msg, newMsg.getContent());
    }
}
