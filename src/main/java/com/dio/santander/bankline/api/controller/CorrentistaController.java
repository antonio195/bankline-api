package com.dio.santander.bankline.api.controller;

import com.dio.santander.bankline.api.dto.NovoCorrentista;
import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.repository.CorrentistaRepository;
import com.dio.santander.bankline.api.service.CorrentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {

    @Autowired
    private CorrentistaRepository repository;

    @Autowired
    private CorrentistaService service;

    @GetMapping
    public ResponseEntity getCorrentista(){
        List<Correntista> lista = repository.findAll();
        if (lista.isEmpty()){
            return status(204).build();
        }else{
            return status(200).body(lista);
        }
    }

    @PostMapping
    public ResponseEntity postCorrentista(@RequestBody NovoCorrentista novoCorrentista){
        service.save(novoCorrentista);
        return ResponseEntity.status(201).build();
    }

}
