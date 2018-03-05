package crud;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class GerenciadorArquivo {

    public static String lerArquivoClass() throws IOException {
        Path p = Paths.get(System.getProperty("user.dir"), "info.txt");
        String str=null;
        if (!Files.exists(p)) {
        } else {
            str = Files.readAllLines(p, Charset.forName("UTF-8")).get(0);
        }
        return str;
    }

}
