package co.com.trabajo_asegurado_Dto.dto;

import org.apache.commons.lang3.StringUtils;

public class TipoIdentificacionDTO {
    private int codigo;
    private String nombre;

    public TipoIdentificacionDTO() {
        super();
    }

    public TipoIdentificacionDTO(int codigo, String nombre) {
        setCodigo(codigo);
        setNombre(nombre);
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return StringUtils.defaultString(nombre);
    }
}
