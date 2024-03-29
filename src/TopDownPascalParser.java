public class TopDownPascalParser extends Parser {

    protected TopDownPascalParser(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void parse() throws Exception {
        Token token;
        long startTime = System.currentTimeMillis();
        while(!((token = nextToken()) instanceof EofToken)) {}
        float elapsed = (System.currentTimeMillis() - startTime) / 1000f;
        sendMessage(new Message(MessageType.PARSER_SUMMARY,
                                new Number[] { token.getLineNumber(),
                                               getErrorCount(),
                                               elapsed
                                              }));
    }

    @Override
    public int getErrorCount() {
        return 0;
    }

    @Override
    public ICode getICode() {
        return null;
    }

    @Override
    public SymbolTable getSymbolTable() {
        return null;
    }

}
