import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CadPaciente extends JFrame{
    public CadPaciente(){
        Container JANELA = getContentPane();
        JANELA.setLayout(null);

        setSize(600,400);
        setVisible(true);
        setResizable(false);

        JTextField nome = new JTextField(20);
        JTextField email = new JTextField(20);
        JPasswordField senha = new JPasswordField(20);
        JButton btnEnviar = new JButton("Enviar");
        JButton btnLogin = new JButton("Login");
        JLabel lblnome = new JLabel("Nome");
        JLabel lblemail = new JLabel("Email");
        JLabel lblsenha = new JLabel("Senha");
        JLabel titulo = new JLabel("Cadastro");

        Font fonte_label = new Font( "Arial", Font.PLAIN, 14);
        Font fonte_titulo = new Font("Arial", Font.PLAIN, 22);
        lblemail.setFont(fonte_label);
        lblnome.setFont(fonte_label);
        lblsenha.setFont(fonte_label);
        titulo.setFont(fonte_titulo);
//            List lstFrase = new List(5, false);
        JANELA.add(titulo);
        JANELA.add(lblnome);
        JANELA.add(nome);
        JANELA.add(lblemail);
        JANELA.add(email);
        JANELA.add(lblsenha);
        JANELA.add(senha);
        JANELA.add(btnEnviar);
        JANELA.add(btnLogin);

//            JANELA.add(lstFrase);
        titulo.setBounds(250, 5, 120, 25);
        lblnome.setBounds(280, 40, 120, 25);
        lblemail.setBounds(280, 100, 120, 25);
        lblsenha.setBounds(280, 160, 120, 25);
        nome.setBounds(180, 60, 240, 25);
        email.setBounds(180, 120, 240, 25);
        senha.setBounds(180, 180, 240, 25);
        btnEnviar.setBounds(225, 240, 150, 25);
        btnLogin.setBounds(225, 280, 150, 25);

        Banco banco = new Banco();

        btnEnviar.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent evt) {
                String nome_paciente = nome.getText();
                String email_paciente = email.getText();
                String senha_paciente = senha.getText();
//                char n = nome_paciente.charAt(0);
//                char e_ = email_paciente.charAt(0);
//                char s = senha_paciente.charAt(0);
                if(nome_paciente.length() < 3 && email_paciente.length() < 3 && senha_paciente.length() < 3){
                    JOptionPane.showMessageDialog(JANELA, "Digite valores validos","Escreva Novamente", JOptionPane.ERROR_MESSAGE);
                }else{

                Usuario usuario = new Usuario(nome_paciente, email_paciente, senha_paciente);

                try {
                    String nome_usuario = usuario.cadastrar();
                    Login login = new Login(nome_usuario);
                    dispose();

                }catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                }
            }
        });

        btnLogin.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                String nome_paciente = nome.getText();
                Login form_login = new Login(nome_paciente);
                dispose();
            }
        });
    }

    public static void main(String args[]){
        CadPaciente app = new CadPaciente();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}



