import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Prim {
    static int V, E;
    static LinkedList<Edge>[] graph; // n번정점에서 연결된 간서정보를 정점마다 유지되도록 하는 인접리스트
    static ArrayList<Edge> mst;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        E = sc.nextInt();

        graph = new LinkedList[V+1];        //1번부터 V번까지 사용함.
        visit =  new boolean[V+1];

        for (int i = 1; i <= V; i++) {
            graph[i]= new LinkedList<>();
        }
        mst = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int value = sc.nextInt();

            graph[v1].add(new Edge(v1,v2,value));
            graph[v2].add(new Edge(v2,v1,value));
        }

        makeMst();
        System.out.println(mst);

    }
    static void makeMst() {
        //1.시작정점 아무거나 지정
        //2.선택한 정점에 연결된 간선들을 우선순위 큐에 집어넣는다.
        //3.우선순위 큐에서 간선 poll하면 제일 짧은애가 나온다. 그 끝에 정점이 이미 방문한 정점이 아니라면 해당간선 선택한다.
        //4. 2~3 반복. n-1개의 간선이 선택할때까지 or 모든 정점이 연결될때까지

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Queue<Integer> queue = new LinkedList<>();        //정점방문 스케줄 처리를 위한 큐

        queue.add(1);

        while(!queue.isEmpty()) {
            int nowV = queue.poll();
            visit[nowV] = true;

            for (Edge edge : graph[nowV]) {        //현재정점 nowV에서 연결된 간선들 중 
                if(!visit[edge.end]) {            //방문한적 없는 정점으로가는 간선들을 우선순위큐에 넣어준다.
                    pq.add(edge);
                }
            }
            while(!pq.isEmpty()) {
                Edge edge = pq.poll();            //지금 들어있는 간선들 중 제일 짧은애가 나올것이다.
                if(!visit[edge.end]) {            //방금나온 간선 써도 되는지 , 미방문 정점으로 가는거 맞는지
                    queue.add(edge.end);        //확인됐으면 해당간선 끝 정점 방문 스케줄에 추가하고
                    visit[edge.end] = true;        // 방문예정 정점은 중복스케줄 방지를 위해 방문처리 해버리기
                    mst.add(edge);                //방금 선택한 간선은 mst에 추가하기
                    break;
                }
            }
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
// source : https://velog.io/@dudrkdl777/Graph-최소신장트리-MSTPrim알고리즘
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