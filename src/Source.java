import java.io.BufferedReader;
import java.io.IOException;

public class Source implements MessageProducer {

    public static final char EOL = '\n';
    public static final char EOF = (char)0;

    private BufferedReader reader;
    private String line;
    private int lineNum;
    private int currentPosition;

    private MessageHandler messageHandler;

    public Source(BufferedReader reader) throws IOException {
        this.lineNum = 0;
        this.currentPosition = -2;
        this.reader = reader;
        this.messageHandler = new MessageHandler();
    }

    public int getLineNumber() {
        return this.lineNum;
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }

    public char currentCharacter() throws Exception {
        if(this.currentPosition == -2) {
            readLine();
            return nextCharacter();
        } else if(this.line == null) {
            return EOF;
        } else if((currentPosition == -1) || (currentPosition == line.length())) {
            return EOL;
        } else if(currentPosition > line.length()) {
            readLine();
            return nextCharacter();
        } else {
            return line.charAt(currentPosition);
        }
    }

    public char nextCharacter() throws Exception {
        currentPosition++;
        return currentCharacter();
    }

    public char peek() throws Exception {
        currentCharacter();
        if(this.line == null) {
            return EOF;
        }
        int nextPosition = this.currentPosition + 1;
        return nextPosition < this.line.length() ? line.charAt(nextPosition) : EOL;
    }

    private void readLine() throws IOException {
        this.line = this.reader.readLine();
        this.currentPosition = - 1;

        if(this.line != null) {
            lineNum++;
        }
    }

    public void close() throws Exception {
        if(this.reader != null) {
            try {
                this.reader.close();
            } catch(Exception e) {
                e.printStackTrace();
                throw e;
            }
        }
    }

    /**
     * Add a parser message listener.
     * @param listener the message listener to add.
     */
    public void addMessageListener(MessageListener listener)
    {
        messageHandler.addListener(listener);
    }

    /**
     * Remove a parser message listener.
     * @param listener the message listener to remove.
     */
    public void removeMessageListener(MessageListener listener)
    {
        messageHandler.removeListener(listener);
    }

    /**
     * Notify listeners after setting the message.
     * @param message the message to set.
     */
    public void sendMessage(Message message)
    {
        messageHandler.sendMessage(message);
    }
}
