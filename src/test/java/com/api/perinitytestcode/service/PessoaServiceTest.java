package com.api.perinitytestcode.service;

import com.api.perinitytestcode.model.Pessoa;
import com.api.perinitytestcode.repository.PessoaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PessoaServiceTest {

    @InjectMocks
    private PessoaService pessoaService;

    @Mock
    private PessoaRepository pessoaRepository;

    public PessoaServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSavePessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("João");
        pessoa.setDepartamento("TI");

        when(pessoaRepository.save(pessoa)).thenReturn(pessoa);

        Pessoa savedPessoa = pessoaService.save(pessoa);

        assertNotNull(savedPessoa);
        assertEquals("João", savedPessoa.getNome());
    }
}
