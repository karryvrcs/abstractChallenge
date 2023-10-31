public class Node extends ListItem{

    public Node(Double value){
        super(value);
    }

    @Override
    public ListItem next(){
        return rightLink;
    }

    @Override
    public ListItem setNext(ListItem item){
        this.rightLink = item;
        return next();
    }

    @Override
    public ListItem previous(){
        return leftLink;
    }

    @Override
    public ListItem setPrevious(ListItem item){
        this.leftLink = item;
        return leftLink;
    }

    @Override
    public int compareTo(ListItem item){
        if (item != null){
            // compareTo method can be used to compare two objects to determine their ordering with respect to each other.
            return ((String) getValue()).compareTo((String) item.getValue());
        } else {
            return -1;
        }
    }


}