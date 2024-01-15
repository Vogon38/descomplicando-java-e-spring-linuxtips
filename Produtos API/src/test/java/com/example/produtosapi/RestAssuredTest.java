package com.example.produtosapi;

import com.example.produtosapi.model.Produto;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Fail.fail;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredTest {

    static {
        RestAssured.baseURI = "http://localhost:8080";
    }

    public Response criaProduto(Produto produto) throws Exception{
        RequestSpecification request = given().contentType("application/json").body(produto);
        return request.post("/produtos");
    }

    private ResponseSpecification responseSpecification(int statusCode) {
        return new ResponseSpecBuilder().expectStatusCode(statusCode).build();
    }

    @Test
    @DisplayName("Sucesso - Deve criar um produto sucesso")
    public void deveCriarUmProdutoComSucesso(){
        try {
            criaProduto(new Produto("Produto 123", "Java", "10")).then().assertThat().spec(responseSpecification(200)).and().assertThat().body("nome", equalTo("Java"));
        } catch (Exception e) {
            fail("Não foi possível criar o produto", e);
        }
    }

    @Test
    @DisplayName("Sucesso - Deve retornar um produto buscando pelo id com sucesso")
    public void deveBuscarUmProdutoPeloIdComSucesso(){
        try {
            criaProduto(new Produto("123", "Java", "10"));
            given()
                    .when()
                    .basePath("/produtos").get("/123")
                    .then()
                    .assertThat()
                    .spec(responseSpecification(200))
                    .and()
                    .assertThat()
                    .body("preco", equalTo("10"));
        } catch (Exception e) {
            fail("Não foi possível buscar o produto pelo id", e);
        }
    }

    @Test
    @DisplayName("Sucesso - Deve excluir um produto pelo id com sucesso")
    public void deveExcluirUmProdutoComSucesso(){
        try {
            criaProduto(new Produto("123", "Java", "10"));
            given()
                    .when()
                    .basePath("/produtos")
                    .delete("/123")
                    .then()
                    .assertThat()
                    .spec(responseSpecification(200))
                    .and()
                    .assertThat()
                    .body(equalTo("Produto removido com sucesso!"));
        } catch (Exception e) {
            fail("Não foi possível excluir um produto pelo id", e);
        }
    }

    @Test
    @DisplayName("Erro - Deve retornar erro ao tentar excluir um produto pelo id com sucesso")
    public void deveRetornarErroAoExcluirUmProduto(){
        try {
            given()
                    .when()
                    .basePath("/produtos")
                    .delete("/999")
                    .then()
                    .assertThat()
                    .spec(responseSpecification(500));
        } catch (Exception e) {
            fail("Foi possível excluir um produto pelo id", e);
        }
    }

}
