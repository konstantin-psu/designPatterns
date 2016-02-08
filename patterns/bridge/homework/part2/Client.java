class Client {

    public static void main(String [] ignore) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < 20; i++) {
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

}
