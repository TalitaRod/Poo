/* 
 * Material destinado ao projeto da disciplina
 * de Programação Orientada a Objetos do 
 * Bacharelado em Ciência da Computação 
 * do IFNMG - Câmpus Montes Claros
 */
package br.edu.ifnmg.poo.cinema.dao;

import br.edu.ifnmg.poo.cinema.entity.Cliente;
import br.edu.ifnmg.poo.cinema.entity.Filme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author annaj
 */
public class FilmeDao {

    public void adicionar(Filme f) {
        Connection conexao = ConexaoBd.getConexao();
        PreparedStatement pst = null;
        PreparedStatement pst2 = null;
        ResultSet rs = null;
        try {
            pst = conexao.prepareStatement("SELECT Max(idfilme)+1 FROM filme");
            rs = pst.executeQuery();
            while (rs.next()) {
                try {
                    pst2 = conexao.prepareStatement("INSERT INTO filme(idfilme,nome,classificacao,sinopse,genero) VALUES (?,?,?,?,?)");
                    if (rs.getString("Max(idfilme)+1") == null) {
                        pst2.setInt(1, 1);
                    } else {
                        pst2.setInt(1, rs.getInt("Max(idfilme)+1"));
                    }
                    pst2.setString(2, f.getNome());
                    pst2.setString(3, f.getClassificacao());
                    pst2.setString(4, f.getSinopse());
                    pst2.setString(5, f.getGenero());
                    int adicionado = pst2.executeUpdate();
                    if (adicionado > 0) {
                        JOptionPane.showMessageDialog(null, "Filme adicionado com sucesso");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public List<Filme> read() {
        Connection conexao = ConexaoBd.getConexao();
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<Filme> filmes = new ArrayList<>();
        try {
            pst = conexao.prepareStatement("SELECT * FROM filme");
            rs = pst.executeQuery();
            while (rs.next()) {
                Filme filme = new Filme();
                filme.setIdfilme(rs.getInt("idfilme"));
                filme.setNome(rs.getString("nome"));
                filme.setClassificacao(rs.getString("classificacao"));
                filme.setGenero(rs.getString("genero"));
                filme.setSinopse(rs.getString("sinopse"));  
                filmes.add(filme);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return filmes;
    }
}
