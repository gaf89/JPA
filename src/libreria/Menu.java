
package libreria;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.servicio.AutorServicio;
import libreria.servicio.EditorialServicio;
import libreria.servicio.LibroServicio;

public class Menu {
    
    private final Scanner leer;
    private final LibroServicio libroServicio = new LibroServicio();
    private final AutorServicio autorServicio = new AutorServicio();
    private final EditorialServicio editorialServicio = new EditorialServicio();
    
    public Menu() {
        libroServicio.setServicio(autorServicio, editorialServicio);
        autorServicio.setServicio(libroServicio, editorialServicio);
        editorialServicio.setServicio(autorServicio, libroServicio);
        leer = new Scanner(System.in);
    }
    
    public void menuDeOpciones() {
        int opcion;                  
            System.out.println("");
            System.out.println("*****Menú*****");
            System.out.println("");
            System.out.println(" 1. Cargar un Autor");
            System.out.println(" 2. Cargar una Editorial");
            System.out.println(" 3. Cargar un Libro");
            System.out.println(" 4. Mostrar Lista de autores");
            System.out.println(" 5. Mostrar Lista de Editoriales");
            System.out.println(" 6. Mostrar Lista de Libros");
            System.out.println(" 7. Buscar un autor por su id");
            System.out.println(" 8. Buscar un autor por su nombre");
            System.out.println(" 9. Buscar una editorial por su id");
            System.out.println("10. Buscar libro por su isbn");
            System.out.println("11. Filtrar Lista de Libros por su Autor");
            System.out.println("12. Filtrar lista de Libros por su Editorial");
            System.out.println("13. Modificar Título de un libro");
            System.out.println("14. Modificar Nombre del autor");
            System.out.println("15. Prestar Libro");
            System.out.println("16. Eliminar Autor");
            System.out.println("17. Eliminar Editorial");
            System.out.println("18. Eliminar Libro");
            System.out.println("19. Salir");
            System.out.println("");
            System.out.print("Ingrese una Opcion: ");
            opcion = leer.nextInt();
            
            switch (opcion) {
                case 1: crearAutroConDatosIngresados();
                        System.out.println("");
                        System.out.println("M: Menú     S: Salir");
                        if (leer.next().equalsIgnoreCase("m")) {
                            menuDeOpciones();
                        }
                        break;
                case 2: crearEditorialConDatosIngresados();
                        System.out.println("");
                        System.out.println("M: Menú     S: Salir");
                        if (leer.next().equalsIgnoreCase("m")) {
                            menuDeOpciones();
                        }
                        break;
                case 3: crearLibroConDatosIngresados();
                        System.out.println("");
                        System.out.println("M: Menú     S: Salir");
                        if (leer.next().equalsIgnoreCase("m")) {
                            menuDeOpciones();
                        }
                        break;
                case 4: autorServicio.mostrarListaDeAutores();
                        System.out.println("");
                        System.out.println("M: Menú     S: Salir");
                        if (leer.next().equalsIgnoreCase("m")) {
                            menuDeOpciones();
                        }
                        break;
                case 5: editorialServicio.mostrarListaDeEditoriales();
                        System.out.println("");
                        System.out.println("M: Menú     S: Salir");
                        if (leer.next().equalsIgnoreCase("m")) {
                            menuDeOpciones();
                        }
                        break;
                case 6: libroServicio.mostrarListaDeLibros();
                        System.out.println("");
                        System.out.println("M: Menú     S: Salir");
                        if (leer.next().equalsIgnoreCase("m")) {
                            menuDeOpciones();
                        }
                        break;
                case 7: buscarAutroPorId();
                        System.out.println("");
                        System.out.println("M: Menú     S: Salir");
                        if (leer.next().equalsIgnoreCase("m")) {
                            menuDeOpciones();
                        }
                        break;
                case 8: buscarAutorPorNombre();
                        System.out.println("");
                        System.out.println("M: Menú     S: Salir");
                        if (leer.next().equalsIgnoreCase("m")) {
                            menuDeOpciones();
                        }
                        break;
                case 9: buscarEditorialPorId();
                        System.out.println("");
                        System.out.println("M: Menú     S: Salir");
                        if (leer.next().equalsIgnoreCase("m")) {
                            menuDeOpciones();
                        }
                        break;
                case 10: buscarLibroPorIsbn();
                        System.out.println("");
                        System.out.println("M: Menú     S: Salir");
                        if (leer.next().equalsIgnoreCase("m")) {
                            menuDeOpciones();
                        }
                         break;
                case 11: filtrarLibrosPorAutor();
                        System.out.println("");
                        System.out.println("M: Menú     S: Salir");
                        if (leer.next().equalsIgnoreCase("m")) {
                            menuDeOpciones();
                        }
                         break;
                case 12: filtrarLibrosPorEditorial();
                        System.out.println("");
                        System.out.println("M: Menú     S: Salir");
                        if (leer.next().equalsIgnoreCase("m")) {
                            menuDeOpciones();
                        }
                         break;
                case 13: modificarTituloDelLibro();
                        System.out.println("");
                        System.out.println("M: Menú     S: Salir");
                        if (leer.next().equalsIgnoreCase("m")) {
                            menuDeOpciones();
                        }
                         break;
                case 14: modificarNombreAutor();
                        System.out.println("");
                        System.out.println("M: Menú     S: Salir");
                        if (leer.next().equalsIgnoreCase("m")) {
                            menuDeOpciones();
                        }
                         break;
                case 15: prestarLibro();
                        System.out.println("");
                        System.out.println("M: Menú     S: Salir");
                        if (leer.next().equalsIgnoreCase("m")) {
                            menuDeOpciones();
                        }
                         break;
                case 16: eliminarAutor();
                        System.out.println("");
                        System.out.println("M: Menú     S: Salir");
                        if (leer.next().equalsIgnoreCase("m")) {
                            menuDeOpciones();
                        }
                         break;
                case 17: eliminarEditorial();
                         break;
                case 18: eliminarLibro();
                        System.out.println("");
                        System.out.println("M: Menú     S: Salir");
                        if (leer.next().equalsIgnoreCase("m")) {
                            menuDeOpciones();
                        }
                         break;
                case 19: System.out.println("Programa Finalizado");
                         break;
                default: System.out.println("Opcion No Vñalida");
                         menuDeOpciones();
                         break;
            }        
    }
      
     
    public void crearLibroConDatosIngresados() {
        Libro libro = libroServicio.ingresarDatosLibro();
        libroServicio.crearLibro2(libro);
        
    }
    
