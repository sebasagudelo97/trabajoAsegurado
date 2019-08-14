package co.com.trabajo_asegurado_Transversal.excepcion;

import co.com.trabajo_asegurado_Transversal.enumeracion.CapaEnum;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

public class TrabajoAseguradoExcepcion extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private Throwable excepcionRaiz;
    private String mensaje;
    private CapaEnum capa;

    private TrabajoAseguradoExcepcion(Throwable excepcionRaiz, String mensaje, CapaEnum capa) {
        setMensaje(mensaje);
        setExcepcionRaiz(excepcionRaiz);
        setCapa(capa);
    }

    public static  TrabajoAseguradoExcepcion CREAR(Throwable excepcionRaiz, String mensaje, CapaEnum capa) {
        return new TrabajoAseguradoExcepcion(excepcionRaiz, mensaje, capa);
    }

    public static TrabajoAseguradoExcepcion CREAR(String mensaje) {
        return new TrabajoAseguradoExcepcion(null, mensaje, null);
    }

    public static TrabajoAseguradoExcepcion CREAR(String mensaje, CapaEnum capa) {
        return new TrabajoAseguradoExcepcion(null, mensaje, capa);
    }

    public static TrabajoAseguradoExcepcion CREAR(Throwable excepcionRaiz, String mensaje) {
        return new TrabajoAseguradoExcepcion(excepcionRaiz, mensaje, null);
    }

    public void setExcepcionRaiz(Throwable excepcionRaiz) {
        this.excepcionRaiz = ObjectUtils.defaultIfNull(excepcionRaiz, new Exception(mensaje));
    }

    public void setMensaje(String mensaje) {
        this.mensaje = StringUtils.defaultString(mensaje);
    }

    public void setCapa(CapaEnum capa) {
        this.capa = ObjectUtils.defaultIfNull(capa, CapaEnum.TRANSVERSAL);
    }

    public Throwable getExcepcionRaiz() {
        return excepcionRaiz;
    }

    public String getMensaje() {
        return mensaje;
    }

    public CapaEnum getCapa() {
        return capa;
    }
}
