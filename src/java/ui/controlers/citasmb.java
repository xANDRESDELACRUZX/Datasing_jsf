/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controlers;

import bdcontrolers.CitasFacade;
import bdcontrolers.UsuariosFacade;
import entitys.Citas;
import entitys.Usuarios;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.text.SimpleDateFormat;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author user
 */
@ManagedBean
public class citasmb {

    String hora, fecha, descripcion;
    @EJB
    CitasFacade controlador;
    Citas obj = new Citas();
    List<Citas> citas = new ArrayList();

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public CitasFacade getControlador() {
        return controlador;
    }

    public void setControlador(CitasFacade controlador) {
        this.controlador = controlador;
    }

    public Citas getObj() {
        return obj;
    }

    public void setObj(Citas obj) {
        this.obj = obj;
    }

    public List<Citas> getCitas() {
        return citas;
    }

    public void setCitas(List<Citas> citas) {
        this.citas = citas;
    }

    

    public void insert() {
        obj.setHora(hora);
        obj.setFecha(fecha);
        obj.setDescripcion(descripcion);
        controlador.create(obj);
        read();
        mostrarCitas();
    }

//    public void prepareEdit(Usuarios u) {
//        this.obj = u;
//        editarUsuarios();
//    }
//
//    public String editar() {
//        this.controlador.edit(obj);
//        this.obj = new Usuarios();
//        return "index";
//    }

////    public void update() {
////        obj.setNombre(nombres);
////        obj.setApellidos(apellidos);
////        obj.setContrasena(contraseña);
////        obj.setEmail(correo);
////        obj.setFechaNacimiento(fecha);
////        controlador.edit(obj);
////    }

    public void delete(Citas obj) {
        controlador.remove(obj);
        read();
    }

    @PostConstruct
    public void read() {

        citas = controlador.findAll();
    }

    public void mostrarCitas() {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath() + "/faces/pages/mostrarCitas.xhtml");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void editarCitas() {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath() + "/faces/pages/editarCitas.xhtml");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void crearCitas() {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath() + "/faces/pages/registerCitas.xhtml");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
