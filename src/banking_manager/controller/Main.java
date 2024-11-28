package banking_manager.controller;
import banking_manager.controller.ClienteController;
import banking_manager.model.dao.ClienteDao;
import banking_manager.model.dao.ContaDao;
import banking_manager.view.ViewBanco;
import banking_manager.controller.ContaController;

public class Main {
        public static void main(String args[]){
            
        
        ViewBanco view = new ViewBanco();
        ClienteDao dao = new ClienteDao();
        ContaDao dao_conta = new ContaDao();
        ClienteController controller = new ClienteController(view,dao);
        ContaController controller_conta = new ContaController(view, dao_conta);
    } 
}
