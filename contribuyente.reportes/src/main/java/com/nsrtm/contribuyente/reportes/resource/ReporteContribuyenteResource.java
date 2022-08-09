package com.nsrtm.contribuyente.reportes.resource;

import com.nsrtm.contribuyente.reportes.domain.ContribuyenteRequest;
import com.nsrtm.contribuyente.reportes.service.ReporteContribuyenteService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/api/reportes")
public class ReporteContribuyenteResource {
    @Autowired
    private ReporteContribuyenteService reporteContribuyenteService;

    @GetMapping("/djcontribuyente")
    public void DJContribuyente(String data, HttpServletResponse response) throws IOException {
        String templateDJ = "DJContribuyente";
        ContribuyenteRequest request = new Gson().fromJson(data, ContribuyenteRequest.class);
        ByteArrayInputStream exportedData = reporteContribuyenteService.exportarDJContribuyente(templateDJ, request);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=DJContribuyente.pdf");
        IOUtils.copy(exportedData, response.getOutputStream());
    }
}
