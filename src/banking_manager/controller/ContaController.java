package banking_manager.controller;

import java.util.List;
import banking_manager.model.Conta;
import banking_manager.model.ContaCorrente;
import banking_manager.model.ContaInvestimento;
import banking_manager.model.dao.ContaDao;
import banking_manager.view.ViewBanco;

public class ContaController {
    private ContaDao dao_conta;
    private ViewBanco view;
    
    public ContaController() {
        
    }
    
    public ContaController(ViewBanco view,ContaDao dao_conta){
        this.view = view;
        this.dao_conta = dao_conta;
        initController();
    }
    
    public void initController(){
        this.view.setControllerConta(this);
    }
    
    public void listarContas(){
        try{
            List<Conta> contas = this.dao_conta.getLista();
            view.mostrarContas(contas);
        }catch( Exception ex){
            
        }
    }
    
    
    public void inserirContaCorrente(ContaCorrente cc){
        try{
            this.dao_conta.insertContaCorrente(cc);
            view.adicionarConta(cc);
        } catch(Exception ex){
            ex.printStackTrace();
            
        }
    }
    
    public void inserirContaInvestimento(ContaInvestimento ci){
        try{
            this.dao_conta.inserirContaInvestimento(ci);
            view.adicionarConta(ci);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public long buscaNumConta(long id_cliente){
        try{
            return this.dao_conta.buscaNumConta(id_cliente);
        }catch(Exception ex){
            ex.printStackTrace();
            throw new RuntimeException(ex); 
        }
    }
    
    public void Remunerar(Conta conta) {
        double saldoAnterior = conta.getSaldo();
        conta.remunera();
        
        if (saldoAnterior == conta.getSaldo()) {
            throw new RuntimeException("Não foi possível remunerar: saldo não positivo");
        }
        AtualizarSaldo(conta);
    }
    
    public boolean Sacar(Conta conta, double valor) {
        if (!conta.saca(valor)) 
            return false;
        
        conta.setSaldo(conta.getSaldo() - valor);
        AtualizarSaldo(conta);
        return true;
        
    }

    public boolean Depositar(Conta conta, double valor) {
        if (!conta.deposita(valor))
            return false;
        conta.setSaldo(conta.getSaldo() + valor);
        AtualizarSaldo(conta);
        return true;
    }
    
    public void AtualizarSaldo(Conta conta) {
        try {
            this.dao_conta.AtualizarSaldo(conta);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    
    
}
