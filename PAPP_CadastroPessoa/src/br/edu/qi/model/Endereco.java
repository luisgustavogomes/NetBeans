package br.edu.qi.model;

public class Endereco {

    private int codigo;
    private String rua;
    private int numero;
    private String complemento;
    private String bairro;
    private String cep;
    protected Cidade cidade;
    
    public Endereco(String rua, Cidade cidade) {
        this.rua = rua;
        this.cidade = cidade;
    }

    public Endereco(int codigo, String rua, Cidade cidade) {
        this.codigo = codigo;
        this.rua = rua;
        this.cidade = cidade;
    }

    public Endereco(String rua, int numero, String complemento, String bairro, String cep) {
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Rua=" + rua + ", Numero=" + numero + ", Compl.=" + complemento + ", Bairro" + bairro + ", CEP=" + cep;
    }

}
