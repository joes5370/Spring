import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class DijkstraPriorityQueue {
	private int distances[]; // 노드별 최소 거리 값
	private int T[]; // 최단 경로 저장
	private Set<Integer> settled; // 노드 방문 여부
	private PriorityQueue<Node> priorityQueue;
	private int number_of_nodes;
	private int adjacencyMatrix[][];

	public DijkstraPriorityQueue(int number_of_nodes) {
		// 생성자 6개 기준 =number_of_nodes
		this.number_of_nodes = number_of_nodes;
		distances = new int[number_of_nodes + 1];
		T = new int[number_of_nodes + 1];

		settled = new HashSet<Integer>(); // 어느 노드를 방문했는지
		priorityQueue = new PriorityQueue<Node>(); // 엣지의 코스트를 오름차순으로 정렬하기 위해 사용
		adjacencyMatrix = new int[number_of_nodes + 1][number_of_nodes + 1]; // 메인함수에서 받은 인접매트릭스를 동일하게 카피하겠다. 함수의 파라미터로
																				// 전달
	}

	public void dijkstra_algorithm(int adjacency_matrix[][], int source) // 시작번호 = source
	{
		int evaluationNode;
		for (int i = 1; i <= number_of_nodes; i++)
			for (int j = 1; j <= number_of_nodes; j++)
				adjacencyMatrix[i][j] = adjacency_matrix[i][j];

		for (int i = 1; i <= number_of_nodes; i++) {
			distances[i] = Integer.MAX_VALUE; // 무한대로 넣는다.
			T[i] = 0;
		}

		priorityQueue.add(new Node(source, 0));
		distances[source] = 0;

		// D,T배열을 계속 업데이트함
		while (!priorityQueue.isEmpty()) {
			// 1번노드를 기준으로 여러개의 edge중 최소의 edge만 꺼내라
			evaluationNode = getNodeWithMinimumDistanceFromPriorityQueue();
			// S(들린노드)여기서 추가함
			settled.add(evaluationNode);
			evaluateNeighbours(evaluationNode);
		}
	}

	private int getNodeWithMinimumDistanceFromPriorityQueue() {
		// 노드와 연결된 엣지의 가장 최소값만 꺼내온다.
		Node node = priorityQueue.poll(); // remove();
		return node.node;
	}

	private void evaluateNeighbours(int evaluationNode) {
		int edgeDistance = -1;
		int newDistance = -1;

		for (int destinationNode = 1; destinationNode <= number_of_nodes; destinationNode++) {
			if (!settled.contains(destinationNode)) {
				if (adjacencyMatrix[evaluationNode][destinationNode] != Integer.MAX_VALUE) {
					// 인접매트릭스의 정보를 찾고
					edgeDistance = adjacencyMatrix[evaluationNode][destinationNode];
					newDistance = distances[evaluationNode] + edgeDistance;
					if (newDistance < distances[destinationNode]) {
						// 여기서 D와 T가 업데이터
						distances[destinationNode] = newDistance;
						T[destinationNode] = evaluationNode;
					}
					priorityQueue.add(new Node(destinationNode, distances[destinationNode]));
				}
			}
		}
	}

	public static void main(String... arg) {
		int adjacency_matrix[][];
		int number_of_vertices;
		int source = 0;
		Scanner scan = new Scanner(System.in);
		try {
			System.out.println("Enter the number of vertices");
			number_of_vertices = scan.nextInt();
			adjacency_matrix = new int[number_of_vertices + 1][number_of_vertices + 1];

			System.out.println("Enter the Weighted Matrix for the graph");
			for (int i = 1; i <= number_of_vertices; i++) {
				for (int j = 1; j <= number_of_vertices; j++) {
					adjacency_matrix[i][j] = scan.nextInt();
					if (i == j) {
						adjacency_matrix[i][j] = 0;
						continue;
					}
					if (adjacency_matrix[i][j] == 0) {
						adjacency_matrix[i][j] = Integer.MAX_VALUE;
					}
				}
			}

			System.out.println("Enter the source ");
			source = scan.nextInt();

			DijkstraPriorityQueue dijkstrasPriorityQueue = new DijkstraPriorityQueue(number_of_vertices);
			dijkstrasPriorityQueue.dijkstra_algorithm(adjacency_matrix, source);

			// Distance배열
			System.out.println("The Shorted Path to all nodes are ");
			for (int i = 1; i <= dijkstrasPriorityQueue.distances.length - 1; i++) {
				System.out.println(source + " to " + i + " is " + dijkstrasPriorityQueue.distances[i]);
			}

			// T -> 경로 찍기
			System.out.println("<T> is... ");
			for (int i = 1; i <= dijkstrasPriorityQueue.T.length - 1; i++) {
				System.out.print(dijkstrasPriorityQueue.T[i] + " ");

			}
		} catch (InputMismatchException inputMismatch) {
			System.out.println("Wrong Input Format");
		}
		scan.close();
	}
}

class Node implements Comparable<Node> {
	public int node;
	public int cost;

	public Node() {
	}

	public Node(int node, int cost) {
		this.node = node;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node node) // , Node node2)
	{
		// 오름차순 정렬
		return this.cost - node.cost;
	}
}

// source : https://www.sanfoundry.com/java-program-mplement-dijkstras-algorithm-using-priority_queue/
// modified by hwy

/*
 * Enter the number of vertices 6 Enter the Weighted Matrix for the graph 0 5 4
 * 0 0 0 5 0 2 7 0 0 4 2 0 6 11 0 0 7 6 0 3 8 0 0 11 3 0 8 0 0 0 8 8 0 Enter the
 * source 1 The Shorted Path to all nodes are 1 to 1 is 0 1 to 2 is 5 1 to 3 is
 * 4 1 to 4 is 10 1 to 5 is 13 1 to 6 is 18 <T> is... 0 1 1 3 4 4
 */