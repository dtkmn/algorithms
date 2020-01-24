package leetcode;

/*
   https://leetcode.com/problems/min-stack/
 */


public class MinStack {

    public static void main(String[] args) {

//        ["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
//        [[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]

        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);


        minStack.top();
        minStack.pop();
        System.out.println(
            minStack.getMin()
        );

        minStack.pop();
        System.out.println(
            minStack.getMin()
        );

        minStack.pop();
        minStack.push(2147483647);

        minStack.top();
        System.out.println(
            minStack.getMin()
        );
        minStack.push(-2147483648);


        minStack.top();

        System.out.println(
            minStack.getMin()
        );

        minStack.pop();

        System.out.println(
            minStack.getMin()
        );
    }

    private int[] list;
    private int[] minList;
    private int last;
    private int min;

    /**
     *  The separated 'minList' is created to track the minimum value 'up to that point'.
     *  i.e. minList[5] means we have added 6 elements in the list, the value saved is
     *  the min value within the first 6 elements
     */
    public MinStack() {
        list = new int[10000];
        minList = new int[10000];
        last = -1;
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        last++;
        list[last] = x;
        min = minList[last] = Math.min(min, x);
    }

    public void pop() {
        last--;
        // Correct the min value when the array 'is empty'
        min = last >= 0 ? minList[last] : Integer.MAX_VALUE;
    }

    public int top() {
        return list[last];
    }

    public int getMin() {
        return minList[last];
    }

}
