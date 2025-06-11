package org.proyecJava.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Pedido {
    private static final AtomicInteger contador = new AtomicInteger(0);
    private int id;
    private List<Carrito> productos = new ArrayList<>();
    private Double total;


    public Pedido() {
        id = contador.incrementAndGet();
    }

    public void agregarProducto(Producto producto, int cantidad) {
        productos.add(new Carrito(producto, cantidad));
        actualizarTotal();
    }

    public void eliminarProducto(Producto producto) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getProducto().getId() == producto.getId()) {
                productos.remove(i);
                break;
            }
        }
        actualizarTotal();
    }

    public List<Carrito> getProductos() {
        return productos;
    }

    public void setProductos(List<Carrito> productos) {
        this.productos = productos;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private void actualizarTotal() {
        this.total = productos.stream()
                .mapToDouble(Carrito::getSubTotal)
                .sum();
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "productos=" + productos +
                ", total=" + total +
                '}';
    }
}
