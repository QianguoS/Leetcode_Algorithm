package niuke;

import java.util.Comparator;
import java.util.PriorityQueue;

public class medianNum {
    int count = 0;
    PriorityQueue<Integer> maxQuene = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    PriorityQueue<Integer> minQuene = new PriorityQueue<>();

    public void Insert(Integer num) {
        count++;
        if((count & 0x01) ==0){
            if(!maxQuene.isEmpty() && num < maxQuene.peek()){
                maxQuene.offer(num);
                num = maxQuene.poll();
            }
            minQuene.offer(num);
        }else{
            if(!minQuene.isEmpty() && num > minQuene.peek()){
                minQuene.offer(num);
                num = minQuene.poll();
            }
            maxQuene.offer(num);
        }
    }

    public Double GetMedian() {
        double result = 0;
        if((count & 0x01) != 0){
            result = maxQuene.peek();
        }else{
            result = (maxQuene.peek() + minQuene.peek())/2.0;
        }
        return result;
    }
}
