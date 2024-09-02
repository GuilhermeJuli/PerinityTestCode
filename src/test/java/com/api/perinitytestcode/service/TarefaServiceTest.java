package com.api.perinitytestcode.service;

import com.api.perinitytestcode.model.Tarefa;
import com.api.perinitytestcode.repository.TarefaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TarefaServiceTest {

    @InjectMocks
    private TarefaService tarefaService;

    @Mock
    private TarefaRepository tarefaRepository;

    public TarefaServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveTarefa() {
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo("Nova Tarefa");
        tarefa.setDescricao("Descrição da Tarefa");

        when(tarefaRepository.save(tarefa)).thenReturn(tarefa);

        Tarefa savedTarefa = tarefaService.save(tarefa);

        assertNotNull(savedTarefa);
        assertEquals("Nova Tarefa", savedTarefa.getTitulo());
    }
}
