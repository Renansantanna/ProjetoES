/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import view.jframe.TelaLogin;
import view.jframe.MenuPrincipal;

import utils.DbUtils;
import model.Login;

import interfaces.IAbstractDaoLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class LoginDao implements IAbstractDaoLogin<Login>{
      @Override
    public void fazerLogin(Login entidade) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

        Connection connection = null;
        String sql = "select * from usuario where login=? and senha=?;";

        try {
            connection = DbUtils.getConnection();
            PreparedStatement statement = DbUtils.getPreparedStatement(connection, sql);

            statement.setString(1, entidade.getLogin());
            statement.setString(2, entidade.getSenha());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                //De equals para equalsIgnoreCase
                if (resultSet.getString(3).equalsIgnoreCase(entidade.getLogin()) && resultSet.getString(4).equals(entidade.getSenha())) {
                    String permisao = resultSet.getString(5);
                    MenuPrincipal.execute();

                    if (permisao.contains("A")) {
                        MenuPrincipal.botaoProduto.setVisible(true);
                        
                      //  Log.i("FazerLogin", "admin");
                      //  TelaDesktop.jmCadastado.setVisible(true);
                      //  TelaDesktop.jmRelatorio.setVisible(true);
                      //  TelaDesktop.jmApuracao.setVisible(true);
                    }
                }
            } else {
                //Mensagem Changed
                JOptionPane.showMessageDialog(null, "Login ou Senha incorretos");
                //Log.i("FazerLogin", "Usuário não existe");
                new TelaLogin().execute();
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}
