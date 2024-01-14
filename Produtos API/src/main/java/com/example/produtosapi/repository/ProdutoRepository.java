package com.example.produtosapi.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.example.produtosapi.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Produto save(Produto produto) {
        dynamoDBMapper.save(produto);
        return produto;
    }

    public Produto findById(String produtoId) {
        return dynamoDBMapper.load(Produto.class, produtoId);
    }

    public Produto[] findAll() {
        return dynamoDBMapper.scan(Produto.class, new DynamoDBScanExpression()).toArray(new Produto[0]);
    }

    public String deleteById(String produtoId) {
        Produto produto = dynamoDBMapper.load(Produto.class, produtoId);
        dynamoDBMapper.delete(produto);
        return "Produto removido com sucesso!";
    }

    public Produto update(String produtoId, Produto produto) {
        dynamoDBMapper.save(new Produto(
                produtoId,
                produto.getNome(),
                produto.getPreco()),
                new DynamoDBSaveExpression()
                        .withExpectedEntry("produtoId",
                                new ExpectedAttributeValue(
                                        new AttributeValue()
                                                .withS(produtoId)
        )));
        return produto;
    }

}
