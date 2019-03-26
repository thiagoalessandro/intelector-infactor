package br.com.intelector.api.controller;

import java.util.Optional;

import javax.validation.Valid;
import javax.xml.ws.BindingType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.intelector.api.controller.response.Response;
import br.com.intelector.api.controller.utils.ResourceApi;
import br.com.intelector.api.exceptions.NoDataContentException;
import br.com.intelector.api.model.SegOperacao;
import br.com.intelector.api.service.SegOperacaoService;

@RestController
@RequestMapping(ResourceApi.RESOURCE_API_SERVICE_OPERACAO)
@CrossOrigin(origins="*", methods = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.GET, RequestMethod.PUT})
public class SegOperacaoController {
	
	@Autowired 
	private SegOperacaoService segOperacaoService;
	
	@GetMapping(params = {"nome", "page", "count"})
	public ResponseEntity<Response<Page<SegOperacao>>> findByFilter(@RequestParam("nome") String nome,
																	@RequestParam("page") int page,
																    @RequestParam("count") int count) throws InterruptedException {
		Response<Page<SegOperacao>> response = new Response<Page<SegOperacao>>(); 
		
		try {			
			Page<SegOperacao> data = segOperacaoService.findByNome(nome, page, count);
			response.setData(data);			
		} catch (Exception e) {
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
			
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Response<SegOperacao>> findById(@PathVariable("id") Long id){		
		Response<SegOperacao> response = new Response<SegOperacao>();		
		try {					
			Optional<SegOperacao> segOperacao = segOperacaoService.findById(id);		
			response.setData(segOperacao.orElseThrow(() -> new NoDataContentException(id)));			
			return ResponseEntity.ok(response);				
		} catch (NoDataContentException e) {
			e.printStackTrace();			
			response.getErrors().add(e.getMessage());
			return ResponseEntity.ok().body(response);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Response<String>> delete(@PathVariable("id") Long id){
		Response<String> response = new Response<String>();
		try {
			Optional<SegOperacao> segOperacao = segOperacaoService.findById(id);
			segOperacao.orElseThrow(() -> new NoDataContentException(id));				
			if(id == 1 || id == 5) {
				throw new NoDataContentException(id);
			}
			segOperacaoService.deleteLogical(segOperacao.get());
			return ResponseEntity.ok(response);
		}catch (NoDataContentException e) {
			e.printStackTrace();			
			response.getErrors().add(e.getMessage());
			return ResponseEntity.ok().body(response);
		}		
	}	
	
	@PostMapping
	public ResponseEntity<Response<SegOperacao>> create(@Valid @RequestBody SegOperacao body){
		
		Response<SegOperacao> response = new Response<SegOperacao>();
		SegOperacao segOperacaoPersisted = null;
		try {
//			segOperacaoPersisted = segOperacaoService.save(body);
//			response.setData(segOperacaoPersisted);
			response.getErrors().add("Nome é obrigatório");
			response.getErrors().add("Descrição é obrigatório");
			return ResponseEntity.ok(response);
		}catch(Exception e) {
			e.printStackTrace();
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		} 
	}
}
