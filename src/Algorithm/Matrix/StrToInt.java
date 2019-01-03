package Algorithm.Matrix;

public class StrToInt {
	public static int StrToInt1(String str) {
		if (str.equals("") || str == null) {// 空字符串
			return 0;
		}
		int flag = 1;
		if (str.charAt(0) == '+' || str.charAt(0) == '-') {// 若首位为符号，去符号,并设flag
			if (str.charAt(0) == '+') {
				flag = 1;
			}
			if (str.charAt(0) == '-') {
				flag = -1;
			}
			str = str.substring(1);
		}
		if (str.equals("") || str.length() > 10) {// 溢出初判断
			return 0;
		}
		if (str.length() == 10) {// 再溢出判断，长度为10，首位大于2必然溢出
			if (str.charAt(0) > '2') {
				return 0;
			}
		}
		for (int i = 0; i < str.length(); i++) {// 判断非法字符
			char temp = str.charAt(i);
			if (!(temp >= '0' && temp <= '9')) {
				return 0;
			}
		}
		int MAX_low = Integer.MAX_VALUE - 2000000000;
		int sum = 0;
		int j = 1;
		for (int i = str.length() - 1; i >= 0; i--) {
			if (j == 1000000000) {
				if (str.charAt(i) > '2') {
					return 0;
				} else if (str.charAt(i) == '2') {
					if (flag == 1) {
						if (sum > MAX_low) {
							return 0;
						}
					}
					if (flag == -1) {
						if (sum > MAX_low + 1) {
							return 0;
						}
					}
				}
			}
			sum += (str.charAt(i) - '0') * j;
			j *= 10;
		}
		return sum * flag;
	}
}
