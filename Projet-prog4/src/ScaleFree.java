import java.util.*;

public class ScaleFree extends Graphe {

    public ScaleFree(int n, int d) {
        super();

        if (n <= 0)
            throw new IllegalArgumentException("n > 0 requis");

        if (d < 1)
            throw new IllegalArgumentException("d ≥ 1 requis");

        // Création des n sommets
        for (int i = 0; i < n; i++) {
            addNode(i);
        }

        int[] M = new int[2 * n * d];
        Random random = new Random();

        for (int v = 0; v < n; v++) {

            for (int i = 0; i < d; i++) {

                int index = v * d + i;

                // source
                M[2 * index] = v;

                if (v == 0) {
                    // premier sommet : pas de prédécesseur
                    M[2 * index + 1] = 0;
                } else {

                    int r = random.nextInt(2 * index);
                    M[2 * index + 1] = M[r];
                }
            }
        }

        // Construction des arcs
        for (int i = 0; i < n * d; i++) {

            int source = M[2 * i];
            int cible = M[2 * i + 1];

            if (source != cible) {
                addArc(source, cible);
            }
        }
    }
}