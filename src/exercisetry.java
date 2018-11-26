
class SplitTest{
	
}
public class exercisetry {
	public static void sort(int[] a){//Òª×¢Òâ±ß½ç
		if(a.length<2){
			return;
		}
		for(int i=0;i<a.length;i++){
			heapInsert(a,i);
		}
		for(int i=a.length-1;i>0;i--){
			int temp=a[i];
			a[i]=a[0];
			a[0]=temp;
			heapify(a, i);
		}
	}
	public static void heapInsert(int[] a,int i){
		while((a[i]>a[(i-1)/2])&&(i>0)){
			int temp=a[i];
			a[i]=a[(i-1)/2];
			a[(i-1)/2]=temp;
			i=(i-1)/2;
		}
	}
	public static void heapify(int[] a,int size){
		int left=1;
		int index=0;
		while(left<size){
			int max=0;
			if((left+1)>=size){
				max=left;
			}else{
			max=a[left]>a[left+1]?left:left+1;
			}
			if(a[index]<a[max]){
				int temp=a[index];
				a[index]=a[max];
				a[max]=temp;
				index=max;
				left=index*2+1;
			}else{
				break;
			}
		}
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={3,1,4,2,7,8,6,5};
		sort(a);
		System.out.println(1/1.25);
	}

}
