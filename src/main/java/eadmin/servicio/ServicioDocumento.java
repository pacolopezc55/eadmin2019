package eadmin.servicio;

import java.util.List;

import es.fpdual.eadmin.eadmin.modelo.Documento;

public interface ServicioDocumento {
	
	public Documento altaDocumento(Documento documento);
	public Documento modificarDocumento(Documento documento);
	public void eliminarDocumento(int codigoDocumento);
	public List <Documento> obtenerTodosDocumentos();



}

