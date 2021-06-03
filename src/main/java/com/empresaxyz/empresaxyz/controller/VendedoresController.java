/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresaxyz.empresaxyz.controller;

import com.empresaxyz.empresaxyz.dao.VendedoresDao;
import com.empresaxyz.empresaxyz.entity.Vendedor;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    public Vendedor saveVendedor(@RequestBody Vendedor vendedor) {
        if (vendedoresDao.existsByIdentificacion(vendedor.getIdentificacion()) & vendedor.getId() == 0) {
            return vendedor = null;
        } else {
            return vendedoresDao.save(vendedor);
        }
    }

    @GetMapping(value = "/get")
    @ResponseBody
    public List<Vendedor> getVendedores(@RequestParam String name) {
        if(name == ""){
            return vendedoresDao.findAll();
        }else{
            return vendedoresDao.findByNombreIsContaining(name);
        }
    }

    @GetMapping(value = "/getById/{id}")
    @ResponseBody
    public Optional<Vendedor> getVendedorById(@PathVariable("id") Long id) {
        return vendedoresDao.findById(id);
    }

    @GetMapping(value = "/deleteById/{id}")
    @ResponseBody
    public void deleteVendedorById(@PathVariable("id") Long id) {
        vendedoresDao.deleteById(id);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Vendedor loginVendedor(@RequestBody Vendedor vendedor) {
        return vendedoresDao.findByUsernameAndPassword(vendedor.getUsername(), vendedor.getPassword());
    }

}
