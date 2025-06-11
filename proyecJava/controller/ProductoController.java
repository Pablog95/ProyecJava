package org.proyecJava.controller;

import org.proyecJava.model.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProductoController {
    private List<Producto> productos = new ArrayList<>();

    public ProductoController() {
    }

    public void agregarProducto(String nombre, Double precio, int stock) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                producto.setStock(producto.getStock() + stock);
                return;
            }
        }
        Producto producto = new Producto(nombre, precio, stock);
        productos.add(producto);
        System.out.println("Producto" + producto.getNombre() + "Agregado");
    }

    public void listarProductos() {
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    public Producto buscarProductos(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().toLowerCase().equals(nombre.toLowerCase())) {
                System.out.println("Producto encontado");
                System.out.println(producto);
                return producto;
            } else {
                System.out.println(nombre + " no existe en el sistema o esta mal escrito");
            }

        }
        return null;
    }

    public Producto buscarProductos(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                System.out.println("Producto encontado");
                System.out.println(producto);
                return producto;
            }
        }
        System.out.println("No existe en el sistema o esta mal escrito");
        return null;

    }

    public void eliminarProducto(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                productos.remove(producto);
                System.out.println("Producto eliminado: " + producto);
                break;
            }
        }
    }
}
