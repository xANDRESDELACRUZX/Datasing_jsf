/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controlers;

import bdcontrolers.UsuariosFacade;
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
public class usuariosmb {

    String nombres, apellidos, correo, contraseña;
    String fecha;
    @EJB
    UsuariosFacade controlador;
    Usuarios obj = new Usuarios();
    List<Usuarios> usuarios = new ArrayList();

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public UsuariosFacade getControlador() {
        return controlador;
    }

    public void setControlador(UsuariosFacade controlador) {
        this.controlador = controlador;
    }

    public Usuarios getObj() {
        return obj;
    }

    public void setObj(Usuarios obj) {
        this.obj = obj;
    }

    public List<Usuarios> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuarios> usuarios) {
        this.usuarios = usuarios;
    }

    public void insert() {
        obj.setNombre(nombres);
        obj.setApellidos(apellidos);
        obj.setFechaNacimiento(fecha);
        obj.setEmail(correo);
        obj.setContrasena(contraseña);
        controlador.create(obj);
        read();
        mostrarUsu();
    }

    public void prepareEdit(Usuarios u) {
        this.obj = u;
        editarUsuarios();
    }

    public String editar() {
        this.controlador.edit(obj);
        this.obj = new Usuarios();
        return "index";
    }

    public void update() {
        obj.setNombre(nombres);
        obj.setApellidos(apellidos);
        obj.setContrasena(contraseña);
        obj.setEmail(correo);
        obj.setFechaNacimiento(fecha);
        controlador.edit(obj);
    }

    public void delete(Usuarios obj) {
        controlador.remove(obj);
        read();
    }

    @PostConstruct
    public void read() {

        usuarios = controlador.findAll();
    }

    public void mostrarUsu() {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath() + "/faces/pages/mostrUsu.xhtml");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void editarUsuarios() {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath() + "/faces/pages/editarUsuarios.xhtml");
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
