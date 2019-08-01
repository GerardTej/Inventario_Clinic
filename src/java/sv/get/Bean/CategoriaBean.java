/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.get.Bean;

import java.beans.*;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Size;
import sv.get.EJB.CategoriasFacadeLocal;
import sv.get.Entidades.Categorias;

/**
 *
 * @author gerardo
 */
@Named
@RequestScoped
public class CategoriaBean {
    
    @EJB
    private CategoriasFacadeLocal catService;
    
    @Size(min=1, message="El nombre de la CATEGORIA es necesaria")
    private String nombre;

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the catService
     */
    public CategoriasFacadeLocal getCatService() {
        return catService;
    }

    public List<Categorias> getCategorias(){
        return catService.findAll();
    }
}

