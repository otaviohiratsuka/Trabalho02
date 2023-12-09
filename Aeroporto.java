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