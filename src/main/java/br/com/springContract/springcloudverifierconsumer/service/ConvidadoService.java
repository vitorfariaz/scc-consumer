package br.com.springContract.springcloudverifierconsumer.service;

import br.com.springContract.springcloudverifierconsumer.model.Convidado;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ConvidadoService {

    private final RestTemplate restTemplate;
    private final java.lang.String urlApiListaConvidados;
    private final java.lang.String pathRecurso = "/todosConvidados";

    public ConvidadoService(RestTemplate restTemplate, @Value("${api.convidados.url}") java.lang.String urlApiListaConvidados) {
        this.restTemplate = restTemplate;
        this.urlApiListaConvidados = urlApiListaConvidados;
    }

    public List<Convidado> buscarTodosConvidados(){
        java.lang.String url = urlApiListaConvidados + pathRecurso;
        return restTemplate
                .exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Convidado>>(){})
                .getBody();
    }
}