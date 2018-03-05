package br.edu.qi.model;

import java.util.List;

public class CursoDoutorado extends Curso {

    private boolean strictoSensu;
    private int mesesParaDefesa;

    public CursoDoutorado(int codigo, int time, int sala, String nome, String nomeProfessor, List<Aluno> alunos, boolean strictoSensu, int mesesParaDefesa) {
        super(codigo, time, sala, nome, nomeProfessor, alunos);
        this.strictoSensu = strictoSensu;
        this.mesesParaDefesa = mesesParaDefesa;
    }

    @Override
    public void calculoDiploma(Curso curso) {
        double valor = 0;
        if (mesesParaDefesa >= 24) {
            valor = 1500;
        } else if (mesesParaDefesa >= 12) {
            valor = 2000;
        } else if (mesesParaDefesa >= 6) {
            valor = 3000;
        } else {
            valor = 4000;
        }
        this.setAdicionalDiploma(valor - (valor * (getPercentualDesconto(curso) / 100)));
    }

    private double getPercentualDesconto(Curso curso) {
        if (curso.alunos.size() <= 3) {
            return 7;
        } else if (curso.alunos.size() <= 7) {
            return 12;
        } else {
            return 15;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "CursoDoutorado{" + "strictoSensu=" + strictoSensu + ", mesesParaDefesa=" + mesesParaDefesa + '}';
    }
    
    
}
