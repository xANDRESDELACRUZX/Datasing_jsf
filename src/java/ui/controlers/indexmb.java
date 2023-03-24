/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controlers;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
public class indexmb {

    public void pagcrud() {

        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath() + "/faces/pages/crud.xhtml");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void pagcrudUsuarios() {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath() + "/faces/pages/mostrUsu.xhtml");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void pagcrudPacientes() {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath() + "/faces/pages/mostrPacientes.xhtml");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void pagcrudDoctores() {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath() + "/faces/pages/mostrarDoctores.xhtml");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void pagcrudCitas() {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath() + "/faces/pages/mostrarCitas.xhtml");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void crearUsu() {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath() + "/faces/pages/register.xhtml");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
