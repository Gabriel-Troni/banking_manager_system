package banking_manager.controller;

import java.util.List;
import banking_manager.model.Cliente;
import banking_manager.view.ViewBanco;
import banking_manager.model.dao.ClienteDao;
import java.sql.SQLException;

public class ClienteController {
    private ViewBanco view;
    private ClienteDao dao;
    
    public ClienteController(ViewBanco view, ClienteDao dao){
        this.view = view;
        this.dao = dao;
        initController();
    }

    public ClienteController() {
        
    }
    
    private void initController(){
       this.view.setController(this);
       this.view.initView();
    }
    
    public Cliente buscaClienteCpf(String cpf){
        try{
            return this.dao.buscaClienteCpf(cpf);
        }catch(Exception ex){
            ex.printStackTrace();
            throw new RuntimeException(ex); 
        }
    } 
    
    public void listarCliente(){
        try{
            List<Cliente> clientes = this.dao.getLista();
            view.mostrarListaClientes(clientes);
        }catch( Exception ex){
            
        }
    }
    
    public void listarClienteSemConta(){
        try{
             List<Cliente> clientes = this.dao.listarClienteSemConta();
             view.mostrarListaClientes(clientes);
        }catch( Exception ex){
            
        }
    }
    
   
    public void inserirCliente(Cliente cliente) throws SQLException {
        try{
            this.dao.inserir(cliente);
            view.adicionarCliente(cliente);
        } catch(SQLException ex){
            throw new SQLException(ex);
            
        }
    }
    
    public void deleteCliente(Cliente cliente){
        try{
            ClienteDao dao_aux = new ClienteDao();
            dao_aux.deleteCliente(cliente);
        }catch(Exception ex){
            ex.printStackTrace();
            
        }
    }
    
    
    public void updateCliente(Cliente cliente){
        try{
            ClienteDao dao_aux = new ClienteDao();
            dao_aux.updateCliente(cliente);
            view.mostarMensagemInfo("Cliente Atualizado com sucesso!");
        }catch(Exception ex){
            ex.printStackTrace();
            
        }
    }
    

    
}
