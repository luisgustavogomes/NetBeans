/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecavirtual;

import org.json.simple.JSONObject;

/**
 *
 * @author Aluno
 */
public class Livro {
    
    private int codigo;
    private String titulo;
    private String autor;
    private int ano;
    
    public Livro(int codigo, String titulo, String autor, int ano){
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }
    
    /*public Livro(String linha){
        String[] colunas = linha.split(";");
        this.codigo = Integer.parseInt(colunas[0]);
        this.titulo = colunas[1];
        this.autor = colunas[2];
        this.ano = Integer.parseInt(colunas[3]);
    }*/
    
    public Livro(JSONObject obj){
        this.codigo = Integer.parseInt(obj.get("codigo").toString());
        this.titulo = obj.get("titulo").toString();
        this.autor = obj.get("autor").toString();
        this.ano = Integer.parseInt(obj.get("ano").toString());
    }
    
    public int getCodigo(){ return this.codigo; }
    
    public JSONObject toJSON(){
        JSONObject obj = new JSONObject();
        obj.put("codigo", this.codigo);
        obj.put("titulo", this.titulo);
        if(!this.autor.equals(""))
            obj.put("autor", this.autor);
        obj.put("ano", this.ano);
        return obj;
    }
    
    @Override
    public String toString(){
        return this.toJSON().toJSONString();
        /*return String.format("%d;%s;%s;%d;\r\n", this.codigo, 
                this.titulo, this.autor, this.ano);*/
    }
}
