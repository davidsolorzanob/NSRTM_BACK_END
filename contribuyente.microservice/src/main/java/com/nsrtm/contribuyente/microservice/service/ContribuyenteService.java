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

	@Transactional
	public ResponseEntity<Object> Crear(ContribuyenteCustom contribuyente,
										CondicionContribuyenteCustom condicion,
										DomicilioContribuyente domContribuyente,
										Relacionado relacionado,
										List<ContactoContribuyente> contactos,
										List<DomicilioContribuyente> domicilios){

		ContribuyenteCustom contri = contribuyenteRepository.CrearContribuyente(contribuyente);

		CondicionContribuyenteCustom cnd = condicion;
		cnd.contribuyenteNumero = contri.contribuyenteNumero;
		condicionContribuyenteRepository.CrearCondicionContribuyente(cnd);

		DomicilioContribuyente dom = domContribuyente;
		dom.contribuyenteNumero = contri.contribuyenteNumero;
		domicilioContribuyenteRepository.CrearDomicilioContribuyente(dom);

		Relacionado rela = relacionado;
		rela.contribuyenteNumero = contri.contribuyenteNumero;
		rela = relacionadoRepository.CrearRelacionado(rela);

		Relacionado domRela = relacionado;
		domRela.relContribuyenteNumero = rela.relContribuyenteNumero;
		domicilioRelacionadoRepository.CrearDomicilioRelacionado(domRela);

		contactoContribuyenteRepository.EliminarContacto(contri.municipalidadId, contri.contribuyenteNumero, null,contribuyente.usuarioCreacion,contribuyente.terminalCreacion);
		contactoContribuyenteRepository.CrearContactoLista(contri.municipalidadId, contri.contribuyenteNumero,contactos);

		//domicilioContribuyenteRepository.EliminarDomicilioContribuyente(contri.municipalidadId, contri.contribuyenteNumero, null);
		//domicilioContribuyenteRepository.CrearDomicilioContribuyenteLista(contri.municipalidadId, contri.contribuyenteNumero, domicilios);

		return MessageResponse.setResponse(true, "El registro del contribuyente se guardó satisfactoriamente", contri);
	}

	public ResponseEntity<Object> Actualizar(ContribuyenteCustom contribuyente,
											 CondicionContribuyenteCustom condicion,
											 DomicilioContribuyente domContribuyente,
											 Relacionado relacionado,
											 List<ContactoContribuyente> contactos,
											 List<DomicilioContribuyente> domicilios){
		contribuyenteRepository.ActualizarContribuyente(contribuyente);
		condicionContribuyenteRepository.ActualizarCondicionContribuyente(condicion);
		domicilioContribuyenteRepository.ActualizarDomicilioContribuyente(domContribuyente);
		relacionadoRepository.ActualizarRelacionado(relacionado);
		domicilioRelacionadoRepository.ActualizarDomicilioRelacionado(relacionado);
		contactoContribuyenteRepository.CrearContactoLista(contribuyente.municipalidadId, contribuyente.contribuyenteNumero,contactos);
		//domicilioContribuyenteRepository.EliminarDomicilioContribuyente(contribuyente.municipalidadId, contribuyente.contribuyenteNumero, null);
		//domicilioContribuyenteRepository.CrearDomicilioContribuyenteLista(contribuyente.municipalidadId, contribuyente.contribuyenteNumero, domicilios);
		return MessageResponse.setResponse(true, "El registro del contribuyente se actualizó satisfactoriamente", contribuyente);
	}

	public ResponseEntity<Object> Eliminar(Long municipalidadId, Long contribuyenteNumero){
		contribuyenteRepository.EliminarContribuyente(municipalidadId,contribuyenteNumero);
		return MessageResponse.setResponse(true, "El registro del contribuyente se eliminó satisfactoriamente");
	}

	public ContribuyenteCustom ObtenerPorId(Long municipalidadId, Long contribuyenteNumero){
		return contribuyenteRepository.ObtenerContribuyente(municipalidadId,contribuyenteNumero);
	}

	public PageResponse<List<ContribuyenteResult>> ListaContribuyentePaginado(PageRequest<ContribuyenteCustom> custom){
		return contribuyenteRepository.ListaContribuyentePaginado(custom);
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
				String[] columns = new String[] { "Nro", "Nro Contribuyente", "Tipo Documento", "Nro doc. identidad", "Apellido Paterno", "Apellido Materno",
						"Nombres", "Razon Social", "Fecha D.J.", "Estado D.J." };

				// Creating header column at the first row
				for (int i = 0; i < columns.length; i++) {
					Cell headerColumn = headerRow.createCell(i);
					headerColumn.setCellValue(columns[i]);
					headerColumn.setCellStyle(headerColumnStyle);
				}

				// Date formatting
				CellStyle dataColumnDateFormatStyle = workbook.createCellStyle();
				CreationHelper createHelper = workbook.getCreationHelper();
				dataColumnDateFormatStyle.setDataFormat(createHelper.createDataFormat().getFormat("d/m/yy h:mm;@"));

				// Adding data to sheet from the second row
				int rowIndex = 1;
				for (ContribuyenteResult result : lista) {
					// Creating row for writing data
					Row dataRow = sheet.createRow(rowIndex);

					Cell colItem = dataRow.createCell(0);
					colItem.setCellValue(String.valueOf(rowIndex));

					Cell colNroContribuyente = dataRow.createCell(1);
					colNroContribuyente.setCellValue(String.valueOf(result.contribuyenteNumero));

					Cell colTipoDoc = dataRow.createCell(2);
					colTipoDoc.setCellValue(result.descDocIdentidad);

					Cell colNroIdentidad = dataRow.createCell(3);
					colNroIdentidad.setCellValue(result.numDocIdentidad);

					Cell colApePaterno = dataRow.createCell(4);
					colApePaterno.setCellValue(result.apellidoPaterno);

					Cell colApeMaterno = dataRow.createCell(5);
					colApeMaterno.setCellValue(result.apellidoMaterno);

					Cell colNombres = dataRow.createCell(6);
					colNombres.setCellValue(result.nombres);

					Cell colRazonSocial = dataRow.createCell(7);
					colRazonSocial.setCellValue(result.razonSocial);

					Cell colFechaDj = dataRow.createCell(8);
					colFechaDj.setCellValue(String.valueOf(result.fechaDJ.getTime()));

					Cell colDesEstadoDj = dataRow.createCell(9);
					colDesEstadoDj.setCellValue(result.desEstadoDj);

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
