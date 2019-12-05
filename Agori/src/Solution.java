import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.lang.Math;
import java.lang.reflect.Array;

/*
 사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
 이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution {
	static int N;
	static int AnswerN;

	static int[] E;
	static int[][] ES;
	static int g_idx;

	public static void main(String args[]) throws Exception {
		/*
		 * 아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다. 여러분이 작성한 코드를
		 * 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후, 이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때
		 * 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다. 따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		 * 단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		System.setIn(new FileInputStream("res/sample_input.txt"));

		/*
		 * 표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 5; test_case++) {
			/*
			 * 각 테스트 케이스를 표준 입력에서 읽어옵니다.
			 */

			N = sc.nextInt();
			E = new int[N];
			for (int i = 0; i < N; i++) {
				E[i] = sc.nextInt();
			}

			// ///////////////////////////////////////////////////////////////////////////////////////////
			/*
			 * 이 부분에 여러분의 알고리즘 구현이 들어갑니다. 여러분의 정답은 AnswerN에 저장되는 것을 가정하였습니다.
			 */
			// ///////////////////////////////////////////////////////////////////////////////////////////
			/*
			 * 6개의 입력값을 2개 그룹으로 나누어서 각각 합을 구한 후 각 합의 차가 제일 적은 값을 구하기. 예) 입력값 : 2, 2, 2, 3,
			 * 3, 3 Σ(2, 2, 3) , Σ (2, 3, 3) -> | 7 - 8 | = 1 <---------- 정답 Case Σ(2, 2, 2)
			 * , Σ (3, 3, 3) -> | 6 - 9 | = 3
			 */
			int totalsum = 0;
			for (int i = 0; i < N; i++)
				totalsum += E[i];

			Arrays.sort(E);

			int temp = (int) (fcalc(N) / ((fcalc(N / 2) * fcalc(N - N / 2))));
			ES = new int[temp][N / 2];
			g_idx = 0;
			int[] sum = new int[temp];
			int tempsum = 0;
			int[] output = new int[N / 2];
			combination(E, N / 2, 0, output, 0);

			for (int i = 0; i < temp; i++) {
				tempsum = 0;
				for (int j = 0; j < N / 2; j++) {
					tempsum += ES[i][j];
				}
				sum[i] = tempsum;
			}
			Arrays.sort(sum);

			// S-2A
			int minimum = Integer.MAX_VALUE;
			int t = 0;
			for (int i = 0; i < temp; i++) {
				t = Math.abs(totalsum - 2 * sum[i]);
				if (minimum > t) {
					minimum = t;
					AnswerN = t;
				}
			}
			// AnswerN = sum[temp-1] - sum[temp-2];

			System.out.println("#" + test_case + " " + AnswerN);
			
		}
	}

	static void combination(int[] arr, int pick, int startIdx, int[] output, int numElem) {
		if (numElem == pick) {
			System.out.println(Arrays.toString(output));
			for (int i = 0; i < pick; i++) {
				ES[g_idx][i] = output[i];
			}
			g_idx++;
			return;
		}

		for (int i = startIdx; i < arr.length; i++) {
			output[numElem++] = arr[i];
			combination(arr, pick, ++startIdx, output, numElem);
			--numElem;
		}
	}

	public static long fcalc(long n) {
		if (n <= 1)
			return 1;
		else
			return n * fcalc(n - 1);
	}

	public static void permute(String input) {
		int inputLength = input.length();
		boolean[] isbranched = new boolean[inputLength];
		StringBuffer outputString = new StringBuffer();
		char[] in = input.toCharArray();
		doPermute(in, outputString, isbranched, inputLength, 0);

	}

	public static void doPermute(char[] in, StringBuffer outputString, boolean[] isbranched, int inputLength,
			int level) {
		if (level == inputLength) {
			System.out.println(outputString.toString());
			return;
		}

		for (int i = 0; i < inputLength; ++i) {
			if (isbranched[i])
				continue;

			outputString.append(in[i]);
			isbranched[i] = true;
			doPermute(in, outputString, isbranched, inputLength, level + 1);
			isbranched[i] = false;
			outputString.setLength(outputString.length() - 1);
		}
	}

	static void generatePermutations(char[] arr, int size, char[] branch, int level, boolean[] visited) {
		if (level >= size - 1) {
			System.out.println(branch);
			return;
		}

		for (int i = 0; i < size; i++) {
			if (!visited[i]) {
				branch[++level] = arr[i];
				visited[i] = true;
				generatePermutations(arr, size, branch, level, visited);
				visited[i] = false;
				level--;
			}
		}
	}

}
