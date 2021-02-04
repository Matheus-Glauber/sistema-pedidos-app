package br.com.catrix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.catrix.entities.ItemPedido;
import br.com.catrix.entities.ItemPedidoPK;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoPK> {

}
