package co.com.trabajo_asegurado_Dominio.dominio;

import co.com.trabajo_asegurado_Transversal.enumeracion.CapaEnum;
import co.com.trabajo_asegurado_Transversal.excepcion.TrabajoAseguradoExcepcion;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Entity
@Table(name = "TAB_USUARIO_TBL", schema = "dbo")
public class UsuarioProveedorDominio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "IN_CODIGO" , nullable = false)
    private int codigo;

    @Column(name = "NV_NOMBRE", nullable = false, length = 500)
    private String nombre;

    @Column(name = "NV_APELLIDO", nullable = false, length = 500)
    private String apellido;

    @Column(name = "NV_FECHA_REGISTRO", nullable = false)
    private Date fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "IN_CODIGO_TIPO_IDENTIFICACION")
    private TipoIdentificacionDominio tipoIdentificacion;

    @Column(name = "NV_TELEFONO", nullable = false, length = 500)
    private String telefono;

    @Column(name = "NV_DIRECCION", nullable = false, length = 500)
    private String direccion;

    public UsuarioProveedorDominio() {

        setTipoIdentificacion(null);
        setNombre(null);
        setTelefono(null);
        setDireccion(null);

    }

    public UsuarioProveedorDominio(int codigo, String apellido,  TipoIdentificacionDominio tipoIdentificacion, String nombre, String telefono, String direccion){
        setCodigo(codigo);
        setApellido(apellido);
        setTipoIdentificacion(tipoIdentificacion);
        setNombre(nombre);
        setTelefono(telefono);
        setDireccion(direccion);

    }


    public void setCodigo(int codigo) {
        if (codigo < 0) {
            throw TrabajoAseguradoExcepcion.CREAR("El código de un usuario no puede ser menor que cero.", CapaEnum.DOMINIO);
        }
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        String nombreTmp = StringUtils.trimToEmpty(nombre);

        if (nombreTmp.length() >=  5) {

            if (nombreTmp.length() > 500) {
                throw TrabajoAseguradoExcepcion.CREAR("El nombre del usuario no puede contener una longitud mayor a 500.", CapaEnum.DOMINIO);
            }

            if (!nombreTmp.matches("^[a-zA-ZñÑáÁéÉíÍóÓúÚ ]+$")) {
                throw TrabajoAseguradoExcepcion.CREAR("El nombre del usuario no cumple el patrón de formación.", CapaEnum.DOMINIO);
            }
        }else {
            throw TrabajoAseguradoExcepcion.CREAR("El nombre del ususario no puede contener una longitud menor a 5",CapaEnum.DOMINIO);
        }

        this.nombre = nombreTmp;
    }

    public void setApellido(String nombre) {
        String apellidoTmp = StringUtils.trimToEmpty(apellido);

        if (apellidoTmp.length() >=  5) {

            if (apellidoTmp.length() > 500) {
                throw TrabajoAseguradoExcepcion.CREAR("El apellido del usuario no puede contener una longitud mayor a 500.", CapaEnum.DOMINIO);
            }

            if (!apellidoTmp.matches("^[a-zA-ZñÑáÁéÉíÍóÓúÚ ]+$")) {
                throw TrabajoAseguradoExcepcion.CREAR("El apellido del usuario no cumple el patrón de formación.", CapaEnum.DOMINIO);
            }
        }else {
            throw TrabajoAseguradoExcepcion.CREAR("El apellido del ususario no puede contener una longitud menor a 5",CapaEnum.DOMINIO);
        }

        this.nombre = apellidoTmp;
    }

    public void setFechaRegistro(Date fecha) {
        this.fechaRegistro = ObjectUtils.defaultIfNull(fecha, Calendar.getInstance().getTime());

        Calendar fechaCalendario = new GregorianCalendar();
        fechaCalendario.setTime(this.fechaRegistro);
        fechaCalendario.set(Calendar.MILLISECOND, 0);

        this.fechaRegistro = fechaCalendario.getTime();
    }

    public void setTipoIdentificacion(TipoIdentificacionDominio tipoIdentificacion) {
        this.tipoIdentificacion = ObjectUtils.defaultIfNull(tipoIdentificacion, new TipoIdentificacionDominio());
    }

    public void setTelefono(String telefono) {
        String telefonoTmp = StringUtils.trimToEmpty(telefono);

        if (telefonoTmp.length() == 7) {

            if (!telefonoTmp.matches("^[0-9- ]+$")) {
                throw TrabajoAseguradoExcepcion.CREAR("El teléfono del usuario no cumple el patrón de formación.", CapaEnum.DOMINIO);
            }
        }else {
            throw TrabajoAseguradoExcepcion.CREAR("El telefono del usuario debe contener exactamente 7 caracteres");
        }

        this.telefono = telefonoTmp;
    }

    public void setDireccion(String direccion) {
        String direccionTmp = StringUtils.trimToEmpty(direccion);

        if (direccionTmp.length() > 0) {

            if (direccionTmp.length() > 500) {
                throw TrabajoAseguradoExcepcion.CREAR("La dirección del usuario no puede contener una longitud mayor a 500.", CapaEnum.DOMINIO);
            }

            if (!direccionTmp.matches("^[a-zA-ZñÑáÁéÉíÍóÓúÚ0-9#-. ]+$")) {
                throw TrabajoAseguradoExcepcion.CREAR("La dirección de residencia del usuario no cumple el patrón de formación.", CapaEnum.DOMINIO);
            }
        }

        this.direccion = direccionTmp;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public TipoIdentificacionDominio getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }
}
