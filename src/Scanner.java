public abstract class Scanner {

    protected Source source;
    private Token currentToken;

    public Scanner(Source source) {
        this.source = source;
    }

    public Token currentToken() {
        return this.currentToken;
    }

    public Token nextToken() throws Exception {
        return null;
    }

    protected abstract Token extractToken() throws Exception;

    public char currentChar() throws Exception {
        return this.source.currentCharacter();
    }

    public char nextChar() throws Exception {
        return this.source.nextCharacter();
    }
}
