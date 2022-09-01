package queue;

import java.util.Stack;

public class MyStackQueue {
    Stack<Integer> pushStack = new Stack();
    Stack<Integer> popStack = new Stack();
    int pushStackBottom, front;





    public void push(int x) {
        if(pushStack.isEmpty() && popStack.isEmpty()){
            front = x;
        }
        else if(pushStack.isEmpty()){
            pushStackBottom = x;
        }
        pushStack.push(x);

    }

    public int pop() {
        if(popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        int ans = popStack.pop();
        if(!popStack.isEmpty()){
            front = popStack.peek();
        }
        else if(!pushStack.isEmpty()){
            front = pushStackBottom;
        }


        return ans;
    }

    public int peek() {

            return front;
    }

    public boolean empty() {
        if(pushStack.isEmpty() && popStack.isEmpty()){
            return true;
        }
        else{
            return false;

        }

    }
}
