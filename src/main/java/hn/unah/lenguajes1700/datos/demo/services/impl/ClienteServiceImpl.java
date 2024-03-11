package hn.unah.lenguajes1700.datos.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes1700.datos.demo.entities.Cliente;
import hn.unah.lenguajes1700.datos.demo.repositories.ClienteRepository;
import hn.unah.lenguajes1700.datos.demo.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> obtenerClientes() {
        return (List<Cliente>) this.clienteRepository.findAll();
    }

    @Override
    public Cliente crearCliente(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    @Override
    public Cliente buscarClientePorDni(String dni) {
        return this.clienteRepository.findById(dni).get();
    }

    @Override
    public Cliente actualizarCliente(String dni, Cliente cliente) {
        Cliente clienteActualizar = this.clienteRepository.findById(dni).get();

        if(null != clienteActualizar){
            clienteActualizar.setCorreo(cliente.getCorreo());
            clienteActualizar.setApellido(cliente.getApellido());
            clienteActualizar.setNombre(cliente.getNombre());
            this.clienteRepository.save(clienteActualizar);
        }

        return clienteActualizar;
    }
    
}
