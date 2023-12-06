import java.util.ArrayList;

public class Pista{
    private ArrayList<Aviao> decolagem;
    private ArrayList<Aviao> decolagem1;
    private ArrayList<Aviao> aterrisagem;
    private ArrayList<Aviao> aterrisagem1;
    private ArrayList<Aviao> suporte;
    private ArrayList<Aviao> prioritario; // percorrer 1 e 2, procurar risco(abaixo de 3min)
    private Aviao aviao;

    public Pista(){
        decolagem = new ArrayList<>();
        decolagem1 = new ArrayList<>();
        aterrisagem = new ArrayList<>();
        aterrisagem1 = new ArrayList<>();
        aviao = new Aviao();
    }

    public int comparacao(){
        return ((decolagem.size()<decolagem1.size())?0:1);
    }

    public void adicionarDecolagem(){ //add decolagem (condição maior/ menor)
        if(comparacao() == 0){
            decolagem.add(aviao);
        }
        else{
            decolagem1.add(aviao);
        }        
    }

    public void adicionarAterrisagem(){ //add pouso (condição maior/menor)
        if(comparacao()==0){
            aterrisagem.add(aviao);
      }
      else{
        aterrisagem1.add(aviao);
      }
    }
    


public ArrayList<Aviao> getDecolagem() {
        return decolagem;
    }

    public void setDecolagem(ArrayList<Aviao> decolagem) {
        this.decolagem = decolagem;
    }

    public ArrayList<Aviao> getDecolagem1() {
        return decolagem1;
    }

    public void setDecolagem1(ArrayList<Aviao> decolagem1) {
        this.decolagem1 = decolagem1;
    }

    public ArrayList<Aviao> getAterrisagem() {
        return aterrisagem;
    }

    public void setAterrisagem(ArrayList<Aviao> aterrisagem) {
        this.aterrisagem = aterrisagem;
    }

    public ArrayList<Aviao> getAterrisagem1() {
        return aterrisagem1;
    }

    public void setAterrisagem1(ArrayList<Aviao> aterrisagem1) {
        this.aterrisagem1 = aterrisagem1;
    }

    public ArrayList<Aviao> getSuporte() {
        return suporte;
    }

    public void setSuporte(ArrayList<Aviao> suporte) {
        this.suporte = suporte;
    }

    public ArrayList<Aviao> getPrioritario() {
        return prioritario;
    }

    public void setPrioritario(ArrayList<Aviao> prioritario) {
        this.prioritario = prioritario;
    }
}
