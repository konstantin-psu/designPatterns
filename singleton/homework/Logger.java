class Logger {
    private Logger() {}
    private static Logger theInstance = new Logger();
    public static  Logger getInstance() { return theInstance; }    
    public void test() {
        try {
            BufferedWriter out = new BufferedWriter
            (new FileWriter("filename"));
            out.write("aString1\n");
            out.close();
            out = new BufferedWriter(new FileWriter
            ("filename",true));
            out.write("aString2");
            out.close();
            BufferedReader in = new BufferedReader
            (new FileReader("filename"));
            String str;
            while ((str = in.readLine()) != null) {
               System.out.println(str);
            }
        }
        in.close();
        catch (IOException e) {
            System.out.println("exception occoured"+ e);
        }
    }

    public void ifExists(String fPath) {
        File f = new File(fPath);
        if(f.exists() && !f.isDirectory()) { 
            return true;
        }
        return false;
    }

}
