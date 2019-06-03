public class SourceMessageListener implements MessageListener {

    @Override
    public void messageReceived(Message message) {
        MessageType type = message.getType();
        Object body[] = (Object[]) message.getBody();

        switch(type) {
            case SOURCE_LINE:
                int lineNumber = (Integer)body[0];
                String lineText = (String)body[1];
                System.out.println(String.format(Pascal.SOURCE_LINE_FORMAT, lineNumber, lineText));
                break;
        }
    }
}
