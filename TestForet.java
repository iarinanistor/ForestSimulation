import java.util.ArrayList;
public class TestForet {
  public static void main(String[] args){
    Foret f = new Foret(5);
    
    for (int i=1 ; i <=10 ; i++){
      if (Math.random()<0.3){
        Champignon c = new Champignon("Cepe");
        f.placer(c);
      } else {
        Arbre a = new Arbre("Pin");
        f.placer(a);
      }
    }

    
    
    for (int i=1 ; i <=4 ; i++){
      ChampignonToxique ct = new ChampignonToxique("Toxique");
      f.placer(ct);
    }
    System.out.println(f.toString());
    
    Panier p = new Panier(8);
    f.ramasser(p);
    System.out.println(f.toString());
    System.out.println();
    System.out.println(p.toString());
    
  }
}
