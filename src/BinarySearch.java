public class BinarySearch {
    //=======================二分查找==============================//
    /**
     * 给定一个有序数组，如{1,2,3,4,5,6,7,8,9}，我们将对这个数组进行选择，
     * 未知从什么位置旋转。下面给出一个可能的旋转结果。
     * 如{4,5,6,7,8,9,1,2,3}，我们可以理解为它从元素4位置开始旋转。
     * 之后给定一个指定的数字n，让我们从{4,5,6,7,8,9,1,2,3}
     * 这个数组中找出它的位置，
     * 要求时间复杂度尽可能的低。*/
    //solution1
    public static void binary_search(int[] nums, int target){

        int L=0;
        int R = nums.length-1;
        int mid;
        int minValue_index=-1;
        while(L<R){
            mid = (L+R)/2;
            if(R-L==1){
                minValue_index = R;
                break;
            }
            if(nums[L]<nums[mid]){
                L = mid;
            }else{
                R = mid;
            }
        }
        System.out.println(minValue_index);
        if(nums[minValue_index]>target || nums[nums.length-1]<target){
            System.out.println("not in this index");
        }
        if(nums[minValue_index]<=target && nums[nums.length-1]>=target){
            L = minValue_index;
            R = nums.length-1;

        }else {
            L = minValue_index;
            R = nums.length - 1;
        }
        while (L <= R) {
            mid = (L + R) / 2;
            if (nums[mid] == target) {
                System.out.println("find the target index:" + mid);
                break;
            }
            if (nums[mid] < target) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }

        }
    }
    //solution2
//    public static void binary_search2(int[] nums, int target){
//        int L = 0;
//        int R = nums.length-1;
//        int mid;
//        while(L<=R){
//            mid = (R-L)/2;
//            if(nums[mid] == target){
//                System.out.println("find the index"+mid);
//                break;
//            }
//
//            if(nums[L]<nums[mid]){
//                if((target>=nums[L]) && (target<=nums[mid])){
//                    R = mid-1;
//                }else{
//                    L = mid+1;
//                }
//            }else{
//                if((target>=nums[mid]) && (target<=nums[R])){
//                    L = mid+1;
//                }else{
//                    R = mid-1;
//                }
//            }
//        }
//    }
    public static void main(String[] args){
        int[] nums = new int[7];
        nums[0] = 8;
        nums[1] = 9;
        nums[2] = 10;
        nums[3] = 1;
        nums[4] = 3;
        nums[5] = 4;
        nums[6] = 5;
        binary_search(nums,3);

    }
}
