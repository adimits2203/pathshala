package queue;

import java.util.Arrays;

class MyCircularQueue {

    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3);
        circularQueue.enQueue(1);
        System.out.println("enq: "+ circularQueue);
        circularQueue.enQueue(2);
        System.out.println("enq: "+ circularQueue);

        circularQueue.enQueue(3);
        System.out.println("enq: "+ circularQueue);

        circularQueue.enQueue(4);
        System.out.println("enq: "+ circularQueue);

        System.out.println("rear: "+ circularQueue.Rear());


        System.out.println("isfull : "+circularQueue.isFull());
        System.out.println(circularQueue);

        System.out.println("deq: "+circularQueue.deQueue());
        System.out.println(circularQueue);

        System.out.println("enq: "+ circularQueue.enQueue(4));
        System.out.println(circularQueue);

        System.out.println("rear: "+circularQueue.Rear());
        System.out.println(circularQueue);
    }

    @Override
    public String toString() {
        return "MyCircularQueue{" +
                "arr=" + Arrays.toString(arr) +
                ", front=" + front +
                ", rear=" + rear +
                '}';
    }

    int[] arr;

    int front=-1, rear=-1;


    public MyCircularQueue(int k) {
        arr = new int[k];
    }
    
    public boolean enQueue(int value) {
        if(!isFull()){
            rear++;
            if(rear>= arr.length){
                rear-=(arr.length);
            }
            arr[rear] = value;
            if(front==-1){
                front++;
            }
            return true;
        }
        return false;
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        else if(front==rear){
            front = rear = -1;
            return true;
        }
        front++;
        if(front>= arr.length){
            front-= arr.length;
        }
        return true;
    }
    
    public int Front() {

        return front==-1 ? -1 : arr[front];
    }
    
    public int Rear() {
        return rear==-1 ? -1 : arr[rear];
    }
    
    public boolean isEmpty() {
        return front==-1 && rear==-1;
    }
    
    public boolean isFull() {
        int t = rear + 1 ;
        if(t >= arr.length){
            t-= (arr.length);
        }
        return (front == t) ? true : false;
    }
}