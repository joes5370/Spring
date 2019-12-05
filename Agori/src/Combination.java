
public class Combination {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		combi(arr, 3);
	}

	public static void combi(int[] arr, int count) {
		int[] temp = new int[count];
		combination(arr, 0, count, temp);
	}

	public static void combination(int[] arr, int start, int count, int[] temp) {
		if (count == 0) {
			for (int i = 0; i < temp.length; i++) {
				System.out.print(arr[temp[i]] + "");
			}
			System.out.println();
			return;
		}
		for (int i = start; i < arr.length; i++) {
			temp[temp.length - count] = i;
			combination(arr, i + 1, count - 1, temp);
		}

	}
}
