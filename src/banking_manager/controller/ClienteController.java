package banking_manager.controller;

import java.util.List;
import banking_manager.model.Cliente;
import banking_manager.view.ViewBanco;
import banking_manager.model.dao.ClienteDao;

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
    
   
    public void inserirCliente(Cliente cliente){
        try{
            this.dao.inserir(cliente);
            //this.listarCliente();
            view.adicionarCliente(cliente);
        } catch(Exception ex){
            ex.printStackTrace();
            
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
