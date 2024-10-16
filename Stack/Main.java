package Stack;

public class Main {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        System.out.println(stack.pop());

    }
}
