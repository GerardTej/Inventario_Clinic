/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.get.EJB;

import sv.get.Entidades.Articulos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gerardo
 */
@Local
public interface ArticuloServiceLocal {
     public List<Articulos> obtenerMedicamentos();
     
     void nuevoArticulo(Articulos artic);
}
