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

    public int controlador_decolagem;
    
    public Aeroporto(){
        pista_1 = new PistaNormal();
        pista_2 = new PistaNormal();
        pista_3 = new PistaEspecial();

        decolagem = new ArrayList<Aviao>();
        aterrisagem =  new ArrayList<Aviao>();

        prioritario =  new ArrayList<Aviao>();

        this.aterrissagensEmergenciais = 0;

        controlador_decolagem = 0;
    }

    public void adicionarAterrisagem(Aviao av){
        if(pista_1.totalAterrisagem() <= pista_2.totalAterrisagem()){
            pista_1.addAviaoAterrisagem(av);
        }
        else{
            pista_2.addAviaoAterrisagem(av)
        }
    }

    public void adicionarDecolagem(Aviao av){
        if(controlador_decolagem != 3){
            pista_3.getDecolagem(av);
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
    public double calcularTempoMedioEsperaDecolagem(){
        int totalAviaoDecolagem = pista_1.getDecolagem_1().size() + pista_1.getDecolagem_2().size() + pista_2.getDecolagem_1().size() + pista_2.getDecolagem_2().size();
        int totalTempoEspera = 0;

        for(Aviao av : pista_1.getDecolagem_1()){
            totalTempoEspera += av.getReservas_minutos();
    }
        for (Aviao av : pista_1.getDecolagem_2()) {
            totalTempoEspera += av.getReservas_minutos();
        }

        for (Aviao av : pista_2.getDecolagem_1()) {
            totalTempoEspera += av.getReservas_minutos();
        }

        for (Aviao avi : pista_2.getDecolagem_2()) {
            totalTempoEspera += av.getReservas_minutos();
        }

        return totalTempoEspera / (double) totalAvioesDecolagem;
}
    public double calcularTempoMedioEsperaAterrissagem(){
        int totalAvioesAterrissagem = pista_1.totalAterrisagem() + pista_2.totalAterrisagem();

        int totalTempoEspera = 0;

        for (Aviao av : pista_1.getAterrisagem_1()) {
            if (av.getReservas_minutos() <= 0) {
            aeroporto.incrementarAterrissagensEmergenciais();
        }

        totalTempoEspera += av.getReservas_minutos();
        totalAterrissagens++;
        }

        for (Aviao av : pista_1.getAterrisagem_2()) {
            totalTempoEspera += av.getReservas_minutos();
        }

        for (Aviao av : pista_2.getAterrisagem_1()) {
            totalTempoEspera += av.getReservas_minutos();
        }

        for (Aviao av : pista_2.getAterrisagem_2()) {
            totalTempoEspera += av.getReservas_minutos();
        }

        return totalTempoEspera / (double) totalAvioesAterrissagem;
    }
    public double calcularTempoMedioGlobal(){
        int totalAvioes = pista_1.totalDecolagem() + pista_2.totalDecolagem() + pista_1.totalAterrisagem() + pista_2.totalAterrisagem();

    int totalTempoEspera = 0;

    for (Aviao av : pista_1.getDecolagem_1()) {
        totalTempoEspera += av.getReservas_minutos();
    }

    for (Aviao av : pista_1.getDecolagem_2()) {
        totalTempoEspera += av.getReservas_minutos();
    }

    for (Aviao av : pista_2.getDecolagem_1()) {
        totalTempoEspera += av.getReservas_minutos();
    }

    for (Aviao av : pista_2.getDecolagem_2()) {
        totalTempoEspera += av.getReservas_minutos();
    }

    for (Aviao av : pista_1.getAterrisagem_1()) {
        totalTempoEspera += av.getReservas_minutos();
    }

    for (Aviao av : pista_1.getAterrisagem_2()) {
        totalTempoEspera += av.getReservas_minutos();
    }

    for (Aviao av : pista_2.getAterrisagem_1()) {
        totalTempoEspera += av.getReservas_minutos();
    }

    for (Aviao av : pista_2.getAterrisagem_2()) {
        totalTempoEspera += av.getReservas_minutos();
    }

    System.out.println("Número de Aterrissagens de Emergência: " + aeroporto.getAterrissagensEmergenciais());

    return totalTempoEspera / (double) totalAvioes;
        }
    
    public void imprimirAvioesNasFilas() {
        System.out.println("Aviões na Fila de Decolagem da Pista 1:");
        imprimirAvioes(pista_1.getDecolagem_1());
        
        System.out.println("Aviões na Fila de Decolagem da Pista 2:");
        imprimirAvioes(pista_1.getDecolagem_2());

        System.out.println("Aviões na Fila de Aterrissagem da Pista 1:");
        imprimirAvioes(pista_1.getAterrisagem_1());

        System.out.println("Aviões na Fila de Aterrissagem da Pista 2:");
        imprimirAvioes(pista_1.getAterrisagem_2());

    }
    
    public void incrementarAterrissagensEmergenciais() {
        this.aterrissagensEmergenciais++;
    }

    public int getAterrissagensEmergenciais() {
        return this.aterrissagensEmergenciais;
    }

    
}