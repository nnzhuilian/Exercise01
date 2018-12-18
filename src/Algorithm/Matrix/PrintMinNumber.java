package Algorithm.Matrix;

import java.util.*;

public class PrintMinNumber {
	/*
	 * �Ż��㷨�� �Ƚ�����ת�����ַ������飬Ȼ����ַ������鰴�չ�����������ź�����ַ�������ƴ�ӳ����� �ؼ������ƶ��������
	 * 
	 * ��ab > ba �� a > b 
	 * ��ab < ba �� a < b 
	 * ��ab = ba �� a = b 
	 * ����˵���� a = 21 b = 2 
	 * ��Ϊ212 < 221, �� ab < ba ������ a < b 
	 * ��������ͨ����ab��ba�Ƚϴ�С�����ж�a��ǰ����b��ǰ�ġ�
	 */

	public String PrintMinNumber2(int[] numbers) {//�Ż��㷨
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

	public String PrintMinNumber1(int[] numbers) {// �ҵĻ������ȶ��еķ��������ȶ��У�������ͷ�ǰ�ָ���������СԪ�أ�
		// һ�󴮱Ƚ��ַ�����С�ĵĴ������ַ����Դ���compareTo�����Ϳ��Խ�������ڳ��Ȳ�ͬ�Ĵ���ʱ������Ҫ����
		// ��һ����Ҫ��Щ���У�Arrays.sort���С�
		if (numbers.length == 0) {
			return "";
		}
		int pw = 1;
		PriorityQueue<String> pro = new PriorityQueue<String>(numbers.length, new Comparator<String>() {
			public int compare(String s1, String s2) {
				int length = s1.length() < s2.length() ? s1.length() : s2.length();
				for (int i = 0; i < length; i++) {
					if (s1.charAt(i) < s2.charAt(i)) {
						return -1;// s1��s2С�����ظ���s1����ǰ�棬��������s1���ں���
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
