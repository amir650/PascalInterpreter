import java.io.BufferedReader;
import java.io.FileReader;

public class Pascal {

    private Parser parser;
    private Source source;
    private ICode iCode;
    private SymbolTable symbolTable;
    private Backend backend;

    public Pascal(String operation,
                  String filePath,
                  String flags) {

        try {
            boolean intermediate = flags.indexOf('i') > -1;
            boolean xref = flags.indexOf('x') > -1;
            this.source = new Source(new BufferedReader(new FileReader(filePath)));
            this.source.addMessageListener(new SourceMessageListener());
            this.parser = FrontEndFactory.createParser("Pascal", "top-down", this.source);
            this.parser.addMessageListener(new ParserMessageListener());
            this.backend = BackendFactory.createBackend(operation);
            this.backend.addMessageListener(new BackendMessageListener());
            this.parser.parse();
            this.source.close();
            this.iCode = parser.getICode();
            this.symbolTable = this.parser.getSymbolTable();
            this.backend.process(iCode, symbolTable);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
