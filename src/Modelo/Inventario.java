package Modelo;

import java.util.ArrayList;

public class Inventario {

    private ArrayList<ObjetosInventario> inventario;

    //Constructor
    public Inventario() {
        this.inventario = new ArrayList<>(11);
        this.generarInventario();
    }

    //Método para generar el inventario vacío
    private void generarInventario() {
        for (int i = 0; i < 11; i++) {
            inventario.add(new ObjetosInventario(i, 0, "Vacío", 0));
        }
    }

    //Método para modificar el inventario al añadir un nuevo objeto
    public void modificarInventario(ObjetosInventario objetoNuevo) {
        boolean encontrado = false;

        //Buscar si el objeto ya existe en el inventario
        for (ObjetosInventario obj : inventario) {
            if (obj.getIDobjeto() == objetoNuevo.getIDobjeto() && obj.getCantidad() > 0) {
                //Sumar cantidad, sin pasar de 6
                obj.setCantidad(Math.min(obj.getCantidad() + objetoNuevo.getCantidad(), 6));
                encontrado = true;
                break;
            }
        }

        //Si no se encontró, insertar en el primer hueco vacío
        if (!encontrado) {
            for (ObjetosInventario obj : inventario) {
                if (obj.getCantidad() == 0) { // espacio vacío
                    obj.setIDobjeto(objetoNuevo.getIDobjeto());
                    obj.setNombreObjeto(objetoNuevo.getNombreObjeto());
                    obj.setCantidad(Math.min(objetoNuevo.getCantidad(), 6));
                    break;
                }
            }
        }
    }

    //Método para validar que un objeto no tenga más de 6 unidades (opcional extra protección)
    private void validarMaximos(ObjetosInventario objeto) {
        if (objeto.getCantidad() > 6) {
            objeto.setCantidad(6);
        }
    }

    //Método para eliminar una unidad de un objeto por su ID
    public void eliminarObjeto(int idObjeto) {
        for (int i = 0; i < inventario.size(); i++) {
            ObjetosInventario objeto = inventario.get(i);
            if (objeto.getIDobjeto() == idObjeto && objeto.getCantidad() > 0) {
                if (objeto.getCantidad() > 1) {
                    objeto.setCantidad(objeto.getCantidad() - 1);
                } else {
                    //Si queda 1 sola unidad, vaciar la casilla en vez de eliminar el objeto
                    objeto.setIDobjeto(i); //Mantener su posición original
                    objeto.setNombreObjeto("Vacío");
                    objeto.setCantidad(0);
                }
                System.out.println("Se ha eliminado 1 unidad de " + objeto.getNombreObjeto());
                break;
            }
        }
    }

    //Getter del inventario
    public ArrayList<ObjetosInventario> getInventario() {
        return inventario;
    }

    //Setter del inventario
    public void setInventario(ArrayList<ObjetosInventario> inventario) {
        this.inventario = inventario;
    }

    //toString para mostrar el inventario
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Inventario:\n");
        for (ObjetosInventario obj : inventario) {
            sb.append(obj.toString()).append("\n");
        }
        return sb.toString();
    }
}
