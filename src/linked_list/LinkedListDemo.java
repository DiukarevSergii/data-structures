package linked_list;

public class LinkedListDemo {
    public static void main(String[] args) {
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.add("First element");
        linkedList.add("Second element");
        linkedList.add("Third element");
        linkedList.add("4 element");
        linkedList.add("5 element");
        linkedList.add("6 element");
        linkedList.add("7 element");
        linkedList.add("8 element");
        linkedList.add("9 element");

        for (String node: linkedList){
            System.out.println(node);
        }
    }

}
