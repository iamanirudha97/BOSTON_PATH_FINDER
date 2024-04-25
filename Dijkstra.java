import java.util.*;
public class Dijkstra {
    public static Dictionary[] dijkstra(Graph g, Vertex startingPoint){
        Dictionary<String, Integer> distances = new Hashtable<>();
        Dictionary<String, Vertex> previous = new Hashtable<>();
        PriorityQueue <QueueObject> queue = new PriorityQueue<QueueObject>();

        queue.add(new QueueObject(startingPoint, 0));

        for (Vertex v: g.getVertices()) {
            if(v != startingPoint){
                distances.put(v.getData(), Integer.MAX_VALUE);
            }
            previous.put(v.getData(), new Vertex("Null"));
        }
        distances.put(startingPoint.getData(),0);

        while(!queue.isEmpty()){
            Vertex current = queue.poll().vertex;
            for(Edge e: current.getEdges()){
                Integer alternative = distances.get(current.getData()) + e.getWeight();
                String neighbourVal = e.getEnd().getData();

                if(alternative < distances.get(neighbourVal)){
                    distances.put(neighbourVal, alternative);
                    previous.put(neighbourVal, current);
                    queue.add(new QueueObject(e.getEnd(), distances.get(neighbourVal)));
                }
            }
        }
        return new Dictionary[] {distances, previous};
    }

    public static void shortestPath(Graph g, Vertex startingPoint, Vertex targetVertex){
        Dictionary[] dijkstraDict = dijkstra(g, startingPoint);
        Dictionary distances = dijkstraDict[0];
        Dictionary previous = dijkstraDict[1];

        Integer distance = (Integer) distances.get(targetVertex.getData());
        System.out.println("Shortest Distance between " + startingPoint.getData() + " and " + targetVertex.getData());
        System.out.println(distance);

        ArrayList<Vertex> path = new ArrayList<>();
        Vertex v = targetVertex;

        while (v.getData() != "Null"){
            path.add(0, v);
            v = (Vertex) previous.get(v.getData());
        }

        System.out.println("The Shortest Path in the Network");

        for (Vertex pathVertex: path){
            System.out.println(pathVertex.getData());
        }
    }

    public static void printDijkstra(Dictionary[] d){
        System.out.println("\nDistances\n");
        for (Enumeration keys = d[0].keys(); keys.hasMoreElements();){
            String nextKey = keys.nextElement().toString();
            System.out.println(nextKey + ": " + d[0].get(nextKey));
        }
        System.out.println("\nPrevious:\n");
        for (Enumeration keys = d[1].keys(); keys.hasMoreElements();) {
            String nextKey = keys.nextElement().toString();
            Vertex nextVertex = (Vertex) d[1].get(nextKey);
            System.out.println(nextKey + ": " + nextVertex.getData());
        }
    }
}
