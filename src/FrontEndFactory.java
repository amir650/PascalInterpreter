public class FrontEndFactory {

    public static Parser createParser(String language,
                                      String type,
                                      Source source) throws Exception {
        if(language.equalsIgnoreCase("Pascal") &&
           type.equals("top-down")) {
           return new TopDownPascalParser(new PascalScanner(source));
        } else if(!language.equalsIgnoreCase("Pascal")) {
            throw new Exception("Invalid language!");
        } else {
            throw new Exception("Invalid type!");
        }
    }

}
