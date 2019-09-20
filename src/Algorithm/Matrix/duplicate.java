package Algorithm.Matrix;

public class duplicate {
	/*��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ� 
	 * ������ĳЩ�������ظ��ģ�����֪���м����������ظ��ġ�
	 * Ҳ��֪��ÿ�������ظ����Ρ����ҳ�����������һ���ظ������֡� 
	 * ���磬������볤��Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ������ǵ�һ���ظ�������2��*/
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    ����Ҫ�ر�ע��~���������ظ���һ������ֵduplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
	
    
	public boolean duplicate1(int numbers[],int length,int [] duplication) {//���ڶ��������
        if(numbers==null||numbers.length==0||numbers.length!=length){
            return false;
        }
        int[] count=new int[numbers.length];
        for(int i=0;i<numbers.length;i++){
            int index=numbers[i];
            if(count[index]>0){
                duplication[0]=index;
                return true;
            }else{
                count[index]++;
            }
        }
        return false;
    }
	/*��򵥵ľ�����һ��������߹�ϣ�����洢�Ѿ������������֣�����������Ҫ���ٶ���Ŀռ䡣
	�����ĿҪ���ܿ��ٶ���Ŀռ䣬�����ǿ��������µķ�����
	��Ϊ�����е����ֶ���0~n-1�ķ�Χ�ڣ����ԣ����������û���ظ�������
	�ǵ��������������i���������±�Ϊi��λ�á�������������������飬
	��ͷ��βɨ��ÿ�����֣���ɨ�赽�±�Ϊi������ʱ�����ȱȽ��������(��Ϊm)�ǲ��ǵ���i��
	����ǣ������ɨ����һ�����֣�������ǣ�����������m λ���ϵ����ֽ��бȽϣ�
	���������ȣ����ҵ���һ���ظ������֣����������±�Ϊi��m��λ�ö������ˣ�������true��
	�������mλ���ϵ����ֲ���ȣ��Ͱѵ�i�����ֺ͵�m�����ֽ�������m�ŵ���������λ�á�
	�������ټ���ѭ����ֱ�����û�ҵ���Ϊû�ҵ��ظ�Ԫ�أ�����false��*/
    public static boolean duplicate2(int numbers[],int length,int [] duplication) {
        if(numbers==null||numbers.length==0||numbers.length!=length){
            return false;
        }
        for(int i=0;i<numbers.length;i++){
            while(i != numbers[i]){//number[i]һֱ�ڱ�ģ���Ȼi���䣬���ǰѺ��±���ȵ��������±괦
            	//һ���ܳ����ѭ�������û���ظ�ֵ����һ�����ҵ��±��Ӧֵ�����У�����return��
                if(numbers[i] == numbers[numbers[i]]){
                    duplication[0] = numbers[i];
                    return true;
                }else{
                    swap(numbers,i,numbers[i]);
                }
            }
        }
        return false;
    }
    public static void swap(int[] num,int a,int b){
        int temp=num[a];
        num[a]=num[b];
        num[b]=temp;
    }
    
    public static void main(String[] args) {
		int[] numbers={3,4,2,1,3};
		int length=numbers.length;
		int[] duplication=new int[1];
    	duplicate2(numbers, length, duplication);
	}
}
