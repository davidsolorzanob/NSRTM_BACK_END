package com.nsrtm.contribuyente.microservice.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.nsrtm.contribuyente.microservice.domain.*;
import com.nsrtm.contribuyente.microservice.domain.complex.CondicionContribuyenteCustom;
import com.nsrtm.contribuyente.microservice.domain.complex.ContribuyenteCustom;
import com.nsrtm.contribuyente.microservice.domain.complex.ContribuyenteResult;
import com.nsrtm.contribuyente.microservice.repository.*;
import com.nsrtm.contribuyente.microservice.util.Catalogo;
import com.nsrtm.contribuyente.microservice.util.MessageResponse;
import com.nsrtm.contribuyente.microservice.util.PageRequest;
import com.nsrtm.contribuyente.microservice.util.PageResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.servlet.http.HttpServletResponse;

@Service
public class ContribuyenteService {
	private static final Logger logger = LogManager.getLogger(ContribuyenteService.class);

	@Autowired
	private ContribuyenteRepository contribuyenteRepository;

	@Autowired
	private CondicionContribuyenteRepository condicionContribuyenteRepository;

	@Autowired
	private DomicilioContribuyenteRepository domicilioContribuyenteRepository;

	@Autowired
	private RelacionadoRepository relacionadoRepository;

	@Autowired
	private DomicilioRelacionadoRepository domicilioRelacionadoRepository;

	@Autowired
	private ContactoContribuyenteRepository contactoContribuyenteRepository;

	@Autowired
	private DocSustentoContribuyenteRepository docSustentoContribuyenteRepository;

	@Transactional
	public ResponseEntity<Object> Crear(ContribuyenteCustom contribuyente,
										CondicionContribuyenteCustom condicion,
										DomicilioContribuyente domContribuyente,
										Relacionado relacionado,
										List<ContactoContribuyente> contactos,
										List<DomicilioContribuyente> domicilios,
										List<DocSustentoContribuyente> documentos){

		ContribuyenteCustom contri = contribuyenteRepository.CrearContribuyente(contribuyente);

		CondicionContribuyenteCustom cnd = condicion;
		cnd.contribuyenteNumero = contri.contribuyenteNumero;
		cnd.numeroDJ = contri.numeroDJ;
		condicionContribuyenteRepository.CrearCondicionContribuyente(cnd);
/*
		DomicilioContribuyente dom = domContribuyente;
		dom.contribuyenteNumero = contri.contribuyenteNumero;
		domicilioContribuyenteRepository.CrearDomicilioContribuyente(dom);
*/
		if(relacionado.tipoRelacionadoId != null) {
			Relacionado rela = relacionado;
			rela.contribuyenteNumero = contri.contribuyenteNumero;
			rela.numeroDJ = contri.numeroDJ;
			rela = relacionadoRepository.CrearRelacionado(rela);

			Relacionado domRela = relacionado;
			domRela.numeroDJ = contri.numeroDJ;
			domRela.relContribuyenteNumero = rela.relContribuyenteNumero;
			domicilioRelacionadoRepository.CrearDomicilioRelacionado(domRela);
		}

		contactoContribuyenteRepository.EliminarContacto(contri.municipalidadId, contri.contribuyenteNumero, contri.numeroDJ, null,contribuyente.usuarioCreacion,contribuyente.terminalCreacion);
		contactoContribuyenteRepository.CrearContactoLista(contri.municipalidadId, contri.contribuyenteNumero, contri.numeroDJ, contactos);

		domicilioContribuyenteRepository.EliminarDomicilioContribuyente(contri.municipalidadId, contri.contribuyenteNumero, contri.numeroDJ, null,contribuyente.usuarioCreacion,contribuyente.terminalCreacion);
		domicilioContribuyenteRepository.CrearDomicilioContribuyenteLista(contri.municipalidadId, contri.contribuyenteNumero, contri.numeroDJ, domicilios);

		docSustentoContribuyenteRepository.EliminarDocSustento(contri.municipalidadId, contri.contribuyenteNumero, contri.numeroDJ,null,contribuyente.usuarioCreacion,contribuyente.terminalCreacion);
		docSustentoContribuyenteRepository.CrearContactoLista(contri.municipalidadId, contri.contribuyenteNumero, contri.numeroDJ, documentos);
		return MessageResponse.setResponse(true, "El registro del contribuyente se guardó satisfactoriamente", contri);
	}

