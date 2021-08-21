package main;

public class Criança {
    private String nome;
    private int idade;
    private Double divisaum;

    public Criança (String nome, int idade){
        this.nome = nome;
        this.idade = idade;
        this.divisaum = (Double) null;
    }

    public Double getDivisaum() {
        return divisaum;
    }

    public void setDivisaum(Double divida) {
        if(this.divisaum ==null)
                this.divisaum = 0.0;
        if(divida == null)
            this.divisaum = (Double) null;
        else
            this.divisaum += divida;
    }

    public String getNome() {
        return this.nome;
    }

    public int getIdade() {
        return this.idade;
    }
}

