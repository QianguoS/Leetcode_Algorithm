package mignqi;

import java.math.BigInteger;
import java.util.Scanner;

public class wangyi {
    /**
     * 牛牛去犇犇老师家补课，出门的时候面向北方，但是现在他迷路了。虽然他手里有一张地图，
     * 但是他需要知道自己面向哪个方向，请你帮帮他。
     输入描述:
     每个输入包含一个测试用例。
     每个测试用例的第一行包含一个正整数，表示转方向的次数N(N<=1000)。
     接下来的一行包含一个长度为N的字符串，由L和R组成，L表示向左转，R表示向右转。*/
    public static void getDirection(int num,String dir){
        int count = 0;
        char[] direction = dir.toCharArray();
        for (int i = 0; i < direction.length; i++) {
            if(direction[i] == 'L'){
                count--;
            }else if(direction[i] == 'R'){
                count++;
            }
        }
        int redu = (count%4+4)%4;
        switch (redu){
            case 1:
                System.out.println("E");
                break;
            case 2:
                System.out.println("S");
                break;
            case 3:
                System.out.println("W");
                break;
            case 0:
                System.out.println("N");
                break;
        }

    }
    /**
     * 牛牛以前在老师那里得到了一个正整数数对(x, y), 牛牛忘记他们具体是多少了。

     但是牛牛记得老师告诉过他x和y均不大于n, 并且x除以y的余数大于等于k。
     牛牛希望你能帮他计算一共有多少个可能的数对。*/
    //solution1 暴力解法
    public static void getPair(int n,int k){

        int count = 0;
        for (int i = 1; i <= n; i++) {
            for(int j = 1; j<=n; j++){
                if(i%j>=k){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    //solution2 通过将问题进一步细化，转化为循环节
    public static void getPair2(int n, int k){
        long count = 0;
        //BigInteger count = new BigInteger("0");
        if(k==0) System.out.println(n*n);
        else {
            for (int i = k+1; i <= n; i++) {
                count += (n/i)*(i-k);
                if(n%i>=k){
                    count += n%i-k+1;
                }
            }
        }
        System.out.println(count);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

//        int num = sc.nextInt();
//        String direc = sc.next();
//        getDirection(num,direc);
        int n = sc.nextInt();
        int k = sc.nextInt();
        //getPair(n,k);
        getPair2(n,k);
    }
}
