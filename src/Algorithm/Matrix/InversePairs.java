package Algorithm.Matrix;
/*在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
输入描述:
题目保证输入的数组中没有的相同的数字

数据范围：

	对于%50的数据,size<=10^4

	对于%75的数据,size<=10^5

	对于%100的数据,size<=2*10^5*/
public class InversePairs {
    public int InversePairs1(int [] array) {//注意大数值超出边界问题，要对可能超出边界的数值取模
        if(array.length==0){
            return 0;
        }
        return InversePairs1(array,0,array.length-1)%1000000007;
    }
    public int InversePairs1(int[] array,int first,int last){
        if(first>=last){
            return 0;
        }
        int mid=(first+last)/2;
        int count1=InversePairs1(array,first,mid)%1000000007;
        int count2=InversePairs1(array,mid+1,last)%1000000007;
        return merge(array,first,last,mid)+count1+count2;
    }
    public int merge(int[] array,int first,int last,int mid){
        int[] help=new int[last-first+1];
        int p1=first;
        int p2=mid+1;
        int count=0;
        for(int i=0;i<help.length;i++){
            if(p2>last){
                help[i]=array[p1++];
                continue;
            }
            if(p1>mid){
                help[i]=array[p2++];
                continue;
            }
            if(array[p1]>array[p2]){
                count+=mid-p1+1;
                if(count>1000000007){
                    count=count%1000000007;
                }
                help[i]=array[p2];
                p2++;
            }else if(array[p1]<=array[p2]){
                help[i]=array[p1];
                p1++;
            }
        }
        for(int i=0;i<help.length;i++){
            array[first++]=help[i];
        }
        return count;
    }
}
