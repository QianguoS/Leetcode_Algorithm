package niuke;
/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
 * 那么对应的输出是第一个重复的数字2。*/
public class duplicateNum {
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        int index = 0;
        while (index<length){
            if(numbers[index] != index && numbers[numbers[index]] != numbers[index]){
                swap(numbers,index,numbers[index]);
            }else if(numbers[index] != index && numbers[numbers[index]] == numbers[index]){
                duplication[0] = numbers[index];
                System.out.println(duplication[0]);
                return true;
            }else if(numbers[index] == index){
                index++;
            }

        }
        return false;
    }

    private static void swap(int[] numbers, int index, int number) {
        int temp = numbers[index];
        numbers[index] = numbers[number];
        numbers[number] = temp;
    }

    public static void main(String[] args){
        int[] num = new int[]{2,3,1,0,2,5,3};
        int[] dup = new int[1];
        System.out.println(duplicate(num,num.length,dup));

    }
}
