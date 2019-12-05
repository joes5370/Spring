import java.util.Random;
import java.util.Scanner;

public class Bit {
	static int[] array;
	static int max_size = 10;
	static int infinite = 999999;
	
	int n = 8;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random r = new Random();
		
		System.out.println("배열 몇개 만들꺼야?");
		int n = scan.nextInt();
		int[] temp = new int[n];
		
		for(int i=0; i < temp.length; i++) {
			temp[i] = r.nextInt(10)+1;
			System.out.print(temp[i]+" ");
		}
		
	}
	

	
	
	
}
