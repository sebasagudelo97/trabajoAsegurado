package co.com.trabajo_asegurado_Api.respuesta;

import lombok.Data;

import java.util.List;


public class RespuestaApi<T> {
    private List<T> datos;
    private List<String> mensaje;
    private String estado;

    public List<T> getDatos() {
        return datos;
    }

    public void setDatos(List<T> datos) {
        this.datos = datos;
    }

    public List<String> getMensaje() {
        return mensaje;
    }

    public void setMensaje(List<String> mensaje) {
        this.mensaje = mensaje;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
