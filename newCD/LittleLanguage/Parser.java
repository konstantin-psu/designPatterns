import java.io.InputStream;

/**
 * Instances of this class parse the word combination little language.
 */
public class Parser {
    private LexicalAnalyzer lexer; // lexical analyzer that parser uses
    private int token;

    /**
     * This method parses a word combination that it reads from a given
     * input stream.
     * @param input An input stream that this method will read the
     *              source for a word combination from.
     * @return A combination object that is the root of the parse tree
     *         produced by the parse.
     */
    public Combination parse(InputStream input) throws SyntaxException{
        lexer = new LexicalAnalyzer(input);
        Combination c = orCombination();
        expect(LexicalAnalyzer.EOF);
        return c;
    } // parse(InputStream)

    // Parse an orCombination
    private Combination orCombination() throws SyntaxException {
        Combination c = andCombination();
        while (token == LexicalAnalyzer.OR) {
            c = new OrCombination(c, andCombination());
        } // while
        return c;
    } // orCombination()

    // Parse an andCombination
    private Combination andCombination() throws SyntaxException {
        Combination c = nearCombination();
        while (token == LexicalAnalyzer.AND) {
            c = new AndCombination(c, nearCombination());
        } // while
        return c;
    } // andCombination

    // parse a nearCombination
    private Combination nearCombination() throws SyntaxException {
        Combination c = simpleCombination();
        while (token == LexicalAnalyzer.NEAR) {
            c = new NearCombination(c, simpleCombination());
        } // while
        return c;
    } // nearCombination()

    // parse a simpleCombination
    private Combination simpleCombination() throws SyntaxException {
        if (token == LexicalAnalyzer.LEFT_PAREN) {
            nextToken();
            Combination c = orCombination();
            expect(LexicalAnalyzer.RIGHT_PAREN);
            return c;
        } // if '('
        if (token == LexicalAnalyzer.NOT)
          return notWordCombination();
        else
          return wordCombination();
    } // simpleCombination()

    // parse a wordCombination
    private Combination wordCombination() throws SyntaxException {
        if (token != LexicalAnalyzer.WORD
             && token != LexicalAnalyzer.QUOTED_STRING) {
            // print error message and throw SyntaxException
            expect(LexicalAnalyzer.WORD);
        } // if
        Combination c = new WordCombination(lexer.getString());
        nextToken();
        return c;
    } // wordCombination()

    // parse a wordCombination
    private Combination notWordCombination() throws SyntaxException {
        expect(LexicalAnalyzer.NOT);
        if (token != LexicalAnalyzer.WORD
             && token != LexicalAnalyzer.QUOTED_STRING) {
            // print error message and throw SyntaxException
            expect(LexicalAnalyzer.WORD);
        } // if
        Combination c = new NotWordCombination(lexer.getString());
        nextToken();
        return c;
    } // notWordCombination()

    /**
     * Get the next token from the lexer.
     */
    private void nextToken() {
        token = lexer.nextToken();
    } // nextToken()

    /**
     * Complain if the current token is not the specified kind of
     * token.
     * @param t The type of token that is expected.
     */
    private void expect(int t) throws SyntaxException {
        if (token != t) {
            String msg = "found " + tokenName(token)
              + " when expecting " + tokenName(t);
            System.err.println("Syntax error: "+msg);
        } // if
        nextToken();
    } // expect(int)

    private String tokenName(int t) {
        String tname;
        switch (t) {
          case LexicalAnalyzer.OR:
              tname = "OR";
              break;
          case LexicalAnalyzer.AND:
              tname = "AND";
              break;
          case LexicalAnalyzer.NEAR:
              tname = "NEAR";
              break;
          case LexicalAnalyzer.NOT:
              tname = "NOT";
              break;
          case LexicalAnalyzer.WORD:
              tname = "word";
              break;
          case LexicalAnalyzer.LEFT_PAREN:
              tname = "(";
              break;
          case LexicalAnalyzer.RIGHT_PAREN:
              tname = ")";
              break;
          case LexicalAnalyzer.QUOTED_STRING:
              tname = "quoted string";
              break;
          case LexicalAnalyzer.EOF:
              tname = "end of file";
              break;
          default:
              tname = "???";
              break;
        } // switch
        return tname;
    } // tokenName(int)
} // class Parser
