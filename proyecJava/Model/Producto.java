package org.proyecJava.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Producto {

    private static final AtomicInteger contador = new AtomicInteger(0);
    private int Id;
    private String Nombre;
    private Double Precio;
    private int Stock;

    public Producto(String nombre, Double precio, int stock) {
        Id = contador.incrementAndGet();
        Nombre = nombre;
        Precio = precio;
        Stock = stock;
    }

    public Producto() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double precio) {
        Precio = precio;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "Id=" + Id +
                ", Nombre='" + Nombre + '\'' +
                ", Precio=" + Precio +
                ", Stock=" + Stock +
                '}';
    }
}
