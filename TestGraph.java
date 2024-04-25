public class TestGraph {
    public Graph tNetwork;
    public TestGraph(){
        this.tNetwork = new Graph(true, true);
        Vertex a = this.tNetwork.addVertex("A");
        Vertex b = this.tNetwork.addVertex("B");
        Vertex c = this.tNetwork.addVertex("C");
        Vertex d = this.tNetwork.addVertex("D");
        Vertex e = this.tNetwork.addVertex("E");

        this.tNetwork.addEdge(a, c, 2);
        this.tNetwork.addEdge(a, b, 4);
        this.tNetwork.addEdge(b, c, 1);
        this.tNetwork.addEdge(b, d, 2);
        this.tNetwork.addEdge(b, e, 3);
        this.tNetwork.addEdge(c, e, 1);
        this.tNetwork.addEdge(e, d, 5);
    }
    public Vertex getStartingPoint(){
        return this.tNetwork.getVertices().get(0);
    }
}
