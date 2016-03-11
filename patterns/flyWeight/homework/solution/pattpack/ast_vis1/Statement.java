package pattpack.ast_vis1;

import java.io.*;

/**
 *  Interface of all statements.
 */
public interface Statement {
    /**
     *  Visitor dispatcher.
     *  @param visitor The visitor to visit this object.
     *  @param data The visitor argument.
     *  @return The visitor returned value.
     */
    Object accept (Visitor visitor, Object data);
    /**
     *  Interpret this statement.
     *  This method is here so students can replace it with a visitor.
     */
    void interpret ();
}
