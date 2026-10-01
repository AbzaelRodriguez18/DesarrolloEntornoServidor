package org.colecciones.entidades;


public record Book(String isbn, String title, String author, int pages)
        implements Comparable<Book> {

    @Override
    public int compareTo(Book otro) {
        return this.title.compareTo(otro.title);
    }
}