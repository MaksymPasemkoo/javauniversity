package practice.linkedlist;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> tail;
    private int length;

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    public LinkedList(T value){
        Node<T> newNode = new Node<>(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public LinkedList() {

    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node<T> current = head;
            @Override
            public boolean hasNext() {
                return current.next != null;
            }

            @Override
            public T next() {
                if (current == null) {
                    throw new NoSuchElementException();
                }
                T value = current.value;

                current = current.next;

                return value;
            }
        };
    }

    public void printList(){
        for (T temp : this) {
            System.out.println(temp);
        }
    }

    public void append(T value){
        Node<T> newNode = new Node<>(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }
    public Node<T> removeLast(){
        Node<T> temp = head;
        Node<T> pre = head;
        if(length == 0) return null;
        while(temp.next != null){
            pre = temp;
            temp = temp.next;
        }
        pre.next = null;
        tail = pre;
        length--;
        if(length == 0){
            tail = null;
            head = null;
        }
        return temp;
    }

    public void prepend(T value){
        Node<T> newNode = new Node<>(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node<T> removeFirst(){
        Node<T> temp = head;
        if(length == 0) return null;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0){
            tail = null;
        }
        return temp;
    }

    public Node<T> get(int index){
        Node<T> temp = head;
        if(index < 0 || index >= length) return null;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index,T value){
        Node<T> temp = get(index);
        if(temp == null) return false;
        temp.value = value;
        return true;
    }

    public boolean insert(int index,T value){
        Node<T> newNode = new Node<>(value);
        Node<T> temp = get(index - 1);
        if(index < 0 || index > length) return false;
        if(length == 0){
            prepend(value);
            return true;
        }
        if(index == length){
            append(value);
            return true;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node<T> remove(int index){
        Node<T> pre = get(index - 1);
        Node<T> temp = pre.next;

        if(index < 0 || index >= length) return null;
        if(index == 0) return removeFirst();
        if(index == length - 1 ) return removeLast();

        pre.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }


}




