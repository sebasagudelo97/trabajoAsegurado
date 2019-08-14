package co.com.trabajo_asegurado_Negocio.negocio.implementacion;


import co.com.trabajo_asegurado_Datos.dao.UsuarioProveedorJPADAO;
import co.com.trabajo_asegurado_Dominio.dominio.UsuarioProveedorDominio;
import co.com.trabajo_asegurado_Negocio.negocio.IUsuarioProveedorNegocio;
import co.com.trabajo_asegurado_Transversal.enumeracion.CapaEnum;
import co.com.trabajo_asegurado_Transversal.excepcion.TrabajoAseguradoExcepcion;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UsuarioProveedorNegocio implements IUsuarioProveedorNegocio {

    @Autowired
    private UsuarioProveedorJPADAO usuarioProveedorDao;
    @Override
    public void registrar(UsuarioProveedorDominio usuarioProveedor) {
        try {

            UsuarioProveedorDominio usuarioConsulta = new UsuarioProveedorDominio();
            usuarioConsulta.setNombre(usuarioProveedor.getNombre());
            usuarioConsulta.setApellido(usuarioProveedor.getApellido());
            usuarioConsulta.setFechaRegistro(usuarioProveedor.getFechaRegistro());

            List<UsuarioProveedorDominio> listaFacturasCustom = usuarioProveedorDao.consultar(usuarioConsulta);


            usuarioProveedorDao.save(usuarioProveedor);
        } catch (TrabajoAseguradoExcepcion excepcion) {
            throw excepcion;
        } catch (Exception excepcion) {
            String mensaje = "Se ha presentado un problema tratando de registrar el nuevo usuario";
            throw TrabajoAseguradoExcepcion.CREAR(excepcion, mensaje, CapaEnum.NEGOCIO);
        }
    }
}
