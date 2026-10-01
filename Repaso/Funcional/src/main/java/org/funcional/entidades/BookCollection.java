package org.funcional.entidades;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BookCollection {

    private final List<Book> libros = new ArrayList<>();

    public void add(Book libro) {
        libros.add(libro);
    }

    public long cantidadLibrosMasDe500Paginas() {
        return libros.stream()
                .filter(libro -> libro.pages() > 500)
                .count();
    }

    public long cantidadLibrosMenosDe300Paginas() {
        return libros.stream()
                .filter(libro -> libro.pages() < 300)
                .count();
    }

    public List<String> titulosMasDe500Paginas() {
        return libros.stream()
                .filter(libro -> libro.pages() > 500)
                .map(Book::title)
                .toList();
    }

    public List<String> tresLibrosConMasPaginas() {
        return libros.stream()
                .sorted(Comparator.comparingInt(Book::pages).reversed())
                .limit(3)
                .map(Book::title)
                .toList();
    }

    public int sumaTotalPaginas() {
        return libros.stream()
                .mapToInt(Book::pages)
                .sum();
    }

    public List<Book> librosPorEncimaDelPromedio() {
        double promedio = libros.stream()
                .mapToInt(Book::pages)
                .average()
                .orElse(0.0);

        return libros.stream()
                .filter(libro -> libro.pages() > promedio)
                .toList();
    }

    public Set<String> autoresSinRepetir() {
        return libros.stream()
                .map(Book::author)
                .collect(Collectors.toSet());
    }

    public Set<String> autoresConMasDeUnLibro() {
        return libros.stream()
                .collect(Collectors.groupingBy(Book::author, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    public Book libroConMasPaginas() {
        return libros.stream()
                .max(Comparator.comparingInt(Book::pages))
                .orElse(null);
    }

    public List<String> todosLosTitulos() {
        return libros.stream()
                .map(Book::title)
                .toList();
    }
}