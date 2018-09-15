
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
public class MenuPrincipal extends JFrame{
    JButton botaoProduto, botaoUsuario, botaoCliente, botaoFornecedor;
    TelaProdutos Produto;
    TelaUsuarios Usuario;
    

    public MenuPrincipal(){
        super("Menu principal");
        Container tela = getContentPane();
        tela.setLayout(null);

        botaoProduto = new JButton("Produto");
        botaoUsuario = new JButton("Usuário");
        botaoCliente = new JButton("Cliente");
        botaoFornecedor = new JButton("Fornecedor");

        botaoProduto.setBounds(20, 20, 150, 20);
        botaoUsuario .setBounds(220, 20, 150, 20);
        botaoCliente.setBounds(20, 50, 150, 20);
        botaoFornecedor.setBounds(220, 50, 150, 20);

        tela.add(botaoProduto);
        tela.add(botaoUsuario);
        tela.add(botaoCliente);
        tela.add(botaoFornecedor);

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

       

        setSize(400, 130);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
}
