
package libreria.servicio;

import java.util.InputMismatchException;
import java.util.Scanner;
import libreria.entidades.Editorial;
import libreria.persistencia.EditorialDAO;

public class EditorialServicio {
    
    private AutorServicio autorServicio;
    private LibroServicio libroServicio;
    private final EditorialDAO dao = new EditorialDAO();
    private final Scanner leer = new Scanner(System.in);
    
    public void setServicio(AutorServicio autorServicio, LibroServicio libroServicio) {
        this.autorServicio = autorServicio;
        this.libroServicio = libroServicio;
    }
    
    public String cargarNombre() {
        try {
            System.out.println("");
            System.out.println("Ingresar datos de la Editorial");
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
    
    public Editorial crearEditorial(String nombre) {
        Editorial editorial = new Editorial();
        try {
            editorial.setNombre(nombre);
            editorial.setAlta(true);
            
            dao.guardar(editorial);
            
            return editorial;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }        
    }
    
    public Editorial buscarPorId(Integer id) {
        try {
            return dao.buscarPorId(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public void mostrarListaDeEditoriales() {
        try {            
            dao.listarTodosLosEditoriales().forEach((e) -> System.out.println(e.toString()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void eliminarEditorail(Integer Id) {
        try {
            dao.eliminar(Id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
