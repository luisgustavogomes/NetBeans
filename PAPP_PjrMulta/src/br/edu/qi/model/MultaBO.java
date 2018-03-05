package br.edu.qi.model;

public class MultaBO {

    
    private MultaDAO dao;

    public MultaBO() {
        
        dao = new MultaDAO();

    }

    public void save(Multa multaVO) throws Exception {
        dao.save(multaVO);
    }

    public MultaDAO getDao() {
        return dao;
    }

}
