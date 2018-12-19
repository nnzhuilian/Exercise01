package Algorithm.Matrix;

public class FirstNotRepeatingChar {

	public int FirstNotRepeatingChar2(String str) {//代码简洁，可以直接通过遍历数组来找，这种方法适合字符串长度小的时候？O(n)+O(n)
		int len = str.length();
		if (len == 0)
			return -1;
		char[] s = str.toCharArray();
		int[] m = new int[256];//Ascii码有256个
		for (int i = 0; i < len; i++) {
			m[s[i]]++;
		}
		for (int i = 0; i < len; i++) {
			if (m[s[i]] == 1)
				return i;
		}
		return -1;
	}

	public int FirstNotRepeatingChar1(String str) {//O(n)+O(256)
		if (str.length() == 0) {
			return -1;
		}
		int[][] chara = new int[52][2];
		for (int i = 0; i < str.length(); i++) {
			int cha = str.charAt(i);
			int index = 0;
			if (cha <= 'Z' && cha >= 'A') {
				index = (int) (cha - 'A') % 52;
			} else if (cha <= 'z' && cha >= 'a') {
				index = ((int) (cha - 'a') + 26) % 52;
			} else {
				return -1;
			}
			if (chara[index][1] == 0) {
				chara[index][0] = i;
			}
			chara[index][1]++;
		}
		int first = 52;
		for (int i = 0; i < 52; i++) {
			if (chara[i][1] == 1 && chara[i][0] < first) {
				first = chara[i][0];
			}
		}
		if (first == 52) {
			return -1;
		}
		return first;
	}
}
