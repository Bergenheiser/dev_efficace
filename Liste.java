class Liste{
    private int val;
    private Liste suiv;
    
    //choix : 

    //liste vide =_def (*,null)
 
    //////////////////////////////////////////////
    //////// méthodes fournies
    //////////////////////////////////////////////
    
    public Liste(){
	suiv = null;
    }

    public Liste(Liste l){
	if(l.estVide()){
	    suiv=null;
	}
	else{
	    val = l.val;
	    suiv = new Liste(l.suiv);
	}
    }

    public Liste(int x, Liste l){
	val = x;
	suiv = new Liste(l);
    } 

    public void ajoutTete(int x){
	Liste aux = new Liste();
	aux.val = val;
	aux.suiv = suiv;
	val = x;
	suiv = aux;
    }

    public void supprimeTete(){
	//sur liste non vide
	val = suiv.val;
	suiv = suiv.suiv;
    }

    public boolean estVide(){
	return suiv==null;
    }



    public String toString(){
	if(estVide()){
	    return "";
	}
	else{
	    return val+" "+suiv.toString();
	}
    }


    //////////////////////////////////////////////
    //////// méthodes du TD
    //////////////////////////////////////////////
    
    

    public static void main(String[] arg){
	Liste l = new Liste();
	l.ajoutTete(4);
	l.ajoutTete(3);
	l.ajoutTete(4);
	l.ajoutTete(2);
	l.ajoutTete(1);
	l.ajoutTete(1);
	l.ajoutTete(1);
	l.ajoutTete(2);
	System.out.println(l);


    }
}
