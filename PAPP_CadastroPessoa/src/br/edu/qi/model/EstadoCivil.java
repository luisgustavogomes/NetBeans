package br.edu.qi.model;

public enum EstadoCivil {

    SOLTEIRO(0),
    CASADO(1),
    SEPARADO(2),
    VIUVO(3);

    public int valorEstadoCivil;
    
    EstadoCivil(int valor){
        this.valorEstadoCivil = valor;
    }

    public int getValorEstadoCivil() {
        return valorEstadoCivil;
    }
    
    
    
    
}
