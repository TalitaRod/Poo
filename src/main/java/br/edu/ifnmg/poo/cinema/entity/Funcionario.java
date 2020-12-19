/* 
 * Material destinado ao projeto da disciplina
 * de Programação Orientada a Objetos do 
 * Bacharelado em Ciência da Computação 
 * do IFNMG - Câmpus Montes Claros
 */
package br.edu.ifnmg.poo.cinema.entity;

/**
 * Representação do Funcionário do cinema
 * 
 * @author Anna Júlia Costa, Matteus Felippe e Talita Rodrigues
 * @version 1.0, 15/12/2020
 */
public class Funcionario {
    
    /**
     * CPF do funcionário cadastrado
     */
    private String cpf;
    
    /**
     * Email do funcionário cadastrado (será o login).
     */
    private String email;
    
    /**
     * Senha que irá servir para a entrada no sistema.
     */
    private String senha;
    
    /**
     * Nome do funcionário cadastrado.
     */
    private String nome;
    
    /**
     * Endereço do funcionário cadastrado.
     */
    private String endereco;
    
    /**
     * O tipo do funcionário (se é administrador ou vendedor).
     */
    private String tipofuncionario;

   
    //<editor-fold defaultstate="collapsed" desc="Construtores">
    
    public Funcionario() {
    }

    public Funcionario(String cpf, String email, String senha, String nome, String endereco, String tipofuncionario) {
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.endereco = endereco;
        this.tipofuncionario = tipofuncionario;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTipofuncionario() {
        return tipofuncionario;
    }

    public void setTipofuncionario(String tipofuncionario) {
        this.tipofuncionario = tipofuncionario;
    }
    
    //</editor-fold>

    /**
     * Gera representação textual do objeto atual.
     */
    @Override
    public String toString() {
        return "Cpf: " + cpf + ", Nome: " + nome;
    }
    
    
}
