package co.com.trabajo_asegurado_Negocio.ensamblador.implementacion;

import co.com.trabajo_asegurado_Dominio.dominio.TipoIdentificacionDominio;
import co.com.trabajo_asegurado_Dto.dto.TipoIdentificacionDTO;
import co.com.trabajo_asegurado_Negocio.ensamblador.IEnsamblador;
import co.com.trabajo_asegurado_Transversal.enumeracion.CapaEnum;
import co.com.trabajo_asegurado_Transversal.excepcion.TrabajoAseguradoExcepcion;

import java.util.List;

public class TipoIdentificacionEnsamblador implements IEnsamblador<TipoIdentificacionDTO, TipoIdentificacionDominio> {

    private static final IEnsamblador<TipoIdentificacionDTO, TipoIdentificacionDominio> INSTANCIA = new TipoIdentificacionEnsamblador();

    private TipoIdentificacionEnsamblador() {
        super();
    }

    public static IEnsamblador<TipoIdentificacionDTO, TipoIdentificacionDominio> obtenerTipoIdentificacionEnsamblador() {
        return INSTANCIA;
    }

    @Override
    public TipoIdentificacionDominio ensamblarDominio(TipoIdentificacionDTO dto) {
        if (dto == null) {
            throw TrabajoAseguradoExcepcion.CREAR("Para ensamblar un dominio de Tipo Identificación, el objeto de transferencia de datos no puede ser nulo", CapaEnum.NEGOCIO);
        }

        return new TipoIdentificacionDominio(dto.getCodigo(), dto.getNombre());
    }

    @Override
    public TipoIdentificacionDTO ensamblarDTO(TipoIdentificacionDominio dominio) {
        if (dominio == null) {
            throw TrabajoAseguradoExcepcion.CREAR("Para ensamblar un objeto de transferencia de datos de Tipo Identificación, el objeto de dominio no puede ser nulo", CapaEnum.NEGOCIO);
        }

        return new TipoIdentificacionDTO(dominio.getCodigo(), dominio.getNombre());
    }

    @Override
    public List<TipoIdentificacionDominio> ensamblarListaDominios(List<TipoIdentificacionDTO> listaDTOs) {
        return null;
    }

    @Override
    public List<TipoIdentificacionDTO> ensamblarListaDTOs(List<TipoIdentificacionDominio> listaDominios) {
        return null;
    }


}
