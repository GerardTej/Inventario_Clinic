/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.get.Bean;

import sv.get.EJB.ArticuloServiceLocal;
import sv.get.Entidades.Articulos;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Size;

/**
 *
 * @author gerardo
 */
@Named
@RequestScoped
public class ArticuloBean {

    @EJB
    private ArticuloServiceLocal medicService;
    
    @Size(min=1, message="El nombre del medicamento es necesario")
    private String nombre;
    
    private String descrip;
    private Boolean estado;

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the descrip
     */
    public String getDescrip() {
        return descrip;
    }

    /**
     * @return the estado
     */
    public Boolean getEstado() {
        return estado;
    }
    
    /**
     *
     * @return
     */
    public List<Articulos> getMedicamento(){
        return medicService.obtenerMedicamentos();
    }
    
    public ArticuloBean(String nombre)
    {
        this.nombre = nombre;
    }
    
}
