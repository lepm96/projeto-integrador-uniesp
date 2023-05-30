package DAO;

import Classes.Usuario;
import Conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO extends Conexao {

    private static Connection connection;
    public  UsuarioDAO() {
        this.connection = new Conexao().GeraConexao();
    }

    public static void adiciona(Usuario user) {
        String sql = "INSERT INTO usuario(Nome, Telefone, Gênero, CID, Endereço) VALUES(?,?,?,?,?)";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, user.getNome_usuario());
            stmt.setString(2, user.getTelefone());
            stmt.setString(3, user.getGenero());
            stmt.setString(4, user.getCid());
            stmt.setString(5, user.getEndereco());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}