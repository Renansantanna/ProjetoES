import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.ParseException;
import java.util.Vector;
import javax.swing.text.*;

public class ProjetoES extends JFrame {

    JButton botaoProduto, botaoUsuario, botaoCliente, botaoFornecedor, botao5;
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

    public static void main(String[] args) {
        ProjetoES app = new ProjetoES();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    ////////////////////////////////////////////////
    //COMEÇA OS PRODUTOS AQUI
    ///////////////////////////////////////////////
    private class Produtos extends JFrame {

        JButton botao, botao2, botao3, botao4, botao5, botao6, botao7;
        JLabel titulo, descri, lnome, quant, UnitVend, UnitComp;
        JTextField descricao, tnome, quantidade, UnitVenda, UnitCompra;
        RelatorioG relatorioG;
        RelatorioCP relatorioCP;

        public Produtos() {
            super("Produtos");
            Container tela1 = getContentPane();
            tela1.setLayout(null);
            titulo = new JLabel("Produtos");
            titulo.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
            descri = new JLabel("Descrição: ");
            lnome = new JLabel("Informe o produto a ser pesquisado: ");
            quant = new JLabel("Quantidade: ");
            UnitVend = new JLabel("Vl Unit Ven:");
            UnitComp = new JLabel("Vl Unit Comp: ");

            descricao = new JTextField(15);
            tnome = new JTextField(50);

            quantidade = new JTextField(15);
            UnitVenda = new JTextField(15);
            UnitCompra = new JTextField(15);

            botao = new JButton("Consultar Registro");
            botao2 = new JButton("Excluir Registro");
            botao3 = new JButton("Limpar Caixas");
            botao4 = new JButton("Incluir");
            botao5 = new JButton("Alterar Registro");
            botao6 = new JButton("Relatorio Geral");
            botao7 = new JButton("Relatorio com Parâmetro");

            descri.setBounds(20, 70, 300, 20);
            lnome.setBounds(60, 250, 300, 20);
            quant.setBounds(20, 110, 80, 20);
            UnitVend.setBounds(20, 150, 100, 20);
            UnitComp.setBounds(20, 190, 80, 20);

            descricao.setBounds(100, 70, 100, 20);
            tnome.setBounds(60, 280, 280, 20);

            quantidade.setBounds(100, 110, 100, 20);
            UnitVenda.setBounds(100, 150, 100, 20);
            UnitCompra.setBounds(100, 190, 100, 20);

            botao.setBounds(350, 260, 150, 20);
            botao2.setBounds(350, 290, 150, 20);
            botao3.setBounds(350, 170, 150, 20);
            botao4.setBounds(350, 70, 150, 20);
            botao5.setBounds(350, 110, 150, 20);
            botao6.setBounds(60, 330, 150, 20);
            botao7.setBounds(250, 330, 200, 20);

            titulo.setBounds(250, 10, 250, 20);

            tela1.add(descri);
            tela1.add(descricao);
            tela1.add(lnome);
            tela1.add(quant);
            tela1.add(UnitVend);
            tela1.add(UnitComp);
            tela1.add(tnome);
            tela1.add(quantidade);
            tela1.add(UnitVenda);
            tela1.add(UnitCompra);
            tela1.add(botao);
            tela1.add(botao2);
            tela1.add(botao3);
            tela1.add(botao4);
            tela1.add(botao5);
            tela1.add(botao6);
            tela1.add(botao7);

            tela1.add(titulo);

            botao.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    try {
                        Connection con;
                        String userName = "root";
                        String password = "";
                        String url = "jdbc:mysql://127.0.0.1/quatro_menus";

                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        con = DriverManager.getConnection(url, userName, password);

                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("SELECT * FROM produtos WHERE descricao LIKE'%" + tnome.getText() + "%'");
                        rs.next();

                        descricao.setText(rs.getString("descricao"));
                        quantidade.setText(rs.getString("quantidade"));
                        UnitVenda.setText(rs.getString("venda"));
                        UnitCompra.setText(rs.getString("compra"));

                        st.close();
                        con.close();
                    } catch (Exception event) {
                        JOptionPane.showMessageDialog(null, "Conexão não estabelecida / Registro não encontrado ", "Mensagem do Progama", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            botao2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    try {
                        Connection con;
                        String userName = "root";
                        String password = "";
                        String url = "jdbc:mysql://127.0.0.1/quatro_menus";

                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        con = DriverManager.getConnection(url, userName, password);

                        Statement st = con.createStatement();
                        st.executeUpdate("DELETE FROM produtos WHERE descricao LIKE '" + descricao.getText() + "'");

                        JOptionPane.showMessageDialog(null, "Registro excluido com sucesso! ", "Mensagem do Progama", JOptionPane.ERROR_MESSAGE);
                        descricao.setText("");
                        quantidade.setText("");
                        UnitVenda.setText("");
                        UnitCompra.setText("");
                        tnome.setText("");

                        descricao.requestFocus();

                        st.close();
                        con.close();
                    } catch (Exception event) {
                        JOptionPane.showMessageDialog(null, "Conexão não estabelecida / Registro não encontrado ", "Mensagem do Progama", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            botao3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    descricao.setText("");
                    tnome.setText("");
                    quantidade.setText("");
                    UnitCompra.setText("");
                    UnitVenda.setText("");

                }
            });

            botao4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    try {
                        Connection con;
                        String userName = "root";
                        String password = "";
                        String url = "jdbc:mysql://127.0.0.1/quatro_menus";

                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        con = DriverManager.getConnection(url, userName, password);

                        Statement st = con.createStatement();

                        st.executeUpdate("INSERT INTO produtos (descricao,quantidade,venda,compra) VALUES ('" + descricao.getText() + "','" + quantidade.getText() + "','" + UnitVenda.getText() + "','" + UnitCompra.getText() + "')");
                        descricao.setText("");
                        quantidade.setText("");

                        UnitVenda.setText("");
                        UnitCompra.setText("");
                        tnome.requestFocus();

                        JOptionPane.showMessageDialog(null, "Registro Inserido Com Sucesso", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

                        st.close();
                        con.close();
                    } catch (Exception event) {
                        JOptionPane.showMessageDialog(null, "Conexão não estabelecida", "Mensagem do Progama", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            botao5.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    try {
                        Connection con;
                        String userName = "root";
                        String password = "";
                        String url = "jdbc:mysql://127.0.0.1/quatro_menus";

                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        con = DriverManager.getConnection(url, userName, password);

                        Statement st = con.createStatement();
                        st.executeUpdate("UPDATE produtos SET quantidade ='" + quantidade.getText() + "',venda='" + UnitVenda.getText() + "',compra='" + UnitCompra.getText() + "' WHERE descricao LIKE'" + descricao.getText() + "'");

                        JOptionPane.showMessageDialog(null, "Registro Alterado com sucesso! ", "Mensagem do Progama", JOptionPane.INFORMATION_MESSAGE);
                        descricao.requestFocus();

                        st.close();
                        con.close();
                    } catch (Exception event) {
                        JOptionPane.showMessageDialog(null, "Conexão não estabelecida / Registro não encontrado ", "Mensagem do Progama", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            botao6.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    relatorioG = new RelatorioG();
                    relatorioG.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    relatorioG.setVisible(true);

                }
            });
            botao7.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    relatorioCP = new RelatorioCP();
                    relatorioCP.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    relatorioCP.setVisible(true);

                }
            });

            setSize(600, 400);
            setVisible(true);
            setLocationRelativeTo(null);

        }

    }

    private class RelatorioG extends JFrame {

        private Connection con;
        private JTable tabela;

        public RelatorioG() {
            super("Relatorio Geral");

            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://127.0.0.1/quatro_menus";

            try {

                Class.forName("com.mysql.jdbc.Driver").newInstance();
                con = DriverManager.getConnection(url, userName, password);

            } catch (Exception event) {
                JOptionPane.showMessageDialog(null, "Conexão não estabelecida  ", "Mensagem do Progama", JOptionPane.ERROR_MESSAGE);
            }
            buscaTabela();
            setSize(600, 200);
            setVisible(true);

        }

        private void buscaTabela() {
            Statement st;
            ResultSet res;

            try {
                Vector cabecalho = new Vector();
                Vector linhas = new Vector();

                st = con.createStatement();
                res = st.executeQuery("SELECT * FROM produtos ORDER BY descricao");
                res.next();
                ResultSetMetaData rsmd = res.getMetaData();
                for (int i = 2; i <= rsmd.getColumnCount(); ++i) {
                    cabecalho.addElement(rsmd.getColumnName(i));
                }
                do {
                    linhas.addElement(proximaLinha(res, rsmd));
                } while (res.next());
                tabela = new JTable(linhas, cabecalho);
                JScrollPane scroller = new JScrollPane(tabela);
                getContentPane().add(scroller, BorderLayout.CENTER);
                validate();
                st.close();

            } catch (SQLException sqlex) {

            }
        }

        private Vector proximaLinha(ResultSet rs, ResultSetMetaData rsmd) {
            Vector LinhaAtual = new Vector();
            try {
                for (int i = 1; i <= rsmd.getColumnCount(); ++i) {
                    switch (rsmd.getColumnType(i)) {
                        case Types.VARCHAR:
                            LinhaAtual.addElement(rs.getString(i));
                            break;
                        case Types.TIMESTAMP:
                            LinhaAtual.addElement(rs.getDate(i));
                            break;
                        case Types.NUMERIC:
                            LinhaAtual.addElement(new Long(rs.getLong(i)));
                            break;
                    }
                }
            } catch (SQLException e) {
            }
            return LinhaAtual;
        }
    }

    private class RelatorioCP extends JFrame {

        JButton b;
        JLabel l;
        JTextField t;
        Inicial janela;

        public RelatorioCP() {
            super("Relatorio com Parâmetros");
            Container tela = getContentPane();
            setLayout(null);

            l = new JLabel("Descrição:");
            l.setBounds(20, 20, 100, 20);

            t = new JTextField(50);
            t.setBounds(20, 50, 250, 20);

            b = new JButton("Exibir Relatório");
            b.setBounds(100, 90, 150, 20);

            tela.add(l);
            tela.add(t);
            tela.add(b);

            b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    janela = new Inicial();
                    janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    janela.setVisible(true);

                }
            });

