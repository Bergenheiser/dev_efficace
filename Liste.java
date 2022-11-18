class Liste {
    private int val;
    private Liste suiv;

    //choix : 

    //liste vide =_def (*,null)

    //////////////////////////////////////////////
    //////// méthodes fournies
    //////////////////////////////////////////////

    public Liste() {
        suiv = null;
    }

    public Liste(Liste l) {
        if (l.estVide()) {
            suiv = null;
        } else {
            val = l.val;
            suiv = new Liste(l.suiv);
        }
    }

    public Liste(int x, Liste l) {
        val = x;
        suiv = new Liste(l);
    }

    public void ajoutTete(int x) {
        Liste aux = new Liste();
        aux.val = val;
        aux.suiv = suiv;
        val = x;
        suiv = aux;
    }

    public void supprimeTete() {
        //sur liste non vide
        val = suiv.val;
        suiv = suiv.suiv;
    }

    public boolean estVide() {
        return suiv == null;
    }


    public String toString() {
        if (estVide()) {
            return "";
        } else {
            return val + " " + suiv.toString();
        }
    }


    //////////////////////////////////////////////
    //////// méthodes du TD
    //////////////////////////////////////////////

    public int longueur() {
        return this.estVide() ? 0 : 1 + this.suiv.longueur();
    }

    public int somme() {
        return this.estVide() ? 0 : this.val + this.suiv.somme();
    }

    public boolean croissant() {
        if (this.estVide()) {
            return true;
        } else {
            return this.val <= this.suiv.val && this.suiv.croissant();
        }
    }

    public int get(int i) {
        if (i == 0) {
            return this.val;
        } else {
            return this.suiv.get(i - 1);
        }
    }

    public void ajoutFin(int x) {
        if (this.estVide()) {
            ajoutTete(x);
        } else {
            this.suiv.ajoutFin(x);
        }
    }
    public void concat(Liste l){
        if(suiv.estVide()){
            this.suiv=l;
        }
        else{
            this.suiv.concat(l);
        }
    }

    public static void main(String[] arg) {
        Liste l = new Liste();
        l.ajoutTete(4);
        l.ajoutTete(3);
        l.ajoutTete(4);
        l.ajoutTete(2);
        l.ajoutTete(1);
        l.ajoutTete(1);
        l.ajoutTete(1);
        l.ajoutTete(2);
        //Exercice 1
        System.out.println(l.longueur());
        System.out.println(l.somme());
        System.out.println(l);
        System.out.println(l.get(4));
        //Exercice 2
        Liste l2 = new Liste();
        System.out.println(l);
        l2.ajoutTete(4);
        l2.ajoutTete(3);
        l2.ajoutTete(4);
        l2.ajoutTete(2);
        l2.ajoutTete(1);
        l2.ajoutTete(1);
        l2.ajoutTete(1);
        l2.ajoutTete(2);
        l2.ajoutFin(10);
        l.concat(l2);
        System.out.println(l);



    }

}
