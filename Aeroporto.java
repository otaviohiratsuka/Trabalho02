import java.util.ArrayList;
import java.util.List;

public class Aeroporto{
    private PistaNormal pista_1;
    private PistaNormal pista_2;
    private PistaEspecial pista_3;

    private List<Aviao> prioritario;

    private int aterrissagemEmergenciais;
    private int tempo_total;
    private int quantidade_prioritario;


    public int controlador_decolagem;
    
    
    public Aeroporto(){
        pista_1 = new PistaNormal();
        pista_2 = new PistaNormal();
        pista_3 = new PistaEspecial();

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

        pista_1.verificarPrioritario();
        pista_2.verificarPrioritario();


        pista_1.suporteAterrisagem();
        pista_1.suporteDecolagem();
                
        System.out.println(pista_1.getSuporteAterrisagem());
        System.out.println(pista_2.getSuporteAterrisagem());

        
        pista_2.suporteAterrisagem();
        pista_2.suporteDecolagem();

        System.out.println(pista_1.getSuporteAterrisagem().get(0).getCompanhia_aerea());
        System.out.println(pista_2.getSuporteAterrisagem().get(0).getCompanhia_aerea());

        System.out.println(pista_1.getSuporteDecolagem());
        System.out.println(pista_2.getSuporteDecolagem());

        pista_1.diminuirTempoAterrisagem();
        pista_2.diminuirTempoAterrisagem();
        pista_3.diminuirTempoAterrisagem();


         //========Pista 3========================================
        if (pista_3.getAterrisagem().size() >= 3) {
            atualizarAeroportoNormal_2();
            return;
        }
        if (!pista_3.getDecolagem().isEmpty()) {
            aviao_pista3 = pista_3.getDecolagem().get(0);

            List<Aviao> novaLista = new ArrayList<>(pista_3.getDecolagem());
            novaLista.remove(0);
            pista_3.setDecolagem(novaLista);
            

            System.out.println("Pista 3 - Decolagem");
            System.out.println("N° PASSAGEIROS: " + aviao_pista3.getNumero_passageiro());
            System.out.println("COMPANHIA AÉREA: " + aviao_pista3.getCompanhia_aerea());
            System.out.println("RESERVAS MINUTOS: " + aviao_pista3.getReservas_minutos());
        } 

         //========Pista 1========================================
        if (pista_1.getDecolagem_1().size() + pista_1.getDecolagem_2().size() < pista_1.getAterrisagem_1().size() + pista_1.getAterrisagem_2().size()) {
           System.out.println("entrou na pista 1");
           
            if (!pista_1.getSuporteAterrisagem().isEmpty()) {
                aviao_pista1 = pista_1.getSuporteAterrisagem().get(0);
                List<Aviao> novaLista = new ArrayList<>(pista_1.getSuporteAterrisagem());
                novaLista.remove(0);
                pista_1.setSuporteAterrisagem(novaLista);
        
                System.out.println("Pista 1 - Aterrisagem");
                System.out.println("N° PASSAGEIROS: " + aviao_pista1.getNumero_passageiro());
                System.out.println("COMPANHIA AÉREA: " + aviao_pista1.getCompanhia_aerea());
                System.out.println("RESERVAS MINUTOS: " + aviao_pista1.getReservas_minutos());
            } 
        } else {             
            if (!pista_1.getSuporteDecolagem().isEmpty()) {
                
                aviao_pista1 = pista_1.getSuporteDecolagem().get(0);
                List<Aviao> novaLista = new ArrayList<>(pista_1.getSuporteDecolagem());
                novaLista.remove(0);
                pista_1.setSuporteDecolagem(novaLista);
        
                System.out.println("Pista 1 - Decolagem");
                System.out.println("N° PASSAGEIROS: " + aviao_pista1.getNumero_passageiro());
                System.out.println("COMPANHIA AÉREA: " + aviao_pista1.getCompanhia_aerea());
                System.out.println("RESERVAS MINUTOS: " + aviao_pista1.getReservas_minutos());
            } 
        }
        
        //========Pista 2========================================
        if (pista_2.getDecolagem_1().size() + pista_2.getDecolagem_2().size() < pista_2.getAterrisagem_1().size() + pista_2.getAterrisagem_2().size()) {
            List<Aviao> suporteAterrisagemPista2 = pista_2.getSuporteAterrisagem();
        
            if (!suporteAterrisagemPista2.isEmpty()) {
                aviao_pista2 = suporteAterrisagemPista2.get(0);
                List<Aviao> novaLista = new ArrayList<Aviao>(suporteAterrisagemPista2);
                novaLista.remove(0);
                pista_2.setSuporteAterrisagem(novaLista);
        
                System.out.println("Pista 2 - Aterrisagem");
                System.out.println("N° PASSAGEIROS: " + aviao_pista2.getNumero_passageiro());
                System.out.println("COMPANHIA AÉREA: " + aviao_pista2.getCompanhia_aerea());
                System.out.println("RESERVAS MINUTOS: " + aviao_pista2.getReservas_minutos());
            } 
        } else {
            List<Aviao> suporteDecolagemPista2 = pista_2.getSuporteDecolagem();
        
            if (!suporteDecolagemPista2.isEmpty()) {
                aviao_pista2 = suporteDecolagemPista2.get(0);
                List<Aviao> novaLista = new ArrayList<>(suporteDecolagemPista2);
                novaLista.remove(0);
                pista_2.setSuporteDecolagem(novaLista);
        
                System.out.println("Pista 2 - Decolagem");
                System.out.println("N° PASSAGEIROS: " + aviao_pista2.getNumero_passageiro());
                System.out.println("COMPANHIA AÉREA: " + aviao_pista2.getCompanhia_aerea());
                System.out.println("RESERVAS MINUTOS: " + aviao_pista2.getReservas_minutos());
            } 
        }
        
        return;

    }

    public void atualizarAeroportoNormal_2() {
        System.out.println("Alerta - Emergencia\n");
        System.out.println("----------------------");

        for (int i = 0; i < 3 && i < pista_3.getAterrisagem().size(); i++) {
            System.out.println("Pista " + (i + 1) + " - Aterrisagem");
            System.out.println("N° PASSAGEIROS: " + pista_3.getAterrisagem().get(i).getNumero_passageiro());
            System.out.println("COMPANHIA AÉREA: " + pista_3.getAterrisagem().get(i).getCompanhia_aerea());
            System.out.println("RESERVAS MINUTOS: " + pista_3.getAterrisagem().get(i).getReservas_minutos());
        }

        List<Aviao> novaLista = new ArrayList<>(pista_3.getAterrisagem());
        novaLista.subList(0, Math.min(3, novaLista.size())).clear();
        pista_3.setAterrisagem(novaLista);
    }

    public void transferenciaDeAviao(){
        pista_3.setAdicionarAterrisagem(pista_1.getPrioritario());
        pista_3.setAdicionarAterrisagem(pista_2.getPrioritario());
        
        List<Aviao> novaLista = new ArrayList<>(pista_1.getPrioritario());
        novaLista.clear();
        pista_1.setPrioritario(novaLista);

        novaLista = new ArrayList<>(pista_2.getPrioritario());
        novaLista.clear();
        pista_2.setPrioritario(novaLista);
        
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