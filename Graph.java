import java.util.ArrayList;

public class Graph {
    private ArrayList<Vertex> vertices;
    private boolean isWeighted;
    private boolean isDirected;

    public Graph(boolean inputIsWeighted, boolean InputIsDirected){
        this.vertices = new ArrayList<Vertex>();
        this.isWeighted = inputIsWeighted;
        this.isDirected = inputIsWeighted;
    }

    public Vertex addVertex(String data){
        Vertex newVertex = new Vertex(data);
        this.vertices.add(newVertex);
        return newVertex;
    }

    public void addEdge(Vertex vertex1, Vertex vertex2, Integer weight){
        if(!this.isWeighted){
            weight = null;
        }
        vertex1.addEdge(vertex2, weight);

        if(!this.isDirected){
            vertex2.addEdge(vertex1, weight);
        }
    }
    public void removeEdge(Vertex vertex1, Vertex vertex2){
        vertex1.removeEdge(vertex2);
        if(!isDirected){
            vertex2.removeEdge(vertex1);
        }
    }

    public void removeVertex(Vertex vertex){
        this.vertices.remove(vertex);
    }

    public ArrayList<Vertex> getVertices() {
        return this.vertices;
    }

    public boolean isDirected() {
        return this.isDirected;
    }

    public boolean isWeighted() {
        return this.isWeighted;
    }

    public Vertex getVertexValue(String value){
        for(Vertex v: this.vertices){
            if(v.getData() == value){
                return v;
            }
        } return null;
    }

    public void print(){
        for (Vertex v: this.vertices){
            v.print(isWeighted);
        }
    }
}
