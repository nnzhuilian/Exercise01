import java.util.*;
public class sortList_array {
	public static void main(String[] args) {
		int[] a={2,4,5,1,6,4};
		Arrays.sort(a);
		
	}
	public static void Listpaixu(String[] args) {
		    List<String> list = new ArrayList<String>();
			list.add("beijing");
			list.add("shanghai");
			list.add("hangzhou");
			Collections.sort(list, new Comparator<String>() {
				public int compare(String str1, String str2) {
					/**
		　　　　　　* 升序排的话就是第一个参数.compareTo(第二个参数);
		　　　　　　* 降序排的话就是第二个参数.compareTo(第一个参数);
		　　　　　　*/

					// 按首字母升序排
					// return str1.compareTo(str2);
					// 按第二个字母升序排
					char c1 = str1.charAt(1);
					char c2 = str2.charAt(1);
					return c1 - c2;
				}
			});
			System.out.println(list);
		}
}
