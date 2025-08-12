package br.dev.br.clientes.controller;

import br.dev.br.clientes.model.Cliente;
import br.dev.br.clientes.service.ClienteService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente){
        Cliente clienteNovo = clienteService.save(cliente);
        return ResponseEntity.ok(clienteNovo);
    }

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> listAll(){
        List<Cliente> clientes = clienteService.findAll();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id){
        Cliente cliente = clienteService.findById(id);
        return ResponseEntity.created(null).body(cliente);
    }

    @DeleteMapping("/clientes")
    public ResponseEntity<?> delete(@RequestBody Cliente cliente){
        clienteService.delete(cliente);
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/clientes")
    public ResponseEntity<Cliente> update(Cliente cliente){
        Cliente clienteNovo = clienteService.update(cliente);
        return ResponseEntity.ok(clienteNovo);
    }

}
