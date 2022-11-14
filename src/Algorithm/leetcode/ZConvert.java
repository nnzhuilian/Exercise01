package Algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：huangxiaohan
 * @description：
 * @date ：Created in 2022/6/13 上午10:22
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列
 * PAYPALISHIRING->PAHNAPLSIIGYIR
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 */
public class ZConvert {
    public static void main(String[] args) {
        convert("P", 3);
    }

    public static String convert(String s, int numRows) {
        if(s==null||s.length()==0||numRows<=1){
            return s;
        }
        String sstr = "";
        List<StringBuffer> sbs = genSbs(s, numRows);
        for (StringBuffer sb : sbs) {
            sstr += sb.toString();
        }
        System.out.println(sstr);
        return sstr;
    }

    public static List<StringBuffer> genSbs(String s, int numRows) {
        List<StringBuffer> sbs = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            sbs.add(new StringBuffer());
        }
        for (int j = 0; j < s.length(); j++) {
            int index = (j + 1) % (numRows * 2 - 2);
            if (index == 0) {
                index = numRows * 2 - 2;
            }
            if (index <= numRows) {
                sbs.get(index - 1).append(s.charAt(j));
            } else {
                index = numRows - index % numRows - 1;
                sbs.get(index).append(s.charAt(j));
            }
        }
        return sbs;
    }
}
