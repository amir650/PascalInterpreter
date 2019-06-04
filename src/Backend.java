public abstract class Backend implements MessageProducer
{
    protected static MessageHandler messageHandler;

    static {
        messageHandler = new MessageHandler();
    }

    protected SymbolTable symTab;
    protected ICode iCode;

    public ICode getICode()
    {
        return iCode;
    }

    public SymbolTable getSymTab()
    {
        return symTab;
    }

    public MessageHandler getMessageHandler()
    {
        return messageHandler;
    }

    public abstract void process(ICode iCode, SymbolTable symTab)
            throws Exception;

    public void sendMessage(Message message)
    {
        messageHandler.sendMessage(message);
    }


    public void addMessageListener(MessageListener listener)
    {
        messageHandler.addListener(listener);
    }

    public void removeMessageListener(MessageListener listener)
    {
        messageHandler.removeListener(listener);
    }
}
