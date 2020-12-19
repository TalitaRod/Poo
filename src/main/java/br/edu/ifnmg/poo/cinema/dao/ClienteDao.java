/* 
 * Material destinado ao projeto da disciplina
 * de Programação Orientada a Objetos do 
 * Bacharelado em Ciência da Computação 
 * do IFNMG - Câmpus Montes Claros
 */
package br.edu.ifnmg.poo.cinema.dao;

import br.edu.ifnmg.poo.cinema.entity.Cliente;
import br.edu.ifnmg.poo.cinema.entity.Funcionario;
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
public class ClienteDao {
    public void adicionar(Cliente c) {
        Connection conexao = ConexaoBd.getConexao();
        PreparedStatement pst = null;
        String sql = "INSERT INTO cliente(cpfcliente,nomecliente,telefonecliente,emailcliente) VALUES (?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, c.getCpfCliente());
            pst.setString(2, c.getNomeCliente());
            pst.setString(3, c.getTelefoneCliente());
            pst.setString(4, c.getEmailCliente());
            int adicionado = pst.executeUpdate();
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public List<Cliente> read() {
        Connection conexao = ConexaoBd.getConexao();
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<Cliente> clientes = new ArrayList<>();
        try {
            pst = conexao.prepareStatement("SELECT * FROM cliente");
            rs = pst.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCpfCliente(rs.getString("cpfcliente"));
                cliente.setEmailCliente(rs.getString("emailcliente"));
                cliente.setNomeCliente(rs.getString("nomecliente"));
                cliente.setTelefoneCliente(rs.getString("telefonecliente"));
                clientes.add(cliente);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return clientes;
    }
    
    public void atualizar(Cliente c) {
        Connection conexao = ConexaoBd.getConexao();
        PreparedStatement pst = null;
        try {
            pst = conexao.prepareStatement("UPDATE cliente set nomecliente=?,telefonecliente=?,emailcliente=? where cpfcliente=?");
            pst.setString(1,c.getNomeCliente());
            pst.setString(2,c.getTelefoneCliente());
            pst.setString(3,c.getEmailCliente());
            pst.setString(4,c.getCpfCliente());

            int adicionado = pst.executeUpdate();
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Dados alterados com sucesso");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
}
