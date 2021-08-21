package main;
    import java.util.ArrayList;
    import java.util.List;

    public class PulaPula{
    private List<Criança> filaDeEspera;
    private List<Criança> pulando_Crianças;
    private int limiteMAX;
    private int AtualPulando_Crianças;
    private double caixa;

    public PulaPula(int limiteMax){
        this.limiteMAX = limiteMax;
        this.filaDeEspera = new ArrayList<>();
        this.pulando_Crianças= new ArrayList<>();
        this.AtualPulando_Crianças=0;
    }
    public int getAtualPulando_Crianças() {
        return AtualPulando_Crianças;
    }
    public int getLimiteMax() {
        return this.limiteMAX;
    }
    public double getCaixa() {
        return this.caixa;
    }
    public List<Criança> getFilaDeEspera() {
        return this.filaDeEspera;
    }

    public List<Criança> getPulando_Crianças() {
        return this.pulando_Crianças;
    }
    public Double getConta(String name){
        for(Criança crianca : filaDeEspera)
            if(crianca.getNome().equals(name))
                return crianca.getDivisaum();
        for(Criança crianca : pulando_Crianças)
            if(crianca.getNome().equals(name))
                return crianca.getDivisaum();
        return null;
    }

    public boolean entrarNaFila(Criança crianca){
        for(Criança crianca_na_fila : filaDeEspera){
            if(crianca_na_fila.getNome().equals(crianca.getNome()))
                return false;
        }
        this.filaDeEspera.add(crianca);
        return true;
    }
    public boolean entrar(){
        if(this.filaDeEspera.isEmpty() || this.AtualPulando_Crianças == this.limiteMAX)
            return false;
        this.filaDeEspera.get(0).setDivisaum(2.50);
        this.pulando_Crianças.add(filaDeEspera.get(0));
        this.filaDeEspera.remove(0);
        this.AtualPulando_Crianças++;
        return true;
    }
    public boolean sair(){
        if(this.pulando_Crianças.isEmpty())
            return false;
        filaDeEspera.add(pulando_Crianças.get(0));
        pulando_Crianças.remove(0);
        this.AtualPulando_Crianças--;
        return true;
    }
    public boolean papaiChegou(String name){
        for(Criança crianca : this.pulando_Crianças) {
            if(crianca.getNome().equals(name)) {
                this.caixa += crianca.getDivisaum();
                crianca.setDivisaum(null);
                this.pulando_Crianças.remove(crianca);
                AtualPulando_Crianças--;
                return true;
            }
        }
    for(Criança crianca : this.filaDeEspera){
            if(crianca.getNome().equals(name)) {
                if(crianca.getDivisaum() != null)
                    this.caixa += crianca.getDivisaum();
                crianca.setDivisaum(null);
                this.filaDeEspera.remove(crianca);
                return true;
            }
        }
        return false;
    }
    public double fechar(){
        for(int i = 0; i < pulando_Crianças.size(); i++) {
            caixa += pulando_Crianças.get(i).getDivisaum();
            pulando_Crianças.remove(i);
            AtualPulando_Crianças--;
        }
        for(int i = 0; i < filaDeEspera.size(); i++) {
            if(filaDeEspera.get(i).getDivisaum() != null)
                caixa += filaDeEspera.get(i).getDivisaum();
            filaDeEspera.remove(i);
        }
        return caixa;
    }
    }
     