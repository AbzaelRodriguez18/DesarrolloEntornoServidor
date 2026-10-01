package org.funcional;

import org.funcional.entidades.Book;
import org.funcional.entidades.BookCollection;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        BookCollection libros = new BookCollection();


        libros.add(new Book("9788422616337", "El Senor de los Anillos", "J.R.R. Tolkien", 800));

        libros.add(new Book("9788445077528", "El Hobbit", "J.R.R. Tolkien", 350));

        libros.add(new Book("9788466316781", "Cabo Trafalgar", "Arturo Perez Reverte", 320));

        libros.add(new Book("9788493975074", "El corazon de la piedra", "Jose Maria Garcia Lopez", 560));

        libros.add(new Book("9788493291488", "Salmos de visperas", "Esteban Hernandez Castello", 95));

        libros.add(new Book("9788420685625", "La musica en las catedrales espanolas del Siglo de Oro", "Robert Stevenson", 600));

        libros.add(new Book("9788423913077", "Luces de bohemia", "Ramon del Valle-Inclan", 296));

        libros.add(new Book("9788448031121", "Contando atardeceres", "La vecina rubia", 528));

        libros.add(new Book("9781529342079", "The Master: The Brilliant Career of Roger Federer", "Christopher Clarey", 456));

        libros.add(new Book("9788408264385", "La teoria de los archipielagos", "Alice Kellen", 300));

        libros.add(new Book("9788423362479", "Esperando al diluvio", "Dolores Redondo", 576));

        libros.add(new Book("9788466367349", "El italiano", "Arturo Perez Reverte", 400));

        libros.add(new Book("9788466359290", "Linea de fuego", "Arturo Perez Reverte", 688));

        boolean menuActivo = true;

        while (menuActivo) {

            System.out.println("""
                    1. Cantidad de libros con mas de 500 paginas
                    2. Cantidad de libros con menos de 300 paginas
                    3. Titulos de libros con mas de 500 paginas
                    4. Titulos de los 3 libros con mas paginas
                    5. Suma total de paginas
                    6. Libros que superan el promedio
                    7. Autores sin repetir
                    8. Autores con mas de un libro
                    9. Libro con mas paginas
                    10. Mostrar todos los titulos
                    0. Salir
                    """);

            int opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println(libros.cantidadLibrosMasDe500Paginas());
                    break;

                case 2:
                    System.out.println(libros.cantidadLibrosMenosDe300Paginas());
                    break;

                case 3:
                    for (String titulo : libros.titulosMasDe500Paginas()) {
                        System.out.println(titulo);
                    }
                    break;

                case 4:
                    for (String titulo : libros.tresLibrosConMasPaginas()) {
                        System.out.println(titulo);
                    }
                    break;

                case 5:
                    System.out.println(libros.sumaTotalPaginas());
                    break;

                case 6:
                    for (Book libroPromedio : libros.librosPorEncimaDelPromedio()) {
                        System.out.println(libroPromedio.title() + " - " + libroPromedio.pages() + " paginas");
                    }
                    break;

                case 7:
                    for (String autor : libros.autoresSinRepetir()) {
                        System.out.println(autor);
                    }
                    break;

                case 8:
                    for (String autor : libros.autoresConMasDeUnLibro()) {
                        System.out.println(autor);
                    }
                    break;

                case 9:
                    Book libro = libros.libroConMasPaginas();
                    if (libro != null) {
                        System.out.println(libro.title() + " - " + libro.pages() + " paginas");
                    }
                    break;

                case 10:
                    for (String titulo : libros.todosLosTitulos()) {
                        System.out.println(titulo);
                    }
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    menuActivo = false;
                    break;

                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }

        teclado.close();
    }
}