            setSize(400, 200);
            setVisible(true);
            setLocationRelativeTo(null);

        }

        private class Inicial extends JFrame {

            private Connection con;
            private JTable tabela;

            private Inicial() {
                super("Relatorio com Parâmetro");
                setSize(400, 300);
                setLocationRelativeTo(null);
                String userName = "root";
                String password = "";
                String url = "jdbc:mysql://127.0.0.1/quatro_menus";
                try {

                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    con = DriverManager.getConnection(url, userName, password);

                } catch (Exception event) {
                    JOptionPane.showMessageDialog(null, "Conexão não estabelecida  ", "Mensagem do Progama", JOptionPane.ERROR_MESSAGE);
                }
                buscaTabela();
            }

            private void buscaTabela() {
                Statement st;
                ResultSet res;

                try {
                    Vector cabecalho = new Vector();
                    Vector linhas = new Vector();

                    st = con.createStatement();
                    res = st.executeQuery("SELECT * FROM produtos where descricao LIKE'%" + t.getText() + "%'");
                    res.next();
                    ResultSetMetaData rsmd = res.getMetaData();
                    for (int i = 2; i <= rsmd.getColumnCount(); ++i) {
                        cabecalho.addElement(rsmd.getColumnName(i));
                    }
                    do {
                        linhas.addElement(proximaLinha(res, rsmd));
                    } while (res.next());
                    tabela = new JTable(linhas, cabecalho);
                    JScrollPane scroller = new JScrollPane(tabela);
                    getContentPane().add(scroller, BorderLayout.CENTER);
                    validate();
                    st.close();

                } catch (SQLException sqlex) {

                }
            }

            private Vector proximaLinha(ResultSet rs, ResultSetMetaData rsmd) {
                Vector LinhaAtual = new Vector();
                try {
                    for (int i = 1; i <= rsmd.getColumnCount(); ++i) {
                        switch (rsmd.getColumnType(i)) {
                            case Types.VARCHAR:
                                LinhaAtual.addElement(rs.getString(i));
                                break;
                            case Types.TIMESTAMP:
                                LinhaAtual.addElement(rs.getDate(i));
                                break;
                            case Types.NUMERIC:
                                LinhaAtual.addElement(new Long(rs.getLong(i)));
                                break;
                        }
                    }
                } catch (SQLException e) {
                }
                return LinhaAtual;
            }

        }

    }
//////////////////////////////////////////////
//TERMINA OS PRODUTOS AQUI
//////////////////////////////////////////////

