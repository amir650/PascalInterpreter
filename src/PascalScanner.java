public class PascalScanner extends Scanner {

    public PascalScanner(Source source) {
        super(source);
    }

    @Override
    protected Token extractToken() throws Exception {
        return currentChar() == Source.EOF ? new EofToken(source) : new Token(source);
    }
}
