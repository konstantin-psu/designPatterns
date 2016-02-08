import java.io.InputStream;
import java.io.IOException;
import java.io.StreamTokenizer;

/**
 * This class contains the logic to perform lexical analysis for the word
 * combination language.
 */
class LexicalAnalyzer {
    private StreamTokenizer input;
    private int lastToken;

    // constants to identify the type of the last recognized token.
    static final int INVALID_CHAR = -1;// unexpected character found.
    static final int NO_TOKEN = 0;// No tokens recognized yet.

    static final int OR = 1;
    static final int AND = 2;
    static final int NEAR = 3;
    static final int NOT = 4;
    static final int WORD = 5;
    static final int LEFT_PAREN = 6;
    static final int RIGHT_PAREN = 7;
    static final int QUOTED_STRING = 8;
    static final int EOF = 9;
    
    /**
     * Constructor
     * @param input The input stream that contains the input to be lexed.
     */
    LexicalAnalyzer(InputStream in) {
        input = new StreamTokenizer(in);
        input.resetSyntax();
        input.eolIsSignificant(false);
        input.wordChars('a', 'z');
        input.wordChars('A','Z');
        input.wordChars('0','9');
        input.wordChars('\u0000',' '-1);
        input.ordinaryChar('(');
        input.ordinaryChar(')');
        input.quoteChar('"');
    } // constructor(InputStream)

    /**
     * Return the string recognized as word token or the body of a
     * quoted string.
     */
    String getString() {
        return input.sval;
    } // getString()

    /**
     * Return the type of the next token.  For word and quoted string
     * tokens, the string that the token represents can be fetched by
     * calling the getString method.
     */
    int nextToken() {
        int token;
        try {
            switch (input.nextToken()) {
              case StreamTokenizer.TT_EOF:
                  token = EOF;
                  break;
              case StreamTokenizer.TT_WORD:
                  if (input.sval.equalsIgnoreCase("or"))
                    token = OR;
                  else if (input.sval.equalsIgnoreCase("and"))
                    token = AND;
                  else if (input.sval.equalsIgnoreCase("near"))
                    token = NEAR;
                  else if (input.sval.equalsIgnoreCase("not"))
                    token = NOT;
                  else
                    token = WORD;
                  break;
              case '"':
                  token = QUOTED_STRING;
                  break;
              case '(':
                  token = LEFT_PAREN;
                  break;
              case ')':
                  token = RIGHT_PAREN;
                  break;
              default:
                  token = INVALID_CHAR;
                  break;
            } // switch
        } catch (IOException e) {
            // Treat an IOException as an end of file
            token = EOF;
        } // try
        return token;
    } // nextToken() 
} // class LexicalAnalyzer
