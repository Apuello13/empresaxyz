/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresaxyz.empresaxyz.dao;

import com.empresaxyz.empresaxyz.entity.Productos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MROMERO
 */
@Repository
public interface ProductosDao extends JpaRepository<Productos, Long>{

    public boolean existsByCodigo(String codigo);
    public List<Productos> findByNombreIsContaining(String nombre);
}
