import java.util.List;

public interface NodeList {

    // public abstract method:
    ListItem getRoot();
    boolean addItem(ListItem item);
    boolean removeItem(ListItem item);
    void tranverse(ListItem root);


}
