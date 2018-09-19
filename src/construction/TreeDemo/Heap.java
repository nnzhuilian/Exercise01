package construction.TreeDemo;

public class Heap {
	public int current=0;
	public int maxsize;
	public int a[];
	public Heap(int maxsize){
		this.maxsize=maxsize;
		a=new int[maxsize];
	}
	public void Insert(int value){
		if(current==maxsize){
			System.out.println("ÒÑÂú");
			return;
		}
		if(current==0){
			a[current++]=value;
		}
		else{
			a[current]=value;
			HeapInsert(current++);
		}
	}
	public void remove(){
		a[0]=a[--current];
		Heapify(0);
	}
	public void HeapInsert(int index) {
		while ((a[index] > a[(index - 1) / 2])) {
			swap(index, (index - 1) / 2);
			index = (index - 1) / 2;
		}
	}
	public void Heapify(int index){
		int left=index*2+1;
		while(left<current-1){
			int temp=((a[left]>a[left+1])||(left+1==current-1))?left:left+1;
			if(a[temp]<=a[index])break;
			swap(index,temp);
			index=temp;
			left=index*2+1;
		}
	}
	public void swap(int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	public void print(){
		for(int i=0;i<current;i++){
			System.out.println(a[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Heap a=new Heap(6);
		a.Insert(10);
		a.Insert(70);
		a.Insert(50);		
		a.Insert(20);
		a.Insert(60);
		a.Insert(100);
		a.Insert(80);
		a.remove();
  		a.remove();
		a.print();
	}

}
