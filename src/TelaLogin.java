/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.text.ParseException;
/**
 *
 * @author Dell
 */
public class TelaLogin extends JFrame {
    JButton btnLogar;
    JLabel  lblLogin, lblSenha;
    JTextField  txtLogin;
    JPasswordField txtSenha;
    String usuario[];
    
    public TelaLogin(){
         super("Login");
            Container tela1 = getContentPane();
            tela1.setLayout(null);
           
            lblLogin = new JLabel("Login: ");
            lblSenha = new JLabel("Senha:");


            txtLogin = new JTextField(15);
            btnLogar = new JButton("Incluir");
          
            lblLogin.setBounds(20, 110, 80, 20);
            lblSenha.setBounds(20, 150, 100, 20);

           

            txtLogin.setBounds(100, 110, 100, 20);
            btnLogar.setBounds(350, 70, 150, 20);

            tela1.add(lblLogin);
            tela1.add(lblSenha);
            tela1.add(txtLogin);
            
             btnLogar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    try {
                        Connection con;
                        String userName = "root";
                        String password = "";
                        String url = "jdbc:mysql://127.0.0.1/quatro_menus";

                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        con = DriverManager.getConnection(url, userName, password);

                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("SELECT * FROM usuario WHERE nome LIKE'" + txtLogin.getText() + "' AND senha Like '"+txtSenha+"'");
                        rs.next();
                        System.out.println(rs.getFetchSize());
                       // for(int count=0;count<rs.getFetchSize();count++)
                        st.close();
                        con.close();
                    } catch (Exception event) {
                        JOptionPane.showMessageDialog(null, "Conexão não estabelecida / Registro não encontrado ", "Mensagem do Progama", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
         
  
    }
    
}
