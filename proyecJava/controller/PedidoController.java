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
        for (Pedido pedido : pedidos) {
            System.out.println(pedido.toString());
        }
    }

    public Pedido crearPedido() {
        Pedido pedido = new Pedido();
        pedidos.add(pedido);
        return pedido;

    }

    public void agregarProductoAPedido(Pedido idPedido, int idProducto, int cantidad, ProductoController productoController) {
        Pedido pedido = obtenerPedidoPorID(idPedido.getId());
        Producto producto = productoController.buscarProductos(idProducto);
        if(producto != null) {
            if(producto.getStock() >= cantidad) {
                pedido.agregarProducto(producto, cantidad);
                producto.setStock(producto.getStock() - cantidad);
            }else{
                System.out.println("Supera stock - el stock actual es de: " + producto.getStock());
            }
        }

    }

    public void eliminarProductoDePedidos(Pedido pedido,int idProducto, ProductoController productoController) {
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
