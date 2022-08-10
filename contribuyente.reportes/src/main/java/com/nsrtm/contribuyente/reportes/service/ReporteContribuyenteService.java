package com.nsrtm.contribuyente.reportes.service;

import com.lowagie.text.DocumentException;
import com.nsrtm.contribuyente.reportes.domain.ContribuyenteRequest;
import com.nsrtm.contribuyente.reportes.domain.ContribuyenteResult;
import com.nsrtm.contribuyente.reportes.domain.DocSustentoContribuyente;
import com.nsrtm.contribuyente.reportes.domain.RelacionadoResult;
import com.nsrtm.contribuyente.reportes.repository.ContribuyenteReporteRepository;
import com.nsrtm.contribuyente.reportes.repository.DocSustentoContribuyenteRepository;
import com.nsrtm.contribuyente.reportes.repository.RelacionadoReporteRepository;
import com.nsrtm.contribuyente.reportes.utils.util;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.*;

@Service
public class ReporteContribuyenteService {
    private Logger logger = LoggerFactory.getLogger(ReporteContribuyenteService.class);

    @Autowired
    private ContribuyenteReporteRepository contribuyenteReporteRepository;

    @Autowired
    private RelacionadoReporteRepository relacionadoReporteRepository;

    @Autowired
    private DocSustentoContribuyenteRepository docSustentoContribuyenteRepository;

    @Autowired
    private TemplateEngine templateEngine;

    public ByteArrayInputStream exportarDJContribuyente(String templateName, ContribuyenteRequest custom) {
        Context context = new Context();
        Map<String, Object> data = MapDataReporteContribuyente(custom);
        context.setVariables(data);
        String htmlContent = templateEngine.process(templateName, context);

        ByteArrayInputStream byteArrayInputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(htmlContent);
            renderer.layout();
            renderer.createPDF(byteArrayOutputStream, false);
            renderer.finishPDF();
            byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        } catch (DocumentException e) {
            logger.error(e.getMessage(), e);
        }

        return byteArrayInputStream;
    }

    public ContribuyenteResult ObtenerContribuyenteReporte(ContribuyenteRequest custom){
        return contribuyenteReporteRepository.ObtenerContribuyenteReporte(custom);
    }

    public RelacionadoResult ObtenerRelacionadoReporte(ContribuyenteRequest custom){
        return relacionadoReporteRepository.ObtenerRelacionadoReporte(custom);
    }

    public List<DocSustentoContribuyente> ListaDocSustento(Long municipalidadId, Long contribuyenteNumero){
        return docSustentoContribuyenteRepository.ListaDocSustento(municipalidadId,contribuyenteNumero);
    }

    private Map<String, Object> MapDataReporteContribuyente(ContribuyenteRequest custom) {
        Map<String, Object> data = new HashMap<>();
        ContribuyenteResult contribuyente = ObtenerContribuyenteReporte(custom);
        RelacionadoResult relacionado = ObtenerRelacionadoReporte(custom);
        List<DocSustentoContribuyente> lista = ListaDocSustento(custom.municipalidadId, custom.contribuyenteNumero);

        data.put("contribuyente", contribuyente);
        data.put("relacionado", relacionado);
        data.put("fechaGeneradoReporte", util.getDateComplete());
        data.put("sustentos", lista);
        return data;
    }
}
