package caodaran;

public class Fibonacci {

	private static int next;

	public static void main(String[] args) {
		System.out.println("쳲��������е�ǰ����λ�����ǣ�");
		System.out.print("1\t1\t");
		int first = 1;
		int second = 1;
		for(int i = 3;i<201;i++) {
			next = first+second;
			first = second;
			second = next;
			System.out.print(next+"\t");
			if(i%5==0) {
				System.out.println();
				}
	   	}

	}

}
