
package br.edu.qi.model;

import java.util.ArrayList;
import java.util.List;


public class MultaDAO {

    private List<Multa> multas;

    public MultaDAO() {
        this.multas = new ArrayList<>();
    }

    public void save(Multa multa) throws Exception {
        if (!find(multa)) {
            multas.add(multa);
        } else {
            throw new Exception("Erro!");
        }
    }

    public boolean find(Multa multa) {
        return multas.stream().anyMatch(m -> m.equals(multa));
    }

    

}
