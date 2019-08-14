package co.com.trabajo_asegurado_Dto.dto;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;


public class UsuarioProveedorDTO {
    private int codigo;
    private String nombre;
    private String apellido;
    private Date fechaRegistro;
    private TipoIdentificacionDTO tipoIdentificacion;
    private String telefono;
    private String direccion;

    public UsuarioProveedorDTO(){
        super();
    }


    public UsuarioProveedorDTO(String nombre, int codigo, String apellido, String direccion, Date fechaRegistro, String telefono, TipoIdentificacionDTO tipoIdentificacion) {
        setNombre(nombre);
        setCodigo(codigo);
        setApellido(apellido);
        setDireccion(direccion);
        setFechaRegistro(fechaRegistro);
        setTelefono(telefono);
        setTipoIdentificacion(tipoIdentificacion);
    }


    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public void setTipoIdentificacion(TipoIdentificacionDTO tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return StringUtils.defaultString(nombre);
    }

    public String getApellido(){
        return StringUtils.defaultString((apellido));
    }

    public TipoIdentificacionDTO getTipoIdentificacion() {
        return ObjectUtils.defaultIfNull(tipoIdentificacion, new TipoIdentificacionDTO());
    }

    public Date getFechaRegistro() {
        return ObjectUtils.defaultIfNull(fechaRegistro, new Date());
    }

    public String getTelefono(){
        return StringUtils.defaultString((telefono));
    }

    public String getDireccion(){
        return StringUtils.defaultString((direccion));
    }

    public int getCodigo() {
        return codigo;
    }

}
