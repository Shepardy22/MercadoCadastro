/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.sun.jdi.connect.spi.Connection;
import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;
import view.Menu;
import view.TelaLogin;

/**
 *
 * @author Yuri
 */
public class LoginController {
    private final TelaLogin view;

    public LoginController(TelaLogin view) {
        this.view = view;
    }

    public void autenticar() throws SQLException {
        
        //pegar usuario na view
        String nome = view.getNomeUsuario().getText();
        String senha = view.getSenha().getText();
        
        Usuario userAuth = new Usuario(nome, senha);
        
        //verificar se existe no banco de dados
        
        UsuarioDAO userDao = new UsuarioDAO(Conexao.conectar());
        boolean userTrue = userDao.autenticarUsuario(userAuth);
        
        if(userTrue){
            Menu telaMenu = new Menu();
            telaMenu.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(view, "Usuario ou Senha inválidos!");
        }
        
        //se existir redirecionar para menu
        
        
    }
    
}
