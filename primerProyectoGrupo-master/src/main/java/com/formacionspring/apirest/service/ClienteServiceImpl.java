package com.formacionspring.apirest.service;

import java.util.*;
import com.formacionspring.apirest.repository.ClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.formacionspring.apirest.entity.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService{
	@Autowired
	private ClienteDao clienteDao;

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> mostrarTodos() {
		// TODO Auto-generated method stub
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente mostrarPorId(Long id) {
		// TODO Auto-generated method stub
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cliente guardar(Cliente cliente) {
		return clienteDao.save(cliente);
	}

	@Override
	@Transactional
	public void borrar(Long id) {
		// TODO Auto-generated method stub
		clienteDao.deleteById(id);
	}

//	@Override
//	public List<region> mostrarRegiones() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	@Override
//    @Transactional(readOnly = true)
//    public List<region> mostrarRegion() {
//        return clienteDao.mostrarRegiones();
//    }


}
