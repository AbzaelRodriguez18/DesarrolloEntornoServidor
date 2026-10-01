package org.colecciones.entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class BookCollection {
    private ArrayList<Book> libros;

    public BookCollection() {
        libros = new ArrayList<>();
    }

    public void add(Book book) {
        libros.add(book);
    }

    public int cantidadLibrosMasDe500Paginas() {

        int cantidad = 0;

        for (Book libro : libros) {
            if (libro.pages() > 500) {
                cantidad++;
            }
        }

        return cantidad;
    }

    public int cantidadLibrosMenosDe300Paginas() {

        int cantidad = 0;

        for (Book libro : libros) {
            if (libro.pages() < 300) {
                cantidad++;
            }
        }

        return cantidad;
    }

    public List<String> titulosMasDe500Paginas() {

        List<String> titulos = new ArrayList<>();

        for (Book libro : libros) {
            if (libro.pages() > 500) {
                titulos.add(libro.title());
            }
        }

        return titulos;
    }

    public List<String> tresLibrosConMasPaginas() {

        List<Book> copia = new ArrayList<>(libros);

        for (int i = 0; i < copia.size() - 1; i++) {

            for (int j = i + 1; j < copia.size(); j++) {

                if (copia.get(j).pages() > copia.get(i).pages()) {

                    Book aux = copia.get(i);
                    copia.set(i, copia.get(j));
                    copia.set(j, aux);
                }
            }
        }

        List<String> titulos = new ArrayList<>();

        int cantidad = 3;

        if (copia.size() < 3) {
            cantidad = copia.size();
        }

        for (int i = 0; i < cantidad; i++) {
            titulos.add(copia.get(i).title());
        }

        return titulos;
    }

    public int sumaTotalPaginas() {

        int suma = 0;

        for (Book libro : libros) {
            suma += libro.pages();
        }

        return suma;
    }

    public List<Book> librosPorEncimaDelPromedio() {

        List<Book> resultado = new ArrayList<>();

        int suma = 0;

        for (Book libro : libros) {
            suma += libro.pages();
        }

        double promedio = 0;

        if (!libros.isEmpty()) {
            promedio = (double) suma / libros.size();
        }

        for (Book libro : libros) {
            if (libro.pages() > promedio) {
                resultado.add(libro);
            }
        }

        return resultado;
    }
    public Set<String> autoresSinRepetir() {

        Set<String> autores = new HashSet<>();

        for (Book libro : libros) {
            autores.add(libro.author());
        }

        return autores;
    }

    public Set<String> autoresConMasDeUnLibro() {

        Set<String> autores = new HashSet<>();

        for (int i = 0; i < libros.size(); i++) {

            String autor = libros.get(i).author();
            int cantidad = 0;

            for (int j = 0; j < libros.size(); j++) {

                if (libros.get(j).author().equals(autor)) {
                    cantidad++;
                }
            }

            if (cantidad > 1) {
                autores.add(autor);
            }
        }

        return autores;
    }
    public Book libroConMasPaginas() {

        Book mayor = libros.get(0);

        for (Book libro : libros) {

            if (libro.pages() > mayor.pages()) {
                mayor = libro;
            }
        }

        return mayor;
    }

    public List<String> todosLosTitulos() {

        List<String> titulos = new ArrayList<>();

        for (Book libro : libros) {
            titulos.add(libro.title());
        }

        return titulos;
    }

    public ArrayList<Book> ordenarLibros() {
        libros.sort(Book::compareTo);
        return libros;
    }
}

