public class Aviao {

    private int numero_passageiro;
    private String companhia_aerea;
    private int reservas_minutos;
    private String ID;

    public Aviao(){}
    
    public Aviao(String id, int numero_passageiro,int reservas_minutos, String companhia_aerea){
        this.ID = id;
        this.numero_passageiro = numero_passageiro;
        this.companhia_aerea = companhia_aerea;
        this.reservas_minutos = reservas_minutos;
    }

    public int getNumero_passageiro() {
        return numero_passageiro;
    }

    public void setNumero_passageiro(int numero_passageiro) {
        this.numero_passageiro = numero_passageiro;
    }

    public String getCompanhia_aerea() {
        return companhia_aerea;
    }

    public void setCompanhia_aerea(String companhia_aerea) {
        this.companhia_aerea = companhia_aerea;
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public int getReservas_minutos() {
        return reservas_minutos;
    }

    public void setReservas_minutos(int reservas_minutos) {
        this.reservas_minutos = reservas_minutos;
    }   
    

}
