public class sortList_array {
    public static void main(String[] args) {
        int[] a=new int[]{5,4,3,2,1};
        sort(a);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
    public static void sort(int[] a){
        for(int i=0;i<a.length;i++){
            heapinsert(a,i);
        }
        for(int i=a.length-1;i>0;i--){
            swap(a,0,i);
            heapfy(a,i);
        }
    }
    public static void heapinsert(int[] a,int i){
        int father=(i-1)/2;
        while(father>0){
            if(a[i]>a[father]){
                swap(a,i,father);
                i=father;
                father=(i-1)/2;
            }
            
            else{
            	break;
            }
        }
    }
    public static void heapfy(int[] a,int i){
        int father=0;
        int leftchild=father*2+1;
        int rightchild=leftchild+1;
        int max_index=0;
        while(leftchild<i){
            if(rightchild<i){
                max_index=a[leftchild]>=a[rightchild]?leftchild:rightchild;
            }else{
                max_index=leftchild;
            }
            if(a[father]<a[max_index]){
                swap(a,father,max_index);
                father=max_index;
            }else{
            	break;
            }
            leftchild=father*2+1;
            rightchild=leftchild+1;
        }
        
        
    }
    public static void swap(int[] a,int i,int j){
        int tmp=a[i];
        a[i]=a[j];
        a[j]=tmp;
    }
}