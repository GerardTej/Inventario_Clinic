/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.get.EJB;

import sv.get.Entidades.Articulos;
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
public class ArticuloService implements ArticuloServiceLocal {

    private static final Logger LOG = Logger.getLogger(ArticuloService.class.getName());
    
    @PersistenceContext(unitName = "Inventario_ClinicPU")
    private EntityManager em;
            
    @Override
    public List<Articulos> obtenerMedicamentos() {
        LOG.log(Level.INFO, "[ArticuloService][obtenerMedicamentos]");
        List<Articulos> resultado = null;
        Query query;
        try{
            query = em.createNamedQuery("Articulos.findAll");
            resultado = query.getResultList();
        }catch (Exception e){
            LOG.log(Level.SEVERE, "[ArticuloService][obtenerMedicamentos] Excepcion -> {0}", e.getMessage());
        }
        return resultado;
    }

    @Override
    public void nuevoArticulo(Articulos artic) {
       try {
            em.merge(artic);
            em.flush();
            em.getEntityManagerFactory().getCache().evictAll();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "[ArticuloService][crearArticulo] Exception -> {0}", e.getMessage());
        }
    }

}
