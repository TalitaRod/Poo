/* 
 * Material destinado ao projeto da disciplina
 * de Programação Orientada a Objetos do 
 * Bacharelado em Ciência da Computação 
 * do IFNMG - Câmpus Montes Claros
 */
package br.edu.ifnmg.poo.cinema.entity;

/**
 * Representação do cliente que irá comprar ingressos
 *
 * @author Anna Júlia, Matteus Felippe, Talita Rodrigues
 * @version 1.0, 15/12/2020
 */
public class Cliente {

    /**
     * Nome do cliente a ser cadastrado.
     */
    private String nomeCliente;

    /**
     * CPF do cliente a ser cadastrado.
     */
    private String cpfCliente;

    /**
     * Telefone do cliente a ser cadastrado.
     */
    private String telefoneCliente;

    /**
     * Email do cliente a ser cadastrado.
     */
    private String emailCliente;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    /**
     * Construtor sobrecarregado.
     */
    public Cliente(String nomeCliente, String cpfCliente, String telefoneCliente, String emailCliente) {
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.telefoneCliente = telefoneCliente;
        this.emailCliente = emailCliente;
    }

    /**
     * Construtor padrão.
     */
    public Cliente() {
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }
    //</editor-fold>

    /**
     * Gera representação textual do objeto atual.
     */
    @Override
    public String toString() {
        return "Nome do Cliente: " + nomeCliente + ", CPF do Cliente: " + cpfCliente;
    }

}
