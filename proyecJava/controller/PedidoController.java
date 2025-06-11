package org.proyecJava.controller;

import org.proyecJava.model.Pedido;
import org.proyecJava.model.Producto;

import java.util.ArrayList;
import java.util.List;

public class PedidoController {
    private List<Pedido> pedidos = new ArrayList<>();

    public PedidoController() {
    }


    public void listarPedido() {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos");
            return;
        }
        for (Pedido pedido : pedidos) {
            System.out.println(pedido);
        }
    }

    public Pedido crearPedido() {
        Pedido pedido = new Pedido();
        pedidos.add(pedido);
        return pedido;

    }

    public void agregarProductoAPedido(Pedido pedido, int idProducto, int cantidad, ProductoController productoController) {
        if(pedido == null) {
            System.out.println("No hay pedidos");
            return;
        }

        if(cantidad <= 0){
            System.out.println("Cantidad debe ser mayor que 0");
            return;
        }
        Pedido pedidoActual = obtenerPedidoPorID(pedido.getId());
        Producto producto = productoController.buscarProductos(idProducto);

        if(producto == null) {
            System.out.println("Producto no encontrado");
            return;
        }

        if(producto.getStock()< cantidad ){
            System.out.println("Cantidad debe ser mayor que "+ producto.getStock());
            return;
        }

        pedidoActual.agregarProducto(producto, cantidad);
        producto.setStock(producto.getStock() - cantidad);
        System.out.println("Producto agregado");

    }

    public void eliminarProductoDePedidos(Pedido pedido,int idProducto, ProductoController productoController) {
        if(pedido == null) {
            System.out.println("No hay pedidos");
            return;
        }
        Producto producto = productoController.buscarProductos(idProducto);

        if(producto != null){
            pedido.eliminarProducto(producto);
        }
    }

    public Pedido obtenerPedidoPorID(int id) {
        return pedidos.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

}
