
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class TelaUsuarios extends JFrame{
  

        JButton btnConsultar, btnExcluir, btnLimpar, btnIncluir, btnAlterar, botao6, botao7;
        JLabel titulo, descri, lnome, quant, UnitVend;
        JTextField descricao, tnome, quantidade;
        JPasswordField UnitVenda;
        RelatorioG2 relatorioG2;
        RelatorioCP2 relatorioCP2;

        public TelaUsuarios() {
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

            btnConsultar = new JButton("Consultar Registro");
            btnExcluir = new JButton("Excluir Registro");
            btnLimpar = new JButton("Limpar Caixas");
            btnIncluir = new JButton("Incluir");
            btnAlterar = new JButton("Alterar Registro");
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

            btnConsultar.setBounds(350, 260, 150, 20);
            btnExcluir.setBounds(350, 290, 150, 20);
            btnLimpar.setBounds(350, 170, 150, 20);
            btnIncluir.setBounds(350, 70, 150, 20);
            btnAlterar.setBounds(350, 110, 150, 20);
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

            tela1.add(btnConsultar);
            tela1.add(btnExcluir);
            tela1.add(btnLimpar);
            tela1.add(btnIncluir);
            tela1.add(btnAlterar);
            tela1.add(botao6);
            tela1.add(botao7);

            tela1.add(titulo);

            btnConsultar.addActionListener(new ActionListener() {
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

            btnExcluir.addActionListener(new ActionListener() {
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

            btnLimpar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    descricao.setText("");
                    tnome.setText("");
                    quantidade.setText("");

                    UnitVenda.setText("");

                }
            });

            btnIncluir.addActionListener(new ActionListener() {
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

            btnAlterar.addActionListener(new ActionListener() {
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

}
