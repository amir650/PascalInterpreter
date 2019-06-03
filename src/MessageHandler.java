import java.util.ArrayList;
import java.util.List;

public class MessageHandler {

    private Message message;
    private List<MessageListener> listeners;

    public MessageHandler() {
        this.listeners = new ArrayList<>();
    }

    public void addListener(MessageListener listener) {
        this.listeners.add(listener);
    }

    public void removeListener(MessageListener listener) {
        this.listeners.remove(listener);
    }

    public void sendMessage(Message message) {
        this.message = message;
        notifyListeners();
    }

    private void notifyListeners() {
        for(MessageListener listener : this.listeners) {
            listener.messageReceived(this.message);
        }
    }

}
