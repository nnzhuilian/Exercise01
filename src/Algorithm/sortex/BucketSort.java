package Algorithm.sortex;

public class BucketSort {
	public static void sort(int a[]){
		int[] bucket=new int[10];
		for(int i=0;i<a.length;i++){
			bucket[a[i]%10]++;
		}
		int k=0;
		for(int i=0;i<bucket.length;i++){
			for(int j=0;j<bucket[i];j++){
				a[k++]=i;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={3,1,4,2,1,8,6,3};
		sort(a);
	}

}
