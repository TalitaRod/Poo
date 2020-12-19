/* 
 * Material destinado ao projeto da disciplina
 * de Programação Orientada a Objetos do 
 * Bacharelado em Ciência da Computação 
 * do IFNMG - Câmpus Montes Claros
 */
package br.edu.ifnmg.poo.cinema.dao;

import br.edu.ifnmg.poo.cinema.entity.Funcionario;
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
public class FuncionarioDao {

    public Boolean logar(Funcionario f) {
        Connection conexao = ConexaoBd.getConexao();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexao.prepareStatement("SELECT * FROM funcionario WHERE email=? AND senha=?");
            pst.setString(1, f.getEmail());
            pst.setString(2, f.getSenha());
            rs = pst.executeQuery();
            if (rs.next()) {
                f.setCpf(rs.getString(1));
                f.setTipofuncionario(rs.getString(6));
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "usuário e/ou senha inválido(s)");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
        return false;
    }

    public void adicionar(Funcionario f) {
        Connection conexao = ConexaoBd.getConexao();
        PreparedStatement pst = null;
        String sql = "INSERT INTO funcionario(cpf,email,senha,nome,endereco,tipofuncionario) VALUES (?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, f.getCpf());
            pst.setString(2, f.getEmail());
            pst.setString(3, f.getSenha());
            pst.setString(4, f.getNome());
            pst.setString(5, f.getEndereco());
            pst.setString(6, f.getTipofuncionario());
            int adicionado = pst.executeUpdate();
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Funcionario adicionado com sucesso");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public List<Funcionario> read() {
        Connection conexao = ConexaoBd.getConexao();
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            pst = conexao.prepareStatement("SELECT * FROM funcionario");
            rs = pst.executeQuery();
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setEndereco(rs.getString("endereco"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setSenha(rs.getString("senha"));
                funcionario.setTipofuncionario(rs.getString("tipofuncionario"));
                funcionarios.add(funcionario);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return funcionarios;
    }
    
    public void excluir(Funcionario f) {
        Connection conexao = ConexaoBd.getConexao();
        PreparedStatement pst = null;
        try {
            pst = conexao.prepareStatement("delete from funcionario where cpf=?");
            pst.setString(1, f.getCpf());
            int apagado = pst.executeUpdate();
            if (apagado > 0) {
                JOptionPane.showMessageDialog(null, "Funcionario removido com sucesso");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void atualizar(Funcionario f) {
        Connection conexao = ConexaoBd.getConexao();
        PreparedStatement pst = null;
        try {
            pst = conexao.prepareStatement("UPDATE funcionario set email=?,tipofuncionario=?,senha=?,nome=?,endereco=? where cpf=?");
            pst.setString(1,f.getEmail());
            pst.setString(2,f.getTipofuncionario());
            pst.setString(3,f.getSenha());
            pst.setString(4,f.getNome());
            pst.setString(5,f.getEndereco());
            pst.setString(6,f.getCpf());
            int adicionado = pst.executeUpdate();
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Dados alterados com sucesso");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
}
