/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;
import view.CadastroForm;

/**
 *
 * @author Yuri
 */
public class UsuarioDAO {

    private final Connection connection;

    //só será gerado um usuarioDAO com uma conexão.
    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(Usuario user) throws SQLException {
        String sql = "insert into usuario(nome, senha) values (?,?);";
        String senhaArray = user.getSenha();

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, user.getNome());
        statement.setString(2, senhaArray);

        statement.executeUpdate();

        statement.close();
        connection.close();

    }

    public boolean autenticarUsuario(Usuario userAuth) throws SQLException {

        String sql = "SELECT * FROM usuario WHERE nome = ? AND senha = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, userAuth.getNome());
        statement.setString(2, userAuth.getSenha());

        statement.execute();

        ResultSet result = statement.getResultSet();

        return result.next();
    }

}
