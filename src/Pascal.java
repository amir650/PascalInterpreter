import java.io.BufferedReader;
import java.io.FileReader;

public class Pascal {

    private Parser parser;
    private Source source;
    private ICode iCode;
    private SymbolTable symbolTable;
    private Backend backend;

    public static final String FLAGS = "[-ix]";
    public static final String USAGE = "...";
    public static final String SOURCE_LINE_FORMAT = "%03d %s";
    public static final String PARSER_SUMMARY_FORMAT = "\n%,20d source lines" +
                                                       "\n%,20d syntax errors." +
                                                       "\n%,20.2f seconds total parsing time.\n";
    public static final String INTERPRETER_SUMMARY_FORMAT =
            "\n%,20d statements executed." +
                    "\n%,20d runtime errors." +
                    "\n%,20.2f seconds total execution time.\n";

    public static final String COMPILER_SUMMARY_FORMAT =
            "\n%,20d instructions generated." +
                    "\n%,20.2f seconds total code generation time.\n";
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

    public static void main(String[] args) {

        try {
            String operation = args[0];
            if(!(operation.equalsIgnoreCase("compile") ||
                 operation.equalsIgnoreCase("execute"))) {
                throw new Exception();
            }
            int i = 0;
            String flags = "";

            while((++i < args.length) && (args[i].charAt(0) == '-')) {
                flags += args[i].substring(i);
            }

            if(i < args.length) {
                String path = args[i];
                new Pascal(operation, path, flags);
            } else {
                throw new Exception();
            }

        } catch(Exception e) {
            System.out.println(USAGE);
        }


    }

}
