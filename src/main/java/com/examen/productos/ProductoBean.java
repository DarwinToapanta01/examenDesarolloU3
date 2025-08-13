package com.examen.productos;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class ProductoBean implements Serializable {
    private Producto producto = new Producto();
    private List<Producto> productos = new ArrayList<>();
    private IProductoDAO productoDAO = new ProductoDAOImpl();

    @PostConstruct
    public void init() {
        productos = productoDAO.listarTodos();
    }

    public void registrar() {
        productoDAO.insertar(producto);
        producto = new Producto();
        productos = productoDAO.listarTodos();
    }

    public void eliminar(int id) {
        productoDAO.eliminar(id);
        productos = productoDAO.listarTodos();
    }

    // Getters y Setters
    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }
    public List<Producto> getProductos() { return productos; }
    public void setProductos(List<Producto> productos) { this.productos = productos; }
}
