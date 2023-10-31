public class Main {
    public static void main(String[] args) {

        MyLinkedList linkedList = new MyLinkedList(null);
        linkedList.traverse(linkedList.getRoot());

        String stringData = "Darwin Brisbane hello world ABC";

        String[] data = stringData.split(" ");
        for (String element : data){
            linkedList.addItem(new Node(element));
        }

        linkedList.traverse(linkedList.getRoot());

    }
}