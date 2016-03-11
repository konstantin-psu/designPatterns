class Client {
    public static void main(String [] ignore) {
	StringBuffer string = new StringBuffer("Hello world.");
	System.out.println(string);
	CommandIF command;
	// ------------------------------------------------------------------
	command = new Insert(string, 6,'x');
	command.execute();
	System.out.println(string);
	command.undo();
	System.out.println(string);
	// ------------------------------------------------------------------
	command = new Delete(string, 6);
	command.execute();
	System.out.println(string);
	command.undo();
	System.out.println(string);
	// ------------------------------------------------------------------
	System.out.println(command.history);
    }
}
