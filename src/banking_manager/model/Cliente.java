package banking_manager.model;

public class Cliente implements Comparable<Cliente> {
    private long id;
    private String nome;
    private String sobrenome;
    private String  cpf;
    private String rg;
    private double salario;
    private String endereco;

        public Cliente( String nome, String sobrenome, String cpf, String rg, double salario, String endereco) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.rg = rg;
        this.salario = salario;
        this.endereco = endereco;
    }
    
    
    public Cliente(long id, String nome, String sobrenome, String cpf, String rg, double salario, String endereco) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.rg = rg;
        this.salario = salario;
        this.endereco = endereco;
    }

    public Cliente() {
        
    }
    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public int compareTo(Cliente outro) {
        return this.nome.compareTo(outro.nome);
    }
}
