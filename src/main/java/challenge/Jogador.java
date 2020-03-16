package challenge;

import java.time.LocalDate;
import java.util.Objects;

public class Jogador {
    private String nacionalidade;
    private String clube;
    private String nomeCompleto;
    private Double rescisao;
    private Double salario;
    private Integer idade;
    private LocalDate nascimento;

    public Jogador(String nacionalidade, String clube, String nomeCompleto, Double rescisao, Double salario, Integer idade, LocalDate nascimento) {
        this.nacionalidade = nacionalidade;
        this.clube = clube;
        this.nomeCompleto = nomeCompleto;
        this.rescisao = rescisao;
        this.salario = salario;
        this.idade = idade;
        this.nascimento = nascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getClube() {
        return clube;
    }

    public void setClube(String clube) {
        this.clube = clube;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public Double getRescisao() {
        return rescisao;
    }

    public void setRescisao(Double rescisao) {
        this.rescisao = rescisao;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jogador jogador = (Jogador) o;
        return Objects.equals(nacionalidade, jogador.nacionalidade) &&
                Objects.equals(clube, jogador.clube) &&
                Objects.equals(nomeCompleto, jogador.nomeCompleto) &&
                Objects.equals(rescisao, jogador.rescisao) &&
                Objects.equals(salario, jogador.salario) &&
                Objects.equals(idade, jogador.idade) &&
                Objects.equals(nascimento, jogador.nascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nacionalidade, clube, nomeCompleto, rescisao, salario, idade, nascimento);
    }
}
