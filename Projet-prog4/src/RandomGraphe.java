import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class RandomGraphe extends Graphe {
    private LinkedList<Node> noeuds;
    private HashMap<Integer, Node> hmap;

        public RandomGraphe(int n, double p) {
            super();

            for (int i = 0; i < n; i++) {
                this.addNode(i);
            }
            Random random = new Random();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (i != j) {
                        double r = random.nextDouble();
                        if (r < p) {
                            this.addArc(i,j);
                        }
                    }
                }
            }
        }

    public RandomGraphe(int n, int m) {
        super();

        int maxArcs = n * (n - 1) / 2;

        if (m < 0 || m > maxArcs) {
            throw new IllegalArgumentException("m doit être entre 0 et n(n-1)/2");
        }

        // Création des sommets
        for (int i = 0; i < n; i++) {
            this.addNode(i);
        }

        Random random = new Random();
        HashSet<Integer> arcsChoisis = new HashSet<>();

        while (arcsChoisis.size() < m) {

            int r = random.nextInt(maxArcs);

            if (!arcsChoisis.contains(r)) {

                arcsChoisis.add(r);

                int[] tab = bijection(r);

                int v = tab[0];
                int w = tab[1];

                this.addArc(v,w);
            }
        }
    }

        public int[] bijection(int i) {
            int[] tab = new int[2];

            int v = 1 + (int)Math.floor(-0.5 + Math.sqrt(0.25 + 2 * i));
            int w = i - (v * (v - 1)) / 2;

            tab[0] = v;
            tab[1] = w;

            return tab;
        }

}
