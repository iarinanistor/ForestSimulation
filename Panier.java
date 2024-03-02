import java.util.ArrayList;
public class Panier extends ArrayList<Ramassable> {
  private double poidsMax;
  public Panier(int pm){
    poidsMax = pm;
  }
  
  public double getPoids(){
    double poids = 0;
    for (Ramassable r : this){
      poids+=r.getPoids();
    }
    return poids;
  }
  
  @Override
  public boolean add(Ramassable r){
    if ((this.getPoids()+r.getPoids())>poidsMax) {
      return false;
    } else {
      this.add(0,r);
      System.out.println(r.toString()+" est ajoute au panier");
      return true;
    }
  }
  
  public int compterToxiques(){
    int cpt = 0;
    for (Ramassable r : this){
      if (r instanceof Toxique){
        cpt++;
      }
    }
    return cpt;
  }
  
  public String toString(){
    int cpt = this.size();
    int cpt_tox = this.compterToxiques();
    return "Panier contenant "+cpt+" objets, dont "+cpt_tox+" toxiques";
  }
  
  
  
}
