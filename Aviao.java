public class Aviao {

    private int numero_passageiro;
    private String companhia_aerea;
    private String ID;

    public Aviao(){}
    
    public Aviao(String id, int numero_passageiro, String companhia_aerea){
        this.ID = id;
        this.numero_passageiro = numero_passageiro;
        this.companhia_aerea = companhia_aerea;
    }   

    public int getNumeroPassageiro() {
        return numero_passageiro;
    }
    public void setNumeroPassageiro(int numero_passageiro) {
        this.numero_passageiro = numero_passageiro;
    }
    public String getCompanhiaAerea() {
        return companhia_aerea;
    }
    public void setCompanhiaAerea(String companhia_aerea) {
        this.companhia_aerea = companhia_aerea;
    }
    public String getID() {
        return ID;
    }
    public String setID(String iD) {
        ID = iD;
    }
    
}
