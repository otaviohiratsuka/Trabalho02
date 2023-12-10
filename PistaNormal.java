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
    
    private int tempo_total_aterrisage1;
    private int tempo_total_aterrisage2;

    private int tempo_total_decolagem1;
    private int tempo_total_decolagem2;

    //private int tempo_total_prioridade;



    public PistaNormal(){
        aterrisagem_1 = new ArrayList<Aviao>();
        aterrisagem_2 = new ArrayList<Aviao>();
        decolagem_1 = new ArrayList<Aviao>();
        decolagem_2 = new ArrayList<Aviao>();
        prioritario = new ArrayList<Aviao>();
        this.suporte_aterrisagem = new ArrayList<Aviao>();
        this.suporte_decolagem = new ArrayList<Aviao>();
        this.tempo_total_aterrisage1 = 0;
        this.tempo_total_aterrisage2 = 0;
        this.tempo_total_decolagem1 = 0;
        this.tempo_total_decolagem2 = 0;    
        //this.tempo_total_prioridade = 0;

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
   public void setPrioritario(List<Aviao> av){
        prioritario = av;
   }
   

    public void verificarPrioritario() {
        List<Aviao> copiaAterrisagem1 = new ArrayList<Aviao>(aterrisagem_1);
        List<Aviao> copiaAterrisagem2 = new ArrayList<Aviao>(aterrisagem_2);

        for (Aviao aux : copiaAterrisagem1) {
            if (aux.getReservas_minutos() <= limite_combustivel) {
                prioritario.add(aux);
                aterrisagem_1.remove(aux);
            }
        }
    
        for (Aviao aux : copiaAterrisagem2) {
            if (aux.getReservas_minutos() <= limite_combustivel) {
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


    public void setSuporteAterrisagem(List<Aviao> av){
        suporte_aterrisagem = av;
    }


    public void suporteAterrisagem() {
        if (aterrisagem_1.size() > aterrisagem_2.size()){
            if (!aterrisagem_1.isEmpty()) {
                suporte_aterrisagem.add(aterrisagem_1.get(0));
                aterrisagem_1.remove(0);
                tempo_total_aterrisage1++;
            }

        }
        else{
            if (!aterrisagem_2.isEmpty()) {
                suporte_aterrisagem.add(aterrisagem_2.get(0));
                aterrisagem_2.remove(0);
                tempo_total_aterrisage2++;
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

    public void setSuporteDecolagem(List<Aviao> av){
        this.suporte_decolagem = av;
    }

    public void suporteDecolagem() {
        if (decolagem_1.size() > decolagem_2.size()){
            if (!decolagem_1.isEmpty()) {
                suporte_decolagem.add(decolagem_1.get(0));
                decolagem_1.remove(0);
                tempo_total_decolagem1++;
            }
        }
        else{
            if (!decolagem_2.isEmpty()) {
                suporte_decolagem.add(decolagem_2.get(0));
                decolagem_2.remove(0);
                tempo_total_decolagem2++;
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
    

    public int getTempoTotalAterrisage1(){
        return this.tempo_total_aterrisage1;
    }
    public int getTempoTotalAterrisage2(){
        return this.tempo_total_aterrisage2;
    }
    public int getTempoTotalDecolagem1(){
        return this.tempo_total_decolagem1;
    }
    public int getTempoTotalDecolagem2(){
        return this.tempo_total_decolagem2;
    }


}