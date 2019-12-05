import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;


public class Test_Prim {
    static int V, E;
    static LinkedList<Edge>[] graph; // n번정점에서 연결된 간서정보를 정점마다 유지되도록 하는 인접리스트
    static ArrayList<Edge> mst;
    static boolean[] visit;
    
    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		V = s.nextInt();
		E = s.nextInt();
		
		graph = new LinkedList[V+1];
		visit = new boolean[V+1];
		
		for(int i =1; i<= V; i++) {
			graph[i] = new LinkedList<>();
		}
		
		mst = new ArrayList<>();
		
		for(int i= 0; i< E; i++) {
			int v1 = s.nextInt();
			int v2 = s.nextInt();
			int value = s.nextInt();
			
			graph[v1].add(new Edge(v1,v2,value));
			graph[v2].add(new Edge(v1,v2,value));
		}
		
		makeMst();
		System.out.println(mst);
		
    }
    
    private static void makeMst() {
		// TODO Auto-generated method stub
    	
    	PriorityQueue<Edge> pq = new PriorityQueue<>();
    	Queue<Integer> queue = new LinkedList<>();
    	queue.add(1);
    	
    	while(!queue.isEmpty()) {
    		int nowV = queue.poll();
    		visit[nowV] = true;
    		
    		for(Edge edge: graph[nowV]) {
    			if(!visit[edge.end]) {
    				pq.add(edge);
    			}
    		}
    		
    		while(!pq.isEmpty()) {
    			Edge edge = pq.poll();
    			if(!visit[edge.end]) {
    				queue.add(edge.end);
    				visit[edge.end] = true;
    				mst.add(edge);
    				break;
    			}
    		}
    	}
		
	}

	static class Edge implements Comparable<Edge>{
    	int start, end, value;
    	
    	Edge(int s, int e, int v){
    		this.start = s;
    		this.end = e;
    		this.value = v;
    	}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.value - o.value;
		}
		@Override
		public String toString() {
			return "Edge [start = "+start+", end="+end + ", value="+ value+"] \n";
		}
    	
    }
}
