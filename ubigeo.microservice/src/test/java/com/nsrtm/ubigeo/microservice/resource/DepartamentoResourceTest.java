package com.nsrtm.ubigeo.microservice.resource;

import com.nsrtm.ubigeo.microservice.domain.Departamento;
import com.nsrtm.ubigeo.microservice.service.DepartamentoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartamentoResource.class)
class DepartamentoResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartamentoService departamentoService;

    private Departamento departamento;

    @BeforeEach
    void setUp() {
        departamento = new Departamento();
        departamento.departamentoId = Long.getLong("1");
        departamento.descripcion = "LIMA";
    }

    @Test
    void todos() throws Exception {
        when(departamentoService.Todos()).thenReturn(Arrays.asList(departamento));
        mockMvc.perform(get("/api/departamento/todos").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[*].descripcion").value("LIMA"));
        verify(departamentoService).Todos();
    }
}