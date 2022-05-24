package com.mateus.gestao.Service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.mateus.gestao.Dtos.MovimentacaoDTO;
import com.mateus.gestao.Repository.MovimentacaoRepository;
import com.mateus.gestao.Service.Exceptions.ObjectNotFoundException;
import com.mateus.gestao.doman.Movimentacao;
import com.mateus.gestao.doman.Usuario;

@Service
public class MovimentacaoService {
	
	@Autowired
	private MovimentacaoRepository repository;
	
	@Autowired
	private UsuarioService service;
	
	public Movimentacao findById(@PathVariable Integer id) {

		Optional<Movimentacao> obj = repository.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Movimentacao.class.getName()));
	}
	
	public List<Movimentacao> findAll() {

		return repository.findAll();
	}
	
	public Movimentacao create(@Valid MovimentacaoDTO dto) {

		return fromDTO(dto);
	}
	
	private Movimentacao fromDTO(MovimentacaoDTO obj) {
		Movimentacao newObj = new Movimentacao();
		
		newObj.setId(obj.getId());
		newObj.setDeposito(obj.getDeposito());
		newObj.setSaque(obj.getSaque());
		
		Usuario u = service.findById(obj.getUsuario());
		
		newObj.setUsuario(u);
		return repository.save(newObj);
	}


}
