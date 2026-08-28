import java.util.Stack;

class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Add element to the back of queue
    public void push(int x) {
        stack1.push(x);
    }

    // Remove element from the front
    public int pop() {
        moveElements();

        return stack2.pop();
    }

    // Get front element
    public int peek() {
        moveElements();

        return stack2.peek();
    }

    // Check if queue is empty
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Move elements from stack1 to stack2
    private void moveElements() {

        if (stack2.isEmpty()) {

            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }
}