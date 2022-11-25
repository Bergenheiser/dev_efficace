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

    public Liste(int... elements) {
        this();
        for (int i = 0; i < elements.length; i++) {
            this.ajoutTete(elements[elements.length - 1 - i]);
        }
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

    public void concat(Liste l) {
        if (suiv.estVide()) {
            this.suiv = l;
        } else {
            this.suiv.concat(l);
        }
    }


    //Exercice 3
    public Liste supprOccs(int x) {
        if (this.estVide()) {
            return new Liste();
        } else if (this.val == x) {
            return new Liste(this.suiv.supprOccs(x));
        } else {
            return new Liste(this.val, this.suiv.supprOccs(x));
        }
    }

    public Liste supprOccsV2(int x){
        if(this.estVide()){
            return this;
        }
        else if(this.val==x){
            supprimeTete();
            return this.supprOccsV2(x);
        }
        else {
            return this.suiv.supprOccsV2(x);
        }
    }

    public Liste retourne(){
        if(this.estVide() || this.suiv.estVide()){
            return this;
        }
        Liste tete = this.suiv.retourne();
        this.suiv.suiv=this;
        this.suiv=new Liste();
        return tete;
    }

    public static void main(String[] arg) {
        Liste l = new Liste(4, 3, 4, 2, 1, 1, 1, 2);
        //Exercice 1
        System.out.println("l: "+l);
        System.out.println("longueur l: "+l.longueur());
        System.out.println("somme l: "+l.somme());
        System.out.println("l.get(4): "+l.get(4));
        //Exercice 2
        Liste l2 = new Liste(1, 2, 1, 1, 1, 1, 1, 4, 5, 6, 6, 7, 7, 7, 9);
        //Exercice 3
        System.out.println("l2: "+l2);
        Liste l4 = new Liste(l2);
        Liste l3 = l2.supprOccs(1);
        System.out.println("l3 = l2.SupprOccs(1): "+l3);
        //Exercice 4
        l4.supprOccsV2(1);
        System.out.println("l4 = l2.SupprOccsV2(1): "+l4);
        Liste l5 = new Liste(1,2,3,4,5,6,7,8,9);
        System.out.println("l5: "+l5);
        l5= l5.retourne();
        System.out.println("l5.retourne(): "+l5);


    }

}
