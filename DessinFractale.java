class DessinFractale{
    private final Turtle bob;
    
    private final static int LARGEUR = 800;
    private final static int HAUTEUR = 600;
    //taille de la fenetre graphique

    public DessinFractale(){
	bob  = new Turtle();
	Turtle.setCanvasSize(LARGEUR,HAUTEUR);//à appeler APRES création de la tortue
    }

    public DessinFractale(int v){
	//attention, plus v est grand, plus bob va lentement !
	this();
	bob.speed(v);
    }


    public void reset(){
	bob.clear();
	bob.up();
	bob.setPosition(0,0);
	bob.setDirection(0);
	bob.down();

    }

    public void close(){
	bob.exit();
    }


    public void carre(double l){
	 bob.down();
	 for(int i =0;i<=3;i++){
		 bob.forward(l);
		 bob.left(90);
	 }
	 bob.up();
    }

	public void vonKoch(double l,int n){
		bob.down();
		if(n==0){
			bob.forward(l);
		}
		else{
			vonKoch(l/3,n-1);
			bob.left(60);
			vonKoch(l/3,n-1);
			bob.right(120);
			vonKoch(l/3, n-1);
			bob.left(60);
			vonKoch(l/3,n-1);
		}
		bob.up();
	}

	public void arbre(double l, int n){
		bob.down();
		if (n==0){
			bob.forward(l);
		}
		else{
			bob.forward(0.66*l);
			bob.left(45);
			arbre(l/3,n-1);
			bob.backward(l/3);
			bob.right(90);
			arbre(l/3,n-1);
			bob.backward(l/3);
			bob.left(45);
			arbre(l/3,n-1);
		}
		bob.up();
	}



    public static void main(String[] args){
	DessinFractale d = new DessinFractale(500);
	d.arbre(100,2);
	d.close();
    }
    
}
