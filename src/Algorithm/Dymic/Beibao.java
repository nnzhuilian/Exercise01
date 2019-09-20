package Algorithm.Dymic;

public class Beibao {
    public static void main(String[] args) {
        int N = 3 ;     // ��ʯ����
        int C = 10 ;    // �������
        int V[] = {0,5,3,4} ;       // ÿ����ʯ�����,����ǰ���0��Ϊ�˺����ʾ���㣬��V[1]��ʾΪ��һ����ʯ���������ͬ
        int W[] = {0,20,10,12} ;    // ÿ����ʯ�ļ�ֵ
        int d[][] = new int [N+1][C+1] ;    // ״̬����

        d[0][C] = 0 ;

        for (int i = 1; i <= N; i++) {
            System.out.println("*********  i="+ i +"  *********" ) ;
                for (int j= 1; j<=C; j++) {
                    if ( i > 0 && j>=V[i]) {
                        // ״̬ת�Ʒ���
                        d[i][j] = (d[i-1][j] > d[i-1][j-V[i]] + W[i]) ? d[i-1][j] : d[i-1][j-V[i]] + W[i] ;

                        System.out.println("\t---------- j="+j+"  d[i-1][j]="+d[i-1][j]+"   d[i-1][j-V[i]]+ W[i]="+(d[i-1][j-V[i]]+ W[i])+"   ---------") ;
                        // ��ӡÿ�α���״̬������
                        print_array(d) ;
                    }
                }
                System.out.println() ;
            }
    }
    // ��ӡ�������ݵĶ�λ����
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