    public void mostrarListaLibros() {
        System.out.println("Lista de Libros");
        libroServicio.mostrarListaDeLibros();
    }
    
    public void crearAutroConDatosIngresados() {
        String nombre = autorServicio.cargarNombre();
        autorServicio.crearAutor(nombre);        
    }
    
    public void crearEditorialConDatosIngresados() {
        String nombre = editorialServicio.cargarNombre();
        editorialServicio.crearEditorial(nombre);
    }
    
    public void buscarAutroPorId() {
        System.out.print("Ingresar Id del autor a buscar: ");
        int Id = leer.nextInt();
        Autor autor = autorServicio.buscarPorId(Id);
        System.out.println(autor.toString());
    }
    
    public void buscarAutorPorNombre() {
        System.out.print("Ingresar nombre del autor a busca: ");
        String nombre = leer.nextLine();
        Autor autor = autorServicio.bucarPoNombre(nombre);
        System.out.println(autor.toString());       
    }
    
    public void buscarEditorialPorId() {
        System.out.print("Ingresar Id de la editorial a buscar: ");
        int Id = leer.nextInt();
        Editorial editorial = editorialServicio.buscarPorId(Id);
        System.out.println(editorial.toString());
    }
    
    public void buscarLibroPorIsbn() {
        System.out.print("Ingresar ISBN del libro a buscar: ");
        long isbn = leer.nextLong();
        Libro libro = libroServicio.buscarPorIsbn(isbn);
        System.out.println(libro.toString());
    }
    
    public void filtrarLibrosPorAutor() {
        leer.skip("\n");
        System.out.print("Ingresar nombre del autor: ");
        String nombre = leer.nextLine();    
        List<Libro> libros = libroServicio.listarLibrosPorNombreAutor(nombre);
        System.out.println("");
        System.out.println("Lista de libros");
        libros.forEach((l) -> System.out.println(l.toString()));
    }
    
    public void filtrarLibrosPorEditorial() {
        leer.skip("\n");
        System.out.print("Ingresar nombre de la editorial: ");
        String nombre = leer.nextLine();
        List<Libro> libros = libroServicio.listarLibrosPorNombreEditorial(nombre);
        System.out.println("");
        System.out.println("Lista de libros");
        libros.forEach((l) -> System.out.println(l.toString()));
    }
    
    public void modificarTituloDelLibro() {
        System.out.print("Ingresar ISBN del libro a modificar: ");
        long isbn = leer.nextLong();
        leer.skip("\n");
        System.out.print("Ingresar título nuevo: ");
        String titulo = leer.nextLine();
        libroServicio.modificarTituloDelLibro(isbn, titulo);
    }
    
    public void modificarNombreAutor() {
        System.out.println("Ingresar Id del autor a modificar: ");
        int id = leer.nextInt();
        leer.skip("\n");
        System.out.println("Ingresar nombre nuevo: ");
        String nombre = leer.nextLine();
        autorServicio.modificarNombreAutor(id, nombre);
    }
    
    public void prestarLibro() {
        System.out.print("Ingresar isbn del libro: ");
        long isbn = leer.nextLong();
        System.out.print("Cantidad de ejemplares a prestar: ");
        int ejemplaresAPrestar = leer.nextInt();
        libroServicio.prestarLibro(isbn, ejemplaresAPrestar);        
    }
    
    public void prueba() {
        System.out.println("isbn");
        long isbn = leer.nextLong();
        System.out.println("prestados");
        int pres = leer.nextInt();
        System.out.println("restantes");
        int rest = leer.nextInt();
       libroServicio.modificarEjemplares(isbn, pres, rest);       
    }
    
    public void eliminarAutor() {
        System.out.print("Ingresar Id de autor a eliminar: ");
        int id = leer.nextInt();
        autorServicio.eliminarAutor(id);
    }
    
    public void eliminarEditorial() {
        System.out.print("Ingresar Id de la editorial a eliminar: ");
        int id = leer.nextInt();
        editorialServicio.eliminarEditorail(id);
    }
    
    public void eliminarLibro() {
        System.out.print("Ingresar ISBN del libor a eliminar: ");
        long isbn = leer.nextLong();
        libroServicio.eliminarLibro(isbn);
    }
    
}
