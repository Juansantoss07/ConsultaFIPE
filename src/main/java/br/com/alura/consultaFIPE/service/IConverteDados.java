package br.com.alura.consultaFIPE.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
