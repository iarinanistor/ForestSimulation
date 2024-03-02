import java.util.ArrayList;

public class Foret{
  private Object terrain[][];
  public Foret(int taille){
    terrain = new Object[taille][taille];
  }
  
  public boolean placer(Object obj){
    int x,y;
    x = (int)(Math.random()*(terrain.length));
    y = (int)(Math.random()*(terrain.length));
    if (terrain[x][y]==null) {
      terrain[x][y] = obj;
      return true;
    } 
    return false;
  }
  
  public String toString(){
    String s= "";
    for (int i=0; i<(terrain.length) ; i++){
      for (int j=0; j<(terrain.length+2) ; j++){
        if (j==0){
          s+="|";
        }
        else if (j==(terrain.length+1)){
          s+="|\n";
        }
        else {
          if (terrain[i][j-1] == null) {
            s+="   ";
          }else {
            s+= " "+terrain[i][j-1].toString().charAt(0)+" ";
          }
        }  
      }
    }
    return s;
  }
  
  public ArrayList<Champignon> ramasserChampignons() {
    ArrayList<Champignon> li = new ArrayList<>();
    for (int i=0; i < terrain.length; i++){
      for (int j=0; j < terrain.length; j++){
        Object o = terrain[i][j];
        if ( o instanceof Champignon ){
          li.add((Champignon)o);
          terrain[i][j] = null;
        }
      }
    }
    return li;
  }
  
  public ArrayList<Ramassable> ramasserTout(){
    ArrayList<Ramassable> li = new ArrayList<>();
    for (int i=0; i < terrain.length; i++){
      for (int j=0; j < terrain.length; j++){
        Object o = terrain[i][j];
        if ( o instanceof Ramassable ){
          li.add((Ramassable)o);
          terrain[i][j] = null;
        }
      }
    }
    return li;
  }
  
  public void ramasser(Panier p){
    for (int i=0; i < terrain.length; i++){
      for (int j=0; j < terrain.length; j++){
        Object o = terrain[i][j];
        if ( o instanceof Ramassable ){
          if (p.add((Ramassable)o)) terrain[i][j] = null;
        }
      }
    }
  }
  
}