	public ResponseEntity<Object> Actualizar(ContribuyenteCustom contribuyente,
											 CondicionContribuyenteCustom condicion,
											 DomicilioContribuyente domContribuyente,
											 Relacionado relacionado,
											 List<ContactoContribuyente> contactos,
											 List<DomicilioContribuyente> domicilios,
											 List<DocSustentoContribuyente> documentos){
		Long nroDJ = contribuyente.numeroDJ;
		ContribuyenteCustom contri = contribuyenteRepository.ActualizarContribuyente(contribuyente);

		condicion.numeroDJ = contri.numeroDJ;
		condicion.usuarioCreacion = condicion.usuarioModificacion;
		condicionContribuyenteRepository.EliminarCondicion(contribuyente.municipalidadId, contribuyente.contribuyenteNumero, nroDJ, null,contribuyente.usuarioModificacion,contribuyente.terminalModificacion);
		condicionContribuyenteRepository.CrearCondicionContribuyente(condicion);

		//domicilioContribuyenteRepository.ActualizarDomicilioContribuyente(domContribuyente);
		if(relacionado.tipoRelacionadoId!=null) {
			relacionado.numeroDJ = contri.numeroDJ;
			relacionadoRepository.ActualizarRelacionado(relacionado);
			domicilioRelacionadoRepository.ActualizarDomicilioRelacionado(relacionado);
		}
		contactoContribuyenteRepository.EliminarContacto(contribuyente.municipalidadId, contribuyente.contribuyenteNumero, nroDJ, null,contribuyente.usuarioModificacion,contribuyente.terminalModificacion);
		contactoContribuyenteRepository.CrearContactoLista(contribuyente.municipalidadId, contribuyente.contribuyenteNumero, contri.numeroDJ, contactos);
		domicilioContribuyenteRepository.EliminarDomicilioContribuyente(contribuyente.municipalidadId, contribuyente.contribuyenteNumero,nroDJ, null, contribuyente.usuarioCreacion, contribuyente.terminalCreacion);
		domicilioContribuyenteRepository.CrearDomicilioContribuyenteLista(contribuyente.municipalidadId, contribuyente.contribuyenteNumero,contri.numeroDJ, domicilios);
		docSustentoContribuyenteRepository.EliminarDocSustento(contribuyente.municipalidadId, contribuyente.contribuyenteNumero, nroDJ, null,contribuyente.usuarioCreacion,contribuyente.terminalCreacion);
		docSustentoContribuyenteRepository.CrearContactoLista(contribuyente.municipalidadId, contribuyente.contribuyenteNumero, contri.numeroDJ, documentos);
		return MessageResponse.setResponse(true, "El registro del contribuyente se actualizó satisfactoriamente", contribuyente);
	}

	public ResponseEntity<Object> Eliminar(Long municipalidadId, Long contribuyenteNumero, Long numeroDJ){
		contribuyenteRepository.EliminarContribuyente(municipalidadId,contribuyenteNumero, numeroDJ);
		return MessageResponse.setResponse(true, "El registro del contribuyente se eliminó satisfactoriamente");
	}

	public ContribuyenteCustom ObtenerPorId(Long municipalidadId, Long contribuyenteNumero, Long numeroDJ){
		return contribuyenteRepository.ObtenerContribuyente(municipalidadId,contribuyenteNumero, numeroDJ);
	}

	public PageResponse<List<ContribuyenteResult>> ListaContribuyentePaginado(PageRequest<ContribuyenteCustom> custom){
		return contribuyenteRepository.ListaContribuyentePaginado(custom);
	}

	public List<ContribuyenteResult> ListaContribuyenteHistorico(Long municipalidadId, Long contribuyenteNumero){
		return contribuyenteRepository.ListaContribuyenteHistorico(municipalidadId, contribuyenteNumero);
	}

