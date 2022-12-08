public class DivideAndConquer {

    public static void main(String[] args) {
        System.out.println("Puissance rapide :" + puissanceRapide(5, 0));
    }

    static int puissanceRapide(int x, int n) {
        if (n % 2 == 0) {
            int res = Intro2Recursive.puiss(x, n / 2);
            return res * res;
        } else {
            int res = Intro2Recursive.puiss(x, (n - 1) / 2);
            return res * res * x;
        }
    }

    public static void quickSortAux(int[] t, int i, int j) {
        if (i < j) {
            int pivot = pivot(t, i, j);
            quickSortAux(t, i, pivot - 1);
            quickSortAux(t, pivot + 1, j);
        }
    }

    public static void quickSort(int[] t) {
        quickSortAux(t, 0, t.length - 1);
    }

    public static void echange(int[] t, int i, int j) {
        int a = t[i];
        t[i] = t[j];
        t[j] = a;
    }

    public static int pivot(int[] t, int i, int j) {
        int pivot = t[j];
        int c = i;
        for (int l = i; l < j; l++) {
            if (t[l] <= pivot) {
                echange(t, c, l);
                c++;
            }
        }
        echange(t, c, j);
        return c;
    }
}
