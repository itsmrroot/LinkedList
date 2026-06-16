public class List {
     Node head;
     Node tail;
    Node cursor;

    public List() {

    }

    public void add(Node newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
            cursor = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }
    public void sort(){
        if (head == null || head.next == null) {
                return; // List is empty or has only one element, no need to sort
            }

            Node current = head;
            while (current != null) {
                Node index = current.next;
                while (index != null) {
                    if (current.data.compareTo(index.data) > 0) {
                        // Swap the data of the nodes
                        String temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        return sb.toString();
    }
    public void remove(String string){
        Node current = head;
        while (current != null) {
            if (current.data.equalsIgnoreCase(string)) {
                if (current.prev != null) current.prev.next = current.next;
                else head = current.next;
                if (current.next != null) current.next.prev = current.prev;
                else tail = current.prev;
                return;
            }
            current = current.next;
        }
        System.out.println("Item not found: " + string);


    }
    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public String get(int num) {
        int count = 0;
        Node current = head;
        while (current != null) {
            if (count == num) return current.data;
            count++;
            current = current.next;
        }
        throw new IndexOutOfBoundsException("Index: " + num + ", Size: " + count);
    }

    public String next() {
        if (cursor != null && cursor.next != null) {
            cursor = cursor.next;
            return cursor.data;
        }
        return null; // already at end
    }

    public String previous() {
        if (cursor != null && cursor.prev != null) {
            cursor = cursor.prev;
            return cursor.data;
        }
        return null; // already at start
    }

}
