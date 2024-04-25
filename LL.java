public class LL {
    public Node head;

    public LL(){
        this.head = null;
    }

    public void addToHead(Vertex data){
        Node newHead = new Node(data);
        Node currentHead = this.head;
        this.head = newHead;
        if(currentHead != null){
            this.head.setNextNode(currentHead);
        }
    }

    public void addToTail(Vertex data) {
        Node tail = this.head;
        if (tail == null) {
            this.head = new Node(data);
        } else {
            while (tail.getNextNode() != null) {
                tail = tail.getNextNode();
            }
            tail.setNextNode(new Node(data));
        }
    }

    public Vertex removeHead(){
        Node removeHead = this.head;
        if(removeHead == null){
            return null;
        } else {
            this.head = removeHead.getNextNode();
            return removeHead.data;
        }
    }
}
