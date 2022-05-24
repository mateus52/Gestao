package com.mateus.gestao.Service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.mateus.gestao.Dtos.ApostaDTO;
import com.mateus.gestao.Repository.ApostaRepository;
import com.mateus.gestao.Service.Exceptions.ObjectNotFoundException;
import com.mateus.gestao.doman.Aposta;
import com.mateus.gestao.doman.TipoAposta;
import com.mateus.gestao.doman.TipoEsporte;
import com.mateus.gestao.doman.TipoResultado;
import com.mateus.gestao.doman.Usuario;

@Service
public class ApostaService {
	
	@Autowired
	private ApostaRepository repository;
	
	@Autowired
	private UsuarioService service;
	
	public Aposta findById(@PathVariable Integer id) {

		Optional<Aposta> obj = repository.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Aposta.class.getName()));
	}
	
	public List<Aposta> findAll() {

		return repository.findAll();
	}
	
	public Aposta create(@Valid ApostaDTO dto) {


		return fromDTO(dto);
	}

	private Aposta fromDTO(ApostaDTO obj) {
		Aposta newObj = new Aposta();
		
		newObj.setId(obj.getId());
		newObj.setAposta(TipoAposta.toEnum(obj.getAposta()));
		newObj.setEsporte(TipoEsporte.toEnum(obj.getEsporte()));
		newObj.setOdd(obj.getOdd());
		newObj.setValor(obj.getValor());
		newObj.setResultado(TipoResultado.toEnum(obj.getResultado()));
		
		Usuario u = service.findById(obj.getUsuario());
		
		newObj.setUsuario(u);
		return repository.save(newObj);
	}

}
