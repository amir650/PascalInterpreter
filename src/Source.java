import java.io.BufferedReader;
import java.io.IOException;

public class Source {

    public static final char EOL = '\n';
    public static final char EOF = (char)0;

    private BufferedReader reader;
    private String line;
    private int lineNum;
    private int currentPosition;

    public Source(BufferedReader reader) throws IOException {
        this.lineNum = 0;
        this.currentPosition = -2;
        this.reader = reader;
    }

    public char currentCharacter() throws Exception {
        return (char)0;
    }

    public char nextCharacter() throws Exception {
        currentPosition++;
        return currentCharacter();
    }

    public char peek() throws Exception {
        return (char)0;
    }

    private void readLine() throws IOException {
    }

    public void close() throws Exception {
    }

    public int getLineNumber() {
        return 0;
    }

    public int getPosition() {
        return 0;
    }
}