////////////////////////////////////////////////
//COMEÇA OS USUARIOS AQUI
///////////////////////////////////////////////   
    private class Usuarios extends JFrame {

        JButton botao, botao2, botao3, botao4, botao5, botao6, botao7;
        JLabel titulo, descri, lnome, quant, UnitVend;
        JTextField descricao, tnome, quantidade;
        JPasswordField UnitVenda;
        RelatorioG2 relatorioG2;
        RelatorioCP2 relatorioCP2;

        public Usuarios() {
            super("Usuarios");
            Container tela1 = getContentPane();
            tela1.setLayout(null);
            titulo = new JLabel("Usuarios");
            titulo.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
            descri = new JLabel("Nome: ");
            lnome = new JLabel("Informe o Nome a ser pesquisado: ");
            quant = new JLabel("Login: ");
            UnitVend = new JLabel("Senha:");

            descricao = new JTextField(15);
            tnome = new JTextField(50);

            quantidade = new JTextField(15);
            UnitVenda = new JPasswordField(15);

            botao = new JButton("Consultar Registro");
            botao2 = new JButton("Excluir Registro");
            botao3 = new JButton("Limpar Caixas");
            botao4 = new JButton("Incluir");
            botao5 = new JButton("Alterar Registro");
            botao6 = new JButton("Relatorio Geral");
            botao7 = new JButton("Relatorio com Parâmetro");

            descri.setBounds(20, 70, 300, 20);
            lnome.setBounds(60, 250, 300, 20);
            quant.setBounds(20, 110, 80, 20);
            UnitVend.setBounds(20, 150, 100, 20);

            descricao.setBounds(100, 70, 100, 20);
            tnome.setBounds(60, 280, 280, 20);

            quantidade.setBounds(100, 110, 100, 20);
            UnitVenda.setBounds(100, 150, 100, 20);

            botao.setBounds(350, 260, 150, 20);
            botao2.setBounds(350, 290, 150, 20);
            botao3.setBounds(350, 170, 150, 20);
            botao4.setBounds(350, 70, 150, 20);
            botao5.setBounds(350, 110, 150, 20);
            botao6.setBounds(60, 330, 150, 20);
            botao7.setBounds(250, 330, 200, 20);

            titulo.setBounds(250, 10, 250, 20);

            tela1.add(descri);
            tela1.add(descricao);
            tela1.add(lnome);
            tela1.add(quant);
            tela1.add(UnitVend);

            tela1.add(tnome);
            tela1.add(quantidade);
            tela1.add(UnitVenda);

            tela1.add(botao);
            tela1.add(botao2);
            tela1.add(botao3);
            tela1.add(botao4);
            tela1.add(botao5);
            tela1.add(botao6);
            tela1.add(botao7);

            tela1.add(titulo);

            botao.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    try {
                        Connection con;
                        String userName = "root";
                        String password = "";
                        String url = "jdbc:mysql://127.0.0.1/quatro_menus";

                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        con = DriverManager.getConnection(url, userName, password);

                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("SELECT * FROM usuario WHERE nome LIKE'%" + tnome.getText() + "%'");
                        rs.next();

                        descricao.setText(rs.getString("Nome"));
                        quantidade.setText(rs.getString("Login"));
                        UnitVenda.setText(rs.getString("Senha"));

                        st.close();
                        con.close();
                    } catch (Exception event) {
                        JOptionPane.showMessageDialog(null, "Conexão não estabelecida / Registro não encontrado ", "Mensagem do Progama", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            botao2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    try {
                        Connection con;
                        String userName = "root";
                        String password = "";
                        String url = "jdbc:mysql://127.0.0.1/quatro_menus";

                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        con = DriverManager.getConnection(url, userName, password);

                        Statement st = con.createStatement();
                        st.executeUpdate("DELETE FROM usuario WHERE nome LIKE '" + descricao.getText() + "'");

                        JOptionPane.showMessageDialog(null, "Registro excluido com sucesso! ", "Mensagem do Progama", JOptionPane.ERROR_MESSAGE);
                        descricao.setText("");
                        quantidade.setText("");
                        UnitVenda.setText("");

                        tnome.setText("");

                        descricao.requestFocus();

                        st.close();
                        con.close();
                    } catch (Exception event) {
                        JOptionPane.showMessageDialog(null, "Conexão não estabelecida / Registro não encontrado ", "Mensagem do Progama", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            botao3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    descricao.setText("");
                    tnome.setText("");
                    quantidade.setText("");

                    UnitVenda.setText("");

                }
            });

            botao4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    try {
                        Connection con;
                        String userName = "root";
                        String password = "";
                        String url = "jdbc:mysql://127.0.0.1/quatro_menus";

                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        con = DriverManager.getConnection(url, userName, password);

                        Statement st = con.createStatement();

                        st.executeUpdate("INSERT INTO usuario (Nome,Login,Senha) VALUES ('" + descricao.getText() + "','" + quantidade.getText() + "','" + UnitVenda.getText() + "')");
                        descricao.setText("");
                        quantidade.setText("");
                        UnitVenda.setText("");

                        tnome.requestFocus();

                        JOptionPane.showMessageDialog(null, "Registro Inserido Com Sucesso", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

                        st.close();
                        con.close();
                    } catch (Exception event) {
                        JOptionPane.showMessageDialog(null, "Conexão não estabelecida", "Mensagem do Progama", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            botao5.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    try {
                        Connection con;
                        String userName = "root";
                        String password = "";
                        String url = "jdbc:mysql://127.0.0.1/quatro_menus";

                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        con = DriverManager.getConnection(url, userName, password);

                        Statement st = con.createStatement();
                        st.executeUpdate("UPDATE usuario SET login ='" + quantidade.getText() + "',senha='" + UnitVenda.getText() + "' WHERE nome LIKE'" + descricao.getText() + "'");

                        JOptionPane.showMessageDialog(null, "Registro Alterado com sucesso! ", "Mensagem do Progama", JOptionPane.INFORMATION_MESSAGE);
                        descricao.requestFocus();

                        st.close();
                        con.close();
                    } catch (Exception event) {
                        JOptionPane.showMessageDialog(null, "Conexão não estabelecida / Registro não encontrado ", "Mensagem do Progama", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            botao6.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    relatorioG2 = new RelatorioG2();
                    relatorioG2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    relatorioG2.setVisible(true);

                }
            });
            botao7.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    relatorioCP2 = new RelatorioCP2();
                    relatorioCP2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    relatorioCP2.setVisible(true);

                }
            });

            setSize(600, 400);
            setVisible(true);
            setLocationRelativeTo(null);

        }

    }

    private class RelatorioG2 extends JFrame {

        private Connection con;
        private JTable tabela;

        public RelatorioG2() {
            super("Relatorio Geral");

            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://127.0.0.1/quatro_menus";

            try {

                Class.forName("com.mysql.jdbc.Driver").newInstance();
                con = DriverManager.getConnection(url, userName, password);

            } catch (Exception event) {
                JOptionPane.showMessageDialog(null, "Conexão não estabelecida  ", "Mensagem do Progama", JOptionPane.ERROR_MESSAGE);
            }
            buscaTabela();
            setSize(600, 200);
            setVisible(true);

        }

        private void buscaTabela() {
            Statement st;
            ResultSet res;

            try {
                Vector cabecalho = new Vector();
                Vector linhas = new Vector();

                st = con.createStatement();
                res = st.executeQuery("SELECT * FROM usuario ORDER BY nome");
                res.next();
                ResultSetMetaData rsmd = res.getMetaData();
                for (int i = 2; i <= rsmd.getColumnCount(); ++i) {
                    cabecalho.addElement(rsmd.getColumnName(i));
                }
                do {
                    linhas.addElement(proximaLinha(res, rsmd));
                } while (res.next());
                tabela = new JTable(linhas, cabecalho);
                JScrollPane scroller = new JScrollPane(tabela);
                getContentPane().add(scroller, BorderLayout.CENTER);
                validate();
                st.close();

            } catch (SQLException sqlex) {

            }
        }

        private Vector proximaLinha(ResultSet rs, ResultSetMetaData rsmd) {
            Vector LinhaAtual = new Vector();
            try {
                for (int i = 1; i <= rsmd.getColumnCount(); ++i) {
                    switch (rsmd.getColumnType(i)) {
                        case Types.VARCHAR:
                            LinhaAtual.addElement(rs.getString(i));
                            break;
                        case Types.TIMESTAMP:
                            LinhaAtual.addElement(rs.getDate(i));
                            break;
                        case Types.NUMERIC:
                            LinhaAtual.addElement(new Long(rs.getLong(i)));
                            break;
                    }
                }
            } catch (SQLException e) {
            }
            return LinhaAtual;
        }
    }

    private class RelatorioCP2 extends JFrame {

        JButton b;
        JLabel l;
        JTextField t;
        Inicial janela;

        public RelatorioCP2() {
            super("Relatorio com Parâmetros");
            Container tela = getContentPane();
            setLayout(null);

            l = new JLabel("Nome:");
            l.setBounds(20, 20, 100, 20);

            t = new JTextField(50);
            t.setBounds(20, 50, 250, 20);

            b = new JButton("Exibir Relatório");
            b.setBounds(100, 90, 150, 20);

            tela.add(l);
            tela.add(t);
            tela.add(b);

            b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    janela = new Inicial();
                    janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    janela.setVisible(true);

                }
            });

            setSize(400, 200);
            setVisible(true);
            setLocationRelativeTo(null);

        }

        private class Inicial extends JFrame {

            private Connection con;
            private JTable tabela;

            private Inicial() {
                super("Relatorio com Parâmetro");
                setSize(400, 300);
                setLocationRelativeTo(null);
                String userName = "root";
                String password = "";
                String url = "jdbc:mysql://127.0.0.1/quatro_menus";
                try {

                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    con = DriverManager.getConnection(url, userName, password);

                } catch (Exception event) {
                    JOptionPane.showMessageDialog(null, "Conexão não estabelecida  ", "Mensagem do Progama", JOptionPane.ERROR_MESSAGE);
                }
                buscaTabela();
            }

            private void buscaTabela() {
                Statement st;
                ResultSet res;

                try {
                    Vector cabecalho = new Vector();
                    Vector linhas = new Vector();

                    st = con.createStatement();
                    res = st.executeQuery("SELECT * FROM usuario where nome LIKE'%" + t.getText() + "%'");
                    res.next();
                    ResultSetMetaData rsmd = res.getMetaData();
                    for (int i = 2; i <= rsmd.getColumnCount(); ++i) {
                        cabecalho.addElement(rsmd.getColumnName(i));
                    }
                    do {
                        linhas.addElement(proximaLinha(res, rsmd));
                    } while (res.next());
                    tabela = new JTable(linhas, cabecalho);
                    JScrollPane scroller = new JScrollPane(tabela);
                    getContentPane().add(scroller, BorderLayout.CENTER);
                    validate();
                    st.close();

                } catch (SQLException sqlex) {

                }
            }

            private Vector proximaLinha(ResultSet rs, ResultSetMetaData rsmd) {
                Vector LinhaAtual = new Vector();
                try {
                    for (int i = 1; i <= rsmd.getColumnCount(); ++i) {
                        switch (rsmd.getColumnType(i)) {
                            case Types.VARCHAR:
                                LinhaAtual.addElement(rs.getString(i));
                                break;
                            case Types.TIMESTAMP:
                                LinhaAtual.addElement(rs.getDate(i));
                                break;
                            case Types.NUMERIC:
                                LinhaAtual.addElement(new Long(rs.getLong(i)));
                                break;
                        }
                    }
                } catch (SQLException e) {
                }
                return LinhaAtual;
            }

        }

    }

