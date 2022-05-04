package com.dio.santander.bankline.api.controller;

import com.dio.santander.bankline.api.dto.NovaMovimentacao;
import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.model.Movimentacao;
import com.dio.santander.bankline.api.repository.MovimentacaoRepository;
import com.dio.santander.bankline.api.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoRepository repository;

    @Autowired
    private MovimentacaoService service;

    @GetMapping
    public ResponseEntity getMovimentacoes(){
        List<Movimentacao> lista = repository.findAll();
        if (lista.isEmpty()){
            return status(204).build();
        }else{
            return status(200).body(lista);
        }
    }

    @PostMapping
    public ResponseEntity postMovimentacao(@RequestBody NovaMovimentacao novaMovimentacao){
        service.save(novaMovimentacao);
        return status(200).build();
    }


}
