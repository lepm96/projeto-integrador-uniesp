package DAO;

import Classes.Voluntario;
import Conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VoluntarioDAO extends Conexao {

    private static Connection connection;
    public  VoluntarioDAO() {
        this.connection = new Conexao().GeraConexao();
    }

    public static void adiciona(Voluntario voluntary) {
        String sql = "INSERT INTO voluntarios(nome, nacionalidade, estado_civil, profissao, rg, orgao_expedidor, cpf) VALUES(?,?,?,?,?,?,?)";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, voluntary.getNome());
            stmt.setString(2, voluntary.getNacionalidade());
            stmt.setString(3, voluntary.getEstadoCivil());
            stmt.setString(4, voluntary.getProfissao());
            stmt.setString(5, voluntary.getRG());
            stmt.setString(6, voluntary.getOrgaoExpedidor());
            stmt.setString(7, voluntary.getCPF());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}