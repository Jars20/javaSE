package club.banyuan;

public class LinkedList implements List {

    private Node head = new Node();
    private Node tail = head;
    private int size = 0;

    @Override
    public Object set(int index, Object element) {
        Node cur = search(index);
        Node node = new Node();
        node.setNext(cur.getNext());
        node.setPrev(cur.getPrev());
        node.getPrev().setNext(node);
        if (node.getNext() != null) {
            node.getNext().setPrev(node);
        }
        cur.setPrev(null);
        cur.setNext(null);
        return cur.getData();
    }

    @Override
    public Object get(int index) {
        Node cur = search(index);
        return cur.getData();
    }

    @Override
    public void clear() {
        head = new Node();
        tail = head;
        size = 0;

    }

    @Override
    public Object remove(int index) {
        Node node = search(index);
        if (node != null) {
            delete(node);
            size--;
            return node.getData();
        }
        return null;
    }

    @Override
    public boolean remove(Object element) {
        Node node;
        node = head.getNext();
        while (node != null) {
            if (node.getData() == element) {
                delete(node);
                size--;
                return true;
            }
            node = node.getNext();
        }
        System.out.println("找不到该元素");
        return false;
    }


    @Override
    public boolean add(Object o) {
        Node node = new Node();
        node.setData(o);
        node.setPrev(tail);
        tail.setNext(node);
        tail = node;
        size++;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    //通过下标寻找位置
    private Node search(int index) {
        if (index >= size) {
            System.out.println("下标不合法");
            return null;
        }
        int count = index;
        Node cur = head;
        while (count != -1) {
            cur = cur.getNext();
            count--;
        }
        return cur;

    }

    //删除当前位置结点
    private void delete(Node node) {
        if (node == tail) {
            tail = node.getPrev();
            tail.setNext(null);
            node.setPrev(null);
        } else {
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
            node.setNext(null);
            node.setPrev(null);
        }
    }


}
