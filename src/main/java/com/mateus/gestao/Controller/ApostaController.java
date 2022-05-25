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

import com.mateus.gestao.Dtos.ApostaDTO;
import com.mateus.gestao.Service.ApostaService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/apostas")
public class ApostaController {
	
	@Autowired
	private ApostaService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<ApostaDTO> findById(@PathVariable Integer id){
		
		ApostaDTO objDTO = new ApostaDTO(service.findById(id));
		
		return ResponseEntity.ok().body(objDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<ApostaDTO>> findAll(){
		
		List<ApostaDTO> listDTO = service.findAll().stream().map(obj
				-> new ApostaDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<ApostaDTO> create(@Valid @RequestBody ApostaDTO dto){
		
		dto = new ApostaDTO(service.create(dto));
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(dto.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
		}

}
