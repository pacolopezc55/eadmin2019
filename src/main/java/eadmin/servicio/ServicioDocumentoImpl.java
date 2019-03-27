package eadmin.servicio;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eadmin.Documento.RepositorioDocumento;
import es.fpdual.eadmin.eadmin.modelo.Documento;

@Service
public class ServicioDocumentoImpl implements ServicioDocumento {

	private final RepositorioDocumento repositorioDocumento;

	@Autowired
	public ServicioDocumentoImpl(RepositorioDocumento repositorioDocumento) {
		this.repositorioDocumento = repositorioDocumento;
	}

	@Override
	public Documento altaDocumento(Documento documento) {
		
		final int siguienteId = repositorioDocumento.getSiguienteId();
		final Date fechaActual = new Date();
		
		Documento documentoModificado = new Documento(siguienteId, documento.getNombre(), documento.getUsuario(),fechaActual, documento.getTipoDocumento());
		
		
		return repositorioDocumento.altaDocumento(documento);
	}

	@Override
	public Documento modificarDocumento(Documento documento) {
		return repositorioDocumento.modificarDocumento(documento);
	}

	@Override
	public void eliminarDocumento(int codigoDocumento) {

		repositorioDocumento.eliminarDocumento(codigoDocumento);

	}

	@Override
	public List<Documento> obtenerTodosDocumentos() {
		return repositorioDocumento.obtenerTodosDocumentos();
	}


}
