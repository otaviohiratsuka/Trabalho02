import java.util.ArrayList;
import java.util.List;

public class PistaNormal{
    private int limite_combustivel = 5;
    private List<Aviao> decolagem_1;
    private List<Aviao> decolagem_2;

    private List<Aviao> aterrisagem_1;
    private List<Aviao> aterrisagem_2;

    private List<Aviao> suporte_decolagem;
    private List<Aviao> suporte_aterrisagem;

    private List<Aviao> prioritario; // percorrer 1 e 2, procurar risco(abaixo de 3min)
    
    public PistaNormal(){
        this.aterrisagem_1 = new ArrayList<Aviao>();
        this.aterrisagem_2 = new ArrayList<Aviao>();
        this.decolagem_1 = new ArrayList<Aviao>();
        this.decolagem_2 = new ArrayList<Aviao>();
        this.prioritario = new ArrayList<Aviao>();
        this.suporte_aterrisagem = new ArrayList<Aviao>();
        this.suporte_decolagem = new ArrayList<Aviao>();

    }

    //adicionará o avião na pista de aterrisagem que tenha menos aviao
    public void addAviaoAterrisagem(Aviao av){
        if(aterrisagem_1.size() > aterrisagem_2.size()){
            aterrisagem_2.add(av);
        }
        else{
            aterrisagem_1.add(av);
        }
    }

    //adicionará o avião na pista de decolagem que tenha menos aviao
    public void addAviaoDecolagem(Aviao av){
        if(decolagem_1.size() > decolagem_2.size()){
            decolagem_2.add(av);
        }
        else{
            decolagem_1.add(av);
        }
    }

    //verifica as duas lista de aterrisagem pata ver sem tem pouco tempo
    public void verificarPrioritario() {

        List<Aviao> copiaAterrisagem1 = new ArrayList<Aviao>(aterrisagem_1);
        List<Aviao> copiaAterrisagem2 = new ArrayList<Aviao>(aterrisagem_2);
        List<Aviao> copiaPrioritario = new ArrayList<Aviao>(prioritario);

        for (Aviao aux : copiaAterrisagem1) {
            if (aux.getNumero_passageiro() <= limite_combustivel) {
                prioritario.add(aux);
                aterrisagem_1.remove(aux);
            }
        }
    
        for (Aviao aux : copiaAterrisagem2) {
            if (aux.getNumero_passageiro() <= limite_combustivel) {
                prioritario.add(aux);
                aterrisagem_2.remove(aux);
            }
        }

        for (Aviao aux : copiaPrioritario) {
            if (aux.getNumero_passageiro() <= limite_combustivel) {
                prioritario.add(aux);
                aterrisagem_2.remove(aux);
            }
        }
    }
    
    public List<Aviao> getPrioritario(){
        return prioritario;
    }

    public int totalAterrisagem(){
        return (aterrisagem_1.size()+aterrisagem_2.size());
    }

    public int totalDecolagem(){
        return (decolagem_1.size()+decolagem_2.size());
    }

    public void diminuirTempoAterrisagem(){
        for (Aviao aux : aterrisagem_1) {
            int num = aux.getReservas_minutos();
            aux.setReservas_minutos(num-1);
        }
        for (Aviao aux : aterrisagem_2) {
            int num = aux.getReservas_minutos();
            aux.setReservas_minutos(num-1);
        }
    }

    public void suporteAterrisagem() {
        if (aterrisagem_1.size() > aterrisagem_2.size()){
            if (!aterrisagem_1.isEmpty()) {
                suporte_aterrisagem.add(aterrisagem_1.get(0));
                aterrisagem_1.remove(0);
            }
        }
        else{
            if (!aterrisagem_2.isEmpty()) {
                suporte_aterrisagem.add(aterrisagem_2.get(0));
                aterrisagem_2.remove(0);
            } 
        }

    }
    public void removerSuporteAterrisagem(Aviao av){
        suporte_aterrisagem.remove(av);
    }
    public void removerSuporteAterrisagem(){
        suporte_aterrisagem.remove(0);
    }
    public List<Aviao> getSuporteAterrisagem(){
        return suporte_aterrisagem;
    }

    public void suporteDecolagem() {
        if (decolagem_1.size() > decolagem_2.size()){
            if (!decolagem_1.isEmpty()) {
                suporte_decolagem.add(decolagem_1.get(0));
                decolagem_1.remove(0);
            }
        }
        else{
            if (!decolagem_2.isEmpty()) {
                suporte_decolagem.add(decolagem_2.get(0));
                decolagem_2.remove(0);
            } 
        }
    }
    public void removerSuporteDecolagem(Aviao av){
        suporte_decolagem.remove(av);
    }
    public void removerSuporteDecolagem(){
        suporte_decolagem.remove(0);
    }
    public List<Aviao> getSuporteDecolagem(){
        return suporte_decolagem;
    }


    public List<Aviao> getDecolagem_1() {
        return decolagem_1;
    }

    public List<Aviao> getDecolagem_2() {
        return decolagem_2;
    }

    public List<Aviao> getAterrisagem_1() {
        return aterrisagem_1;
    }

    public List<Aviao> getAterrisagem_2() {
        return aterrisagem_2;
    }

}