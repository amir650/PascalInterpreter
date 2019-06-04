public class Executor extends Backend {
    @Override
    public void process(ICode iCode, SymbolTable symbolTable) throws Exception {

        long startTime = System.currentTimeMillis();
        float elapsedTime = (System.currentTimeMillis() - startTime)/1000f;
        int executionCount = 0;
        int runtimeErrors = 0;

        // Send the interpreter summary message.
        sendMessage(new Message(MessageType.INTERPRETER_SUMMARY,
                new Number[] {executionCount,
                        runtimeErrors,
                        elapsedTime}));

    }

}
