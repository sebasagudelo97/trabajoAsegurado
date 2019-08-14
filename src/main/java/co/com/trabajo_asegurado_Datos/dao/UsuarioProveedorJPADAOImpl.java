package co.com.trabajo_asegurado_Datos.dao;

import co.com.trabajo_asegurado_Dominio.dominio.UsuarioProveedorDominio;
import co.com.trabajo_asegurado_Transversal.enumeracion.CapaEnum;
import co.com.trabajo_asegurado_Transversal.excepcion.TrabajoAseguradoExcepcion;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class UsuarioProveedorJPADAOImpl implements UsuarioProveedorJPADAOCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UsuarioProveedorDominio> consultar(UsuarioProveedorDominio usuarioProveedor) {
        try {
            CriteriaBuilder construccionCriterios = entityManager.getCriteriaBuilder();
            CriteriaQuery<UsuarioProveedorDominio> consulta = construccionCriterios.createQuery(UsuarioProveedorDominio.class);
            Root<UsuarioProveedorDominio> usuarioRaiz = consulta.from(UsuarioProveedorDominio.class);
            List<Predicate> predicados = new ArrayList<>();

            if (usuarioProveedor != null) {

                if (usuarioProveedor.getNombre() != null ) {
                    predicados.add(construccionCriterios.equal(usuarioRaiz.get("nombre"), usuarioProveedor.getNombre()));
                }

                if (usuarioProveedor.getApellido() != null) {
                    predicados.add(construccionCriterios.equal(usuarioRaiz.get("apellido"), usuarioProveedor.getApellido()));
                }

                if (usuarioProveedor.getFechaRegistro() != null) {
                    predicados.add(construccionCriterios.equal(usuarioRaiz.get("fecha"), usuarioProveedor.getFechaRegistro()));
                }

                if (usuarioProveedor.getTelefono() != null) {
                    predicados.add(construccionCriterios.equal(usuarioRaiz.get("telefono"), usuarioProveedor.getFechaRegistro()));
                }


            }

            consulta.select(usuarioRaiz).where(construccionCriterios.and(predicados.toArray(new Predicate[0])));

            return entityManager.createQuery(consulta).getResultList();
        } catch (Exception excepcion) {
            throw TrabajoAseguradoExcepcion.CREAR(excepcion, "Se ha presentado un problema tratando de consultar la información customizada.", CapaEnum.DATOS);
        }
    }
}
