package leetcode;


/**
 * https://leetcode.com/problems/moving-average-from-data-stream/
 */
public class MovingAverage {

    private int count = 0;
    private int size = 0;
    private int[] array;
    private int sum = 0;

    public MovingAverage(int size) {
        this.size = size;
        this.array = new int[size];
    }

    public double next(int val) {
        // retrieve the first item within the window for removal later
        int de = (count == 0) ? 0 : array[count%size];
        array[(++count-1)%size] = val;
        sum = count > size ? sum - de + val : sum + val;
        return sum * 1.0 / (count<size?count:size);
    }

    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
        System.out.println(m.next(1));
        System.out.println(m.next(10));
        System.out.println(m.next(3));
        System.out.println(m.next(5));
//        System.out.println(m.next(0));
    }

}
