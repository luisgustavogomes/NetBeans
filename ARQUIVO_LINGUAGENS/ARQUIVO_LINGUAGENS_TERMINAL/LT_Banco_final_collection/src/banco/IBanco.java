package banco;

public interface IBanco {
    
    public boolean verificarLoginUsuario();

    /**
     *
     * @param agencia
     * @param conta
     * Utiliza programação funcional com o metodo removeIF 
     * @return
     */
    public boolean excluirCliente(String agencia, String conta);
}
