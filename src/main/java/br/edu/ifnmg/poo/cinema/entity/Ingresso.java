/* 
 * Material destinado ao projeto da disciplina
 * de Programação Orientada a Objetos do 
 * Bacharelado em Ciência da Computação 
 * do IFNMG - Câmpus Montes Claros
 */
package br.edu.ifnmg.poo.cinema.entity;

/**
 * Representação do ingresso que estará disponível para venda
 *
 * @author Anna Júlia, Matteus Felippe, Talita Rodrigues
 * @version 1.0, 15/12/2020
 */
public class Ingresso {
    
    /**
     * Id do ingresso.
     */
    private int idIngresso;
    
    /**
     * Id da sessão que o ingresso fará parte.
     */
    private int idSessaoPertence;
    
    /**
     * CPF do cliente que irá comprar o ingresso.
     */
    private String cpfClienteCompra;
    
    /**
     * CPF do Funcionário que irá vender o ingresso.
     */
    private String cpfFuncionarioVenda;
    
    
    //<editor-fold defaultstate="collapsed" desc="Construtores">

    public Ingresso(int idIngresso, int idSessaoPertence, String cpfClienteCompra, String cpfFuncionarioVenda) {
        this.idIngresso = idIngresso;
        this.idSessaoPertence = idSessaoPertence;
        this.cpfClienteCompra = cpfClienteCompra;
        this.cpfFuncionarioVenda = cpfFuncionarioVenda;
    }

    public Ingresso() {
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    
    public int getIdIngresso() {
        return idIngresso;
    }

    public void setIdIngresso(int idIngresso) {
        this.idIngresso = idIngresso;
    }

    public int getIdSessaoPertence() {
        return idSessaoPertence;
    }

    public void setIdSessaoPertence(int idSessaoPertence) {
        this.idSessaoPertence = idSessaoPertence;
    }

    public String getCpfClienteCompra() {
        return cpfClienteCompra;
    }

    public void setCpfClienteCompra(String cpfClienteCompra) {
        this.cpfClienteCompra = cpfClienteCompra;
    }

    public String getCpfFuncionarioVenda() {
        return cpfFuncionarioVenda;
    }

    public void setCpfFuncionarioVenda(String cpfFuncionarioVenda) {
        this.cpfFuncionarioVenda = cpfFuncionarioVenda;
    }
    
    //</editor-fold>

    
    /**
     * Gera representação textual do objeto atual.
     */
    
    @Override
    public String toString() {
        String texto = "id do ingresso: " + idIngresso + ", sessao que pertence: " + idSessaoPertence;
        if(cpfClienteCompra == null || cpfClienteCompra.isEmpty()){
            texto = texto + "    [DISPONIVEL]"; //Se não tiver nenhum cliente associado, o ingresso está disponível para comptra.
        }else{
            texto = texto + "    [INDISPONIVEL]"; //Se tiver cliente associado o ingresso não está disponível para compra.
        }
        return texto;
    }
    
    
}
