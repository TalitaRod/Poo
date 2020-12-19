/* 
 * Material destinado ao projeto da disciplina
 * de Programação Orientada a Objetos do 
 * Bacharelado em Ciência da Computação 
 * do IFNMG - Câmpus Montes Claros
 */
package br.edu.ifnmg.poo.cinema.dao;


import br.edu.ifnmg.poo.cinema.entity.Sessao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Operações utilizadas pela classe Sessão
 *
 * @author Anna Júlia, Matteus Felippe, Talita Rodrigues
 * @version 1.0, 15/12/2020
 */
public class SessaoDao {

    public void adicionar(Sessao s) { //Faz o papel de adicionar uma nova sessão
        Connection conexao = ConexaoBd.getConexao(); //Cria uma nova conexão com o Banco de Dados
        PreparedStatement pst = null;
        PreparedStatement pst2 = null;
        ResultSet rs = null;
        try {
            pst = conexao.prepareStatement("SELECT Max(idsessao)+1 FROM sessao"); //Vai selecionar o próximo ID (Pega o máximo id + 1)
            rs = pst.executeQuery(); //executa o select
            while (rs.next()) {
                try {
                    pst2 = conexao.prepareStatement("INSERT INTO sessao(idsessao,idfilmepertence,sala,hora,data,valormeia,valorinteira) VALUES (?,?,?,?,?,?,?)"); //Irá inserir os dados na sessão
                    if (rs.getString("Max(idsessao)+1") == null) { //Se não tiver nenhum idsessao, será o primeiro, então o id é 1.
                        pst2.setInt(1, 1);
                    } else { //Se já tiver sessão cadastrada, irá pegar o próximo número disponível para o id. 
                        pst2.setInt(1, rs.getInt("Max(idsessao)+1"));
                    }
                    pst2.setInt(2, s.getIdfilme());//coloca no select a informação do id do filme
                    pst2.setString(3, s.getSala());//coloca no select a informação da sala do filme
                    pst2.setString(4, s.getHora());//coloca no select a informação da hora do filme
                    pst2.setString(5, s.getData());//coloca no select a informação da data do filme
                    pst2.setString(6, s.getValorMeia());//coloca no select a informação do valor de meia entrada
                    pst2.setString(7, s.getValorInteira());//coloca no select a informação do valor da inteira
                    int adicionado = pst2.executeUpdate(); 
                    if (adicionado > 0) { //olha se foi adicionado com sucerro
                        JOptionPane.showMessageDialog(null, "Sessao adicionada com sucesso");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public List<Sessao> read() { //Faz o papel de ler valores sessão
        Connection conexao = ConexaoBd.getConexao();
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<Sessao> sessoes = new ArrayList<>(); //Faz uma lista das sessões
        try {
            pst = conexao.prepareStatement("SELECT * FROM sessao"); //Seleciona tudo da tabela de sessão
            rs = pst.executeQuery(); //executa o select
            while (rs.next()) {
                Sessao sessao = new Sessao(); //Cria uma nova sessão
                sessao.setData(rs.getString("data")); //Pega a data do resultado do select
                sessao.setHora(rs.getString("hora")); //Pega o campo hora do resultado do select
                sessao.setIdfilme(rs.getInt("idfilmepertence")); //Pega o campo do id do filme do select
                sessao.setIdsessao(rs.getInt("idsessao")); //Pega o campo do id de sessão do resultado do select
                sessao.setSala(rs.getString("sala")); //Pega o campo de sala do resultado do select
                sessao.setValorInteira(rs.getString("valorinteira")); //Pega o campo de valorinteira do resultado do select
                sessao.setValorMeia(rs.getString("valormeia")); //Pega o campo de valormeia do resultado do select
                sessoes.add(sessao); //Adiciona na lista os valores lidos
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return sessoes;
    }

    public void excluir(Sessao s) { //Faz o papel de excluir uma sessão
        Connection conexao = ConexaoBd.getConexao();
        PreparedStatement pst = null;
        PreparedStatement pst2 = null;
        try {
            pst = conexao.prepareStatement("delete from sessao where idsessao=?"); //Deleta uma linha da tabela que possui o id da sessão passado
            pst.setInt(1, s.getIdsessao()); //Coloca o id do ingresso no select
            int apagado = pst.executeUpdate(); //
            try {
                pst2 = conexao.prepareStatement("delete from ingresso where idsessaopertence=?");
                pst2.setInt(1, s.getIdsessao());
                pst2.executeUpdate();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            if (apagado > 0) {
                JOptionPane.showMessageDialog(null, "Sessão removida com sucesso");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
