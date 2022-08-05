package com.nsrtm.contribuyente.microservice.service;

import com.nsrtm.contribuyente.microservice.domain.DocSustentoContribuyente;
import com.nsrtm.contribuyente.microservice.repository.DocSustentoContribuyenteRepository;
import com.nsrtm.contribuyente.microservice.util.MessageResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocSustentoContribuyenteService {
    private static final Logger logger = LogManager.getLogger(ContribuyenteService.class);

    @Autowired
    private DocSustentoContribuyenteRepository docSustentoRepository;

    public ResponseEntity<Object> CrearDocSustento(DocSustentoContribuyente e) {
        e = docSustentoRepository.CrearDocSustento(e);
        return MessageResponse.setResponse(true,"El documento de sustento del contribuyente se registró correctamente", e);
    }

    public ResponseEntity<Object> ActualizarDocSustento(DocSustentoContribuyente e){
        e = docSustentoRepository.ActualizarDocSustento(e);
        return MessageResponse.setResponse(true,"El documento de sustento se actualizó correctamente", e);
    }

    public ResponseEntity<Object> EliminarDocSustento(Long municipalidadId, Long contribuyenteNumero, Long docSustentoId, Long usuario, String terminal){
        docSustentoRepository.EliminarDocSustento(municipalidadId, contribuyenteNumero, docSustentoId, usuario, terminal);
        return MessageResponse.setResponse(true, "El registro del documento de sustento se eliminó satisfactoriamente");
    }

    public List<DocSustentoContribuyente> ObtenerLista(Long municipalidadId, Long contribuyenteNumero){
        return docSustentoRepository.ListaDocSustento(municipalidadId, contribuyenteNumero);
    }
}
