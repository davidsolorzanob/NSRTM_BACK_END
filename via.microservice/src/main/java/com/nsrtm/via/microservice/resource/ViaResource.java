package com.nsrtm.via.microservice.resource;

import com.nsrtm.via.microservice.domain.Via;
import com.nsrtm.via.microservice.service.ViaService;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/via")
public class ViaResource {
    @Autowired
    private ViaService viaService;

    @PostMapping("crear")
    @ResponseStatus(HttpStatus.OK)
    public void Crear(@RequestBody Via via) {
        viaService.Guardar(via);
    }

    @PostMapping("editar")
    @ResponseStatus(HttpStatus.OK)
    public void Editar(@RequestBody Via via) {
        viaService.Actualizar(via);
    }

    @PostMapping("eliminar")
    @ResponseStatus(HttpStatus.OK)
    public void Eliminar(Long id) {
        viaService.Eliminar(id);
    }

    @GetMapping("obtener")
    @ResponseStatus(HttpStatus.OK)
    public Via ObtenerPorId(Long id) {
        return viaService.ObtenerPorId(id);
    }

    @GetMapping("todos")
    @Bulkhead(name = "viaServiceBulk", fallbackMethod = "errorGetAll", type = Bulkhead.Type.THREADPOOL)
    @TimeLimiter(name = "viaServiceTime", fallbackMethod = "errorGetAll")
    //@ResponseStatus(HttpStatus.OK)
    public CompletableFuture<ResponseEntity<List<Via>>> Todos() {
        return CompletableFuture.completedFuture( new ResponseEntity<List<Via>>(viaService.Todos(),HttpStatus.OK));
    }

    public CompletableFuture<ResponseEntity<String>> errorGetAll(Exception e){
        return CompletableFuture.completedFuture(new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST));
    }

    @GetMapping("otros")
    @Cacheable(value="ViaService")
    @ResponseStatus(HttpStatus.OK)
    public List<Via> Otros() {
        return viaService.Otros();
    }

}
