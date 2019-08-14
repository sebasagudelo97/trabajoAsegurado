package co.com.trabajo_asegurado_Datos.dao;

import co.com.trabajo_asegurado_Dominio.dominio.UsuarioProveedorDominio;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioProveedorJPADAOCustom {
    List<UsuarioProveedorDominio> consultar(UsuarioProveedorDominio usuarioProveedor);
}
