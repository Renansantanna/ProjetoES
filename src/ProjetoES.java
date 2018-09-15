import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.ParseException;
import java.util.Vector;
import javax.swing.text.*;

public class ProjetoES extends JFrame {

<<<<<<< HEAD
    JButton botaoProduto, botaoUsuario, botaoCliente, botaoFornecedor;
    Produtos Produto;
    Usuarios Usuario;
    Clientes Cliente;
    Fornecedores Fornecedor;

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
                Produto = new Produtos();
                Produto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                Produto.setVisible(true);

            }
        });

        botaoUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Usuario = new Usuarios();
                Usuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                Usuario.setVisible(true);

            }
        });

        botaoCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Cliente = new Clientes();
                Cliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                Cliente.setVisible(true);

            }
        });

        botaoFornecedor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Fornecedor = new Fornecedores();
                Fornecedor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                Fornecedor.setVisible(true);
            }
        });

        setSize(400, 130);
        setVisible(true);
        setLocationRelativeTo(null);

    }

=======
 
>>>>>>> 403fa52cd62432643dd05bd55ca4e3034e2aa458
    public static void main(String[] args) {
       MenuPrincipal  app = new MenuPrincipal();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

    
////////////////////////////////////////////////
//COMEÇA OS USUARIOS AQUI
///////////////////////////////////////////////   
   
////////////////////////////////////////////////
//TERMINA OS USUARIOS AQUI
///////////////////////////////////////////////   



