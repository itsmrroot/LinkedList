public class Node {
    String data;
    Node next;
    Node prev;

    public Node(String date) {
        this.data = date;
    }

     public String getDate() {
        return data;
    }

     public void setDate(String date) {
        this.data = data;
    }

     public Node getNext() {
        return next;
    }

     public void setNext(Node next) {
        this.next = next;
    }

     public Node getPrev() {
        return prev;
    }

     public void setPrev(Node prev) {
        this.prev = prev;
    }

     @Override
    public String toString() {        return "Node{" +
                "date='" + data + '\'' +
                '}';    }
}
