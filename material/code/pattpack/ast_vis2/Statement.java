package pattpack.ast_vis2;

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
}
