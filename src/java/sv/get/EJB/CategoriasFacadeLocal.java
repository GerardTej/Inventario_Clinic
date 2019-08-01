/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.get.EJB;

import java.util.List;
import java.util.Map;
import javax.ejb.Local;
import sv.get.Entidades.Categorias;

/**
 *
 * @author gerardo
 */
@Local
public interface CategoriasFacadeLocal {

    void create(Categorias categorias);
    
//    public Map<String, String> insert();

    void edit(Categorias categorias);

    void remove(Categorias categorias);

    Categorias find(Object id);

    List<Categorias> findAll();

    List<Categorias> findRange(int[] range);

    int count();
    
}
