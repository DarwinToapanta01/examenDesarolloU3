package com.examen.productos;

import java.util.List;

public interface IProductoDAO {
    void insertar(Producto p);
    List<Producto> listarTodos();
    void eliminar(int id);
}
