package L07EnumsAndAnnotations.Ex02WarningLevels;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private List<Message> messages;
    private Importance importance;

    public Logger(String importance) {
        this.importance = Enum.valueOf(Importance.class, importance);
        this.messages = new ArrayList<>();
    }

    public void addMessage(Message message) {
        if (message.getImportance().compareTo(this.importance) >= 0) {
            this.messages.add(message);
        }
    }

    public Iterable<Message> getMessages() {
        return this.messages;
    }


}
