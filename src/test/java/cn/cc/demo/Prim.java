package cn.cc.demo;
import java.util.*;

public class Prim {
    static List<Vertex> vertexList = new ArrayList<>();
    static List<Edge> edgeList = new ArrayList<>();
    static List<Vertex> vertexVisitedList = new ArrayList<>();

    static List<Deque<Vertex>> vertexQueueList = new ArrayList<>();
    private static void buildGraph(){
        Vertex v1 = new Vertex("a");
        Prim.vertexList.add(v1);
        Vertex v2 = new Vertex("b");
        Prim.vertexList.add(v2);
        Vertex v3 = new Vertex("c");
        Prim.vertexList.add(v3);
        Vertex v4 = new Vertex("d");
        Prim.vertexList.add(v4);
        Vertex v5 = new Vertex("e");
        Prim.vertexList.add(v5);
        addEdge(v1, v2, 6);
        addEdge(v1, v3, 7);
        addEdge(v2, v3, 8);
        addEdge(v2, v5, 4);
        addEdge(v2, v4, 5);
        addEdge(v3, v4, 3);
        addEdge(v3, v5, 9);
        addEdge(v5, v4, 7);
        addEdge(v5, v1, 2);
        addEdge(v4, v2, 2);
    }

    private static void addEdge(Vertex start, Vertex end, int key) {
        edgeList.add(new Edge(start, end, key));
    }

    public static void main(String[] args) {
//        prim();
        djstl();
        //a   b   e   d   c
    }


    private static void djstl(){
        buildGraph();
        List<Vertex> result = new ArrayList<>();

    }
    private static void prim() {
        buildGraph();
        //先将第一个添加到已经访问
        vertexVisitedList.add(vertexList.get(0));
        //添加剩下的n - 1个
        for (int n = 0; n < vertexList.size() - 1; n++) {
            Vertex temp = new Vertex(vertexList.get(0).key);
            Edge tempEdge = new Edge(temp, temp, 1000);
            for (Vertex vertex : vertexVisitedList) {
                for (Edge edge : edgeList) {
                    if(edge.start==vertex && !vertexVisitedList.contains(edge.end)){
                        if(edge.key < tempEdge.key){
                            temp = edge.end;
                            tempEdge=edge;
                        }
                    }
                }
            }
            vertexVisitedList.add(temp);
        }
        for (Vertex vertex : vertexVisitedList) {
            System.out.println(vertex.key);
        }
    }
}
class Vertex{
    String key;
    public Vertex(String key) {
        this.key = key;
    }
}
class Edge{
    Vertex start;
    Vertex end;
    int key;

    public Edge(Vertex start, Vertex end, int key) {
        this.start = start;
        this.end = end;
        this.key = key;
    }
}
