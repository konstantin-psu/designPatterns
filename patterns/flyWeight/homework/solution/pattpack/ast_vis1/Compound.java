package pattpack.ast_vis1;

import java.io.*;

/**
 *  This class represents a compound statement.
 */

public class Compound implements Statement {
    private Statement [] body;
    /**
     *  Constructor, instances are immutable.
     *  This constructor is for a two-statements compound only.
     *  @param stmt0 The first statement of this compound.
     *  @param stmt1 The second statement of this compound.
     */
    public Compound (Statement stmt0, Statement stmt1) {
	body = new Statement [2];
	body [0] = stmt0;
	body [1] = stmt1;
    }
    /**
     *  Constructor, instances are immutable.
     *  @param body The sequence of statements of this compound.
     */
    public Compound (Statement [] body) { this.body = body; }
    /**
     *  Return the body of this compound.
     *  An enumeration would be more appropriate.
     *  @return The body of this compound.
     */
    public Statement [] getBody () { return body; }
    /**
     *  Visitor dispatcher.
     *  @param visitor The visitor to visit this object.
     *  @param data The visitor argument.
     *  @return The visitor returned value.
     */
    public Object accept (Visitor visitor, Object data) {
	return visitor.visit (this, data);
    }
    /**
     *  Interpret this statement.
     */
    public void interpret () {
	for (int i = 0; i < body.length; i++) body [i].interpret ();
    }
}