////////////////////////////////////////////////
//TERMINA OS USUARIOS AQUI
///////////////////////////////////////////////   
////////////////////////////////////////////////
//COMEÇA OS Clientes AQUI
///////////////////////////////////////////////   
    private class Clientes extends JFrame {

        JButton botao, botao2, botao3, botao4, botao5, botao6, botao7;
        JLabel titulo, nome, lnome, endereco, complemento, bairro, cidade, estado, telefone, celular, cpf, rg;
        JTextField nome2, tnome, endereco2, complemento2, bairro2, cidade2, estado2;
        JFormattedTextField telefone2, celular2, cpf2, rg2;
        MaskFormatter tel, cel, c, r;
        RelatorioG3 relatorioG3;
        RelatorioCP3 relatorioCP3;

        public Clientes() {
            super("Clientes");
            Container tela1 = getContentPane();
            tela1.setLayout(null);
            titulo = new JLabel("Clientes");
            titulo.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
            lnome = new JLabel("Informe o Cliente a ser pesquisado: ");
            nome = new JLabel("Nome: ");
            endereco = new JLabel("Endereço: ");
            complemento = new JLabel("Complemento:");
            bairro = new JLabel("Bairro: ");
            cidade = new JLabel("Cidade: ");
            estado = new JLabel("Estado:");
            telefone = new JLabel("Telefone: ");
            celular = new JLabel("Celular: ");
            cpf = new JLabel("CPF:");
            rg = new JLabel("RG: ");

            nome2 = new JTextField(15);
            tnome = new JTextField(50);

            endereco2 = new JTextField(15);
            complemento2 = new JTextField(15);
            bairro2 = new JTextField(15);
            cidade2 = new JTextField(15);
            estado2 = new JTextField(15);

            try {
                tel = new MaskFormatter("(##) ####-####");
                cel = new MaskFormatter("(##) #####-####");
                c = new MaskFormatter(" ###.###.###/##");
                r = new MaskFormatter("##.###.###-#");
            } catch (ParseException excp) {
            }

            telefone2 = new JFormattedTextField(tel);;
            celular2 = new JFormattedTextField(cel);;
            cpf2 = new JFormattedTextField(c);;
            rg2 = new JFormattedTextField(r);;

            botao = new JButton("Consultar Registro");
            botao2 = new JButton("Excluir Registro");
            botao3 = new JButton("Limpar Caixas");
            botao4 = new JButton("Incluir");
            botao5 = new JButton("Alterar Registro");
            botao6 = new JButton("Relatorio Geral");
            botao7 = new JButton("Relatorio com Parâmetro");

            nome.setBounds(20, 70, 300, 20);
            lnome.setBounds(60, 490, 300, 20);
            endereco.setBounds(20, 110, 80, 20);
            complemento.setBounds(20, 150, 100, 20);
            bairro.setBounds(20, 190, 80, 20);
            cidade.setBounds(20, 230, 80, 20);
            estado.setBounds(20, 270, 80, 20);
            telefone.setBounds(20, 310, 80, 20);
            celular.setBounds(20, 350, 80, 20);
            cpf.setBounds(20, 390, 80, 20);
            rg.setBounds(20, 430, 80, 20);

            tnome.setBounds(60, 520, 280, 20);
            nome2.setBounds(110, 70, 200, 20);
            endereco2.setBounds(110, 110, 200, 20);
            complemento2.setBounds(110, 150, 200, 20);
            bairro2.setBounds(110, 190, 200, 20);
            cidade2.setBounds(110, 230, 200, 20);
            estado2.setBounds(110, 270, 200, 20);
            telefone2.setBounds(110, 310, 200, 20);
            celular2.setBounds(110, 350, 200, 20);
            cpf2.setBounds(110, 390, 200, 20);
            rg2.setBounds(110, 430, 200, 20);

            botao.setBounds(350, 490, 150, 20);
            botao2.setBounds(350, 530, 150, 20);
            botao3.setBounds(350, 170, 150, 20);
            botao4.setBounds(350, 70, 150, 20);
            botao5.setBounds(350, 110, 150, 20);
            botao6.setBounds(60, 570, 150, 20);
            botao7.setBounds(250, 570, 200, 20);

            titulo.setBounds(250, 10, 250, 20);

            tela1.add(nome);
            tela1.add(nome2);
            tela1.add(lnome);
            tela1.add(endereco);
            tela1.add(complemento);
            tela1.add(bairro);
            tela1.add(cidade);
            tela1.add(estado);
            tela1.add(telefone);
            tela1.add(celular);
            tela1.add(cpf);
            tela1.add(rg);
            tela1.add(endereco2);
            tela1.add(complemento2);
            tela1.add(bairro2);
            tela1.add(cidade2);
            tela1.add(estado2);
            tela1.add(telefone2);
            tela1.add(celular2);
            tela1.add(cpf2);
            tela1.add(rg2);

            tela1.add(tnome);

            tela1.add(botao);
            tela1.add(botao2);
            tela1.add(botao3);
            tela1.add(botao4);
            tela1.add(botao5);
            tela1.add(botao6);
            tela1.add(botao7);

            tela1.add(titulo);

            botao.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    try {
                        Connection con;
                        String userName = "root";
                        String password = "";
                        String url = "jdbc:mysql://127.0.0.1/quatro_menus";

                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        con = DriverManager.getConnection(url, userName, password);

                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("SELECT * FROM clientes WHERE nome LIKE'%" + tnome.getText() + "%'");
                        rs.next();

                        nome2.setText(rs.getString("nome"));
                        endereco2.setText(rs.getString("endereco"));
                        complemento2.setText(rs.getString("complemento"));
                        bairro2.setText(rs.getString("bairro"));
                        cidade2.setText(rs.getString("cidade"));
                        estado2.setText(rs.getString("estado"));
                        telefone2.setText(rs.getString("telefone"));
                        celular2.setText(rs.getString("celular"));
                        cpf2.setText(rs.getString("cpf"));
                        rg2.setText(rs.getString("rg"));
                        st.close();
                        con.close();
                    } catch (Exception event) {
                        JOptionPane.showMessageDialog(null, "Conexão não estabelecida / Registro não encontrado ", "Mensagem do Progama", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            botao2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    try {
                        Connection con;
                        String userName = "root";
                        String password = "";
                        String url = "jdbc:mysql://127.0.0.1/quatro_menus";

                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        con = DriverManager.getConnection(url, userName, password);

                        Statement st = con.createStatement();
                        st.executeUpdate("DELETE FROM clientes WHERE nome LIKE '" + nome2.getText() + "'");

                        JOptionPane.showMessageDialog(null, "Registro excluido com sucesso! ", "Mensagem do Progama", JOptionPane.ERROR_MESSAGE);
                        nome2.setText("");
                        endereco2.setText("");
                        complemento2.setText("");
                        bairro2.setText("");
                        cidade2.setText("");
                        estado2.setText("");
                        telefone2.setText("");
                        celular2.setText("");
                        cpf2.setText("");
                        rg2.setText("");
                        tnome.setText("");

                        nome2.requestFocus();

                        st.close();
                        con.close();
                    } catch (Exception event) {
                        JOptionPane.showMessageDialog(null, "Conexão não estabelecida / Registro não encontrado ", "Mensagem do Progama", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            botao3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    nome2.setText("");
                    endereco2.setText("");
                    complemento2.setText("");
                    bairro2.setText("");
                    cidade2.setText("");
                    estado2.setText("");
                    telefone2.setText("");
                    celular2.setText("");
                    cpf2.setText("");
                    rg2.setText("");
                    tnome.setText("");

                }
            });

            botao4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    try {
                        Connection con;
                        String userName = "root";
                        String password = "";
                        String url = "jdbc:mysql://127.0.0.1/quatro_menus";

                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        con = DriverManager.getConnection(url, userName, password);

                        Statement st = con.createStatement();

                        st.executeUpdate("INSERT INTO clientes (nome,endereco,complemento,bairro,cidade,estado,telefone,celular,cpf,rg) VALUES ('" + nome2.getText() + "','" + endereco2.getText() + "','" + complemento2.getText() + "','" + bairro2.getText() + "','" + cidade2.getText() + "','" + estado2.getText() + "','" + telefone2.getText() + "','" + celular2.getText() + "','" + cpf2.getText() + "','" + rg2.getText() + "')");
                        nome2.setText("");
                        endereco2.setText("");
                        complemento2.setText("");
                        bairro2.setText("");
                        cidade2.setText("");
                        estado2.setText("");
                        telefone2.setText("");
                        celular2.setText("");
                        cpf2.setText("");
                        rg2.setText("");
                        tnome.setText("");

                        JOptionPane.showMessageDialog(null, "Registro Inserido Com Sucesso", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

                        st.close();
                        con.close();
                    } catch (Exception event) {
                        JOptionPane.showMessageDialog(null, "Conexão não estabelecida", "Mensagem do Progama", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            botao5.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    try {
                        Connection con;
                        String userName = "root";
                        String password = "";
                        String url = "jdbc:mysql://127.0.0.1/quatro_menus";

                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        con = DriverManager.getConnection(url, userName, password);

                        Statement st = con.createStatement();
                        st.executeUpdate("UPDATE clientes SET endereco ='" + endereco2.getText() + "',complemento='" + complemento2.getText() + "',bairro='" + bairro2.getText() + "',cidade='" + cidade2.getText() + "',estado='" + estado2.getText() + "',telefone='" + telefone2.getText() + "',celular='" + celular2.getText() + "',cpf='" + cpf2.getText() + "',rg='" + rg2.getText() + "' WHERE nome LIKE'" + nome2.getText() + "'");

                        JOptionPane.showMessageDialog(null, "Registro Alterado com sucesso! ", "Mensagem do Progama", JOptionPane.INFORMATION_MESSAGE);
                        nome2.requestFocus();

                        st.close();
                        con.close();
                    } catch (Exception event) {
                        JOptionPane.showMessageDialog(null, "Conexão não estabelecida / Registro não encontrado ", "Mensagem do Progama", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            botao6.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    relatorioG3 = new RelatorioG3();
                    relatorioG3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    relatorioG3.setVisible(true);

                }
            });
            botao7.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    relatorioCP3 = new RelatorioCP3();
                    relatorioCP3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    relatorioCP3.setVisible(true);

                }
            });

            setSize(600, 700);
            setVisible(true);
            setLocationRelativeTo(null);

        }

    }

    private class RelatorioG3 extends JFrame {

        private Connection con;
        private JTable tabela;

        public RelatorioG3() {
            super("Relatorio Geral");

            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://127.0.0.1/quatro_menus";

            try {

                Class.forName("com.mysql.jdbc.Driver").newInstance();
                con = DriverManager.getConnection(url, userName, password);

            } catch (Exception event) {
                JOptionPane.showMessageDialog(null, "Conexão não estabelecida  ", "Mensagem do Progama", JOptionPane.ERROR_MESSAGE);
            }
            buscaTabela();
            setSize(1000, 200);
            setVisible(true);

        }

        private void buscaTabela() {
            Statement st;
            ResultSet res;

            try {
                Vector cabecalho = new Vector();
                Vector linhas = new Vector();

                st = con.createStatement();
                res = st.executeQuery("SELECT * FROM clientes ORDER BY COD");
                res.next();
                ResultSetMetaData rsmd = res.getMetaData();
                for (int i = 2; i <= rsmd.getColumnCount(); ++i) {
                    cabecalho.addElement(rsmd.getColumnName(i));
                }
                do {
                    linhas.addElement(proximaLinha(res, rsmd));
                } while (res.next());
                tabela = new JTable(linhas, cabecalho);
                JScrollPane scroller = new JScrollPane(tabela);
                getContentPane().add(scroller, BorderLayout.CENTER);
                validate();
                st.close();

            } catch (SQLException sqlex) {

            }
        }

        private Vector proximaLinha(ResultSet rs, ResultSetMetaData rsmd) {
            Vector LinhaAtual = new Vector();
            try {
                for (int i = 1; i <= rsmd.getColumnCount(); ++i) {
                    switch (rsmd.getColumnType(i)) {
                        case Types.VARCHAR:
                            LinhaAtual.addElement(rs.getString(i));
                            break;
                        case Types.TIMESTAMP:
                            LinhaAtual.addElement(rs.getDate(i));
                            break;
                        case Types.NUMERIC:
                            LinhaAtual.addElement(new Long(rs.getLong(i)));
                            break;
                    }
                }
            } catch (SQLException e) {
            }
            return LinhaAtual;
        }
    }

    private class RelatorioCP3 extends JFrame {

        JButton b;
        JLabel l;
        JTextField t;
        Inicial janela;

        public RelatorioCP3() {
            super("Relatorio com Parâmetros");
            Container tela = getContentPane();
            setLayout(null);

            l = new JLabel("Nome do Cliente:");
            l.setBounds(20, 20, 100, 20);

            t = new JTextField(50);
            t.setBounds(20, 50, 250, 20);

            b = new JButton("Exibir Relatório");
            b.setBounds(100, 90, 150, 20);

            tela.add(l);
            tela.add(t);
            tela.add(b);

            b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    janela = new Inicial();
                    janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    janela.setVisible(true);

                }
            });

            setSize(300, 200);
            setVisible(true);
            setLocationRelativeTo(null);

        }

        private class Inicial extends JFrame {

            private Connection con;
            private JTable tabela;

            private Inicial() {
                super("Relatorio com Parâmetro");
                setSize(1000, 300);
                setLocationRelativeTo(null);
                String userName = "root";
                String password = "";
                String url = "jdbc:mysql://127.0.0.1/quatro_menus";
                try {

                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    con = DriverManager.getConnection(url, userName, password);

                } catch (Exception event) {
                    JOptionPane.showMessageDialog(null, "Conexão não estabelecida  ", "Mensagem do Progama", JOptionPane.ERROR_MESSAGE);
                }
                buscaTabela();
            }

            private void buscaTabela() {
                Statement st;
                ResultSet res;

                try {
                    Vector cabecalho = new Vector();
                    Vector linhas = new Vector();

                    st = con.createStatement();
                    res = st.executeQuery("SELECT * FROM clientes where nome LIKE'%" + t.getText() + "%'");
                    res.next();
                    ResultSetMetaData rsmd = res.getMetaData();
                    for (int i = 2; i <= rsmd.getColumnCount(); ++i) {
                        cabecalho.addElement(rsmd.getColumnName(i));
                    }
                    do {
                        linhas.addElement(proximaLinha(res, rsmd));
                    } while (res.next());
                    tabela = new JTable(linhas, cabecalho);
                    JScrollPane scroller = new JScrollPane(tabela);
                    getContentPane().add(scroller, BorderLayout.CENTER);
                    validate();
                    st.close();

                } catch (SQLException sqlex) {

                }
            }

            private Vector proximaLinha(ResultSet rs, ResultSetMetaData rsmd) {
                Vector LinhaAtual = new Vector();
                try {
                    for (int i = 1; i <= rsmd.getColumnCount(); ++i) {
                        switch (rsmd.getColumnType(i)) {
                            case Types.VARCHAR:
                                LinhaAtual.addElement(rs.getString(i));
                                break;
                            case Types.TIMESTAMP:
                                LinhaAtual.addElement(rs.getDate(i));
                                break;
                            case Types.NUMERIC:
                                LinhaAtual.addElement(new Long(rs.getLong(i)));
                                break;
                        }
                    }
                } catch (SQLException e) {
                }
                return LinhaAtual;
            }

        }

    }
