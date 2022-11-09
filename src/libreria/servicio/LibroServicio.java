
package libreria.servicio;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.persistencia.LibroDAO;

public class LibroServicio {
    
    private AutorServicio autorServicio;
    private EditorialServicio editorialServicio;
    private final LibroDAO dao = new LibroDAO();
    private final Scanner leer = new Scanner(System.in);
    
    public void setServicio(AutorServicio autorServicio, EditorialServicio editorialServicio) {
        this.autorServicio = autorServicio;
        this.editorialServicio = editorialServicio;
    }
    
     public Libro ingresarDatosLibro() {
        Libro libro = new Libro();
         try {
        System.out.println("");
        System.out.println("Ingresar datos del libro");
        System.out.print("Título: ");
        String titulo = leer.nextLine();
        System.out.print("Año: ");
        int anio = leer.nextInt();
        System.out.print("Ejemplares: ");
        int ejemplares = leer.nextInt();
        System.out.print("Id del Autor: ");
        int idAutor = leer.nextInt();
        System.out.print("Id de la Editorial: ");
        int idEditorial = leer.nextInt();
        
        Autor autor = autorServicio.buscarPorId(idAutor);
        Editorial editorial = editorialServicio.buscarPorId(idEditorial);
        
        libro.setTitulo(titulo);
        libro.setAnio(anio);
        libro.setEjemplares(ejemplares);
        libro.setEjemplaresPrestados(0);
        libro.setEjemplaresRestantes(ejemplares);
        libro.setAutor(autor);
        libro.setEditorial(editorial);
        libro.setAlta(true);
                
        return libro;   //new Libro(titulo, anio, ejemplares, autor, editorial);        
        } catch(InputMismatchException e) {
            System.out.println("Error de ingreso de datos tipo cadena");
            return null;
        } catch (NullPointerException e) {
            System.out.println("Error, valor nulo encontrado");
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public Libro crearLibro(String titulo, int anio, int ejemplares, Autor autor, Editorial editorial) {
        Libro libro = new Libro();
        try {
            libro.setTitulo(titulo);
            libro.setAnio(anio);
            libro.setEjemplares(ejemplares);
            libro.setEjemplaresPrestados(0);
            libro.setEjemplaresRestantes(ejemplares);
            libro.setAutor(autor);
            libro.setEditorial(editorial);
            libro.setAlta(true);
            
            dao.guardar(libro);
            
            return libro;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }     
    }
    
    public void crearLibro2(Libro libro) {
        try {
            dao.guardar(libro);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public Libro buscarPorIsbn(Long isbn) {
        try {            
            return dao.buscarPorISBN(isbn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public Libro buscarLibroPorTitulo (String titulo) {
        try {
            return dao.buscarPorTitulo(titulo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public List<Libro> listarLibrosPorNombreAutor(String nombre) {
        try {
            return dao.buscarPorNombreAutor(nombre);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public List<Libro> listarLibrosPorNombreEditorial(String nombre) {
        try {
            return dao.buscarPorNombreEditorial(nombre);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public void modificarTituloDelLibro(Long isbn, String titulo) {
        try {
            dao.modificarTitulo(isbn, titulo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void modificarEjemplares(Long isbn, int ejemPrestados, int ejemRestante) {
        try {
            dao.modificarEjemplaresPrestadosYRestantes(isbn, ejemPrestados, ejemRestante);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
        
    public void prestarLibro(Long isbn, int ejemplaresAPrestar) {
        try {
            Libro libro = buscarPorIsbn(isbn);
            
            if(libro.getEjemplaresRestantes() >= ejemplaresAPrestar) {
                int prestados = libro.getEjemplaresPrestados() + ejemplaresAPrestar;
                int restatntes = libro.getEjemplaresRestantes() - ejemplaresAPrestar;
                modificarEjemplares(isbn, prestados, restatntes);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void mostrarListaDeLibros() {
        try {            
            dao.listarTodosLosLibros().forEach((l) -> System.out.println(l.toString()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void eliminarLibro(Long isbn) {
        try {
            dao.eliminar(isbn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }
}
