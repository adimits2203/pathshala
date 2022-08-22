package stack;

import java.util.Stack;

public class MyStack {

    public static void main(String[] args) {
       MinStack minStack = new MinStack();
       minStack.push(512);;
       minStack.push(-1024);;
       minStack.push(-1024);
       minStack.push(512);
       minStack.pop();
        System.out.println(minStack.getMin());
       minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println( minStack.getMin());
        //System.out.println(nextLargerElement(new long[]{1,3,2,4}, 4));
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


    /***/
    private static String plugin(String s){
        Stack<Character> stk = new Stack();
        for (char c:s.toCharArray()
             ) {
            if(stk.isEmpty()){
                stk.push(c);
            }
            else{
                if(stk.peek()==c){
                    stk.pop();
                }
                else{
                    stk.push(c);
                }
            }

        }

        return (stk.toString());

    }


    /**
     * https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/
     *
     * Idea is to use Stack to push the characters in and pop as soon as abc is achieved
     *
     * */
    public static boolean isValidN(String s) {
        Stack<Character> stack = new Stack();
        for (char c:s.toCharArray()
             ) {
            if(stack.isEmpty()){
                stack.push(c);
            }
            else{
                if(c=='c' && stack.size()>=2){
                    char b = stack.pop();
                    char a = stack.pop();
                    if(b=='b' && a=='a'){
                        continue;
                    }
                    else{
                        stack.push(a);
                        stack.push(b);
                        stack.push(c);
                    }
                }
                else{
                    stack.push(c);
                }
            }
        }
        if(stack.isEmpty() || stack.toString()=="abc"){
            return true;
        }
        return false;
    }

    /**
     * https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1#_=_
     *
     * Idea is to create a stack of elements which is sorted in desc order
     *  loop though tht elements
     *      if the element is less than stack.top() then push the element
     *      else keep popping the elements till you reach the element greater than the current one
     *
     *
     * */
    public static long[] nextLargerElement(long[] arr, int n)
    {
        long[] res = new long[arr.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = -1;
        }
        Stack<Integer> stack = new Stack();
        stack.push(0);
        for (int i = 1; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[i] > arr[stack.peek()]){
                res[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        return res;
    }


}
