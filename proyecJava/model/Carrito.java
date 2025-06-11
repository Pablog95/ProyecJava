package org.proyecJava.model;

public class Carrito {

    private Producto producto;
    private int cantidad;

    public Carrito(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        if (producto == null) {
            throw new IllegalArgumentException("Producto no puede ser nulo");
        }
        this.producto = producto;
    }


    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero. Valor recibido: " + cantidad);
        }
        this.cantidad = cantidad;
    }

    public Double getSubTotal() {
        if (producto == null) {
            throw new IllegalStateException("No se puede calcular subtotal: producto no asignado");
        }

        Double precio = producto.getPrecio();
        if (precio == null) {
            throw new IllegalStateException("No se puede calcular subtotal: el producto '" +
                    producto.getNombre() + "' no tiene precio asignado");
        }

        if (precio < 0) {
            throw new IllegalStateException("Precio inválido para '" + producto.getNombre() +
                    "': " + precio + ". El precio no puede ser negativo");
        }

        return precio * cantidad;
    }


    @Override
    public String toString() {
        return "producto=" + producto +
                ", cantidad=" + cantidad +
                '}';
    }
}
