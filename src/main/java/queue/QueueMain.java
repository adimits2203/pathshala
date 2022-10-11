package queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class QueueMain {

    public static void main(String[] args) {
        System.out.println(generate(2));

    }
    /**
     * https://practice.geeksforgeeks.org/problems/generate-binary-numbers-1587115620/1#_=_
     *
     * Given a number N. The task is to generate and print all binary numbers with decimal values from 1 to N.
     *
     * Example 1:
     *
     * Input:
     * N = 2
     * Output:
     * 1 10
     * Explanation:
     * Binary numbers from
     * 1 to 2 are 1 and 10.
     *
     *
     * Idea is to take a queue and push 1. then pop the element - i from queue and print it
     * after printing psu two elements i * 10 and i*10+1. These are nothign but binary representation of next elements in level order traversal
     * */
    static ArrayList<String> generate(int N)
    {
        Queue<Integer> queue = new ArrayDeque<>();
        ArrayList<String> res = new ArrayList();
        queue.add(1);
        int count = 0;
        while(count<N){
            int t = queue.poll();
            res.add(t+"");
            queue.add(t*10);
            queue.add(t*10+1);
            count++;
        }
        return res;
    }
}
