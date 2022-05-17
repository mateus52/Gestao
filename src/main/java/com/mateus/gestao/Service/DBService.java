package com.mateus.gestao.Service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.gestao.Repository.ApostaRepository;
import com.mateus.gestao.Repository.MovimentacaoRepository;
import com.mateus.gestao.Repository.UsuarioRepository;
import com.mateus.gestao.doman.Aposta;
import com.mateus.gestao.doman.Movimentacao;
import com.mateus.gestao.doman.TipoAposta;
import com.mateus.gestao.doman.TipoEsporte;
import com.mateus.gestao.doman.TipoResultado;
import com.mateus.gestao.doman.Usuario;

@Service
public class DBService {

	@Autowired
	private ApostaRepository apostaRepository;
	@Autowired
	private MovimentacaoRepository movRepository;
	@Autowired
	private UsuarioRepository UsuarioRepository;
	

	public void intanciaGestao() {
		
		Usuario u1 = new Usuario(null, "Mateus", "mateus@gmail.com", 200.0);
		
		Aposta a1 = new Aposta(null, 10.0, TipoEsporte.BASQUETE, 7.50, TipoResultado.RED, TipoAposta.MULTIPLA,u1);
		
		Movimentacao m1 = new Movimentacao(null, 30.0, 30.0,u1);
		
		UsuarioRepository.saveAll(Arrays.asList(u1));
		apostaRepository.saveAll(Arrays.asList(a1));
		movRepository.saveAll(Arrays.asList(m1));
		
		u1.getMovimentacaos().addAll(Arrays.asList(m1));
		u1.getApostas().addAll(Arrays.asList(a1));
		
		
	}

}
