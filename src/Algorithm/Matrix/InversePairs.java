package Algorithm.Matrix;
/*�������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�����һ������,�����������е�����Ե�����P������P��1000000007ȡģ�Ľ������� �����P%1000000007
��������:
��Ŀ��֤�����������û�е���ͬ������

���ݷ�Χ��

	����%50������,size<=10^4

	����%75������,size<=10^5

	����%100������,size<=2*10^5*/
public class InversePairs {
    public int InversePairs1(int [] array) {//ע�����ֵ�����߽����⣬Ҫ�Կ��ܳ����߽����ֵȡģ
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
