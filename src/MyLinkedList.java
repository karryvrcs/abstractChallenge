import java.util.LinkedList;

// "Root" will always refer to the first object to be listed, so don't forget to update it,
// if necessary, when linking new Node objects.
// If no objects have been "added" by the user, "root" remains null.

public class MyLinkedList implements NodeList{
    private ListItem root;


    // 当创建一个linkedListD的时候，就得有root这个节点了，所以得先创建一个ListItem(Node)，然后赋值到root
    // 在这里，我们直接传入一个listItem作为root
    public MyLinkedList(ListItem item) {
        this.root = item;
    }

    @Override
    public ListItem getRoot() {
        return root;
    }

    // If the head of the tree is null, make the head refer to the item to be added.
    //
    //          If the item to be added is less than the current item in the tree, add the item [before] the current item
    //          (i.e., make the previous item's "next" refer to the new item, and the new item's "next" refer to the current item).
    //
    //          If the item to be added is greater than the current item, move onto the next item and compare again
    //          (if there is no next item, then that is where the new item belongs).
    @Override
    public boolean addItem(ListItem item){
        // Check for the empty listItem first
        // Add the item as the head of the list if it was empty.

        // If the list is not empty, we need to invoke the compareTo method and get the return to determine where the item should be inserted.
        if (this.root == null){
            this.root = item;
            return true;
        }
        ListItem current = root;
        while (current != null){
            int comparison = current.compareTo(item);
            if (comparison < 0){
                // Item is greater, move onto the next item and compare again
                // (if possible, check whether the next exists first!)
                // Current is not the last node, move to the next item.
                if(current.next() != null){
                    current = current.next(); // move for comparing.
                } else {
                    // there is no next node, so insert the item at end of the list
                    current.setNext(item);
                    item.setPrevious(current);
                    return true;
                }

            } else if (comparison > 0){
                // item is less, insert the item [before] the current item (left) (currentItem前面可能已经有一个entry，所以要insert between the entry and currentItem
                if (current.previous() != null){
                    current.previous().setNext(item);
                    item.setPrevious(current.previous());
                    item.setNext(current);
                    current.setPrevious(item);
                } else {
                    item.setNext(current);
                    current.setPrevious(item);
                    root = item; // Insert an entry before the linkedList, so we have to assign the newItem to the root.
                }
                return true;
            } else {
                System.out.println("Already exists");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        Object object = new Object();
        ListItem dummy = new Node(object);
        dummy.setNext(root);
        root.setPrevious(dummy);
        ListItem current = dummy;
        boolean flag = false;
        while (current.next() != null){
            if (current.next().compareTo(item) == 0) {
                current.setNext(current.next().next());
                flag = true;
            } else {
                // move to next node
                current = current.next();
            }
        }
        root = dummy.next();
        return flag;
    }


    // takes the root as an argument and does not return anything.
    // It uses recursion to visit all the branches in the tree (Inorder). Print each value on a separate line.



    @Override
    public void traverse(ListItem root) {
        if (root == null){
            System.out.println("empty");
        }
        while (root != null){
            System.out.println(root.getValue());
            root = root.next();
        }
    }


}
