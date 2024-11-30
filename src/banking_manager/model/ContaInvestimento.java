package banking_manager.model;

public class ContaInvestimento extends Conta {
    
    private double depositoMinimo;

    public double getDepositoMinimo() {
        return depositoMinimo;
    }

    public void setDepositoMinimo(double depositoMinimo) {
        this.depositoMinimo = depositoMinimo;
    }

    public double getMontanteMinimo() {
        return montanteMinimo;
    }

    public void setMontanteMinimo(double montanteMinimo) {
        this.montanteMinimo = montanteMinimo;
    }
    private double montanteMinimo;
    
    
    @Override
    public boolean saca(double valor) {
        if(valor>0 && (this.saldo-valor >= montanteMinimo )){
            super.saca(valor);
            return true;
        }else{
            return false;        
        }      
    }
    
    
    @Override
    public boolean deposita(double valor) {
        if(valor>0 && valor>=this.depositoMinimo){
            super.deposita(valor);
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public void remunera() {
        if (this.saldo > 0) {
            this.saldo += this.saldo * 0.02;
        }
    }
}   
    
    
