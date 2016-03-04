import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * This class provides access to text files, fetching a string
 * containing the next or previous n lines.
 * <p>
 * This class illustrates a serializable class that refers to a
 * non-serializable object.  In particular it refers to a RandomAccessFile
 * that is not serializble.  Since it cannot write the RandomAccessFile
 * object directly to a file, it saves the file name and the current
 * position in the file. 
 */
public class TextFileReader implements Serializable {
    private transient RandomAccessFile file;
    private String browseFileName;
    private FilePositionStack stack;

    /**
     * Construct a TextFileReader that will read from the specified
     * file.
     * @param fileName The name of the file to read from.
     * @exception IOException if there is a problem opening the file.
     */
    public TextFileReader(String fileName) throws IOException {
        browseFileName = fileName;
        file = new RandomAccessFile(browseFileName, "r");
        stack = new FilePositionStack();
    } // constructor(String)

    /**
     * return a string containing the next n lines of text in the file.
     */
    public String getNext(int n) throws IOException {
        String lines = "";
        for (int i = n; i > 0; i--) {
            stack.savePosition(file);
            String line = file.readLine();
            if (line == null) {
                if (lines.length() > 0)
                  return lines;
                else
                  throw new IOException();
            } // if
            lines += line + "\n";
        } // for
        return lines;
    } // getNext(int)

    /**
     * Return a string containing the n lines of text preceding the n
     * lines before the files current position. If there aren't that
     * many lines before the current position then this method returns
     * the first n lines in the file.
     */
    public String getPrevious(int n) throws IOException {
        try {
            for (int i = n*2; i > 0; i--) {
                stack.restorePosition(file);
            } // for
        } catch (EmptyStackException e) {
        } // try
        return getNext(n);
    } // getPrevious(int)

    /**
     * This method returns the name of the text file associated with
     * this object.
     */
    public String getFileName() {
        return browseFileName;
    } // getFileName()

    /**
     * Save this object in the named file.
     * @param fileName The name of the file.
     * @exception IOException if there is a problem
     */
    public void save(String fileName) throws IOException {
        FileOutputStream fout = new FileOutputStream(fileName);
        ObjectOutputStream out = new ObjectOutputStream(fout);
        try {
            out.writeObject(this);
            out.close();
        } catch (IOException e) {
            // if write not successful, delete file
            try {
                out.close();
            } catch (IOException e2) {
                // ignore IOExceptions that occur during cleanup of
                // failed write
            } // try
            new File(fileName).delete();
        } // try
    } // save(String)

    /**
     * Retrive a TextFileReader object from the named file.
     * @param fileName The name of the file.
     * @exception IOException if there is a problem
     */
    public static TextFileReader restore(String fileName)
                                 throws IOException {
        FileInputStream fin = new FileInputStream(fileName);
        ObjectInputStream in = new ObjectInputStream(fin);
        try {
            return (TextFileReader)in.readObject();
        } catch (ClassNotFoundException e) {
            String msg = "Unable to find class";
            if (e.getMessage() != null)
              msg += ": " + e.getMessage();
            throw new IOException(msg);
        } // try
    } // restore(String)

    /**
     * this methods overrides the default serialization logic in order
     * to write information that will allow the RandomAccessFile object
     * referenced by the variable file to be reconstructed during
     * deserialization.
     * <p>
     * This method is called by the given ObjectOutputStream during
     * serialization.
     */
    private void writeObject(ObjectOutputStream stream)
                 throws IOException{
        stream.defaultWriteObject();
        stream.writeLong(file.getFilePointer());
    } // writeObject(ObjectOutputStream)

    private void readObject(ObjectInputStream stream) 
                 throws IOException {
        try {
            stream.defaultReadObject();
        } catch (ClassNotFoundException e) {
            String msg = "Unable to find class";
            if (e.getMessage() != null)
              msg += ": " + e.getMessage();
            throw new IOException(msg);
        } // try
        file = new RandomAccessFile(browseFileName, "r");
        file.seek(stream.readLong());
    } // readObject(ObjectInputStream)

    /**
     * This class implemenents a stack of file positions.
     */
    private static class FilePositionStack implements Serializable {
        private Stack stack;

        FilePositionStack() {
            stack = new Stack();
        } // constructor()
        
        /**
         * Push a file position on the stack.
         * @param pos a file position.
         */
        void savePosition(RandomAccessFile file) throws IOException {
            stack.push(new Long(file.getFilePointer()));
        } // push(long)

        /**
         * Pops a file position off the stack.
         * @exception EmptyStackException If the stack is empty.
         */
        public void restorePosition(RandomAccessFile file) 
                    throws IOException {
            file.seek(((Long)stack.pop()).longValue());
        }
    } // class FilePositionStack
} // class TextFileReader
