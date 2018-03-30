package niuke;
/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，
 * 写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，
 * 但却读不懂它的意思。例如，“student. a am I”。后来才意识到，
 * 这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？*/
public class reverseString {
    public static String getReseverString(String str){
        if(str==""){
            return null;
        }
        String result = "";
        char[] array = str.toCharArray();
        int start = 0;
        int end = array.length-1;
        rever(array,start,end);
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i]);
//        }
        start = 0;
        end = 0;
        while(start<array.length && end<array.length){
            if(array[end] == ' '){
                rever(array,start,end-1);

                start = end+1;
                end++;

            }else if(end==array.length-1){
                rever(array,start,end);
                break;
                //start = end+1;
                //end++;
            } else{
                end++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            result += array[i];
            //System.out.print(array[i]);
        }
        return result;
    }

    private static void rever(char[] array, int start, int end) {
        while(start < end){
            swap(array, start, end);
            start++;
            end--;
        }
    }

    private static void swap(char[] array, int start, int end) {
        char temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }

    public static void main(String[] args){
        getReseverString("I am a student.");
    }
}
