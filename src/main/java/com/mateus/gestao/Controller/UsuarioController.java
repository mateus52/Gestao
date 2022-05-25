package com.mateus.gestao.Controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mateus.gestao.Dtos.UsuarioDTO;
import com.mateus.gestao.Service.UsuarioService;
import com.mateus.gestao.doman.Usuario;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<UsuarioDTO> findById(@PathVariable Integer id){
		
		UsuarioDTO objDTO = new UsuarioDTO(service.findById(id));
		
		return ResponseEntity.ok().body(objDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> findAll(){
		
		List<UsuarioDTO> listDTO = service.findAll().stream().map(obj
				-> new UsuarioDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<UsuarioDTO> create(@Valid @RequestBody UsuarioDTO dto){
		
		Usuario obj = service.create(dto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
		}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<UsuarioDTO> update(@PathVariable Integer id, @Valid @RequestBody UsuarioDTO dto){
		
		UsuarioDTO newDTO = new UsuarioDTO(service.update(id, dto));
		
		return ResponseEntity.ok().body(newDTO);
		
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();		
	}
}
