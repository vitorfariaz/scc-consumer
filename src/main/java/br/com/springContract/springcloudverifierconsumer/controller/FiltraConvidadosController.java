package br.com.springContract.springcloudverifierconsumer.controller;

import br.com.springContract.springcloudverifierconsumer.model.Convidado;
import br.com.springContract.springcloudverifierconsumer.service.ConvidadoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FiltraConvidadosController {

    private final ConvidadoService service;

    public FiltraConvidadosController(ConvidadoService service) {
        this.service = service;
    }

    @GetMapping("/convidados")
    public List<Convidado> filtraConvidados(@RequestParam int idade){
    return service
            .buscarTodosConvidados()
            .stream()
            .filter(conv -> conv.getIdade() == idade)
            .collect(Collectors.toList());
    }


}
