package co.com.trabajo_asegurado_Negocio.ensamblador;

import java.util.List;

public interface IEnsamblador <A , B>{

    B ensamblarDominio(A dto);

    A ensamblarDTO(B dominio);

    List<B> ensamblarListaDominios(List<A> listaDTOs);

    List<A> ensamblarListaDTOs(List<B> listaDominios);
}
