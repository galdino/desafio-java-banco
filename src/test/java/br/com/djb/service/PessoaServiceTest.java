package br.com.djb.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.djb.dto.CriarPessoaDto;
import br.com.djb.model.Pessoa;
import br.com.djb.repository.PessoaRepository;

@RunWith(MockitoJUnitRunner.class)
public class PessoaServiceTest {
	
	@Mock
    private PessoaRepository pessoaRepository;
	
	@InjectMocks
    private PessoaServiceImpl pessoaServiceImpl;
    private CriarPessoaDto criarPessoaDto;
    
    @Mock
    private ContaCorrenteServiceImpl contaCorrenteServiceImpl;
    
    @Before
    public void setup() {
        criarPessoa();
    }

	private void criarPessoa() {
		
		this.criarPessoaDto = new CriarPessoaDto();
		this.criarPessoaDto.setNome("Fernando");
		this.criarPessoaDto.setTipo("PF");
		this.criarPessoaDto.setNumDocumento("01554223378");
		
	}
	
	@Test
    public void TestarCriacaoPessoaComSucesso() {

        this.pessoaServiceImpl.save(this.criarPessoaDto);

        ArgumentCaptor<Pessoa> argumentCaptor = ArgumentCaptor.forClass(Pessoa.class);

        verify(this.pessoaRepository).save(argumentCaptor.capture());

        assertEquals("Fernando", argumentCaptor.getValue().getNome());
        assertEquals("PF", argumentCaptor.getValue().getTipo());
        assertEquals("01554223378", argumentCaptor.getValue().getNumDocumento());
        assertTrue(0 <= argumentCaptor.getValue().getScore() && argumentCaptor.getValue().getScore() <= 9);
    }
	
	@Test
    public void TestarListarPessoasComSucesso() {
        List<Pessoa> listPessoa = new ArrayList<>();
        listPessoa.add(new Pessoa());
        when(this.pessoaRepository.findAll()).thenReturn(listPessoa);

        final List<Pessoa> resultado = this.pessoaServiceImpl.listarPessoas();

        assertEquals(1, resultado.size());
        verify(this.pessoaRepository).findAll();
    }

}
