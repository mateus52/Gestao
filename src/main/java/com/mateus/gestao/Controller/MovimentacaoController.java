package com.mateus.gestao.Controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mateus.gestao.Dtos.MovimentacaoDTO;
import com.mateus.gestao.Service.MovimentacaoService;
import com.mateus.gestao.doman.Movimentacao;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/movimentacoes")
public class MovimentacaoController {
	
	@Autowired
	private MovimentacaoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<MovimentacaoDTO> findById(@PathVariable Integer id){
		
		MovimentacaoDTO objDTO = new MovimentacaoDTO(service.findById(id));
		
		return ResponseEntity.ok().body(objDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<MovimentacaoDTO>> findAll(){
		
		List<MovimentacaoDTO> listDTO = service.findAll().stream().map(obj
				-> new MovimentacaoDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<MovimentacaoDTO> create(@Valid @RequestBody MovimentacaoDTO dto){
		
		Movimentacao obj = service.create(dto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
		}

}
