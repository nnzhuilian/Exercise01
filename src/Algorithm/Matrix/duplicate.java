package Algorithm.Matrix;

public class duplicate {
	/*在一个长度为n的数组里的所有数字都在0到n-1的范围内。 
	 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
	 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 
	 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。*/
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
	
    
	public boolean duplicate1(int numbers[],int length,int [] duplication) {//基于额外数组的
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
	/*最简单的就是用一个数组或者哈希表来存储已经遍历过的数字，但是这样需要开辟额外的空间。
	如果题目要求不能开辟额外的空间，那我们可以用如下的方法：
	因为数组中的数字都在0~n-1的范围内，所以，如果数组中没有重复的数，
	那当数组排序后，数字i将出现在下标为i的位置。现在我们重排这个数组，
	从头到尾扫描每个数字，当扫描到下标为i的数字时，首先比较这个数字(记为m)是不是等于i。
	如果是，则接着扫描下一个数字；如果不是，则再拿它和m 位置上的数字进行比较，
	如果它们相等，就找到了一个重复的数字（该数字在下标为i和m的位置都出现了），返回true；
	如果它和m位置上的数字不相等，就把第i个数字和第m个数字交换，把m放到属于它的位置。
	接下来再继续循环，直到最后还没找到认为没找到重复元素，返回false。*/
    public static boolean duplicate2(int numbers[],int length,int [] duplication) {
        if(numbers==null||numbers.length==0||numbers.length!=length){
            return false;
        }
        for(int i=0;i<numbers.length;i++){
            while(i != numbers[i]){//number[i]一直在变的，虽然i不变，就是把和下标相等的数放入下标处
            	//一定能出这个循环，如果没有重复值，则一定能找到下表对应值，若有，则能return。
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
