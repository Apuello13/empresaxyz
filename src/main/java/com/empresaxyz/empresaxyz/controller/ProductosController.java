/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresaxyz.empresaxyz.controller;

import com.empresaxyz.empresaxyz.dao.ProductosDao;
import com.empresaxyz.empresaxyz.entity.Productos;
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
 * @author MROMERO
 */
@Controller
@RequestMapping("/produc")
public class ProductosController {

    @Autowired
    private ProductosDao productoD;

    @RequestMapping(value = "/saveP", method = RequestMethod.POST)
    @ResponseBody
    public Productos saveProducto(@RequestBody Productos productos) {
        if (productoD.existsByCodigo(productos.getCodigo()) & productos.getId() == 0) {
            return productos = null;
        } else {
            return productoD.save(productos);
        }
    }
    //LISTAR

    @GetMapping(value = "/get")
    @ResponseBody
    public List<Productos> getPro(@RequestParam String nombre) {
        if (nombre == "") {
            return productoD.findAll();
        } else {
            return productoD.findByNombreIsContaining(nombre);
        }
    }    

    @GetMapping(value = "/getById/{id}")
    @ResponseBody
    public Optional<Productos> gitPro(@PathVariable("id") Long id) {
        return productoD.findById(id);
    }

    @GetMapping(value = "/eliminarBy/{id}")
    @ResponseBody
    public void eliminarPro(@PathVariable("id") long id) {
        productoD.deleteById(id);
    }
}
