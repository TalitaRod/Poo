/* 
 * Material destinado ao projeto da disciplina
 * de Programação Orientada a Objetos do 
 * Bacharelado em Ciência da Computação 
 * do IFNMG - Câmpus Montes Claros
 */
package br.edu.ifnmg.poo.cinema.entity;

/**
 * Representação do filme que será cadastrado
 *
 * @author Anna Júlia, Matteus Felippe, Talita Rodrigues
 * @version 1.0, 15/12/2020
 */

public class Filme {

    /**
     * Id do filme cadastrado.
     */
    private int idfilme;
    
    /**
     * Nome do filme cadastrado.
     */
    private String nome;
    
    /**
     * Classificação do filme cadastrado.
     */
    private String classificacao;
    
    /**
     * Sinopse do filme cadastrado.
     */
    private String sinopse;
    
    /**
     * Gênero do filme cadastrado.
     */
    private String genero;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Filme(int idfilme, String nome, String classificacao, String sinopse, String genero) {
        this.idfilme = idfilme;
        this.nome = nome;
        this.classificacao = classificacao;
        this.sinopse = sinopse;
        this.genero = genero;
    }

    public Filme() {
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public int getIdfilme() {
        return idfilme;
    }

    public void setIdfilme(int idfilme) {
        this.idfilme = idfilme;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    //</editor-fold>

    /**
     * Gera representação textual do objeto atual.
     */
    @Override
    public String toString() {
        return "Id do filme: " + idfilme + ", Nome: " + nome;
    }
    
    
}
