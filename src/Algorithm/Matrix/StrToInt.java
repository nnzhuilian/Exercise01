package Algorithm.Matrix;

public class StrToInt {
	public static int StrToInt1(String str) {
		if (str.equals("") || str == null) {// ���ַ���
			return 0;
		}
		int flag = 1;
		if (str.charAt(0) == '+' || str.charAt(0) == '-') {// ����λΪ���ţ�ȥ����,����flag
			if (str.charAt(0) == '+') {
				flag = 1;
			}
			if (str.charAt(0) == '-') {
				flag = -1;
			}
			str = str.substring(1);
		}
		if (str.equals("") || str.length() > 10) {// ������ж�
			return 0;
		}
		if (str.length() == 10) {// ������жϣ�����Ϊ10����λ����2��Ȼ���
			if (str.charAt(0) > '2') {
				return 0;
			}
		}
		for (int i = 0; i < str.length(); i++) {// �жϷǷ��ַ�
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
