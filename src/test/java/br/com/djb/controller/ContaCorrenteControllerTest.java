package br.com.djb.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.djb.model.ContaCorrente;
import br.com.djb.service.ContaCorrenteService;

@RunWith(SpringRunner.class)
@WebMvcTest(ContaCorrenteController.class)
public class ContaCorrenteControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
	private ContaCorrenteService contaCorrenteService;
	
	@Test
	public void TesteControllerListarContasComSucesso() throws Exception{
		List<ContaCorrente> listContaCorrente = new ArrayList<>();
		when(this.contaCorrenteService.listarContas()).thenReturn(listContaCorrente);
		
//		this.mockMvc.perform(get("/contas").contentType(MediaType.APPLICATION_JSON))
//					.andDo(print())
//					.andExpect(status().isOk());
	}
	
}