	public StreamingResponseBody ExportarExcel(ContribuyenteCustom custom, HttpServletResponse response) {

		List<ContribuyenteResult> lista = contribuyenteRepository.ListaContribuyenteReporte(custom);

		return outputStream -> {
			try (ByteArrayOutputStream out = new ByteArrayOutputStream();
				 SXSSFWorkbook workbook = new SXSSFWorkbook(SXSSFWorkbook.DEFAULT_WINDOW_SIZE)) {
				// Creating excel sheet
				String sheetName = "Contribuyentes";
				Sheet sheet = workbook.createSheet(sheetName);

				// Creating font style for excel sheet
				Font headerFont = workbook.createFont();
				headerFont.setColor(IndexedColors.BLACK.getIndex());

				CellStyle headerColumnStyle = workbook.createCellStyle();
				headerColumnStyle.setFont(headerFont);

				// Row for header at 0 index
				Row headerRow = sheet.createRow(0);

				// Name of the columns to be added in the sheet
				String[] columns = new String[] {
						"Nro",
						"Código contribuyente",
						"Nombres/Razón Social",
						"Fecha de Declaración(Modificación/Registro)",
						"Documento de identidad",
						"Nro documento de identidad",
						"Tipo de Medio",
						"Medio",
						"Motivo",
						"Tipo de contribuyente",
						"Condición de contribuyente",
						"Departamento",
						"Provincia",
						"Distrito",
						"Dirección fiscal",
						"Estado",
						"Área usuaria",
						"Usuario de creación",
						"Fecha de creación",
						"Terminal de creación",
						"Usuario de modificación",
						"Fecha de modificación",
						"Terminal de modificación"};

				for (int i = 0; i < columns.length; i++) {
					Cell headerColumn = headerRow.createCell(i);
					headerColumn.setCellValue(columns[i]);
					headerColumn.setCellStyle(headerColumnStyle);
				}

				CellStyle dataColumnDateFormatStyle = workbook.createCellStyle();
				CreationHelper createHelper = workbook.getCreationHelper();
				dataColumnDateFormatStyle.setDataFormat(createHelper.createDataFormat().getFormat("d/m/yy h:mm;@"));

				int rowIndex = 1;
				for (ContribuyenteResult result : lista) {
					// Creating row for writing data
					Row dataRow = sheet.createRow(rowIndex);

					Cell colItem = dataRow.createCell(0);
					colItem.setCellValue(String.valueOf(rowIndex));

					Cell colNroContribuyente = dataRow.createCell(1);
					colNroContribuyente.setCellValue(String.valueOf(result.contribuyenteNumero));

					Cell colNombresRazon = dataRow.createCell(2);
					colNombresRazon.setCellValue(result.docIdentidadId == Catalogo.Maestro.TipoDocumentoIdentidad.Ruc ? result.razonSocial: (result.apellidoPaterno + result.apellidoMaterno + result.nombres));

					Cell colFechaDec = dataRow.createCell(3);
					colFechaDec.setCellValue(String.valueOf(result.fechaInscripcion == null ? "": result.fechaInscripcion.getTime()));

					Cell colDocIdentidad = dataRow.createCell(4);
					colDocIdentidad.setCellValue(result.desDocIdentidad);

					Cell colNroDocumento = dataRow.createCell(5);
					colNroDocumento.setCellValue(result.numDocIdentidad);

					Cell colTipoMedio = dataRow.createCell(6);
					colTipoMedio.setCellValue(result.desTipoMedioDeterminacion);

					Cell colMedioDetermina = dataRow.createCell(7);
					colMedioDetermina.setCellValue(result.desMedioDeterminacion);

					Cell colMotivo = dataRow.createCell(8);
					colMotivo.setCellValue(result.desMotivoDj);

					Cell colTipoContri = dataRow.createCell(9);
					colTipoContri.setCellValue(result.desTipoPersona);

					Cell colCondicion = dataRow.createCell(10);
					colCondicion.setCellValue(result.desCondicion);

					Cell colDepartamento = dataRow.createCell(11);
					colDepartamento.setCellValue(result.departamento);

					Cell colProvincia = dataRow.createCell(12);
					colProvincia.setCellValue(result.provincia);

					Cell colDistrito = dataRow.createCell(13);
					colDistrito.setCellValue(result.distrito);

					Cell colDomicilio = dataRow.createCell(14);
					colDomicilio.setCellValue(result.desDomicilio);

					Cell colEstado = dataRow.createCell(15);
					colEstado.setCellValue(result.desEstadoDj);

					Cell colArea = dataRow.createCell(16);
					colArea.setCellValue("");

					Cell colUsuarioCrea = dataRow.createCell(17);
					colUsuarioCrea.setCellValue(result.usuarioCreacion);

					Cell colFechaCrea = dataRow.createCell(18);
					colFechaCrea.setCellValue(String.valueOf(result.fechaCreacion == null ? "" : result.fechaCreacion.getTime()));

					Cell colTerminalCrea = dataRow.createCell(19);
					colTerminalCrea.setCellValue(result.terminalCreacion == null ? "":result.terminalCreacion);

					Cell colUsuarioMod = dataRow.createCell(20);
					colUsuarioMod.setCellValue(result.usuarioModificacion == null ? "":result.usuarioModificacion.toString());

					Cell colFechaMod = dataRow.createCell(21);
					colFechaMod.setCellValue(String.valueOf(result.fechaModificacion == null ? "" : result.fechaModificacion.getTime()));

					Cell colTerminalMod = dataRow.createCell(22);
					colTerminalMod.setCellValue(result.terminalModificacion == null ? "":result.terminalModificacion);

					rowIndex++;
				}

				workbook.write(out);
				workbook.dispose();

				String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
				String filename = "Reporte-Contribuyentes-" + date + ".xlsx";
				response.setHeader("Content-Disposition", "attachment; filename=" + filename);
				response.setContentLength((int) out.size());

				InputStream inputStream = new ByteArrayInputStream(out.toByteArray());
				int BUFFER_SIZE = 1024;
				int bytesRead;
				byte[] buffer = new byte[BUFFER_SIZE];

				// Writing to output stream
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}

				if (inputStream != null) {
					inputStream.close();
				}
			}
		};
	}

	public List<Contribuyente> Todos(){
		return contribuyenteRepository.findAll();
	}
}
