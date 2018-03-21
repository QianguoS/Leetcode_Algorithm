import java.util.Random;

public class from_chao_shen {
    public static int MoreThanHalfNum_Solution(int [] array) {
        int lo = 0, hi = array.length-1;
        while (true) {
            int[] pivots = partitionInThreeWay(array, lo, hi);
            System.out.println(array[pivots[0]] + "," + pivots[0]);
            if (pivots[1] - pivots[0] + 1 > array.length / 2) return array[pivots[0]];
            else if (hi - pivots[1] + 1 > array.length / 2) lo = pivots[1] + 1;
            else if (pivots[0] - lo + 1 > array.length / 2) hi = pivots[0] - 1;
            else return 0;
        }
    }

    private static int[] partitionInThreeWay(int[] array, int lo, int hi) {
        int pivotIndex = lo + new Random().nextInt(hi - lo + 1);
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, hi);
        int lt = lo, gt = hi-1;
        for (int i = lo; i <= gt; ) {
            if (array[i] < pivot) swap(array, lt++, i++);
            else if (array[i] == pivot) i++;
            else swap(array, i, gt--);
        }
        swap(array, hi, ++gt);
        return new int[] {lt, gt}; //返回等于区的头和尾
    }

    private static void swap(int[] array, int i, int j) {
        if (i == j) return;
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,2,2,2,5,4,2};
//        System.out.println(Arrays.toString(partitionInThreeWay(array, 0, array.length-1)));
        System.out.println(MoreThanHalfNum_Solution(array));
    }


}
