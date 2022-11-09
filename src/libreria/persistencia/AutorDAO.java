
package libreria.persistencia;

import java.util.List;
import libreria.entidades.Autor;


public class AutorDAO extends DAO<Autor>{

    @Override
    public void guardar(Autor autor) {
        super.guardar(autor);
    }
    
     public Autor buscarPorId(Integer id) {
        conectar();
        //Autor autor = (Autor) em.find(Autor.class, id);
        Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.id = :id")
                .setParameter("id", id).getSingleResult();
        desconectar();
        return autor;
    }
     
    public Autor buscarPorNombre(String nombre) {
        conectar();
        Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE A.nombre LIKE :nombre")
                .setParameter("Nombre", nombre).getSingleResult();
        desconectar();
        return autor;
    }
    
    public List<Autor> listarTodosLosAutores() {
        conectar();
        List<Autor> autores = em.createQuery("SELECT a FROM Autor a")
                .getResultList();
        desconectar();
        return autores;
    }
    
    public void eliminar(Integer id) {
        Autor autor = buscarPorId(id);
        super.eliminar(autor);
    }
    
    public void modificarNombre(Integer id, String nombre) {
        Autor autor = buscarPorId(id);
        autor.setNombre(nombre);
        super.editar(autor);
    }
    
    public void darDeBajaAutor(Integer id) {
        Autor autor = buscarPorId(id);
        autor.setAlta(false);
        super.editar(autor);
    }
}
