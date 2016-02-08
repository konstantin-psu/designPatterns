import java.io.*;
public class z {
    public static void main(String[] argv) {
        FileInputStream fin;
        try {
            fin = new FileInputStream("input");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        } // try
        LexicalAnalyzer lex = new LexicalAnalyzer(fin);
        int tt;
        do {
            tt = lex.nextToken();
            System.out.println("Token type is "+tt);
            System.out.println("Token string is \n"+lex.getString());
        } while (tt!= LexicalAnalyzer.EOF);
        System.out.println("Done");
    }
} // z
