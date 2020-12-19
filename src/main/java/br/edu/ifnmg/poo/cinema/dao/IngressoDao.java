/* 
 * Material destinado ao projeto da disciplina
 * de Programação Orientada a Objetos do 
 * Bacharelado em Ciência da Computação 
 * do IFNMG - Câmpus Montes Claros
 */
package br.edu.ifnmg.poo.cinema.dao;

import br.edu.ifnmg.poo.cinema.entity.Ingresso;
import br.edu.ifnmg.poo.cinema.entity.Sessao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author annaj
 */
public class IngressoDao {

    public void cadastrar(Ingresso i) {
        Connection conexao = ConexaoBd.getConexao();
        PreparedStatement pst = null;
        PreparedStatement pst2 = null;
        ResultSet rs = null;
        try {
            pst = conexao.prepareStatement("SELECT Max(idingresso)+1 FROM ingresso");
            rs = pst.executeQuery();
            while (rs.next()) {
                try {
                    pst2 = conexao.prepareStatement("INSERT INTO ingresso(idingresso,idsessaopertence) VALUES (?,?)");
                    if (rs.getString("Max(idingresso)+1") == null) {
                        pst2.setInt(1, 1);
                    } else {
                        pst2.setInt(1, rs.getInt("Max(idingresso)+1"));
                    }
                    pst2.setInt(2, i.getIdSessaoPertence());
                    int adicionado = pst2.executeUpdate();
                    if (adicionado > 0) {
                        JOptionPane.showMessageDialog(null, "Ingresso cadastrado com sucesso");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public List<Ingresso> read() {
        Connection conexao = ConexaoBd.getConexao();
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<Ingresso> ingressos = new ArrayList<>();
        try {
            pst = conexao.prepareStatement("SELECT * FROM ingresso");
            rs = pst.executeQuery();
            while (rs.next()) {
                Ingresso ingresso = new Ingresso();
                ingresso.setIdIngresso(rs.getInt("idingresso"));
                ingresso.setCpfClienteCompra(rs.getString("cpfclientecompra"));
                ingresso.setCpfFuncionarioVenda(rs.getString("cpffuncionariovenda"));
                ingresso.setIdSessaoPertence(rs.getInt("idsessaopertence"));
                ingressos.add(ingresso);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return ingressos;
    }

    public void vender(Ingresso i) {
        Connection conexao = ConexaoBd.getConexao();
        PreparedStatement pst = null;
        PreparedStatement pst2 = null;
        ResultSet rs = null;
        try {
            pst = conexao.prepareStatement("SELECT * FROM ingresso where idingresso=?");
            pst.setInt(1, i.getIdIngresso());
            rs = pst.executeQuery();
            while (rs.next()) {
                if (rs.getString("cpfclientecompra") == null || rs.getString("cpfclientecompra").isEmpty()) {
                    try {
                        pst2 = conexao.prepareStatement("UPDATE ingresso set cpfclientecompra=?,cpffuncionariovenda=? where idingresso=?");
                        pst2.setString(1, i.getCpfClienteCompra());
                        pst2.setString(2, i.getCpfFuncionarioVenda());
                        pst2.setInt(3, i.getIdIngresso());
                        int adicionado = pst2.executeUpdate();
                        if (adicionado > 0) {
                            JOptionPane.showMessageDialog(null, "Ingresso vendido com sucesso");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ingresso já foi vendido");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
}
