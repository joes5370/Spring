import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Kruskal {
    static int V, E;
    static ArrayList<Edge> mst;            //선택한 간선들만 넣어서 만드는 최소한의 신장트리 결과물
    static int[] arr ;                    //디스조인트셋 대표자 확인을 위한 배열
    static PriorityQueue<Edge> pq;        //크루스칼에서는 모든 간선을 여기에 집어넣고 시작한다.
	private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        V = sc.nextInt();            //정점의 갯수
        E = sc.nextInt();            //간선의 갯수

        mst = new ArrayList<>();
        arr = new int[V+1];
        pq = new PriorityQueue<>();

        for (int i = 0; i <= V; i++) {//disjoint init
            arr[i]=i;                //자기자신을 대표로 만들어놓고 시작한다.
        }

        for (int i = 0; i < E; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int value = sc.nextInt();

            pq.add(new Edge(v1, v2, value));
        }

        while(mst.size() < (V-1)) {                //V개의 정점을 연결하기 위한 최소간선 갯수는 V-1개인데 아직 그게 안됐으면 계속 하기
            Edge edge = pq.poll();
            if(find(edge.start)!=find(edge.end)) {
                mst.add(edge);
                union(edge.start,edge.end);
            }
            //대표자가 이미 같은 번호로 설정되있다면 현재 가중치가 더 큰 숫자이므로 union-find과정을 생략한다 (PriorityQueue로 가중치가 작은 간선부터 꺼내오는 중) 
        }

        System.out.println(mst);
    }
    static int find(int n) { // n이속한 집합의 대표를 반환하는 함수
        if (n == arr[n]) {
            return n;
        } else {
            int p = find(arr[n]);
            arr[n]=p;                    //너무많은 재귀호출을 피하기 위해서 최종대표를 저장한다.
            return p;
        }
    }
    static void union(int n1, int n2) { // n1이 속한 집합과 n2가 속한 집합을 통합하는 함수(뒤에놈이 대표가 된다)
        int p1 = find(n1);
        int p2 = find(n2);

        if (p1 != p2) {
            arr[p1]= p2;
        }
    }
    static class Edge implements Comparable<Edge>{
        int start, end, value;

        Edge(int s, int e, int v) {
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
            return "Edge [start=" + start + ", end=" + end + ", value=" + value + "]\n";
        }
    }
}

/*
6
9
1 2 5
1 3 4
2 3 2
2 4 7
3 4 6
4 6 8
3 5 11
4 5 3
5 6 8
*/
// source : https://velog.io/@dudrkdl777/Graph-최소신장트리-MSTKruskal알고리즘