
package com.empresaxyz.empresaxyz.dao;

import com.empresaxyz.empresaxyz.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */
@Repository
public interface ClientesDao extends JpaRepository<Cliente, Long>{}