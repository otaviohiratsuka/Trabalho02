import java.util.ArrayList;
import java.util.List;

public class Aeroporto{
    private PistaNormal pista_1;
    private PistaNormal pista_2;
    private PistaEspecial pista_3;

    private List<Aviao> decolagem;
    private List<Aviao> aterrisagem;

    private List<Aviao> prioritario;

    public int controlador_decolagem;
    
    public Aeroporto(){
        pista_1 = new PistaNormal();
        pista_2 = new PistaNormal();
        pista_3 = new PistaEspecial();

        decolagem = new ArrayList<Aviao>();
        aterrisagem =  new ArrayList<Aviao>();

        prioritario =  new ArrayList<Aviao>();

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




}