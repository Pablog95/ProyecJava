package org.proyecJava.view;

import org.proyecJava.model.Pedido;
import org.proyecJava.controller.PedidoController;
import org.proyecJava.controller.ProductoController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    PedidoController pedidoController = new PedidoController();
    ProductoController productoController = new ProductoController();

    public Menu() {

    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            System.out.println("Ingrese un numero del menu: ");
            try {
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        menuAgregarProducto();
                        break;
                    case 2:
                        listarProductos();
                        break;
                    case 3:
                        buscarProducto();
                        break;

                    case 4:
                        eliminarProducto();
                        break;
                    case 5:
                        crearPedido();
                        break;
                    case 6:
                        listarPedido();
                        break;
                    case 7:
                        System.out.println("Saliendo...");
                        return;

                }
            } catch (InputMismatchException e) {
                System.out.println("Opcion incorrecta intente de nuevo");
                sc.nextLine();
                opcion = 0;
            }
        } while (opcion != 7);
    }

    private void mostrarMenu() {
        System.out.println("Menu");
        System.out.println("1- Agregar Producto");
        System.out.println("2- Listar Productos");
        System.out.println("3- Buscar/Actualizar Productos");
        System.out.println("4- Eliminar Producto");
        System.out.println("5- Crear un pedido");
        System.out.println("6- Listar pedido");
        System.out.println("7- Salir");
    }

    private void menuAgregarProducto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre del producto: ");
        String nombre = sc.nextLine();

        double precio;
        System.out.println("Precio del producto: ");
        try{
            precio = sc.nextDouble();
            if(precio < 0){
                System.out.println("Precio invalido");
                return;
            }
        }catch(InputMismatchException e){
            System.out.println("Debe ingresar un numero valido");
            sc.nextLine();
            return;
        }

        int stock;
        System.out.println("Stock del producto: ");

        try{
            stock = sc.nextInt();
            if(stock < 0){
                System.out.println("Stock invalido");
                return;
            }
        }catch (InputMismatchException e){
            System.out.println("Debe ingresar un numero valido");
            return;
        }
        productoController.agregarProducto(nombre, precio, stock);
    }

    private void listarProductos() {
        productoController.listarProductos();
    }

    private void buscarProducto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del producto a buscar: ");
        String nombre = sc.nextLine();
        productoController.buscarProductos(nombre);
    }

    private void eliminarProducto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("ID del producto a eliminar: ");
        int id = sc.nextInt();
        productoController.eliminarProducto(id);
    }
    private void listarPedido() {
        pedidoController.listarPedido();
    }

    private void crearPedido() {
        Pedido pedido = pedidoController.crearPedido();
        MenuPedido menuPedido = new MenuPedido(productoController, pedidoController,pedido);
        menuPedido.menuPedido();

    }
}
