import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
public class Solution {
    public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> arr=new ArrayList<Integer>();
        if(array==null)
            return arr;
        int p1=0;
        int p2=array.length-1;
        int chen=Integer.MAX_VALUE;
        int[] p=new int[2];
        while(p1<p2){
            if((array[p1]+array[p2])<sum)
                p1++;
            else if((array[p1]+array[p2])>sum)
                p2--;
            else{
                if(array[p1]*array[p2]<chen){
                   p[0]=p1;
                   p[1]=p2;
                }
                p1++;
                p2--;
            }
        }
        arr.add(p[0]);
        arr.add(p[1]);
        return arr;
    }
    public static void main(String[] args) {
		int[] array=new int[]{1,2,4,7,11,16};
		FindNumbersWithSum(array,10);
	}
}