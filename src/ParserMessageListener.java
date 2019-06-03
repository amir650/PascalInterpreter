public class ParserMessageListener implements MessageListener {
    @Override
    public void messageReceived(Message message) {
        MessageType type = message.getType();

        switch (type) {
            case PARSER_SUMMARY: {
                Number body[] = (Number[])message.getBody();
                int statementCount = (Integer)body[0];
                int syntaxErrors = (Integer)body[1];
                float elapsedTime = (Float)body[2];
                System.out.printf(Pascal.PARSER_SUMMARY_FORMAT, statementCount, syntaxErrors, elapsedTime);
                break;
            }
        }
    }
}
