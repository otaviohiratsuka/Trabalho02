import java.util.ArrayList;
import java.util.List;

public class Aeroporto{
    private PistaNormal pista_1;
    private PistaNormal pista_2;
    private PistaEspecial pista_3;

    private List<Aviao> decolagem;
    private List<Aviao> aterrisagem;

    private List<Aviao> prioritario;

    private int aterrissagemEmergenciais;
    private int tempo_total;
    private int quantidade_prioritario;


    public int controlador_decolagem;
    
    
    public Aeroporto(){
        pista_1 = new PistaNormal();
        pista_2 = new PistaNormal();
        pista_3 = new PistaEspecial();

        decolagem = new ArrayList<Aviao>();
        aterrisagem =  new ArrayList<Aviao>();
        prioritario =  new ArrayList<Aviao>();

        aterrissagemEmergenciais = 0;
        controlador_decolagem = 0;
        tempo_total = 0;
        quantidade_prioritario = 0;
    }

    public void adicionarAterrisagem(Aviao av){
        if(pista_1.totalAterrisagem() <= pista_2.totalAterrisagem()){
            pista_1.addAviaoAterrisagem(av);
        }
        else{
            pista_2.addAviaoAterrisagem(av);
        }
    }

    public void adicionarDecolagem(Aviao av){
        if(controlador_decolagem != 3){
            pista_3.setDecolagem(av);
            controlador_decolagem ++;
        }
        else{
            if(pista_1.totalDecolagem()<pista_2.totalDecolagem()){
                pista_1.addAviaoDecolagem(av);
            }
            else{
                pista_2.addAviaoDecolagem(av);
                controlador_decolagem = 0;
            }
        }
    }

    public void atualizarAeroportoNormal(){
        tempo_total ++;
        Aviao aviao_pista3;
        Aviao aviao_pista2;
        Aviao aviao_pista1;


        if(pista_3.getAterrisagem().size()!=0 && pista_3.getAterrisagem().size()<3){
            aviao_pista3 = pista_3.getAterrisagem().get(0);
            pista_3.setAterrisagem(pista_3.getAterrisagem().remove(0));
        }
        else if(pista_3.getAterrisagem().size()>=3){
            atualizarAeroportoNormal_2();
            return;
        }
        else{
            aviao_pista3 = pista_3.getDecolagem().get(0);
            pista_3.setDecolagem(pista_3.getDecolagem().remove(0));
        }



        if (pista_1.getDecolagem_1().size() + pista_1.getDecolagem_2().size() < pista_1.getAterrisagem_1().size() + pista_1.getAterrisagem_2().size()) {
            aviao_pista1 = pista_1.getSuporteAterrisagem().get(0);
            List<Aviao> novaLista = new ArrayList<>(pista_1.getSuporteAterrisagem());
            novaLista.remove(0);
            pista_1.setSuporteAterrisagem(novaLista);
        }
        else{
            aviao_pista1 = pista_1.getSuporteDecolagem().get(0);
            List<Aviao> novaLista = new ArrayList<>(pista_1.getSuporteDecolagem());
            novaLista.remove(0);
            pista_1.setSuporteDecolagem(novaLista);
        }



        if (pista_2.getDecolagem_1().size() + pista_2.getDecolagem_2().size() < pista_2.getAterrisagem_1().size() + pista_2.getAterrisagem_2().size()) {
            aviao_pista1 = pista_2.getSuporteAterrisagem().get(0);
            List<Aviao> novaLista = new ArrayList<>(pista_2.getSuporteAterrisagem());
            novaLista.remove(0);
            pista_2.setSuporteAterrisagem(novaLista);
        }
        else{
            aviao_pista2 = pista_2.getSuporteDecolagem().get(0);
            List<Aviao> novaLista = new ArrayList<>(pista_2.getSuporteDecolagem());
            novaLista.remove(0);
            pista_2.setSuporteDecolagem(novaLista);
        }





    }

     public void atualizarAeroportoNormal_2(){

     }


 
    //o tempo médio de espera para decolagem em cada fila
    public void rodarTempoTotal(){
        this.tempo_total++;
    }

    public double tempoMedioPista_1_Aterrissagem_1(){
        return (double)tempo_total/pista_1.getTempoTotalAterrisage1();
    }

    public double tempoMedioPista_1_Aterrissagem_2(){
        return (double)tempo_total/pista_1.getTempoTotalAterrisage2();
    }


    public double tempoMedioPista_2_Aterrissagem_1(){
        return (double)tempo_total/pista_2.getTempoTotalAterrisage1();
    }


    public double tempoMedioPista_2_Aterrissagem_2(){
        return (double)tempo_total/pista_2.getTempoTotalAterrisage2();
    }


    public double tempoMedioPista_1_Decolagem_1(){
        return (double)tempo_total/pista_1.getTempoTotalDecolagem1();
    }


    public double tempoMedioPista_1_Decolagem_2(){
        return (double)tempo_total/pista_1.getTempoTotalDecolagem2();
    }


    public double tempoMedioPista_2_Decolagem_1(){
        return (double)tempo_total/pista_2.getTempoTotalDecolagem1();
    }


    public double tempoMedioPista_2_Decolagem_2(){
        return (double)tempo_total/pista_2.getTempoTotalDecolagem2();
    }


    public double tempoMedioPista_3_Decolagem(){
        return (double)tempo_total/pista_3.getTempoTotalDecolagem();
    }


    public double tempoMedioPista_3_Aterrissagem(){
        return (double)tempo_total/pista_3.getTempoTotalAterrissagem();
    }


    public double tempoMedioGlobalAterrisagem(){
        return (double)(pista_1.getTempoTotalAterrisage1()+pista_1.getTempoTotalAterrisage2()+pista_2.getTempoTotalAterrisage1()+pista_2.getTempoTotalAterrisage2()+pista_3.getTempoTotalAterrissagem())/tempo_total;
    }

    public double tempoMedioGlobalDecolagem(){
        return (double)(pista_1.getTempoTotalDecolagem1()+pista_1.getTempoTotalDecolagem2()+pista_2.getTempoTotalDecolagem1()+pista_2.getTempoTotalDecolagem2()+pista_3.getTempoTotalDecolagem())/tempo_total;
    }


}