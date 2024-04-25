public class Que {
    public LL queue;
    public int size;

    public Que(){
        this.queue = new LL();
        this.size = 0;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public void enque(Vertex data){
        this.queue.addToTail(data);
        this.size++;
    }

    public Vertex deque(){
        if(!this.isEmpty()){
            Vertex data = this.queue.removeHead();
            this.size--;
            return data;
        } else {
            throw new Error("QUEUE IS EMPTY!!!");
        }
    }

    public Vertex peek(){
        if(this.isEmpty()) {
            return null;
        } else {
            return this.queue.head.data;
        }
    }
}
