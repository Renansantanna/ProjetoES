import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.ParseException;
import java.util.Vector;
import javax.swing.text.*;

public class ProjetoES extends JFrame {


    JButton botaoProduto, botaoUsuario, botaoCliente, botaoFornecedor;
    TelaProdutos Produto;
    TelaUsuarios Usuario;
    
    

    public ProjetoES() {
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


    public static void main(String[] args) {
       MenuPrincipal  app = new MenuPrincipal();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

    




