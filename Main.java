import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TestGraph tLine = new TestGraph();
        Vertex start = tLine.getStartingPoint();
        Vertex target = tLine.tNetwork.getVertices().get(2);

        System.out.println();
        System.out.println("GRAPH NETWORK");
        tLine.tNetwork.print();

        System.out.println();
        System.out.println("DIJKSTRA's ALGORITHM");
        System.out.println();

        Dijkstra.printDijkstra(Dijkstra.dijkstra(tLine.tNetwork, start));

        Dijkstra.shortestPath(tLine.tNetwork, start, target);
    }
}
