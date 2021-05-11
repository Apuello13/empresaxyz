/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresaxyz.empresaxyz.controller;

import com.empresaxyz.empresaxyz.dao.ClientesDao;
import com.empresaxyz.empresaxyz.entity.Cliente;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author HP
 */
@Controller
@RequestMapping("/clients")
public class ClientesController {
    @Autowired
    private ClientesDao clientedao;
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Cliente saveCliente(@RequestBody Cliente cliente){
        return clientedao.save(cliente);
    }
    
    @GetMapping(value = "/get")
    @ResponseBody
    public List<Cliente> getClientes(){
        return clientedao.findAll();
    }
    
    @GetMapping(value = "/getById/{id}")
    @ResponseBody
    public Optional<Cliente> getClienteById(@PathVariable("id") Long id){
        return clientedao.findById(id);
    }
    
    @GetMapping(value = "/deleteById/{id}")
    @ResponseBody
    public void deleteClienteById(@PathVariable("id") Long id){
        clientedao.deleteById(id);
    }
}
