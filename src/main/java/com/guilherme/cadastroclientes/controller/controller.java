package com.guilherme.cadastroclientes.controller;

import com.guilherme.cadastroclientes.model.Cliente;
import com.guilherme.cadastroclientes.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class controller {

    private final ClienteService service;

    public controller(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Cliente> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Cliente buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Cliente salvar(@RequestBody Cliente cliente) {
        return service.salvar(cliente);
    }

    @PutMapping("/{id}")
    public Cliente atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        return service.atualizar(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}