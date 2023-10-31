public abstract class ListItem {

    protected ListItem leftLink;
    protected ListItem rightLink;
    protected Object value;

    public ListItem(Object value){
        leftLink = null;
        rightLink = null;
        this.value = value;
    }

    protected abstract ListItem next();
    protected abstract ListItem setNext(ListItem item);
    protected abstract ListItem previous();
    protected abstract ListItem setPrevious(ListItem item);

    protected abstract int compareTo(ListItem item);


    public Object getValue(){
        return value;
    }

    public void setValue(Object value){
        this.value = value;
    }
}