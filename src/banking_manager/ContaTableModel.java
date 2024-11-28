package banking_manager;

import banking_manager.model.ContaInvestimento;
import banking_manager.model.Conta;
import banking_manager.model.ContaCorrente;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import banking_manager.model.Cliente;

public class ContaTableModel extends AbstractTableModel{
    private String[] colunas=new String[]{"CPF", "Numero"};

    // private List<Cliente> lista =new ArrayList();
    //private List<ContaCorrente> listaConta1=new ArrayList();
    //private List<ContaInvestimento> listaConta2=new ArrayList();
    private List<Conta> listaConta = new ArrayList();
    
    public ContaTableModel(List<Conta> lista){
        this.listaConta=lista;
    }

    public ContaTableModel(){
    }


    @Override
    public int getRowCount() {
        return this.listaConta.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public String getColumnName(int index) {
        return this.colunas[index];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
        /*if(column==0)
            return true;
        return false;*/
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Conta customer = listaConta.get(rowIndex);
        
        
        switch (columnIndex) {
            case 0: return customer.getDono().getCpf();//if column 1 (name)
            case 1: return customer.getNumero();//if column 2 (birthday)
            case 2: return customer.getSaldo();
            case 3: customer.remunera();

            default : return null;
        }
    }
    
    public Conta getContaRemunera(int rowIndex){
        return listaConta.get(rowIndex);
    }
    
    public Conta getValueAt(int rowIndex, int columnIndex, double valor) {
        Conta customer = listaConta.get(rowIndex);
        return customer;
        /*
        switch (columnIndex) {
            case 0: return customer.deposita(valor);
            case 1: return customer.saca(valor);
            default : return null;
        }*/
    }

/*
    @Override;
    public void setValueAt(Object value, int row, int col) {
        Cliente customer = lista.get(row);
        switch (col) {
            case 0:
                customer.setNome((String) value);
                break;
            case 1:
                customer.setSobrenome((String) value);
                break;

            default:
        }
        this.fireTableCellUpdated(row, col);
    }
*/
    public void setContas(List<Conta> list){
        this.listaConta = list;
        this.fireTableDataChanged();
    }

    public void adicionaListaConta(Conta conta) {
        this.listaConta.add(conta);
        //this.fireTableDataChanged();
        this.fireTableRowsInserted(listaConta.size()-1,listaConta.size()-1);//update JTable
    }
}
