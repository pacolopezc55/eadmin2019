package es.fpdual.eadmin.eadmin.modelo;


import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Expediente extends AdministracionElectronicaBase {
	private final TipoExpediente tipoExpediente;
	private final List<Documento> documentos;

	public Expediente(int id, String nombre, Usuario usuario, Date fechaCreacion, TipoExpediente tipoExpediente,
			List<Documento> documentos) {
		this.id = id;
		this.nombre = nombre;
		this.usuario = usuario;
		this.fechaCreacion = fechaCreacion;
		this.tipoExpediente = tipoExpediente;
		this.documentos = documentos;
	}

	public TipoExpediente getTipoExpediente() {
		return tipoExpediente;
	}

	public List<Documento> getDocumentos() {
		return this.documentos;
	}

	@Override
	public int hashCode() {
		return this.getId();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Expediente) {
			final Expediente expediente = (Expediente) obj;
			return expediente.getId() == this.getId();
		}
		return false;
	}

	public List<Integer> obetenerLongitudNombresDocumentos() {
		if (documentos.size() == 0) {
			throw new AdministracionElectronicaException("Lista de documentos vacía");
		}

		return documentos.stream().filter(this::esDocumentoContable).map(Documento::getNombre).map(String::length)
				.collect(Collectors.toList());
	}

	public boolean esDocumentoContable(Documento documento) {
		return documento.getTipoDocumento().equals(TipoDocumento.DOCUMENTO_CONTABLE);
	}

	public Map<TipoDocumento, List<Documento>> obtenerDocumentosPorTipos() {
		return documentos.stream().collect(Collectors.groupingByConcurrent(Documento::getTipoDocumento));
	}
}
