package ifrn.projetopi.dlart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ifrn.projetopi.dlart.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
