/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.Usuario;
import view.CadastroForm;

/**
 *
 * @author Yuri
 */
public class FormController {
    private CadastroForm cadastroView ;

    public FormController(CadastroForm cadastroView) {
        this.cadastroView = cadastroView;
    }
    
    public void salvarUsuario(){
        String userTxt = cadastroView.getTxtUsuario().getText();
        String senhaTxt = cadastroView.getTxtSenha().getText();
        
        Usuario usuario = new Usuario(userTxt, senhaTxt); 
        
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO(Conexao.conectar());
            usuarioDAO.insert(usuario);
            
            JOptionPane.showMessageDialog(null, "Usuario Cadastrado com Sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um Erro!");

            Logger.getLogger(CadastroForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

   
    
    
    
}
