/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresaxyz.empresaxyz.controller;

import com.empresaxyz.empresaxyz.dao.VendedoresDao;
import com.empresaxyz.empresaxyz.entity.Vendedores;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author apuello
 */
@Controller
@RequestMapping("/vendors")
public class VendedoresController {
    @Autowired
    private VendedoresDao vendedoresDao;
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Vendedores saveVendedor(@RequestBody Vendedores vendedor){
        return vendedoresDao.save(vendedor);
    }
    
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ResponseBody
    public List<Vendedores> getVendedores(){
        return vendedoresDao.findAll();
    }
    
    @RequestMapping(value = "/getById/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Optional<Vendedores> getVendedorById(@PathVariable("id") Long id){
        return vendedoresDao.findById(id);
    }
    
    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.POST)
    @ResponseBody
    public void deleteVendedorById(@PathVariable("id") Long id){
        vendedoresDao.deleteById(id);
    }
}