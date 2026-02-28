import java.util.*;

public class Node {
    private int id;
    private LinkedList<Arc> succ;
    protected boolean mark;

    public Node(int id){
        this.id = id;
        this.succ = new LinkedList<Arc>();
    }

    public String toString(){
        return "Node " + id + "\n";
    }

    public String toStrings(){
        return "Node " + id + succ.toString()+ "\n";
    } 

    public int getId(){
        return this.id;
    }



    public void addSucc(Arc a){
        this.succ.add(a);
    }

    public boolean hasSuccesseur(int j){
        for(Arc s : succ){
            if(s.getCible().getId() == j){
                return true;
            }
        }
            return false;
    }

    public LinkedList<Arc> getSuccesseurs(){
        return this.succ;
    }

}
    
