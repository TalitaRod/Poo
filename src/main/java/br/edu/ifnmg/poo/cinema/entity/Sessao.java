/* 
 * Material destinado ao projeto da disciplina
 * de Programação Orientada a Objetos do 
 * Bacharelado em Ciência da Computação 
 * do IFNMG - Câmpus Montes Claros
 */
package br.edu.ifnmg.poo.cinema.entity;

/**
 * Representação de uma sessão do cinema
 *
 * @author Anna Júlia, Matteus Felippe, Talita Rodrigues
 * @version 1.0, 15/12/2020
 */

public class Sessao {
    
    /**
     * id de uma sessão.
     */
    private int idsessao;
    
    /**
     * id do filme que terá em uma sessão.
     */
    private int idfilme;
    
    /**
     * Hora de início de uma sessão.
     */
    private String hora;
    
    /**
     * Sala de uma sessão.
     */
    private String sala;
    
    /**
     * Data de uma sessão.
     */
    private String data;
    
    /**
     * Valor que o ingresso inteiro terá em uma sessão
     */
    private String valorInteira;
    
    /**
     * Valor que o ingresso meia entrada terá em uma sessão
     */
    private String valorMeia;
    
    //<editor-fold defaultstate="collapsed" desc="Construtores">

    public Sessao(int idsessao, int idfilme, String hora, String sala, String data, String valorInteira, String valorMeia) {
        this.idsessao = idsessao;
        this.idfilme = idfilme;
        this.hora = hora;
        this.sala = sala;
        this.data = data;
        this.valorInteira = valorInteira;
        this.valorMeia = valorMeia;
    }

    public Sessao() {
    }
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    
    public int getIdsessao() {
        return idsessao;
    }

    public void setIdsessao(int idsessao) {
        this.idsessao = idsessao;
    }

    public int getIdfilme() {
        return idfilme;
    }

    public void setIdfilme(int idfilme) {
        this.idfilme = idfilme;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getValorInteira() {
        return valorInteira;
    }

    public void setValorInteira(String valorInteira) {
        this.valorInteira = valorInteira;
    }

    public String getValorMeia() {
        return valorMeia;
    }

    public void setValorMeia(String valorMeia) {
        this.valorMeia = valorMeia;
    }
   
    //</editor-fold>

    /**
     * Gera representação textual do objeto atual.
     */
    @Override
    public String toString() {
        return "Sessao: " + idsessao + ", filme: " + idfilme + ", hora: " + hora + ", data: " + data;
    }
    
    
}
