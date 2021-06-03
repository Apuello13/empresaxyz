/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresaxyz.empresaxyz.dao;

import com.empresaxyz.empresaxyz.entity.Vendedor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author apuello
 */
@Repository
public interface VendedoresDao extends JpaRepository<Vendedor, Long>{
    
    public Vendedor findByUsernameAndPassword(String username, String password);
    public boolean existsByIdentificacion(String identificacion);
    public List<Vendedor> findByNombreIsContaining(String name);
}
