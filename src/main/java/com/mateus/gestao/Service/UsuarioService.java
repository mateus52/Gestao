package com.mateus.gestao.Service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.gestao.Dtos.UsuarioDTO;
import com.mateus.gestao.Repository.UsuarioRepository;
import com.mateus.gestao.Service.Exceptions.DataIntegratyViolationException;
import com.mateus.gestao.Service.Exceptions.ObjectNotFoundException;
import com.mateus.gestao.doman.Usuario;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public Usuario findById(Integer id) {
		Optional<Usuario> obj = repository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class
				.getName()));
	}
	
	public List<Usuario> findAll(){
		
		return repository.findAll();
	}
	
	public Usuario create(@Valid UsuarioDTO dto) {			
	
		return repository.save(new Usuario(null, dto.getNome(), dto.getEmail(), dto.getSaldo()));
	}

	public Usuario update(Integer id, @Valid UsuarioDTO dto) {
		
		Usuario oldUsuario = findById(id);
		
		oldUsuario.setNome(dto.getNome());
		oldUsuario.setEmail(dto.getEmail());
		
		return repository.save(oldUsuario);
	}

	public void delete(Integer id) {
		
		Usuario usuario = findById(id);
		
		if(usuario.getMovimentacaos().size() > 0 || usuario.getApostas()
			.size()	> 0) {
			throw new DataIntegratyViolationException("O usuário possui apostas ou movimentações, não pode ser deletado!");
		}
		
		repository.deleteById(id);
	}
}
