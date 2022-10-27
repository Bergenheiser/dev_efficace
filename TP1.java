public class TP1 {

    public static void main(String[] args) {
        System.out.println(sommesImpairs(5));
        System.out.println(puiss(10, 2));
        int[] tableau = {1, 2, 1, 4, 5};
        System.out.println(nbOccAux(1, tableau, tableau.length - 1));
        int[] tab = {};
        System.out.println(nbOcc(1, tab));
        char[] t = {'a', 'b', 'a'};
        System.out.println(estPalindrome(t));
        int[] tabl = {1, 4, 2, 5, 6};
        int[] tbl2 = {1, 2, 3, 4, 5};
        int[] tbl3 = {};
        System.out.println("expected : false, result : " + estCroissant(tabl));
        System.out.println("expected : true, result : " + estCroissant(tbl2));
        System.out.println("expected : true, result : " + estCroissant(tbl3));
        System.out.println(f(10));
    }

    public static int factorielle(int n) {
        return n == 1 ? 1 : n * factorielle(n - 1);
    }

    public static boolean pair(int n) {
        if (n == 1) {
            return false;
        } else if (n == 0) {
            return true;
        } else {
            return pair(n - 2);
        }
    }

    public static int sommesImpairs(int n) {
        //requires n>=1 && impair
        return n == 1 ? 1 : n + sommesImpairs(n - 2);
    }

    public static int puiss(int x, int n) {
        return n == 1 ? x : n == 0 ? 1 : x * puiss(x, n - 1);
    }

    //Exercice 2

    public static int nbOccAux(int x, int[] t, int i) {
        if (i >= 1) {
            return t[i] == x ? 1 + nbOccAux(x, t, i - 1) : nbOccAux(x, t, i - 1);
        } else {
            return t[i] == x ? 1 : 0;
        }
    }

    public static int nbOcc(int x, int[] t) {
        return t.length != 0 ? nbOccAux(x, t, t.length - 1) : 0;
    }

    public static int nbOccAux2(int x, int[] t, int i) {
        if (i >= t.length) {
            return 0;
        } else {
            if (t[i] == x) {
                return 1 + nbOccAux2(x, t, i + 1);
            } else {
                return nbOccAux2(x, t, i + 1);
            }
        }
    }

    public static boolean estPalindrome(char[] t) {
        return t.length <= 2 || estPalindromeAux(t, 0);
    }

    private static boolean estPalindromeAux(char[] t, int i) {
        if (i == t.length) {
            return t[i - 1] == t[t.length - i];
        } else {
            return t[i] == t[t.length - 1 - i] && estPalindromeAux(t, i + 1);
        }
    }

    public static boolean estCroissant(int[] t) {
        return t.length < 2 || estCroissantAux(t, 0);
    }

    private static boolean estCroissantAux(int[] t, int i) {
        if (i == t.length-1) {
            return t[i - 1] < t[i];
        } else {
            return t[i] < t[i + 1] && estCroissantAux(t, i + 1);
        }
    }

    //8.2 Fibonacci sur les dominos

    public static int f(int i){
        //pré-requis : i>=1
        if(i<2){
            return i;
        }
        else {
            return f(i-1)+f(i-2);
        }
    }


}
