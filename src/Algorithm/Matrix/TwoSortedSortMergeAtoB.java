package Algorithm.Matrix;

public class TwoSortedSortMergeAtoB {
	public int[] merge(int[] a,int[] b){
		if(b==null){
			return a;
		}
		if(a==null){
			return b;
		}
		if((a==null)&&(b==null)){
			return null;
		}
		int p1=0;
		int p2=0;
		int p3=0;
		int len=a.length+b.length;
		int dir[]=new int[len];
		while(p3<len){
			if(p1>=a.length){
				dir[p3++]=b[p2++];
			}
			else if(p2>=b.length){
				dir[p3++]=a[p1++];
			}else{
				dir[p3++]=a[p1]>b[p2]?b[p2++]:a[p1++];
			}
			
		}
		return dir;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={};//{1,3,6,7,8,10,13,18};
		int[] b={};//{2,3,5,6,9,10,11};
		TwoSortedSortMergeAtoB m=new TwoSortedSortMergeAtoB();
		int dir[]=m.merge(a, b);
		System.out.println(dir);
		for(int i=0;i<dir.length;i++){
			System.out.print(dir[i]+" ");
		}
	}

}
