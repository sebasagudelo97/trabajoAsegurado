package co.com.trabajo_asegurado_Api.controlador;

import co.com.trabajo_asegurado_Api.respuesta.RespuestaApi;
import co.com.trabajo_asegurado_Dto.dto.UsuarioProveedorDTO;
import co.com.trabajo_asegurado_Negocio.fachada.IUsuarioProveedorFachada;
import co.com.trabajo_asegurado_Transversal.excepcion.TrabajoAseguradoExcepcion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/trabajo")
public class UsuarioProveedorControlador {

    @Autowired
    private IUsuarioProveedorFachada usuarioFachada;

    @GetMapping("/dummy")
    @ResponseBody
    public UsuarioProveedorDTO crearDummy() {
        UsuarioProveedorDTO usuarioProveedor = new UsuarioProveedorDTO();

        UsuarioProveedorDTO nombre = new UsuarioProveedorDTO();
        usuarioProveedor.setCodigo(6);
        usuarioProveedor.setNombre("a");

        UsuarioProveedorDTO apellido = new UsuarioProveedorDTO();
        usuarioProveedor.setCodigo(7);
        usuarioProveedor.setApellido("b");

        return usuarioProveedor;

    }

    @PostMapping
    public RespuestaApi<UsuarioProveedorDTO> crear(@RequestBody UsuarioProveedorDTO usuarioProveedor) {

        RespuestaApi<UsuarioProveedorDTO> respuesta = new RespuestaApi<UsuarioProveedorDTO>();

        try {
            usuarioFachada.registrar(usuarioProveedor);

            List<String> mensajes = new ArrayList<String>();
            mensajes.add("Factura registrada exitosamente");

            respuesta.setMensaje(mensajes);
            respuesta.setDatos((new ArrayList<UsuarioProveedorDTO>()));
            respuesta.getDatos().add(usuarioProveedor);
            respuesta.setEstado("EXITO");
        } catch (TrabajoAseguradoExcepcion excepcion) {
            List<String> mensajes = new ArrayList<String>();
            mensajes.add(excepcion.getMensaje());
            respuesta.setMensaje(mensajes);
            respuesta.setDatos((new ArrayList<UsuarioProveedorDTO>()));
            respuesta.setEstado("ERROR");
        } catch (Exception excepcion) {
            List<String> mensajes = new ArrayList<String>();
            mensajes.add("Se ha presentado un problema no controlado tratando de registrar la nueva factura.");
            respuesta.setMensaje(mensajes);
            respuesta.setDatos((new ArrayList<UsuarioProveedorDTO>()));
            respuesta.setEstado("ERROR");
        }

        return respuesta;
    }
}
