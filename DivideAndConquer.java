public class DivideAndConquer {

    public static void main(String[] args) {
        System.out.println("Puissance rapide :" + puissanceRapide(5, 0));
    }

    static int puissanceRapide(int x, int n) {
        if (n % 2 == 0) {
            int res = Recursive.puiss(x, n / 2);
            return res * res;
        } else {
            int res = Recursive.puiss(x, (n - 1) / 2);
            return res * res * x;
        }
    }

    //Exercice 2 QuickSort

    //Exercice 3 : Fractale

}
