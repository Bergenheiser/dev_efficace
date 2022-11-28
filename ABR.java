import java.util.Objects;


public class ABR {
    private int val;
    private ABR filsG;
    private ABR filsD;
    //fisG == null <=> filsD == null

    ///////////////////////////////////////////////////////
    ////// méthodes fournies
    ///////////////////////////////////////////////////////

    public ABR() {
        filsG = null;
        filsD = null;
    }

    public ABR(int x, ABR g, ABR d) {
        val = x;
        filsG = g;
        filsD = d;
    }


    public boolean estVide() {
        return filsG == null;
    }

    public boolean egal(ABR a) {
        if (estVide() != a.estVide())
            return false;
        if (estVide())
            return true;
        //les 2 non vides
        return val == a.val && filsG.egal(a.filsG) && filsD.egal(a.filsD);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ABR abr = (ABR) o;
        return this.egal(abr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, filsG, filsD);
    }

    public String toStringV2aux(String s) {
        //pre : aucun
        //resultat : retourne une chaine de caracteres permettant d'afficher this dans un terminal (avec l'indentation du dessin precedent, et en ajoutant s au debut de chaque ligne ecrite) et passe a la ligne

        if (estVide())
            return s + "()\n";
        else
            return filsD.toStringV2aux(s + "     ") + s + val + "\n" + filsG.toStringV2aux(s + "     ");
    }

    public String toString() {
        return toStringV2aux("");
    }

    ///////////////////////////////////////////////////////
    ////// méthodes demandées dans le TP
    ///////////////////////////////////////////////////////

    public boolean recherche(int x) {
        if (estVide()) {
            return false;
        }
        if (x == val) {
            return true;
        }
        if (x < val) {
            return filsG.recherche(x);
        } else {
            return filsD.recherche(x);
        }

    }

    public void insert(int x) {
        if (estVide()) {
            val = x;
            filsG = new ABR();
            filsD = new ABR();
        } else {
            if (x <= val) {
                filsG.insert(x);
            } else {
                filsD.insert(x);
            }
        }
    }

    public Liste toListeTriee() {
        if (estVide()) {
            return new Liste();
        } else {
            Liste l = new Liste(filsG.toListeTriee());
            l.concat(new Liste(val, filsD.toListeTriee()));
            return l;
        }
    }

    public void toListeTrieeV2aux(Liste l) {
        if (!estVide()) {
            filsD.toListeTrieeV2aux(l);
            l.ajoutTete(val);
            filsG.toListeTrieeV2aux(l);
        }
    }

    public Liste toListeTrieeV2() {
        //version cliente qui est donc O(n)
        Liste res = new Liste();
        toListeTrieeV2aux(res);
        return res;
    }

    public ABR(Liste l) {
        new ABR();
        while (!l.estVide()) {
            this.insert(l.get(0));
            l.supprimeTete();
        }
    }


    public int max() {
        //retourne l'entier max de this (et -infini si vide)
        if (estVide()) {
            return Integer.MIN_VALUE;

        }
        if (!filsD.estVide()) {
            filsD.max();
        }
        setFilsD(null);
        setFilsG(null);
        return val;
    }


    public void suppr(int x) {
        //supprime x de this, et ne fait rien si x n'est pas présent
        if (!estVide()) {
            if (x < val) {
                filsG.suppr(x);
            } else if (x > val) {
                filsD.suppr(x);
            } else {
                if (filsD.estVide()) {
                    val = filsG.getVal();
                    filsD = filsG.getFilsD();
                    filsG = filsG.getFilsG();
                }
                if (filsG.estVide()) {
                    val = filsD.getVal();
                    filsG = filsD.getFilsG();
                    filsD = filsD.getFilsD();
                } else {
                    int m = filsG.max();
                    val = m;
                    filsG.suppr(m);
                }
            }

        }
    }

    public boolean verifie() {
        //prérequis : this est bien un arbre (au sens de la classe Arbre : soit les deux fils null, soit les deux fils non null)
        throw new RuntimeException("méthode non implémentée");
    }

    public boolean verifABR(int m, int M) {
        //prérequis : this est bien un arbre (au sens de la classe Arbre : soit les deux fils null, soit les deux fils non null)
        throw new RuntimeException("méthode non implémentée");
    }

    public int[] verifABRV2() {
        //prérequis : this est bien un arbre (au sens de la classe Arbre : soit les deux fils null, soit les deux fils non null)
        throw new RuntimeException("méthode non implémentée");
    }


    ///////////////////////////////////////////////////////
    ////// méthodes utiles seulement pour les tests
    ///////////////////////////////////////////////////////


    public int getVal() {
        return val;
    }

    public ABR getFilsG() {
        return filsG;
    }

    public ABR getFilsD() {
        return filsD;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setFilsG(ABR filsG) {
        this.filsG = filsG;
    }

    public void setFilsD(ABR filsD) {
        this.filsD = filsD;
    }

    public static void main(String[] args) {


    }

}
