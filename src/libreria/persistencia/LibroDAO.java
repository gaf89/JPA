
package libreria.persistencia;


import java.util.List;
import libreria.entidades.Libro;
import libreria.servicio.LibroServicio;

public class LibroDAO extends DAO<Libro>{

    @Override
    public void guardar(Libro libro) {
        super.guardar(libro);
    }
    
    public Libro buscarPorISBN(Long isbn) {
        conectar();
        Libro libro = (Libro) em.find(Libro.class, isbn);
//        Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.isbn LIKE :isbn")
//                .setParameter("isbn", isbn).getResultList();
        desconectar();
        return libro;
    }
    
    public Libro buscarPorTitulo(String titulo) {
        conectar();
        Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE :titulo")
                .setParameter("titulo", titulo).getSingleResult();
        desconectar();
        return libro;
    }
    
    public List<Libro> buscarPorNombreAutor(String nombre) {
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l JOIN l.autor a WHERE a.nombre LIKE :nombre")
                .setParameter("nombre", nombre).getResultList();
        desconectar();
        return libros;
    }
    
    public List<Libro> buscarPorNombreEditorial(String nombre) {
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l JOIN L.editorial e WHERE e.nombre LIKE :nombre")
                .setParameter("nombre", nombre).getResultList();
        desconectar();
        return libros;
    }

    public List<Libro> listarTodosLosLibros() {
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l")
                .getResultList();
        desconectar();
        return libros;
    }
    
    public void eliminar(Long isbn) {
        Libro libro = buscarPorISBN(isbn);
        super.eliminar(libro);
    }
    
    public void modificarTitulo(Long isbn, String titulo) {
        Libro libro = buscarPorISBN(isbn);
        libro.setTitulo(titulo);
        super.editar(libro);
    }
    
    public void modificarEjemplares(Long isbn, Integer ejemplares) {
        Libro libro = buscarPorISBN(isbn);
        libro.setEjemplares(ejemplares);
        super.editar(libro);
    }
    
    public void modificarEjemplaresPrestadosYRestantes(Long isbn, Integer ejemPrestados, Integer ejemRestantes) {
        Libro libro = buscarPorISBN(isbn);
        libro.setEjemplaresPrestados(ejemPrestados);
        libro.setEjemplaresRestantes(ejemRestantes);
        super.editar(libro);
    }
    
    public void darDeBajaLibro(Long isbn) {
        Libro libro = buscarPorISBN(isbn);
        libro.setAlta(false);
        super.editar(libro);
    }
    
}
