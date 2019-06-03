public class BackendMessageListener implements MessageListener {
    @Override
    public void messageReceived(Message message) {
        MessageType messageType = message.getType();

        switch (messageType) {
            case INTERPRETER_SUMMARY: {
                Number body[] = (Number[]) message.getBody();
                int executionCount = (Integer)body[0];
                int runtimeErrors = (Integer)body[1];
                float elapsedTime = (Float)body[2];
                System.out.printf(Pascal.INTERPRETER_SUMMARY_FORMAT, executionCount, runtimeErrors, elapsedTime);
                break;
            }
            case COMPILER_SUMMARY: {
                Number body[] = (Number[]) message.getBody();
                int instructionCount = (Integer)body[0];
                float elapsedTime = (Float)body[1];
                System.out.printf(Pascal.COMPILER_SUMMARY_FORMAT, instructionCount, elapsedTime);
                break;
            }
        }
    }
}
