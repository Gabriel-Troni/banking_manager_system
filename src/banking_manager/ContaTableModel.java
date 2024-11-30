package banking_manager;

import banking_manager.model.Conta;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ContaTableModel extends AbstractTableModel{
    private String[] colunas=new String[]{"Cliente", "CPF", "Número da Conta", "Tipo de Conta"};
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
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Conta conta = listaConta.get(rowIndex);
        
        
        switch (columnIndex) {
            case 0: return conta.getDono().getNome() + " " + conta.getDono().getSobrenome();
            case 1: return conta.getDono().getCpf();
            case 2: return conta.getNumero();
            case 3: return conta.getTipo().equals("C") ? "Corrente" : "Investimento";
            case 4: return conta.getSaldo();
            case 5: conta.remunera();

            default : return null;
        }
    }
    
    public Conta getContaRemunera(int rowIndex){
        return listaConta.get(rowIndex);
    }
    
    public Conta getValueAt(int rowIndex, int columnIndex, double valor) {
        Conta customer = listaConta.get(rowIndex);
        return customer;
    }
    public void setContas(List<Conta> list){
        this.listaConta = list;
        this.fireTableDataChanged();
    }

    public void adicionaListaConta(Conta conta) {
        this.listaConta.add(conta);
        this.fireTableRowsInserted(listaConta.size()-1,listaConta.size()-1);
    }
}
