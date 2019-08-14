package co.com.trabajo_asegurado_Negocio.fachada.implementacion;

import co.com.trabajo_asegurado_Dominio.dominio.UsuarioProveedorDominio;
import co.com.trabajo_asegurado_Dto.dto.UsuarioProveedorDTO;
import co.com.trabajo_asegurado_Negocio.ensamblador.implementacion.UsuarioProveedorEnsamblador;
import co.com.trabajo_asegurado_Negocio.fachada.IUsuarioProveedorFachada;
import co.com.trabajo_asegurado_Negocio.negocio.IUsuarioProveedorNegocio;
import org.springframework.beans.factory.annotation.Autowired;

public class UsuarioProveedorFachada implements IUsuarioProveedorFachada {

    @Autowired
    private IUsuarioProveedorNegocio usuarioProveedor;

    @Override
    public void registrar(UsuarioProveedorDTO usuario) {
        UsuarioProveedorDominio usuarioDominio = UsuarioProveedorEnsamblador.obtenerUsuarioProveedorEnsamblador().ensamblarDominio(usuario);
        usuarioProveedor.registrar(usuarioDominio);
    }
}
