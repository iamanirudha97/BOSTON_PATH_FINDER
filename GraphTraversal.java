import java.util.ArrayList;
import java.util.Queue;

public class GraphTraversal {
    public static void dfsTraversal(Vertex start, ArrayList<Vertex> visited) {
        System.out.println(start.getData());

        for (Edge e: start.getEdges()){
            Vertex neighbour = e.getEnd();
            if(!visited.contains(neighbour)){
              visited.add(neighbour);
              GraphTraversal.dfsTraversal(neighbour, visited);
            };
        }
    }

    public static void bfsTraversal(Vertex start, ArrayList<Vertex> visited){
        Que visitedQue = new Que();
        visitedQue.enque(start);

        while(!visitedQue.isEmpty()){
            Vertex current = visitedQue.deque();
            System.out.println(current.getData());

            for (Edge e: current.getEdges()){
             Vertex neighbour = e.getEnd();
             if(!visited.contains(neighbour)){
                 visited.add(neighbour);
                 visitedQue.enque(neighbour);
                }
            }
        }
    }
}