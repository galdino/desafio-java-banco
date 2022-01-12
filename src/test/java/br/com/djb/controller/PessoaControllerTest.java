package br.com.djb.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

import br.com.djb.model.Pessoa;
import br.com.djb.service.PessoaService;

@RunWith(SpringRunner.class)
@WebMvcTest(PessoaController.class)
public class PessoaControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
	private PessoaService pessoaService;
	
	@Test
	public void TesteControllerCriarPessoaComSucesso() throws Exception {
		when(this.pessoaService.save(any())).thenReturn(new Pessoa());
		
//		this.mockMvc.perform(post("/pessoas").contentType(MediaType.APPLICATION_JSON).content("{\"nome\":\"Ricardo\", \"tipo\":\"PF\",\"numDocumento\":\"01354223373\" }"))
//					.andDo(print())
//					.andExpect(status().isCreated());
	}
	
	@Test
	public void TesteControllerListarPessoasComSucesso() throws Exception{
		List<Pessoa> listPessoa = new ArrayList<>();
		when(this.pessoaService.listarPessoas()).thenReturn(listPessoa);
		
//		this.mockMvc.perform(get("/pessoas").contentType(MediaType.APPLICATION_JSON))
//					.andDo(print())
//					.andExpect(status().isOk());
	}

}