////////////////////////////////////////////////
//Termina OS Clientes AQUI
///////////////////////////////////////////////  

////////////////////////////////////////////////
//Começa OS Fornecedores AQUI
///////////////////////////////////////////////      
    private class Fornecedores extends JFrame {

        JButton botao, botao2, botao3, botao4, botao5, botao6, botao7;
        JLabel titulo, lnome, endereco, complemento, bairro, cidade, estado, telefone1, telefone2, cnpj, contato;
        JTextField tnome, endereco2, complemento2, bairro2, cidade2, estado2, contato2;
        JFormattedTextField telefone12, telefone22, cnpj2;
        MaskFormatter tel, cel, c;
        RelatorioG4 relatorioG4;
        RelatorioCP4 relatorioCP4;

        public Fornecedores() {
            super("Fornecedores");
            Container tela1 = getContentPane();
            tela1.setLayout(null);
            titulo = new JLabel("Fornecedores");
            titulo.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
            lnome = new JLabel("Informe o Contato a ser pesquisado: ");
            endereco = new JLabel("Endereço: ");
            complemento = new JLabel("Complemento:");
            bairro = new JLabel("Bairro: ");
            cidade = new JLabel("Cidade: ");
            estado = new JLabel("Estado:");
            telefone1 = new JLabel("Telefone: ");
            telefone2 = new JLabel("Telefone 2: ");
            cnpj = new JLabel("CNPJ:");
            contato = new JLabel("Contato: ");

            tnome = new JTextField(50);

            endereco2 = new JTextField(15);
            complemento2 = new JTextField(15);
            bairro2 = new JTextField(15);
            cidade2 = new JTextField(15);
            estado2 = new JTextField(15);
            contato2 = new JTextField(15);
            
            try {
                tel = new MaskFormatter("(##) ####-####");
                cel = new MaskFormatter("(##) ####-####");
                c = new MaskFormatter(" ##.###.###/####-##");

            } 
            catch (ParseException excp) {
                
            }

            telefone12 = new JFormattedTextField(tel);
            telefone22 = new JFormattedTextField(cel);
            cnpj2 = new JFormattedTextField(c);

            botao = new JButton("Consultar Registro");
            botao2 = new JButton("Excluir Registro");
            botao3 = new JButton("Limpar Caixas");
            botao4 = new JButton("Incluir");
            botao5 = new JButton("Alterar Registro");
            botao6 = new JButton("Relatorio Geral");
            botao7 = new JButton("Relatorio com Parâmetro");

            lnome.setBounds(60, 490, 300, 20);
            endereco.setBounds(20, 110, 80, 20);
            complemento.setBounds(20, 150, 100, 20);
            bairro.setBounds(20, 190, 80, 20);
            cidade.setBounds(20, 230, 80, 20);
            estado.setBounds(20, 270, 80, 20);
            telefone1.setBounds(20, 310, 80, 20);
            telefone2.setBounds(20, 350, 80, 20);
            cnpj.setBounds(20, 390, 80, 20);
            contato.setBounds(20, 430, 80, 20);

            tnome.setBounds(60, 520, 280, 20);

            endereco2.setBounds(110, 110, 200, 20);
            complemento2.setBounds(110, 150, 200, 20);
            bairro2.setBounds(110, 190, 200, 20);
            cidade2.setBounds(110, 230, 200, 20);
            estado2.setBounds(110, 270, 200, 20);
            telefone12.setBounds(110, 310, 200, 20);
            telefone22.setBounds(110, 350, 200, 20);
            cnpj2.setBounds(110, 390, 200, 20);
            contato2.setBounds(110, 430, 200, 20);

            botao.setBounds(350, 490, 150, 20);
            botao2.setBounds(350, 530, 150, 20);
            botao3.setBounds(350, 170, 150, 20);
            botao4.setBounds(350, 70, 150, 20);
            botao5.setBounds(350, 110, 150, 20);
            botao6.setBounds(60, 570, 150, 20);
            botao7.setBounds(250, 570, 200, 20);

            titulo.setBounds(250, 10, 250, 20);

            tela1.add(lnome);
            tela1.add(endereco);
            tela1.add(complemento);
            tela1.add(bairro);
            tela1.add(cidade);
            tela1.add(estado);
            tela1.add(telefone1);
            tela1.add(telefone2);
            tela1.add(cnpj);
            tela1.add(contato);
            tela1.add(endereco2);
            tela1.add(complemento2);
            tela1.add(bairro2);
            tela1.add(cidade2);
            tela1.add(estado2);
            tela1.add(telefone12);
            tela1.add(telefone22);
            tela1.add(cnpj2);
            tela1.add(contato2);

            tela1.add(tnome);

            tela1.add(botao);
            tela1.add(botao2);
            tela1.add(botao3);
            tela1.add(botao4);
            tela1.add(botao5);
            tela1.add(botao6);
            tela1.add(botao7);

            tela1.add(titulo);

            botao.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    try {
                        Connection con;
                        String userName = "root";
                        String password = "";
                        String url = "jdbc:mysql://127.0.0.1/quatro_menus";

                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        con = DriverManager.getConnection(url, userName, password);

                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("SELECT * FROM fornecedores WHERE contato LIKE'%" + tnome.getText() + "%'");
                        rs.next();

                        endereco2.setText(rs.getString("endereco"));
                        complemento2.setText(rs.getString("complemento"));
                        bairro2.setText(rs.getString("bairro"));
                        cidade2.setText(rs.getString("cidade"));
                        estado2.setText(rs.getString("estado"));
                        telefone12.setText(rs.getString("telefone"));
                        telefone22.setText(rs.getString("telefone2"));
                        cnpj2.setText(rs.getString("cnpj"));
                        contato2.setText(rs.getString("contato"));
                        st.close();
                        con.close();
                    } catch (Exception event) {
                        JOptionPane.showMessageDialog(null, "Conexão não estabelecida / Registro não encontrado ", "Mensagem do Progama", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            botao2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    try {
                        Connection con;
                        String userName = "root";
                        String password = "";
                        String url = "jdbc:mysql://127.0.0.1/quatro_menus";

                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        con = DriverManager.getConnection(url, userName, password);

                        Statement st = con.createStatement();
                        st.executeUpdate("DELETE FROM fornecedores WHERE cnpj LIKE '" + cnpj2.getText() + "'");

                        JOptionPane.showMessageDialog(null, "Registro excluido com sucesso! ", "Mensagem do Progama", JOptionPane.ERROR_MESSAGE);
                        endereco2.setText("");
                        complemento2.setText("");
                        bairro2.setText("");
                        cidade2.setText("");
                        estado2.setText("");
                        telefone12.setText("");
                        telefone22.setText("");
                        cnpj2.setText("");
                        contato2.setText("");
                        tnome.setText("");

                        endereco2.requestFocus();

                        st.close();
                        con.close();
                    } catch (Exception event) {
                        JOptionPane.showMessageDialog(null, "Conexão não estabelecida / Registro não encontrado ", "Mensagem do Progama", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            botao3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    endereco2.setText("");
                    complemento2.setText("");
                    bairro2.setText("");
                    cidade2.setText("");
                    estado2.setText("");
                    telefone12.setText("");
                    telefone22.setText("");
                    cnpj2.setText("");
                    contato2.setText("");
                    tnome.setText("");

                }
            });

            botao4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    try {
                        Connection con;
                        String userName = "root";
                        String password = "";
                        String url = "jdbc:mysql://127.0.0.1/quatro_menus";

                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        con = DriverManager.getConnection(url, userName, password);

                        Statement st = con.createStatement();

                        st.executeUpdate("INSERT INTO fornecedores (endereco,complemento,bairro,cidade,estado,telefone,telefone2,cnpj,contato) VALUES ('" + endereco2.getText() + "','" + complemento2.getText() + "','" + bairro2.getText() + "','" + cidade2.getText() + "','" + estado2.getText() + "','" + telefone12.getText() + "','" + telefone22.getText() + "','" + cnpj2.getText() + "','" + contato2.getText() + "')");

                        endereco2.setText("");
                        complemento2.setText("");
                        bairro2.setText("");
                        cidade2.setText("");
                        estado2.setText("");
                        telefone12.setText("");
                        telefone22.setText("");
                        cnpj2.setText("");
                        contato2.setText("");
                        tnome.setText("");

                        JOptionPane.showMessageDialog(null, "Registro Inserido Com Sucesso", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

                        st.close();
                        con.close();
                    } catch (Exception event) {
                        JOptionPane.showMessageDialog(null, "Conexão não estabelecida", "Mensagem do Progama", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            botao5.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    try {
                        Connection con;
                        String userName = "root";
                        String password = "";
                        String url = "jdbc:mysql://127.0.0.1/quatro_menus";

                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        con = DriverManager.getConnection(url, userName, password);

                        Statement st = con.createStatement();
                        st.executeUpdate("UPDATE fornecedores SET endereco ='" + endereco2.getText() + "',complemento='" + complemento2.getText() + "',bairro='" + bairro2.getText() + "',cidade='" + cidade2.getText() + "',estado='" + estado2.getText() + "',telefone='" + telefone12.getText() + "',telefone2='" + telefone22.getText() + "',cnpj='" + cnpj2.getText() + "',contato='" + contato2.getText() + "' WHERE cnpj LIKE'" + cnpj2.getText() + "'");

                        JOptionPane.showMessageDialog(null, "Registro Alterado com sucesso! ", "Mensagem do Progama", JOptionPane.INFORMATION_MESSAGE);
                        endereco2.requestFocus();

                        st.close();
                        con.close();
                    } catch (Exception event) {
                        JOptionPane.showMessageDialog(null, "Conexão não estabelecida / Registro não encontrado ", "Mensagem do Progama", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            botao6.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    relatorioG4 = new RelatorioG4();
                    relatorioG4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    relatorioG4.setVisible(true);

                }
            });
            botao7.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    relatorioCP4 = new RelatorioCP4();
                    relatorioCP4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    relatorioCP4.setVisible(true);

                }
            });

            setSize(600, 700);
            setVisible(true);
            setLocationRelativeTo(null);

        }

    }

    private class RelatorioG4 extends JFrame {

        private Connection con;
        private JTable tabela;

        public RelatorioG4() {
            super("Relatorio Geral");

            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://127.0.0.1/quatro_menus";

            try {

                Class.forName("com.mysql.jdbc.Driver").newInstance();
                con = DriverManager.getConnection(url, userName, password);

            } catch (Exception event) {
                JOptionPane.showMessageDialog(null, "Conexão não estabelecida  ", "Mensagem do Progama", JOptionPane.ERROR_MESSAGE);
            }
            buscaTabela();
            setSize(1000, 200);
            setVisible(true);

        }

        private void buscaTabela() {
            Statement st;
            ResultSet res;

            try {
                Vector cabecalho = new Vector();
                Vector linhas = new Vector();

                st = con.createStatement();
                res = st.executeQuery("SELECT * FROM Fornecedores ORDER BY COD");
                res.next();
                ResultSetMetaData rsmd = res.getMetaData();
                for (int i = 2; i <= rsmd.getColumnCount(); ++i) {
                    cabecalho.addElement(rsmd.getColumnName(i));
                }
                do {
                    linhas.addElement(proximaLinha(res, rsmd));
                } while (res.next());
                tabela = new JTable(linhas, cabecalho);
                JScrollPane scroller = new JScrollPane(tabela);
                getContentPane().add(scroller, BorderLayout.CENTER);
                validate();
                st.close();

            } catch (SQLException sqlex) {

            }
        }

        private Vector proximaLinha(ResultSet rs, ResultSetMetaData rsmd) {
            Vector LinhaAtual = new Vector();
            try {
                for (int i = 1; i <= rsmd.getColumnCount(); ++i) {
                    switch (rsmd.getColumnType(i)) {
                        case Types.VARCHAR:
                            LinhaAtual.addElement(rs.getString(i));
                            break;
                        case Types.TIMESTAMP:
                            LinhaAtual.addElement(rs.getDate(i));
                            break;
                        case Types.NUMERIC:
                            LinhaAtual.addElement(new Long(rs.getLong(i)));
                            break;
                    }
                }
            } catch (SQLException e) {
            }
            return LinhaAtual;
        }
    }

    private class RelatorioCP4 extends JFrame {

        JButton b;
        JLabel l;
        JTextField t;
        Inicial janela;

        public RelatorioCP4() {
            super("Relatorio com Parâmetros");
            Container tela = getContentPane();
            setLayout(null);

            l = new JLabel("Contato:");
            l.setBounds(20, 20, 100, 20);

            t = new JTextField(50);
            t.setBounds(20, 50, 250, 20);

            b = new JButton("Exibir Relatório");
            b.setBounds(100, 90, 150, 20);

            tela.add(l);
            tela.add(t);
            tela.add(b);

            b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    janela = new Inicial();
                    janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    janela.setVisible(true);

                }
            });

            setSize(300, 200);
            setVisible(true);
            setLocationRelativeTo(null);

        }

        private class Inicial extends JFrame {

            private Connection con;
            private JTable tabela;

            private Inicial() {
                super("Relatorio com Parâmetro");
                setSize(1000, 300);
                setLocationRelativeTo(null);
                String userName = "root";
                String password = "";
                String url = "jdbc:mysql://127.0.0.1/quatro_menus";
                try {

                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    con = DriverManager.getConnection(url, userName, password);

                } catch (Exception event) {
                    JOptionPane.showMessageDialog(null, "Conexão não estabelecida  ", "Mensagem do Progama", JOptionPane.ERROR_MESSAGE);
                }
                buscaTabela();
            }

            private void buscaTabela() {
                Statement st;
                ResultSet res;

                try {
                    Vector cabecalho = new Vector();
                    Vector linhas = new Vector();

                    st = con.createStatement();
                    res = st.executeQuery("SELECT * FROM fornecedores where contato LIKE'%" + t.getText() + "%'");
                    res.next();
                    ResultSetMetaData rsmd = res.getMetaData();
                    for (int i = 2; i <= rsmd.getColumnCount(); ++i) {
                        cabecalho.addElement(rsmd.getColumnName(i));
                    }
                    do {
                        linhas.addElement(proximaLinha(res, rsmd));
                    } while (res.next());
                    tabela = new JTable(linhas, cabecalho);
                    JScrollPane scroller = new JScrollPane(tabela);
                    getContentPane().add(scroller, BorderLayout.CENTER);
                    validate();
                    st.close();

                } catch (SQLException sqlex) {

                }
            }

            private Vector proximaLinha(ResultSet rs, ResultSetMetaData rsmd) {
                Vector LinhaAtual = new Vector();
                try {
                    for (int i = 1; i <= rsmd.getColumnCount(); ++i) {
                        switch (rsmd.getColumnType(i)) {
                            case Types.VARCHAR:
                                LinhaAtual.addElement(rs.getString(i));
                                break;
                            case Types.TIMESTAMP:
                                LinhaAtual.addElement(rs.getDate(i));
                                break;
                            case Types.NUMERIC:
                                LinhaAtual.addElement(new Long(rs.getLong(i)));
                                break;
                        }
                    }
                } catch (SQLException e) {
                }
                return LinhaAtual;
            }

        }

    }

}
