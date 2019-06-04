public class Token {

    protected TokenType type;
    protected String text;
    protected Object value;
    protected Source source;
    protected int lineNumber;
    protected int position;

    public Token(Source source) throws Exception {
        this.source = source;
        this.lineNumber = source.getLineNumber();
        this.position = source.getCurrentPosition();
        extract();
    }

    protected void extract() throws Exception {
        this.text = Character.toString(currentChar());
        this.value = null;
        nextChar();
    }

    protected char currentChar() throws Exception {
        return this.source.currentCharacter();
    }

    protected char nextChar() throws Exception {
        return this.source.nextCharacter();
    }

    protected char peekChar() throws Exception {
        return this.source.peek();
    }

    public Number getLineNumber() {
        return this.lineNumber;
    }
}
