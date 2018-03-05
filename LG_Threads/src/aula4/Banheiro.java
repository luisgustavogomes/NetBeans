package aula4;

public class Banheiro {

    private boolean ehSujo = true;

    public void FazNumero1() {
        String nome = Thread.currentThread().getName();
        System.out.println(nome + " batendo na porta");
        synchronized (this) {
            System.out.println(nome + " Entrando no banheiro");
            if (ehSujo) {
                esperaLaFora(nome);
            }
            System.out.println(nome + " Fazendo coisa rápida");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println(nome + " dando descarga");
            System.out.println(nome + " lavando mão");
            System.out.println(nome + " saindo do banheiro");
        }

    }

    public void FazNumero2() {
        String nome = Thread.currentThread().getName();
        System.out.println(nome + " batendo na porta");
        synchronized (this) {
            System.out.println(nome + " Entrando no banheiro");
            if (ehSujo) {
                esperaLaFora(nome);
            }
            System.out.println(nome + " Fazendo coisa demorada");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println(nome + " dando descarga");
            System.out.println(nome + " lavando mão");
            System.out.println(nome + " saindo do banheiro");
        }
    }

    private void esperaLaFora(String nome) {
        System.out.println(nome + " eca, banheiro está sujo");
        try {
            this.wait();
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }

}
