package Algorithm.Dymic;

public class Beibao {
    public static void main(String[] args) {
        int N = 3 ;     // 宝石个数
        int C = 10 ;    // 书包容量
        int V[] = {0,5,3,4} ;       // 每个宝石的体积,这里前面的0是为了后面表示方便，即V[1]表示为第一个宝石的体积，下同
        int W[] = {0,20,10,12} ;    // 每个宝石的价值
        int d[][] = new int [N+1][C+1] ;    // 状态数组

        d[0][C] = 0 ;

        for (int i = 1; i <= N; i++) {
            System.out.println("*********  i="+ i +"  *********" ) ;
                for (int j= 1; j<=C; j++) {
                    if ( i > 0 && j>=V[i]) {
                        // 状态转移方程
                        d[i][j] = (d[i-1][j] > d[i-1][j-V[i]] + W[i]) ? d[i-1][j] : d[i-1][j-V[i]] + W[i] ;

                        System.out.println("\t---------- j="+j+"  d[i-1][j]="+d[i-1][j]+"   d[i-1][j-V[i]]+ W[i]="+(d[i-1][j-V[i]]+ W[i])+"   ---------") ;
                        // 打印每次保存状态的数组
                        print_array(d) ;
                    }
                }
                System.out.println() ;
            }
    }
    // 打印保存数据的二位数组
    public static void print_array(int A[][]){
        System.out.println("=======================================================================") ;
        for (int i= 1;i<A.length ;i++ ) {
            for (int j = 1; j<A[0].length; j++) {
                System.out.print(A[i][j] + "\t") ;
            }
            System.out.println();
        }
        System.out.println("=======================================================================") ;
    }
}
