import java.util.*;
public class Maind{
    public static void main(String args[]){
        Scanner cin=new Scanner(System.in);
        String a=cin.nextLine();
        /* ArrayList<Integer> arr=new ArrayList<Integer>();
           while(cin.hasNextInt()){
        	arr.add(cin.nextInt);
        }
           List<String> strlist = Arrays.asList(s);//数组转集合
           set = new HashSet(Arrays.asList(array));
           set.toArray();//集合转数组
        */
        if(a==null||a.length()==0)
            System.out.println(0);
        int con=0;
        con=a.length()-count(a,0,a.length()-1,con);
        System.out.println(con);
        ArrayList<String> arr=new ArrayList<String>();
        arr.add("a");
        arr.add("b");
        String[] b=arr.toArray(new String[arr.size()]);//list转换成数组
    }
    public static int count(String s,int p1,int p2,int count){
        if(p1==p2)
            return count+1;
        if(p1>p2)
        	return count;
        if(s.charAt(p1)==s.charAt(p2)){
            count=count+2;
            return count(s,p1+1,p2-1,count);
        }
        else{
            int c1=count(s,p1+1,p2,count);
            int c2=count(s,p1,p2-1,count);
            return c1>c2?c1:c2;
        }
    }
}