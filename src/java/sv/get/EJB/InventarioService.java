/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.get.EJB;

import sv.get.Entidades.Categorias;
import sv.get.Entidades.Inventario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author gerardo
 */
@Stateless
public class InventarioService {

    private static final Logger LOG = Logger.getLogger(ArticuloService.class.getName());
    
    @PersistenceContext(unitName = "Inventario_ClinicPU")
    private EntityManager em;
    public List<Inventario> obtenerInventario() 
    {
        LOG.log(Level.INFO, "[InventarioService][obtenerInventario]");
        List<Inventario> resultado = null;
        Query query;
        try{
            query = em.createNamedQuery("Inventario.findAll");
            resultado = query.getResultList();
        }catch (Exception e){
            LOG.log(Level.SEVERE, "[InventarioService][obtenerInventario] Excepcion -> {0}", e.getMessage());
        }
        return resultado;
    }
}