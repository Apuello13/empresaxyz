package com.empresaxyz.empresaxyz.controller;

import com.empresaxyz.empresaxyz.dao.UsuariosDao;
import com.empresaxyz.empresaxyz.entity.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsuarioController {

    @Autowired
    private UsuariosDao usuariosDao;

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody Usuarios usuario) {
        return usuariosDao.authentication(usuario.getUsername(), usuario.getPassword());
    }
}
