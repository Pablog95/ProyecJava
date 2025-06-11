package org.proyecJava.view;

import org.proyecJava.model.Pedido;
import org.proyecJava.model.Producto;
import org.proyecJava.controller.PedidoController;
import org.proyecJava.controller.ProductoController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPedido {
    private ProductoController productoController;
    private PedidoController pedidoController;
    private Pedido pedidoActual;
    private final Scanner sc = new Scanner(System.in);


    public MenuPedido(ProductoController productoController, PedidoController pedidoController, Pedido pedidoActual) {
        this.productoController = productoController;
        this.pedidoController = pedidoController;
        this.pedidoActual = pedidoActual;
    }

    public void menuPedido() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenuPedido();
            System.out.println("Ingrese un numero: ");
            try {
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1: agregarProducto();
                        break;
                    case 2: listarProductosDisponibles();
                        break;
                    case 3: eliminarProducto();
                        break;
                    case 4:
                        listarPedido();
                        break;
                    case 5:
                        confirmarPedido();
                        return;
                    case 6:
                        cancelarPedido();
                        return;

                }
            } catch (InputMismatchException e) {
                System.out.println("Opcion incorrecta intente de nuevo");
                sc.nextLine();
                opcion = 0;
            }
        } while (opcion != 6);
    }

    public void mostrarMenuPedido() {
        System.out.println("Menu pedidos");
        System.out.println("1- Agregar Producto al pedido");
        System.out.println("2- Listar Productos disponibles");
        System.out.println("3- Eliminar Producto del pedido");
        System.out.println("4- Listar pedido");
        System.out.println("5- Confirmar Pedido");
        System.out.println("6- Cancelar Pedido");

    }

    public void agregarProducto() {
        productoController.listarProductos();
        System.out.println("Ingrese el id del producto: ");
        int id = sc.nextInt();
        Producto producto = productoController.buscarProductos(id);

        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        System.out.println("Ingrese la cantidad del producto: ");
        int cantidad = sc.nextInt();

        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        pedidoController.agregarProductoAPedido(pedidoActual, id, cantidad, productoController);

    }

    public void eliminarProducto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el id del producto: ");
        int idProducto = sc.nextInt();
        Producto producto = productoController.buscarProductos(idProducto);

        if (producto != null) {
            pedidoController.eliminarProductoDePedidos(pedidoActual,producto.getId(), productoController);
            System.out.println("Producto eliminado.");
        } else {

            System.out.println("Producto no encontrado.");
        }
    }

    public void listarPedido() {
        System.out.println(pedidoActual.getProductos());

    }
    private void listarProductosDisponibles() {
        productoController.listarProductos();
    }

    private void confirmarPedido(){
        finalizarPedido("Pedido Exitoso");
    }

    private void cancelarPedido(){
        finalizarPedido("Pedido cancelado...");
    }

    private void finalizarPedido(String mensaje){
        System.out.println(mensaje);
        pedidoActual = null;
    }
}
