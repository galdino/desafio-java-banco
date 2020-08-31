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

import br.com.djb.model.ContaCorrente;
import br.com.djb.model.Pessoa;
import br.com.djb.repository.ContaCorrenteRepository;

@RunWith(MockitoJUnitRunner.class)
public class ContaCorrenteServiceTest {
	
	
	@Mock
    private ContaCorrenteRepository contaCorrenteRepository;
	
	@InjectMocks
	private ContaCorrenteServiceImpl contaCorrenteServiceImpl = new ContaCorrenteServiceImpl("3755");
	private Pessoa pessoa;
	
	@Before
    public void setup() {
        criarPessoa();
    }
	
	private void criarPessoa() {
		this.pessoa = new Pessoa();
		this.pessoa.setNome("Fernando");
		this.pessoa.setTipo("PF");
		this.pessoa.setNumDocumento("01554223378");
		this.pessoa.setScore(2);
	}
	
	@Test
    public void TestarCriacaoContaCorrenteCarteiraComSucesso() {
		
        this.contaCorrenteServiceImpl.save(this.pessoa);

        ArgumentCaptor<ContaCorrente> argumentCaptor = ArgumentCaptor.forClass(ContaCorrente.class);

        verify(this.contaCorrenteRepository).save(argumentCaptor.capture());
        
        assertTrue(String.valueOf(argumentCaptor.getValue().getNumero()).length() == 6);
        assertEquals("C", argumentCaptor.getValue().getTipo());
        assertEquals(1, argumentCaptor.getValue().getCarteiras().size());
        assertEquals(1000.00, argumentCaptor.getValue().getCarteiras().get(0).getLimiteCE(), 0.00001);
        assertEquals(200.00, argumentCaptor.getValue().getCarteiras().get(0).getLimiteCC(), 0.00001);
        
    }
	
	@Test
    public void TestarListarContasComSucesso() {
        List<ContaCorrente> listContaCorrente = new ArrayList<>();
        listContaCorrente.add(new ContaCorrente());
        when(this.contaCorrenteRepository.findAll()).thenReturn(listContaCorrente);

        final List<ContaCorrente> resultado = this.contaCorrenteServiceImpl.listarContas();

        assertEquals(1, resultado.size());
        verify(this.contaCorrenteRepository).findAll();
    }

}
