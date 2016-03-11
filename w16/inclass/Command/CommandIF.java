import java.util.Vector;

abstract class CommandIF {
    void execute() {
	history.add(this);
    }
    abstract void undo();
    static Vector history = new Vector();
}

class Insert extends CommandIF {
    StringBuffer string;
    int position;
    char theChar;
    Insert(StringBuffer string, int position, char theChar) {
	this.string = string;
	this.position = position;
	this.theChar = theChar;
    }
    void execute() {
	super.execute();
	string.insert(position, theChar);
    }
    void undo() {
	string.deleteCharAt(position);
    }
}

class Delete extends CommandIF {
    StringBuffer string;
    int position;
    char theChar;
    Delete(StringBuffer string, int position) {
	this.string = string;
	this.position = position;
    }
    void execute() {
	super.execute();
	theChar = string.charAt(position);
	string.deleteCharAt(position);
    }
    void undo() {
	string.insert(position, theChar);
    }
}
