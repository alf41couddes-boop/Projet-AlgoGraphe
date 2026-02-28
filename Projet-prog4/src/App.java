public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Graphe g1 = new Graphe();

        g1.addNode(1);
        g1.addNode(2);
        g1.addNode(3);
        g1.addNode(4);
        g1.addNode(5);
        g1.addNode(6);
        g1.addNode(7);
        g1.addNode(8);
        g1.addNode(9);



        g1.addArc(4, 9);
        g1.addArc(4, 2);
        g1.addArc(8, 4);
        g1.addArc(8, 2);
        g1.addArc(8, 5);
        g1.addArc(2, 1);
        g1.addArc(1, 5);
        g1.addArc(1, 3);
        g1.addArc(1, 7);
        g1.addArc(1, 6);
        g1.addArc(7, 3);
        g1.addArc(3, 6);
        g1.addArc(7, 6);

        g1.parcours();
        

        System.out.println(g1.toString());
    }
}
