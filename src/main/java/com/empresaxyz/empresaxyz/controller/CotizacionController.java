package com.empresaxyz.empresaxyz.controller;

import com.empresaxyz.empresaxyz.dao.CotizacionDao;
import com.empresaxyz.empresaxyz.entity.Cotizacion;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
/**
 *
 * @author apuello
 */
@Controller
@RequestMapping("/cotizacion")
public class CotizacionController {
	
    @Autowired
    private CotizacionDao cotizacionDao;
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Cotizacion saveCotizacion(@RequestBody Cotizacion cotizacion){
        if(cotizacionDao.existsByTitulo(cotizacion.getTitulo()) & cotizacion.getId() == 0){
            return cotizacion = null;
        }else{
        	cotizacion.setCreated(new Date());
            return cotizacionDao.save(cotizacion);
        }
    }
    
    @GetMapping(value = "/get")
    @ResponseBody
    public List<Cotizacion> getCotizacion(@RequestParam String titulo){
        if(titulo == ""){
            return cotizacionDao.findAll();
        }else{
            return cotizacionDao.findByTituloIsContaining(titulo);
        }
    }
    
    @GetMapping(value = "/getById/{id}")
    @ResponseBody
    public Cotizacion getById(@PathVariable Long id){
        return cotizacionDao.findById(id).orElse(null);
    }
}