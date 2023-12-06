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

    public void setDecolagem(List<Aviao> decolagem) {
        this.decolagem = decolagem;
    }

    public List<Aviao> getAterrisagem() {
        return aterrisagem;
    }

    public void setAterrisagem(List<Aviao> aterrisagem) {
        this.aterrisagem = aterrisagem;
    }
}

    
