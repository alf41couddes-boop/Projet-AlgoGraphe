import java.util.*;

public class Graphe {
    private LinkedList<Node> noeuds;
    private HashMap<Integer, Node> hmap;
    

    public Graphe(){
        this.noeuds = new LinkedList<Node>();
        this.hmap = new HashMap<>();
    }

    public Graphe(int k){
        this.noeuds = new LinkedList<Node>();
        this.hmap = new HashMap<Integer, Node>();

        for(int i = 0; i < k ; i++){ 
            Node n = new Node(i);
            this.noeuds.add(n);
            this.hmap.put(i,n);
        }
    }

    public void addNode(int n){
        this.noeuds.add(new Node(n));
    }

    public Node getNode(int n ){
        return this.hmap.get(n);
    }

    public void addArc(int x, int y){
        Node nodex = getNode(x);
        Node nodey = getNode(y);
        if(!nodex.hasSuccesseur(y)){
            nodex.addSucc(new Arc(nodex, nodey));
        }
        
    }

    public String toString(){
        String str = "";
        for (Node n : noeuds){
            str =str + n.toStrings();
        }
        return str;
    }

    public void parcours(){

        for(Node n : noeuds ){
            n.mark = false;
        }
        for(Node n : noeuds){
            if(!n.mark){
                profR(n);
            }
        }

    }
                

    public void profR(Node n){
        n.mark = true;
        System.out.println(n.toString());
        for( Node x : noeuds){
            if(!x.mark){
                profR(x);
            }
        }
    }

    public void profI(){
        for(Node n : noeuds ){
            n.mark = false;
        }
        for(Node n : noeuds){
            if(!n.mark){
                profI(n);
            }
        }
    }

    public void profI(Node n){
        for(Node x : noeuds){
            x.mark = false;
        }
        Stack<Node> pile = new Stack<Node>();
        n.mark = true;
        pile.push(n);
        System.out.println(n);

        while(!pile.isEmpty()){
            Node sommet = pile.peek();
            boolean tousMarques = true;

            for(Arc a : sommet.getSuccesseurs()){
                Node x = a.getCible();
                if(!x.mark){
                    x.mark = true;
                    pile.push(x);
                    System.out.println(x);
                    tousMarques = false;
                    break;
                }
            }
            if(tousMarques){
                pile.pop();
            }
        }
    }

    public void largeur(Node n){
        for(Node x : noeuds){
            x.mark = false;
        }
        LinkedList<Node> file = new LinkedList<>();
        n.mark = true;
        file.addFirst(n);
        System.out.println(n);

        while(!file.isEmpty()){
            Node sommet = file.getLast();
            file.removeLast();

            for(Arc a : sommet.getSuccesseurs()){
                Node x = a.getCible();
                if(!x.mark){
                    x.mark = true;
                    file.addFirst(x);
                    System.out.println(x);
                }
            }
        }
    }

    public void largeur(){
        for(Node n : noeuds ){
            n.mark = false;
        }
        for(Node n : noeuds){
            if(!n.mark){
                largeur(n);
            }
        }
    }

}

