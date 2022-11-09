
package libreria.servicio;

import java.util.InputMismatchException;
import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.persistencia.AutorDAO;

public class AutorServicio {
    
    private LibroServicio libroServicio;
    private EditorialServicio editorialServicio;
    private final AutorDAO dao = new AutorDAO();
    private final Scanner leer = new Scanner(System.in);
    
    public void setServicio(LibroServicio libroServicio, EditorialServicio editorialServicio) {
        this.libroServicio = libroServicio;
        this.editorialServicio = editorialServicio;
    }
    
    public String cargarNombre() {
        try {
            System.out.println("");
            System.out.println("Ingresar datos del Autor");
            System.out.print("Nombre: ");
            String nombre = leer.nextLine();

            return nombre;
        } catch(InputMismatchException e) {
            System.out.println("Error de ingreso de datos tipo cadena");
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public Autor crearAutor(String nombre) {
        Autor autor = new Autor();
        try {
            autor.setNombre(nombre);
            autor.setAlta(true);
            
            dao.guardar(autor);
            
            return autor;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }        
    }
    
    public Autor buscarPorId(Integer id) {
        try {
            return dao.buscarPorId(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public Autor bucarPoNombre(String nombre) {
        try {
            return dao.buscarPorNombre(nombre);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public void mostrarListaDeAutores() {
        try {            
            dao.listarTodosLosAutores().forEach((a) -> System.out.println(a.toString()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void eliminarAutor(Integer Id) {
        try {
            dao.eliminar(Id);            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void modificarNombreAutor(Integer id, String nombre) {
        try {
            dao.modificarNombre(id, nombre);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
