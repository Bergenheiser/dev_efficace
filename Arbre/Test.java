

import java.util.*;


public class Test {
    public static void printTest(String msg, boolean b){
        System.out.println("test : "+(b?" ok":" KO") + " (" + msg + ")");
    }

    public static ABR construitArbre0(){
        ABR a= new ABR();
        a.setVal(5);
        a.setFilsD(new ABR(10,new ABR(),new ABR()));
        a.setFilsG(new ABR());
        return a;
    }

    public static ABR construitArbre1(){
        ABR a= new ABR();
        a.insert(10);
        a.insert(5);
        a.insert(1);
        a.insert(20);
        a.insert(15);
        a.insert(30);
        a.insert(40);
        a.insert(8);
        return a;
    }

    public static boolean contientTous(ABR a, int[] t){
        boolean res = true;
        int i=0;
        while(res && i < t.length){
            res = res && a.recherche(t[i]);
            i++;
        }
        return res;
    }
    public static void testRecherche(){
        ABR a = construitArbre1();
        printTest("testRecherche1", a.recherche(20));
        printTest("testRecherche2", a.recherche(8));
        printTest("testRecherche3", !a.recherche(0));
        printTest("testRecherche4", !a.recherche(16));
    }



    public static void testSuppr1() {
        ABR a = construitArbre1();
        a.suppr(1);
        int[] set = {5,8,10,15,20,30,40};
        printTest("testsuppr1", !a.recherche(1) && contientTous(a,set));
    }

    public static void testSuppr2() {
        ABR a = construitArbre1();
        a.suppr(10);
        int[] set = {1,5,8,15,20,30,40};
        printTest("testsuppr2", !a.recherche(10) && contientTous(a,set));
    }
    public static void testSuppr3() {
        ABR a = construitArbre1();
        a.suppr(20);
        int[] set = {1,5,8,10,15,30,40};
        printTest("testsuppr3", !a.recherche(20) && contientTous(a,set));
    }
    public static void testVerifie1() {
        ABR a = construitArbre1();
        printTest("testVerifie1", a.verifie());
    }

    public static void testVerifie2() {
        ABR a = construitArbre1();
        a.getFilsD().getFilsG().setVal(9);//plus un abr
        printTest("testVerifie2", !a.verifie());
    }

    public static void main(String[] args){
        ABR a0 = construitArbre0();
        System.out.println(a0);
        ABR a = construitArbre1();
        System.out.println(a);
        testRecherche();
        testSuppr1();
        testSuppr2();
        testSuppr3();
        testVerifie1();
        testVerifie2();

    }

}
