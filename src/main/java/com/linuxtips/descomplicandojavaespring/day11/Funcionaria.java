package com.linuxtips.descomplicandojavaespring.day11;

import java.util.Objects;

public class Funcionaria {

    private Integer idade;
    private String nome;
    private String cargo;
    private Double salario;
    private String setor;

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    @Override
    public String toString() {
        return "Funcionaria com o nome "
                + nome + " e idade "
                + idade + " anos, trabalha como "
                + cargo + " no setor "
                + setor + " e recebe R$ "
                + salario + " por mês.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionaria that = (Funcionaria) o;
        return Objects.equals(idade, that.idade) && Objects.equals(nome, that.nome) && Objects.equals(cargo, that.cargo) && Objects.equals(salario, that.salario) && Objects.equals(setor, that.setor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idade, nome, cargo, salario, setor);
    }

}
