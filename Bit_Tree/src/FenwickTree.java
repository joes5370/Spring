import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class FenwickTree {

//	private void update(int[] arr, int pos, int val) {
//		int len = arr.length;
//		for(; pos < len; pos = (pos+1))
//			arr[pos] += val;
//		System.out.println(Arrays.toString(arr));
//		
//	}
//	
//	private int sum(int[] arr, int pos) {
//		int sum = 0;
//		for(; pos >= 0; pos = (pos&(pos+1)) -1 )
//			sum +=arr[pos];
//			System.out.println(sum + " " + pos+"번째");
//		return sum;
//	}
	
	public void updateCode(int []arr, int index, int val) {
		System.out.println("배열 길이" + arr.length);
		while(index <= arr.length) {
			arr[index] = arr[index] + val;
			index = index + (index & (-index));
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public int sumCode(int[] arr, int index) {
		int sum = 0;
		while(index > 0) {
			sum = sum + arr[index];
			System.out.println(arr[index] + "구간");
			index = index - (index & (-index));
			System.out.println(sum + "합");
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random r = new Random();
		System.out.println("Fenwick Tree Test \n");
		
		
		System.out.println("배열 몇개 만들꺼야?");
		int n = scan.nextInt();
		int[] temp = new int[n];
		for(int i=0; i < temp.length; i++) {
			temp[i] = r.nextInt(10)+1;
			System.out.print(temp[i]+" ");
		}
		
		FenwickTree ft = new FenwickTree();
		char ch;
		do {
			System.out.println("\n Fenwick Tree Operations \n");
			System.out.println("1. update");
			System.out.println("2. sum");
			
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("변경값 입력");
				ft.updateCode(temp, scan.nextInt(), scan.nextInt());
				System.out.println();
				break;
			case 2:
				System.out.println("합 구할래?");
				try {
					int sum = ft.sumCode(temp, scan.nextInt());
					System.out.println("Sum = " + sum);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("\n Error!");
				}
				break;
				
			default:
				System.out.println("틀렸어요");
				break;
			}
			System.out.println("다시 할래? y or n");
			ch = scan.next().charAt(0);
		}while(ch == 'Y' || ch == 'y');
	}
	
	
}
