package stack;

import java.util.Stack;

public class MyStack {

    public static void main(String[] args) {
        System.out.println(isValid("]["));
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
       * https://leetcode.com/problems/valid-parentheses/
       * */
       public static boolean isValid(String s) {
            Stack<Character> stk = new Stack();
            char[] arr = s.toCharArray();
           for (char c:arr
                ) {
               if(isOpen(c)){
                   stk.push(c);
               }
               else if(!stk.isEmpty()){// close brace

                   if(stk.peek()=='(' && c==')') {
                       stk.pop();
                       continue;
                   }
                   if(stk.peek()=='{' && c=='}') {
                       stk.pop();
                       continue;
                   }
                   if(stk.peek()=='[' && c==']') {
                       stk.pop();
                       continue;
                   }
                   return false;
               }
               else {
                   return false;
               }
           }
           if(stk.isEmpty()){
               return true;
           }
            return false;
       }

    private static boolean isOpen(char c) {
           return c=='(' || c=='{' || c=='[';
    }


}
