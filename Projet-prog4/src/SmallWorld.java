import java.util.*;

public class SmallWorld extends Graphe {

    public SmallWorld(int n, int d) {
        super();

        if (n <= 0) {
            throw new IllegalArgumentException("n doit être > 0");
        }

        if (d < 1 || d > (n - 1) / 2) {
            throw new IllegalArgumentException("d doit vérifier 1 ≤ d ≤ (n-1)/2");
        }

        // Création des n sommets
        for (int i = 0; i < n; i++) {
            this.addNode(i);
        }

        // Génération du graphe en anneau
        for (int i = 0; i < n; i++) {

            for (int j = 1; j <= d; j++) {

                int voisin = (i + j) % n;

                this.addArc(i,voisin);
            }
        }
    }

     public SmallWorld(int n, int d, double p) {

        this(n, d); // construit d'abord le ring

        if (p <= 0 || p >= 1)
            throw new IllegalArgumentException("0 < p < 1");

        Random random = new Random();

        for (int v = 0; v < n; v++) {

            for (int j = 1; j <= d; j++) {

                int x = (v + j) % n;

                double r = random.nextDouble();

                if (r < p) {

                    int newNode;

                    // choisir un sommet valide
                    do {
                        newNode = random.nextInt(n);
                    } while (newNode == v ||
                             this.getNode(v).hasSuccesseur(newNode));

                    // supprimer ancienne arête
                    this.removeArc(v, x);

                    // ajouter nouvelle arête
                    this.addArc(v,newNode);
                }
            }
        }
     }
}