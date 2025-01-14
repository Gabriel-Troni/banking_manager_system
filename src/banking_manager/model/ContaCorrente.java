package banking_manager.model;

public class ContaCorrente extends Conta{
    
    public double limite;
    public long numeroConta;

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public long getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(long numeroConta) {
        this.numeroConta = numeroConta;
    }

    @Override
    public boolean saca(double valor) {
        if(valor>0 && (this.saldo + limite >= valor)){
            return true;
        }else{
            return false;        
        }      
    }
    
    @Override
    public boolean deposita(double valor) {
        if(valor>0){
            //saldo += valor;
            return true;
        }else{
            return false;
        }
    }

    @Override
    public double getSaldo() {
       return this.saldo;
    }

    @Override
    public void remunera() {
        if (this.saldo > 0) {
            this.saldo += this.saldo * 0.01;
        }
    }
}   
    
