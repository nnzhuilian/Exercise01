package Algorithm.Matrix;

import java.util.ArrayList;

public class FindContinuousSequence {
	  public ArrayList<ArrayList<Integer>> FindContinuousSequence1(int sum) {//优解，过程见笔记
			ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
			if (sum < 3) {
				return arr;
			}
	        int small=1;
	       int big=2;
	       while(small<=sum/2){
	           int temp=(small+big)*(big-small+1)/2;
	           if(temp<sum){
	               big++;
	           }
	           if(temp>sum){
	               small++;
	           }
	           if(temp==sum){
	               ArrayList<Integer> ad=new ArrayList<Integer>();
	               for(int i=small;i<=big;i++){
	                   ad.add(i);
	               }
	               small++;
	               big++;
	               arr.add(ad);
	           }
	       }
	       return arr;
		}
	//////////////////////////----------------先算首尾项和，再算首尾项-----------////////////////
	public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		if (sum < 3) {
			return arr;
		}
		for (int i = 2; i <= (int) Math.sqrt(sum * 2); i++) {// 找到项数i
			double bl = (double)sum * 2 / i;// 项数对应的首尾项和
			if (bl % 1 == 0) {
				ArrayList<Integer> f = find((int) bl, i);
				if(f!=null){
				ArrayList<Integer> ad = new ArrayList<Integer>();
				for (int j = f.get(0); j <= f.get(1); j++) {
					ad.add(j);
				}
				arr.add(ad);
				}

			}
		}
		return arr;
	}

	public static ArrayList<Integer> find(int blsum, int num) {
		int[] k = new int[blsum - 1];
		for (int i = 0; i < blsum - 1; i++) {
			k[i] = i + 1;
		}
		int first = 0;
		int last = blsum - 2;
		while (first < last) {
			int temp = k[first] + k[last];
			if ((last - first + 1) == num) {
				ArrayList<Integer> arr = new ArrayList<Integer>();
				arr.add(k[first]);
				arr.add(k[last]);
				return arr;
			}else{
				last--;
				first++;
			}
		}
		return null;
	}
//////////////--------------////////////////////////////////////////////////////////
	public static void main(String[] args) {
		FindContinuousSequence(15);
	}
}
