package stack;

import java.util.Stack;

public class MyStack {

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(4);
        s.push(3);
        s.push(2);
        s.push(1);
        System.out.println("before: "+ s);
        reverse(s);
        System.out.println("after: "+ s);
        System.out.println("peek : "+ s.peek());
    }

    /**
     * PushBottom on stack
     *
     * ip: (top)1 2 3 4 , 5
     * op: (top)1 2 3 4 5
     *
     * Idea is to use recurrsion
     *
     * */
     private static void pushBottom(Stack<Integer> stack, int k){
         if(stack.isEmpty()){
             stack.push(k);
             return;
         }
         int t = stack.pop();
         pushBottom(stack, k);
         stack.push(t);

     }

     /**
      *
      * */
      private static void reverse(Stack<Integer> stack)
      {
          if(stack.isEmpty()){// revrese of empty is empty
              return;
          }
         int t = stack.pop();
         reverse(stack);
         pushBottom(stack, t);
      }

      /**
       *
       * */

}
