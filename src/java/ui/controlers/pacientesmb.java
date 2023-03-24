/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controlers;

import bdcontrolers.PacientesFacade;
import entitys.Pacientes;
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
public class pacientesmb {

    String nombres, apellidos, correo, contraseña;
    String fecha;
    @EJB
    PacientesFacade controlador;
    Pacientes obj = new Pacientes();
    List<Pacientes> pacientes = new ArrayList();

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

    public PacientesFacade getControlador() {
        return controlador;
    }

    public void setControlador(PacientesFacade controlador) {
        this.controlador = controlador;
    }

    public Pacientes getObj() {
        return obj;
    }

    public void setObj(Pacientes obj) {
        this.obj = obj;
    }

    public List<Pacientes> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Pacientes> pacientes) {
        this.pacientes = pacientes;
    }

  

    public void insert() {

        obj.setNombre(nombres);
        obj.setApellidos(apellidos);
        obj.setEmail(correo);
        obj.setContrasena(contraseña);
        obj.setFechaNacimiento(fecha);
        controlador.create(obj);
        read();
        mostrarPacientes();
    }

    public void update(Pacientes obj) {
        this.obj = obj;
        editarPacientes();
        
    }

//    public void editar(Pacientes obj) {
//        obj.setNombre(nombres);
//        obj.setApellidos(apellidos);
//        obj.setEmail(correo);
//        obj.setContrasena(contraseña);
//        obj.setFechaNacimiento(fecha);
//        controlador.edit(obj);
//    }

    public void delete(Pacientes obj) {
        controlador.remove(obj);
        read();
        mostrarPacientes();
    }

    @PostConstruct
    public void read() {
    pacientes = controlador.findAll();
    }

    public void mostrarPacientes() {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath() + "/faces/pages/mostrPacientes.xhtml");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void editarPacientes() {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath() + "/faces/pages/editarPacientes.xhtml");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void crearUsu() {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath() + "/faces/pages/registerPacientes.xhtml");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
