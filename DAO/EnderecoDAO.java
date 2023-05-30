package DAO;

import Classes.Endereco;
import Classes.Voluntario;
import Conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnderecoDAO extends Conexao {

    private static Connection connection;
    public  EnderecoDAO() {
        this.connection = new Conexao().GeraConexao();
    }

    public static void adiciona(Endereco address) {
        String sql = "INSERT INTO endereco_voluntarios(rua, numero, complemento, bairro, cep, cidade, estado) VALUES(?,?,?,?,?,?,?)";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, address.getRua());
            stmt.setString(2, address.getNumero());
            stmt.setString(3, address.getComplemento());
            stmt.setString(4, address.getBairro());
            stmt.setString(5, address.getCep());
            stmt.setString(6, address.getCidade());
            stmt.setString(7, address.getEstado());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}