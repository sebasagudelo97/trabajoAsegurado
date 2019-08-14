package co.com.trabajo_asegurado_Datos.dao;

import co.com.trabajo_asegurado_Dominio.dominio.UsuarioProveedorDominio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioProveedorJPADAO extends JpaRepository<UsuarioProveedorDominio , Integer>, UsuarioProveedorJPADAOCustom {
}
