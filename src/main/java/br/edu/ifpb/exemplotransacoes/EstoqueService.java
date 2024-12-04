package br.edu.ifpb.exemplotransacoes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstoqueService {

    private Logger logger = LoggerFactory.getLogger(EstoqueService.class);
    private final ProdutoService produtoService;

    public EstoqueService(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addProdutos(List<Produto> produtos) throws ProdutoInvalidoException {
        logger.info("Salvando {} produtos", produtos.size());
        for (Produto produto : produtos) {
            logger.info("Salvando produto {}...", produto.getNome());
            produtoService.salvar(produto);
        }
        throw new RuntimeException("Erro...");
    }
}
