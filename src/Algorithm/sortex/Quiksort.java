package Algorithm.sortex;

public class Quiksort {

	public static void sort(int a[]){
		if(a.length<2||a==null){
			return;
		}
		sort(a, 0, a.length-1);
	}
	public static void sort(int a[],int L,int R){
		if(L>=R) return;
		int rI=(int)(Math.random()*(R-L+1));//���ѡȡһ����
		swap(a,L+rI,R);
		//System.out.println(rI);
		int p[]=partition(a,L,R);
		sort(a,L,p[0]);
		sort(a,p[1],R);
	}
	public static int[] partition(int a[], int L, int R) {
		int less = L - 1;//��ʾ����С�ڱȽ�λa[r]�����һλ
		int more = R;//��ʾ���д��ڱȽ�λa[r]����ǰһλ
		int index = L;//��ʾ��Ҫ�Ƚϵ�λ��
		int p[]=new int[2];
		while (index < more) {
			if (a[index] == a[R]) {//a[R]Ϊ���ڱȽϵ���
				index++;//�����ڣ��򲻶�
			}
			else if (a[index] < a[R]) {//��С�ڣ���ǰ��������С�����ĺ�һλ����������or���ǵ�ǰ��������
				swap(a, ++less, index++);
			}
			else if (a[index] > a[R]) {//�����ڣ���ǰ����moreǰһ������������ǰ�Ƚ����±��䣨����������û�жϹ�������
				swap(a, --more, index);
			}
		}
		swap(a,more,R);
		p[0]=less;
		p[1]=more+1;//��R�ų�ȥ
		return p;
	}

	public static void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		int a[]=new int[]{2,5,3,6,1,4,6,9,2,3};
		//partition(a,0,9,4);// TODO Auto-generated method stub
		sort(a);
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]);
		}

	}

}
