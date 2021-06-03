
package com.empresaxyz.empresaxyz.dao;

import com.empresaxyz.empresaxyz.entity.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */
@Repository
public interface ClientesDao extends JpaRepository<Cliente, Long>{
    
    public boolean existsByIdentificacion(String identificacion);
    public List<Cliente> findByNombreIsContaining(String nombre);
}