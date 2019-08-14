package co.com.trabajo_asegurado_Dominio.dominio;

import co.com.trabajo_asegurado_Transversal.enumeracion.CapaEnum;
import co.com.trabajo_asegurado_Transversal.excepcion.TrabajoAseguradoExcepcion;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;

@Entity
@Table(name = "TAB_TIPO_IDENTIFICACION_TBL", schema="dbo")
public class TipoIdentificacionDominio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "IN_CODIGO" , nullable = false)
    private int codigo;

    @Column(name = "NV_NOMBRE", nullable = false, length = 500)
    private String nombre;


    public TipoIdentificacionDominio() {
        setNombre(null);
    }

    public TipoIdentificacionDominio(int codigo, String nombre) {
        setCodigo(codigo);
        setNombre(nombre);
    }

    public void setCodigo(int codigo) {
        if (codigo < 0) {
            throw TrabajoAseguradoExcepcion.CREAR("El código de un tipo de identificación no puede ser menor que cero.", CapaEnum.DOMINIO);
        }

        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        String nombreTmp = StringUtils.trimToEmpty(nombre);

        if (nombreTmp.length() > 0) {

            if (nombreTmp.length() > 500) {
                throw TrabajoAseguradoExcepcion.CREAR("El nombre del tipo de identificación no puede contener una longitud mayor a 500.", CapaEnum.DOMINIO);
            }

            if (!nombreTmp.matches("^[a-zA-ZñÑáÁéÉíÍóÓúÚ ]+$")) {
                throw TrabajoAseguradoExcepcion.CREAR("El nombre del tipo de identificación no cumple el patrón de formación.", CapaEnum.DOMINIO);
            }
        }

        this.nombre = nombreTmp;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }
}
