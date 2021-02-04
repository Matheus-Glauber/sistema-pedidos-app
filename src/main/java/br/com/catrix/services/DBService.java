package br.com.catrix.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.catrix.entities.Categoria;
import br.com.catrix.entities.Cidade;
import br.com.catrix.entities.Cliente;
import br.com.catrix.entities.Endereco;
import br.com.catrix.entities.Estado;
import br.com.catrix.entities.ItemPedido;
import br.com.catrix.entities.PagamentoComCartao;
import br.com.catrix.entities.Pedido;
import br.com.catrix.entities.Produto;
import br.com.catrix.entities.enums.EstadoPagamento;
import br.com.catrix.entities.enums.TipoCliente;
import br.com.catrix.repositories.CategoriaRepository;
import br.com.catrix.repositories.CidadeRepository;
import br.com.catrix.repositories.ClienteRepository;
import br.com.catrix.repositories.EnderecoRepository;
import br.com.catrix.repositories.EstadoRepository;
import br.com.catrix.repositories.ItemPedidoRepository;
import br.com.catrix.repositories.PagamentoRepository;
import br.com.catrix.repositories.PedidoRepository;
import br.com.catrix.repositories.ProdutoRepository;

@Service
public class DBService {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	EnderecoRepository enderecoReposity;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	PagamentoRepository pagamentoRepository;
	
	@Autowired
	ItemPedidoRepository itemPedidoRepository;
		
	public void instantiateTestDatabase() throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Categoria categoria = new Categoria(null, "Domésticos");
		
		categoriaRepository.save(categoria);
		
		Produto produto = new Produto(null, "Escrivaninha", 250.00);
		
		produtoRepository.save(produto);
		
		Estado estado = new Estado(null, "RN");
		
		estadoRepository.save(estado);
		
		Cidade cidade = new Cidade(null, "Natal", estado);
		
		cidadeRepository.save(cidade);
		
		Cliente cliente = new Cliente(null, "Teste", "teste@teste.com", "10254658470", TipoCliente.PESSOA_FISICA);
		
		clienteRepository.save(cliente);
		
		Endereco endereco = new Endereco(null, "Maria da Penha", "102", "2 andar", "Tolipa", "44502450", cliente, cidade);
		
		enderecoReposity.save(endereco);
		
		Pedido pedido = new Pedido(null, sdf.parse("03/02/2021 20:56"), null, cliente, endereco);
		
		PagamentoComCartao pagamento = new PagamentoComCartao(null, EstadoPagamento.QUITADO, pedido, 4);
		
		pedido.setPagamento(pagamento);
		
		pedidoRepository.save(pedido);
		
		pagamentoRepository.save(pagamento);
		
		ItemPedido itemPedido = new ItemPedido(pedido, produto, 10.0, 1, 250.0);
		
		itemPedidoRepository.save(itemPedido);		
	}

}
