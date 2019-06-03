public abstract class Parser {

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
        return null;
        //return this.scanner.currentToken();
    }

    public Token nextToken() throws Exception {
        return null;
        //return this.scanner.nextToken();
    }
}
