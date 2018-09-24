package view.jframe;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import utils.DbUtils;
import model.Login;
import dao.LoginDao;

import java.sql.SQLException;
import java.awt.HeadlessException;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.text.ParseException;
/**
 *
 * @author Dell
 */
public class TelaLogin {
    JButton btnLogar;
    JLabel  lblLogin, lblSenha;
    JTextField  txtLogin;
    JPasswordField txtSenha;
    String usuario[];
    
    private ImageIcon icon;
    private Connection connection;
    
    public TelaLogin(){
        
         try {
            connection = DbUtils.getConnection();
            if (connection != null) {
                icon = new ImageIcon(getClass().getResource("/imgs/bola_verde.png"));
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Sem conexão");
            icon = new ImageIcon(getClass().getResource("/imgs/bola_vermelha.png"));
         //   Log.i("TelaLogin Sem Conexão", ex.getMessage());
        }
        

    }
    
    public void execute(){
         
          final JFrame tela1 = new JFrame("Tela de Login");
            
            tela1.setLayout(null);
           
            lblLogin = new JLabel("Login: ");
            lblSenha = new JLabel("Senha:");


            txtLogin = new JTextField(15);
            btnLogar = new JButton("Logar");
            btnLogar.setIcon(icon);
            
            txtSenha = new JPasswordField(15);
           txtSenha.setBounds(100, 50, 100, 20);
           
            lblLogin.setBounds(20, 20, 80, 20);
            lblSenha.setBounds(20, 50, 100, 20);

           

            txtLogin.setBounds(100, 20, 100, 20);
            btnLogar.setBounds(100, 80, 100, 20);

            tela1.add(lblLogin);
            tela1.add(lblSenha);
            tela1.add(txtLogin);
            tela1.add(txtSenha);
            tela1.add(btnLogar);
            
             btnLogar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                Login fazerLogin = new Login();
                fazerLogin.setLogin(txtLogin.getText());
                fazerLogin.setSenha(new String(txtSenha.getPassword()));
                
                 if (connection != null) {
                    if (new String(txtSenha.getPassword()).isEmpty() || txtLogin.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Campos login e senha obrigatórios");
                    } else {
                        try {
                            new LoginDao().fazerLogin(fazerLogin);
                            tela1.dispose();
                        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException | HeadlessException ex) {
                            JOptionPane.showMessageDialog(null, "Erro .." + ex.getMessage());
                            //Log.e("TelaLogin Sem Conexão", ex.getMessage());
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Sem conexão");
                }
                    /*try {
                        Connection con;
                        String userName = "root";
                        String password = "";
                        String url = "jdbc:mysql://127.0.0.1/quatro_menus";

                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        con = DriverManager.getConnection(url, userName, password);

                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("SELECT * FROM usuario WHERE login LIKE'" + txtLogin.getText() + "' AND senha Like '"+txtSenha+"'");
                        rs.next();
                       //System.out.println(rs.getFetchSize());
                       // for(int count=0;count<rs.getFetchSize();count++)
                        st.close();
                        con.close();
                    } catch (Exception event) {
                        JOptionPane.showMessageDialog(null, "Conexão não estabelecida / Registro não encontrado ", "Mensagem do Progama", JOptionPane.ERROR_MESSAGE);
                    }
                    */
                }
            });
         
            tela1.setSize(300, 200);
            tela1.setVisible(true);
            tela1.setResizable(false);
            tela1.setLocationRelativeTo(null);
            tela1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
    }
    
}
