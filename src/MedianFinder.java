import java.math.BigDecimal;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    Queue<Integer> small;
    Queue<Integer> large;

    public MedianFinder() {
        this.small = new PriorityQueue<>(Comparator.reverseOrder());
        this.large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        //simply add
        small.add(num);

        //Small has a bigger element
        if (!small.isEmpty() && !large.isEmpty() && small.peek() > large.peek()) {
            int val = small.poll();
            large.add(val);
        }

        //size uneven
        if (small.size() > large.size() + 1) {
            int val = small.poll();
            large.add(val);
        }

        if (large.size() > small.size() + 1) {
            int val = large.poll();
            small.add(val);
        }
    }

    public double findMedian() {
        if (small.size() > large.size()) {
            return small.peek();
        } else if (large.size() > small.size()) {
            return large.peek();
        } else {
            return (small.peek() + large.peek())/2.0;
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        queue.add(4);
        queue.add(3);
        queue.add(5);
        queue.add(1);
        System.out.println(queue);
        System.out.println(queue.peek());



        MedianFinder medianFinder = new MedianFinder();

        medianFinder.addNum(3);
        System.out.println(medianFinder);
        medianFinder.addNum(2);
        System.out.println(medianFinder);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(7);
        System.out.println(medianFinder);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(4);
        System.out.println(medianFinder);
        System.out.println(medianFinder.findMedian());

        medianFinder.addNum(1);
        System.out.println(medianFinder);
        medianFinder.addNum(2);
        System.out.println(medianFinder);
        System.out.println(medianFinder.findMedian());
        System.out.println(medianFinder);
        medianFinder.addNum(3);
        System.out.println(medianFinder);
        System.out.println(medianFinder.findMedian());

    }

    @Override
    public String toString() {
        return "MedianFinder{" +
                "small=" + small +
                ", large=" + large +
                '}';
    }
}
