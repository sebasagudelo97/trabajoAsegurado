package co.com.trabajo_asegurado_Negocio.ensamblador.implementacion;

import co.com.trabajo_asegurado_Dominio.dominio.UsuarioProveedorDominio;
import co.com.trabajo_asegurado_Dto.dto.UsuarioProveedorDTO;
import co.com.trabajo_asegurado_Negocio.ensamblador.IEnsamblador;
import co.com.trabajo_asegurado_Transversal.enumeracion.CapaEnum;
import co.com.trabajo_asegurado_Transversal.excepcion.TrabajoAseguradoExcepcion;

import java.util.List;

public class UsuarioProveedorEnsamblador implements IEnsamblador<UsuarioProveedorDTO , UsuarioProveedorDominio> {

    private static final IEnsamblador<UsuarioProveedorDTO, UsuarioProveedorDominio> INSTANCIA = new UsuarioProveedorEnsamblador();

    private UsuarioProveedorEnsamblador() {
        super();
    }

    public static IEnsamblador<UsuarioProveedorDTO, UsuarioProveedorDominio> obtenerUsuarioProveedorEnsamblador() {
        return INSTANCIA;
    }

    @Override
    public UsuarioProveedorDominio ensamblarDominio(UsuarioProveedorDTO dto) {
        if (dto == null) {
            throw TrabajoAseguradoExcepcion.CREAR("Para ensamblar un dominio de Usuario, el objeto de transferencia de datos no puede ser nulo", CapaEnum.NEGOCIO);
        }

        return new UsuarioProveedorDominio(dto.getCodigo(), TipoIdentificacionEnsamblador.obtenerTipoIdentificacionEnsamblador().ensamblarDominio(dto.getTipoIdentificacion()), dto.getNombre(), dto.getTelefono(), dto.getDireccion() );
    }

    @Override
    public UsuarioProveedorDTO ensamblarDTO(UsuarioProveedorDominio dominio) {
        if (dominio == null) {
            throw TrabajoAseguradoExcepcion.CREAR("Para ensamblar un objeto de transferencia de datos de Usuario, el objeto de dominio no puede ser nulo", CapaEnum.NEGOCIO);
        }

        return new UsuarioProveedorDTO(dominio.getNombre(), dominio.getCodigo(), dominio.getApellido(), dominio.getDireccion(), dominio.getFechaRegistro(), dominio.getTelefono(),  TipoIdentificacionEnsamblador.obtenerTipoIdentificacionEnsamblador().ensamblarDTO(dominio.getTipoIdentificacion()));
    }



    @Override
    public List<UsuarioProveedorDominio> ensamblarListaDominios(List<UsuarioProveedorDTO> listaDTOs) {
        return null;
    }

    @Override
    public List<UsuarioProveedorDTO> ensamblarListaDTOs(List<UsuarioProveedorDominio> listaDominios) {
        return null;
    }
}
