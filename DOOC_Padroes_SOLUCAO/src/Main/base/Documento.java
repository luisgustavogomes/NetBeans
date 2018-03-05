/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.base;

import java.time.LocalDate;

/**
 *
 * @author lg
 */
public abstract class Documento {
    
    private String titulo = "Padroes de projeto";
    private String empresa = "Universidade Federal da Bahia";
    private String texto = "Aula de padroes de projeto na disciplina Engenharia de Software I.";
    private LocalDate data = LocalDate.now();

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    
}
