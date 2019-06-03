public abstract class Parser implements MessageProducer {

    protected static SymbolTable symbolTable = null;

    protected Scanner scanner;
    protected ICode iCode;

    protected Parser(Scanner scanner) {
        this.scanner = scanner;
        this.iCode = null;
    }

    public abstract void parse() throws Exception;

    public abstract int getErrorCount();

    public Token currentToken() {
        return this.scanner.currentToken();
    }

    public Token nextToken() throws Exception {
        return this.scanner.nextToken();
    }

    public abstract ICode getICode();

    public abstract SymbolTable getSymbolTable();
}
