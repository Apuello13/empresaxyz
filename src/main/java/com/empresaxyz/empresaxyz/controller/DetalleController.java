package com.empresaxyz.empresaxyz.controller;

import com.empresaxyz.empresaxyz.dao.DetalleDao;
import com.empresaxyz.empresaxyz.entity.DetalleCotizacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Date;
/**
 *
 * @author apuello
 */
@Controller
@RequestMapping("/detail")
public class DetalleController {
    @Autowired
    private DetalleDao detalleDao;
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public DetalleCotizacion saveDetalle(@RequestBody DetalleCotizacion detalle){
        detalle.setFecha(new Date());
        return detalleDao.save(detalle);
    }
}