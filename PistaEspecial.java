import java.util.ArrayList;
import java.util.List;

public class PistaEspecial {
    private List<Aviao> decolagem;
    private List<Aviao> aterrisagem;

    public PistaEspecial(){
        decolagem = new ArrayList<Aviao>();
        aterrisagem = new ArrayList<Aviao>();
    }

    public List<Aviao> getDecolagem() {
        return decolagem;
    }

    public void setDecolagem(Aviao decolagem) {
        this.decolagem.add(decolagem);
    }

    public List<Aviao> getAterrisagem() {
        return aterrisagem;
    }

    public void setAterrisagem(Aviao aterrisagem) {
        this.aterrisagem.add(aterrisagem);
    }
}

    
