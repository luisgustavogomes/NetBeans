package biblioteca;

import java.util.Arrays;

public class Genero {

    String[] tipos;

    public Genero() {
        this.tipos = new String[]{"acao", "romance", "ficcao", "historia", "tecnico"};
    }

    @Override
    public String toString() {
        return Arrays.toString(tipos);
    }

}
