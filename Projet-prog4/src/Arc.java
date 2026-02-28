import java.util.*;

public class Arc {
    private Node source;
    private Node cible;

    public Arc(Node source, Node cible){
        this.source=source;
        this.cible=cible;
    }

    public String toString(){
        return "cible : " + cible.toString();
    }

    public Node getCible(){
        return cible;
    }

    public Node getSource(){
        return source;
    }
}
