package Algorithm.Matrix;

public class Add {
    public int Add(int num1,int num2) {
        while((num1&num2)!=0){
            int yh=num1^num2;
            int yu=num1&num2;
            num1=yu;
            num2=yh;
            num1=num1<<1;
        }
        return num1^num2;
    }
}
