import java.util.ArrayList;
import java.util.List;

public class PistaEspecial {
    private List<Aviao> decolagem;
    private List<Aviao> aterrisagem;

    private int tempo_total_decolagem;
    private int tempo_total_aterrisagem;

    public PistaEspecial(){
        decolagem = new ArrayList<Aviao>();

        aterrisagem = new ArrayList<Aviao>();
        tempo_total_decolagem = 0;
        tempo_total_aterrisagem = 0;
    }

    public List<Aviao> getDecolagem() {
        return decolagem;
    }

    public void setDecolagem(Aviao decolagem) {
        this.decolagem.add(decolagem);
    }
    public void setDecolagem(List<Aviao> decolagem) {
        this.decolagem = decolagem;
    }

    public List<Aviao> getAterrisagem() {
        return aterrisagem;
    }

    public void setAterrisagem(Aviao aterrisagem) {
        this.aterrisagem.add(aterrisagem);
    }
    public void setAterrisagem(List<Aviao> aterrisagem) {
        this.aterrisagem = aterrisagem;
    }


    public double getTempoTotalDecolagem(){
        return tempo_total_decolagem;
    }

    public double getTempoTotalAterrissagem(){
        return tempo_total_aterrisagem;
    }
}


    
