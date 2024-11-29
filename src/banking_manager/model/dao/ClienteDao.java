package banking_manager.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import banking_manager.model.Cliente;
import banking_manager.model.Cliente;

public class ClienteDao {

    private final String insert = "insert into cliente (nome , sobrenome, cpf, rg, salario, endereco) values (?,?,?,?,?,?)";
    //private final String select = "select * from cliente";
    private final String select = "select * from cliente";
    private final String select_ciente_sem_conta = "select * from cliente left join conta on(conta.id_cliente = cliente.id) where conta.id_cliente is NULL";
    private final String select_cpf = "select id,nome,sobrenome,cpf,rg,salario,endereco from cliente where cpf = ?";
    private final String select_cliente = "select * from cliente where id=?";
    private final String update = "update cliente set nome=?, sobrenome=?, cpf=?, rg=?, salario=?, endereco=? WHERE id=?";
    private final String delete = "delete from cliente WHERE id=?";

    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/SISTEMA_BANCARIO", "root", "171668");
//            return DriverManager.getConnection("jdbc:mysql://localhost/lpooii", "root", "root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ClienteDao() {

    }

    public void inserir(Cliente cliente) {
        try (
                Connection connection = this.getConnection(); PreparedStatement stmtAdiciona = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);) {
            // seta os valores
            stmtAdiciona.setString(1, cliente.getNome());
            stmtAdiciona.setString(2, cliente.getSobrenome());
            stmtAdiciona.setString(3, cliente.getCpf());
            stmtAdiciona.setString(4, cliente.getRg());
            stmtAdiciona.setDouble(5, cliente.getSalario());
            stmtAdiciona.setString(6, cliente.getEndereco());
            // executa
            stmtAdiciona.execute();
            //Seta o id do contato
            ResultSet rs = stmtAdiciona.getGeneratedKeys();
            rs.next();
            long i = rs.getLong(1);
            cliente.setId(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cliente> getLista() {
        try (
                Connection connection = this.getConnection(); PreparedStatement stmtLista = connection.prepareStatement(select);) {
                ResultSet rs = stmtLista.executeQuery();
            List<Cliente> clientes = new ArrayList();
            while (rs.next()) {
                // criando o objeto Contato
                //Contato contato = new Contato();
                long id = rs.getLong("id");
                String nome = rs.getString("nome");
                String sobrenome = rs.getString("sobrenome");
                String cpf = rs.getString("cpf");
                String rg = rs.getString("rg");
                double salario = rs.getDouble("salario");
                String endereco = rs.getString("endereco");
                // adicionando o objeto à lista
                clientes.add(new Cliente(id, nome, sobrenome, cpf, rg, salario, endereco));
            }
            return clientes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    
    public List<Cliente> listarClienteSemConta(){
        try (
                Connection connection = this.getConnection(); PreparedStatement stmtLista = connection.prepareStatement(select_ciente_sem_conta);) {
                ResultSet rs = stmtLista.executeQuery();
            List<Cliente> clientes = new ArrayList();
            while (rs.next()) {
                // criando o objeto Contato
                //Contato contato = new Contato();
                long id = rs.getLong("id");
                String nome = rs.getString("nome");
                String sobrenome = rs.getString("sobrenome");
                String cpf = rs.getString("cpf");
                String rg = rs.getString("rg");
                double salario = rs.getDouble("salario");
                String endereco = rs.getString("endereco");
                // adicionando o objeto à lista
                clientes.add(new Cliente(id, nome, sobrenome, cpf, rg, salario, endereco));
            }
            return clientes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Cliente buscaClienteCpf(String Cpf) {
        try (
            Connection connection = this.getConnection(); PreparedStatement stmtBusca = connection.prepareStatement(select_cpf);) 
        {
            
            stmtBusca.setString(1, Cpf);
            ResultSet rs = stmtBusca.executeQuery();
            
            long id = 0;
            String cpf = null;
            String nome= null;
            String sobrenome = null;
            String rg = null;
            String endereco = null;
            Double salario = null;
            
            while (rs.next()) {
                id = rs.getLong("id");
                cpf = rs.getString("cpf");
                nome = rs.getString("nome");
                sobrenome = rs.getString("sobrenome");
                rg = rs.getString("rg");
                endereco = rs.getString("endereco");
                salario = rs.getDouble("salario");
            }
            
            Cliente cliente = new Cliente(id, nome,sobrenome, cpf, rg, salario, endereco);
            return cliente;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteCliente(Cliente cliente) throws SQLException {
        try (
                Connection connection = this.getConnection(); PreparedStatement stmt = connection.prepareStatement(delete);) {
            long id = cliente.getId();
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateCliente(Cliente cliente) {
        try (
                Connection connection = this.getConnection();
                PreparedStatement stmt = connection.prepareStatement(update);)
        {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getSobrenome());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getRg());
            stmt.setDouble(5, cliente.getSalario());
            stmt.setString(6, cliente.getEndereco());
            stmt.setLong(7, cliente.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    
    public Cliente getCliente(long id_cliente) throws SQLException{
        try (
                Connection connection = this.getConnection();
                PreparedStatement stmt = connection.prepareStatement(select_cliente);)
        {
            Cliente cliente = new Cliente(); 
            stmt.setLong(1, id_cliente);
            ResultSet rst = stmt.executeQuery();    

            if (rst.next()) {
                cliente.setId(id_cliente);
                cliente.setNome(rst.getString("nome"));
                cliente.setSobrenome(rst.getString("sobrenome"));
                cliente.setRg(rst.getString("rg"));
                cliente.setCpf(rst.getString("cpf"));
                cliente.setEndereco(rst.getString("endereco"));
                cliente.setSalario(rst.getDouble("salario"));
            }
            
            return cliente;
        } catch(SQLException e) {
             throw new RuntimeException(e);
        }
    }

}
