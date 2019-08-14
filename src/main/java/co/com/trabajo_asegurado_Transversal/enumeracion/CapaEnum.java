package co.com.trabajo_asegurado_Transversal.enumeracion;

public enum CapaEnum {

    DATOS("DATOS", "Capa de datos de la aplicación"), DOMINIO("DOMINIO", "Capa de dominio de la aplicación"),
    NEGOCIO("NEGOCIO", "Capa de negocio de la aplicación"), FACHADA("FACHADA", "Capa de fachada de la aplicación"),
    API("API", "Capa de api de la aplicación"), DTO("DTO", "Capa de dto de la aplicación"),
    TRANSVERSAL("TRANSVERSAL", "Capa de transversal de la aplicación"),
    BACKEND("BACKEND", "Capa de backend de la aplicación");

    private String codigo;
    private String descripcion;

    private CapaEnum(String codigo, String descripcion) {
        setCodigo(codigo);
        setDescripcion(descripcion);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    private void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    private void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
