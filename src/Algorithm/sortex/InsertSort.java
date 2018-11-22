package Algorithm.sortex;

public class InsertSort {//≤Â»Î≈≈–Ú
	public static void sort(int[] a){
		for(int i=1;i<a.length;i++){
			for(int j=i;j>0;j--){
				if(a[j]<a[j-1]){
					int temp=a[j];
					a[j]=a[j-1];
					a[j-1]=temp;
				}else{
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={3,1,4,2,7,8,6,5};
		sort(a);
	}

}
