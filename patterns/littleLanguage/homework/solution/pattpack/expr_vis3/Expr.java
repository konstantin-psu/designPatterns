package pattpack.expr_vis3;

import java.io.*;

/**
 *  This class represents an expression of the "while" language.
 */
public interface Expr {
    /**
     *  Visitor dispatcher.
     *  @param visitor The visitor to visit this object.
     *  @param data The visitor argument.
     *  @return The visitor returned value.
     */
    Object accept (Visitor visitor, Object data);
}
