package view.jframe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dell
 */
public class MenuPrincipal{

    public static JButton botaoProduto, botaoUsuario;
    private static TelaProdutos Produto;
    private static TelaUsuarios Usuario;

    public MenuPrincipal() {

    }

    public static void execute() {
        final JFrame jf = new JFrame("Menu");
        jf.setSize(400, 130);

        // Panel que será responsavel por add todos os elementos
        JPanel panel = new JPanel();
        panel.setLayout(null);

        botaoProduto = new JButton("Produto");
        botaoUsuario = new JButton("Usuário");

        botaoProduto.setBounds(20, 20, 150, 20);
        botaoUsuario.setBounds(220, 20, 150, 20);

        panel.add(botaoProduto);
        panel.add(botaoUsuario);
        
        botaoProduto.setVisible(false);
        botaoUsuario.setVisible(false);

        botaoProduto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Produto = new TelaProdutos();
                Produto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                Produto.setVisible(true);

            }
        });

        botaoUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Usuario = new TelaUsuarios();
                Usuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                Usuario.setVisible(true);

            }
        });

        jf.add(panel);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
