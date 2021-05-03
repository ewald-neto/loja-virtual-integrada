package com.autopecasriobranco.lojavirtualintegrada.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
/*	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private MovimentoRepository movimentoRepository;

	@Autowired
	private GrupoRepository grupoRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private PedidoItemRepository pedidoItemRepository;
*/

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Iniciando a aplicação!!!!!");
	}

}
