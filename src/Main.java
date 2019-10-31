import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
class Node{
	public int val;
	HashMap<Integer,Integer> map=new HashMap<>();
}
public class Main {
	static ArrayList<Node> arr;
    public static void main(String[] args) {
    	Scanner in=new Scanner(System.in);
    	arr=new ArrayList<>();
    	int index=1;
    	while(in.hasNextLine()){
    		String tmp=in.nextLine();
    		String[] tmps=tmp.split(" ");
    		Node cur=new Node();
    		cur.val=index++;
    		for(int i=0;i<tmps.length;i++){
    			if(Integer.parseInt(tmps[i])>0){
    			cur.map.put(i+1,Integer.parseInt(tmps[i]));}
    		}
    	}
    	for(int i=2;i<=arr.size();i++){
    		System.out.println(bfs(arr.get(0),i));
    	}
    	
    }
    public static int bfs(Node vn,int vi){
    	if(vn.val==vi){
    		return 0;
    	}
    	if(vn.map.size()==0){
    		return 0;
    	}
    	int min_tmp=Integer.MAX_VALUE;
    	for(Map.Entry<Integer, Integer> en:vn.map.entrySet()){
    		int tmp=bfs(arr.get(en.getKey()),vi);
    		if(tmp<min_tmp){
    			min_tmp=tmp;
    		}
    	}
    	return min_tmp;
    }
}