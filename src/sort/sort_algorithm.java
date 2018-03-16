package sort;
/**
 * 本文主要介绍了常用的几大排序算法*/


public class sort_algorithm {
    //public static int[] nums = new int[]{5,2,6,3,7,8,9,1};
    //public static int[] nums = new int[]{122,87,78,45,17,65,53,9,32};

    //冒泡排序算法
    public static void maopao_sort(int[] a){
        int n = a.length;
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<i;j++){
                if(a[j]>a[j+1]){
                    swap(a,j,j+1);
                }
            }
        }
        for(int i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }
    }

    //插入排序算法
    public static void insert_sort(int[] a){
        int n = a.length;
        int i;
        int j;
        for(i=1;i<n;i++){
            int temp = a[i];
            for(j=i-1;j>=0;j--){
                if(a[j]>temp){
                    a[j+1] = a[j];
                }else{
                    break;
                }
            }
            a[++j] = temp;
        }
        for(int st=0;st<n;st++){
            System.out.print(a[st]+" ");
        }
    }
    //选择排序算法
    public static void select_sort(int[] a){
        int n = a.length;
        for(int i=0;i<n-1;i++){
            int index = i;
            for(int j=i+1;j<n;j++){
                if(a[j]<a[index]){
                    index = j;
                }
            }
            if(index!=i){
                swap(a,i,index);
            }
        }
        for(int st=0;st<n;st++){
            System.out.print(a[st]+" ");
        }
    }
    //快速排序
    public static void quick_sort(int[] a){
        for(int st=0;st<a.length;st++){
            System.out.print(a[st]+" ");
        }
        System.out.println();
        recquick_sort(a,0,a.length-1);
        for(int st=0;st<a.length;st++){
            System.out.print(a[st]+" ");
        }
    }
    public static void recquick_sort(int[] a,int left,int right){
        if(left>=right){
            return;
        }else{
            int partion = getPartions(a,left,right);
            recquick_sort(a,left,partion-1);
            recquick_sort(a,partion+1,right);
        }
    }

    private static int getPartions(int[] a,int left, int right) {
        int leftPtr = left;
        int rightPtr = right-1;
        while(true){
            while(leftPtr<right && a[leftPtr]<a[right]) leftPtr++;
            while(rightPtr>=0 && a[rightPtr]>=a[right])rightPtr--;
            if(leftPtr<rightPtr){
                swap(a,leftPtr,rightPtr);
            }else{
                break;
            }
        }
        swap(a,leftPtr,right);
        return leftPtr;


    }
    //希尔排序
    public static void shell_sort(int[] a){
        int n = a.length;
        int h=1;
        int out,inner;
        while(h<=(n/3)){
            h = h*3+1;
        }
        while(h>0){
            for(out=h;out<n;out++){
                int temp = a[out];
                inner = out;
                while (inner>h-1 && a[inner-h] > temp){
                    a[inner] = a[inner-h];
                    inner -= h;
                }
                a[inner] = temp;
            }
            h = (h-1)/3;
        }
        for(int st=0;st<a.length;st++){
            System.out.print(a[st]+" ");
        }

    }

    //堆排序具体代码详细

    public static void heap_sort(int[] a){
        if(a.length == 0) return;
        int length = a.length;
        buildHeap(a);
        for(int i=length-1;i>0;i--){
            swap(a,i,0);
            sink(a,0,i);
        }
        for(int st=0;st<a.length;st++){
            System.out.print(a[st]+" ");
        }
    }

    private static void buildHeap(int[] a) {
        for(int i = a.length/2-1;i>=0;i--){
            sink(a,i,a.length);
        }
    }
    //归并排序
    public static void mer_sort(int[] a){
        sort(a,0,a.length-1);
        for(int st=0;st<a.length;st++){
            System.out.print(a[st]+" ");
        }
    }

    private static void sort(int[] a, int left, int right) {
        if(left<right){
            int mid = left+((right-left)>>1);
            sort(a,left,mid);
            sort(a,mid+1,right);
            meger(a,left,mid,right);
        }
    }

    private static void meger(int[] a, int left, int mid, int right) {
        int[] tempArr = new int[a.length];
        int start = left;
        int tmp = 0;
        int R = mid+1;
        while(left<=mid && R<=right){
            if(a[left]<a[R]){
                tempArr[tmp++] = a[left++];

            }else{
                tempArr[tmp++] = a[R++];
            }
        }
        while(left<=mid){
            tempArr[tmp++] = a[left++];
        }
        while(R<=right){
            tempArr[tmp++] = a[R++];
        }
        tmp = 0;
        while(start<=right){
            a[start++] = tempArr[tmp++];
        }

    }

    private static void sink(int[] a, int i, int length) {
        while(i<length){
            int child = getLeftChild(i);
            if(child>=length) break;
            if(child+1<length && a[child]<a[child+1]){
                child++;
            }
            if(a[child]>a[i]){
                swap(a,child,i);
                i = child;
            }else{
                break;
            }
        }
    }

    private static void swap(int[] a, int child, int i) {
        int temp = a[child];
        a[child] = a[i];
        a[i] = temp;
    }

    private static int getLeftChild(int i) {
        return 2*i+1;
    }



    public static void main(String[] args){
        int[] a = new int[]{2,6,1,9,3,5,4};
        //maopao_sort(a);
        //insert_sort(a);
        //select_sort(a);
        //quick_sort(a);
        //shell_sort(a);//{5,2,6,3,7,8,9,1}
        //heap_sort(a);
        mer_sort(a);

    }
}
