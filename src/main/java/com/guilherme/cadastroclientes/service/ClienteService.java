package com.guilherme.cadastroclientes.service;

import com.guilherme.cadastroclientes.model.Cliente;
import com.guilherme.cadastroclientes.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public List<Cliente> listarTodos() {
        return repository.findAll();
    }

    public Cliente salvar(Cliente cliente) {
        return repository.save(cliente);
    }

    public Cliente buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public Cliente atualizar(Long id, Cliente clienteAtualizado) {
        Cliente cliente = buscarPorId(id);
        cliente.setNome(clienteAtualizado.getNome());
        cliente.setEmail(clienteAtualizado.getEmail());
        cliente.setCpf(clienteAtualizado.getCpf());
        cliente.setTelefone(clienteAtualizado.getTelefone());
        cliente.setDataNascimento(clienteAtualizado.getDataNascimento());
        return repository.save(cliente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}