package br.edu.ifpb.exemplotransacoes;

import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

}
