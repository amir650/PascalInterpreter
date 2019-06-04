public abstract class Parser implements MessageProducer {

    protected static SymbolTable symbolTable = null;

    protected Scanner scanner;
    protected ICode iCode;
    protected static MessageHandler messageHandler = new MessageHandler();

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
