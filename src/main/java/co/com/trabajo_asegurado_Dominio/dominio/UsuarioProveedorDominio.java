package co.com.trabajo_asegurado_Dominio.dominio;

import co.com.trabajo_asegurado_Dto.dto.TipoIdentificacionDTO;
import co.com.trabajo_asegurado_Transversal.enumeracion.CapaEnum;
import co.com.trabajo_asegurado_Transversal.excepcion.TrabajoAseguradoExcepcion;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table
public class UsuarioProveedorDominio {

    private int codigo;
    private String nombre;
    private String apellido;
    private Date fechaRegistro;
    private TipoIdentificacionDTO tipoIdentificacion;
    private String telefono;
    private String direccion;

    public void setCodigo(int codigo) {
        if (codigo < 0) {
            throw TrabajoAseguradoExcepcion.CREAR("El código de un usuario no puede ser menor que cero.", CapaEnum.DOMINIO);
        }
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        String nombreTmp = StringUtils.trimToEmpty(nombre);

        if (nombreTmp.length() > 5) {

            if (nombreTmp.length() > 500) {
                throw TrabajoAseguradoExcepcion.CREAR("El nombre del usuario no puede contener una longitud mayor a 500.", CapaEnum.DOMINIO);
            }

            if (!nombreTmp.matches("^[a-zA-ZñÑáÁéÉíÍóÓúÚ ]+$")) {
                throw TrabajoAseguradoExcepcion.CREAR("El nombre del usuario no cumple el patrón de formación.", CapaEnum.DOMINIO);
            }
        }

        this.nombre = nombreTmp;
    }

}
