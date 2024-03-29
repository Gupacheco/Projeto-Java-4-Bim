import java.sql.SQLException;
public class Log {
    private String clausula;
    private Banco banco;
    Log(String operacao, int id_usuario){
        this.banco = new Banco();

        try {
            this.banco.conectar();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String sql = "INSERT INTO operacoes (data_operacao, operacao, id_usuario) VALUE (now(), '"+operacao+"', '"+id_usuario+"')";
        try {
            this.banco.getSt().executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getClausula() {
        return clausula;
    }

    public void setClausula(String clausula) {
        this.clausula = clausula;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }
}
