public class Aviao {

    private int numero_passageiro;
    private String companhia_aerea;
    private int reservas_minutos;
    private String ID;
    private boolean passageiro_prioridade;

    public Aviao(){}
    
    public Aviao(String id, int numero_passageiro, int reservas_minutos, String companhia_aerea) {
        this.ID = id;
        this.numero_passageiro = numero_passageiro;
        this.companhia_aerea = companhia_aerea;
        this.reservas_minutos = reservas_minutos;
        this.passageiro_prioridade = false; 
    }

    public Aviao(String id, int numero_passageiro, int reservas_minutos, String companhia_aerea, boolean pp) {
        this.ID = id;
        this.numero_passageiro = numero_passageiro;
        this.companhia_aerea = companhia_aerea;
        this.reservas_minutos = reservas_minutos;
        this.passageiro_prioridade = pp;
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

    public boolean getPassageiro_prioridade() {
        return passageiro_prioridade;
    }

    public void setPassageiro_prioridade(boolean passageiro_prioridade) {
        this.passageiro_prioridade = passageiro_prioridade;
    }   
    

}
