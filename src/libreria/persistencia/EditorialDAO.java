
package libreria.persistencia;

import java.util.List;
import libreria.entidades.Editorial;

public class EditorialDAO extends DAO<Editorial>{

    @Override
    public void guardar(Editorial editorial) {
        super.guardar(editorial);
    }
    
    public Editorial buscarPorId(Integer id) {
        conectar();
//        Editorial editorial = (Editorial) em.find(Editorial.class, id);        
        Editorial editorial = (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.id = :id")
                .setParameter("id", id).getSingleResult();
        desconectar();
        return editorial;
    }
    
    public List<Editorial> listarTodosLosEditoriales() {
        conectar();
        List<Editorial> editoriales = em.createQuery("SELECT e FROM Editorial e")
                .getResultList();
        desconectar();
        return editoriales;
    }
    
    public void eliminar(Integer id) {
        Editorial editorial = buscarPorId(id);
        super.eliminar(editorial);
    }
    
    public void modificarNombre(Integer id, String nombre) {
        Editorial editorial = buscarPorId(id);
        editorial.setNombre(nombre);
        super.editar(editorial);
    }
    
    public void darDeBajaEditorial(Integer id) {
        Editorial editorial = buscarPorId(id);
        editorial.setAlta(false);
        super.editar(editorial);
    }
    
}
