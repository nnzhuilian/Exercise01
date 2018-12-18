package Algorithm.Matrix;

import java.util.*;

public class PrintMinNumber {
	/*
	 * 优化算法： 先将数组转换成字符串数组，然后对字符串数组按照规则排序，最后将排好序的字符串数组拼接出来。 关键就是制定排序规则：
	 * 
	 * 若ab > ba 则 a > b 
	 * 若ab < ba 则 a < b 
	 * 若ab = ba 则 a = b 
	 * 解释说明： a = 21 b = 2 
	 * 因为212 < 221, 即 ab < ba ，所以 a < b 
	 * 所以我们通过对ab和ba比较大小，来判断a在前或者b在前的。
	 */

	public String PrintMinNumber2(int[] numbers) {//优化算法
		int len = numbers.length;
		if (len == 0)
			return "";
		if (len == 1)
			return String.valueOf(numbers[0]);
		StringBuffer res = new StringBuffer();
		String[] str = new String[len];
		for (int i = 0; i < len; i++)
			str[i] = String.valueOf(numbers[i]);
		Arrays.sort(str, new Comparator<String>() {
			public int compare(String s1, String s2) {
				String c1 = s1 + s2;
				String c2 = s2 + s1;
				return c1.compareTo(c2);
			}
		});
		for (int i = 0; i < len; i++)
			res.append(str[i]);
		return res.toString();
	}

	public String PrintMinNumber1(int[] numbers) {// 我的基于优先队列的方法，优先队列，堆排序，头是按指定排序的最小元素，
		// 一大串比较字符串大小的的代码用字符串自带的compareTo函数就可以解决，但在长度不同的处理时还是需要处理
		// 不一定需要有些队列，Arrays.sort就行。
		if (numbers.length == 0) {
			return "";
		}
		int pw = 1;
		PriorityQueue<String> pro = new PriorityQueue<String>(numbers.length, new Comparator<String>() {
			public int compare(String s1, String s2) {
				int length = s1.length() < s2.length() ? s1.length() : s2.length();
				for (int i = 0; i < length; i++) {
					if (s1.charAt(i) < s2.charAt(i)) {
						return -1;// s1比s2小，返回负数s1排在前面，返回正数s1排在后面
					} else if (s1.charAt(i) > s2.charAt(i)) {
						return 1;
					}
				}
				if (s1.length() == s2.length()) {
					return 0;
				} else if (s1.length() < s2.length()) {
					if (s2.charAt(s2.length() - 1) > s1.charAt(0)) {
						return -1;
					} else {
						return 1;
					}
				} else {
					if (s1.charAt(s1.length() - 1) > s2.charAt(0)) {
						return 1;
					} else {
						return -1;
					}
				}
			}
		});
		for (int i = 0; i < numbers.length; i++) {
			pro.offer(String.valueOf(numbers[i]));
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < numbers.length; i++) {
			sb.append(pro.poll());
		}
		String r = sb.toString();
		return r;
	}

}
