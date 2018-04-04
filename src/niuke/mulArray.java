package niuke;
/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。*/
public class mulArray {
    public int[] multiply(int[] A) {
        if(A.length == 0)return null;
        int[] b = new int[A.length];
        b[0] = 1;
        for (int i = 1; i < A.length; i++) {
            b[i] = b[i-1] * A[i-1];
        }
        int temp = 1;
        for (int i = A.length-2; i >= 0; i--) {
            temp *= A[i+1];
            b[i] = b[i] *temp;
        }
        return b;

    }
    public static void main(String[] args){

    }
}
