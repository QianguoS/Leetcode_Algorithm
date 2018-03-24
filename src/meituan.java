import java.util.Scanner;

public class meituan {


    public static int calculator_distance(String a,String b){
        int lenA = a.length();
        int lenB = b.length();
        int sl;
        int tl;
        if(lenA>=lenB){
            sl=lenA;
            tl=lenB;
        }else{
            sl = lenB;
            tl=lenA;
            String temp = a;
            a = b;
            b = temp;
        }
        int count=0;
        for(int i=0;i<sl-tl+1;i++){
            char[] temp = a.substring(i,i+tl).toCharArray();
            for(int j=0;j<tl;j++){
                if(temp[i]!=b.charAt(i)){
                    count++;
                }
            }

        }

        System.out.println("a,b"+a+" "+b+" ");
        return count;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        int result =calculator_distance(a,b);
        System.out.println(result);
//        Scanner scanner = new Scanner(System.in
//
//        );
//        String str = scanner.next();
//        System.out.println(solution(str));
    }

    public static String solution(String str) {
        char[] count = new char[10];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - '0']++;
        }
        int minCount = 1000, minIndex = -1;
        for (int i = 1; i <= 9; i++) {
            if (count[i] < minCount) {
                minCount = count[i];
                minIndex = i;
            }
        }
        StringBuilder res = new StringBuilder();
        if (minCount > count[0]) {
            res.append("1");
            for (int i = 1; i <= count[0] + 1; i++) {
                res.append("0");
            }
            return res.toString();
        }
        for (int i = 1; i <= minCount + 1; i++) {
            res.append(minIndex);
        }
        return res.toString();
    }
}
