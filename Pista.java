import java.util.ArrayList;


public class Pista{
    private List<Aviao> decolagem_1;
    private List<Aviao> decolagem_2;

    private List<Aviao> aterrisagem_1;
    private List<Aviao> aterrisagem_2;

    private List<Aviao> suporte_decolagem;
    private List<Aviao> suporte_aterrisagem;

    private List<Aviao> prioritario; // percorrer 1 e 2, procurar risco(abaixo de 3min)
    

    //adicionará o avião na pista de aterrisagem que tenha menos aviao
    public void addAviaoAterrisagem(Aviao av){
        if(decolagem_1.size() > decolagem_2.size()){
            decolagem_2.add(add);
        }
    }



}