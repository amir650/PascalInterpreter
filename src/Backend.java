public abstract class Backend implements MessageProducer {

    protected static MessageHandler messageHandler = new MessageHandler();

    protected SymbolTable symbolTable;
    protected ICode iCode;

    public abstract void process(ICode iCode, SymbolTable symbolTable) throws Exception;

}
