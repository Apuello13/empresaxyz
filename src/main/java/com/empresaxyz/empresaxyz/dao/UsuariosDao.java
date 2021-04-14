package com.empresaxyz.empresaxyz.dao;

import com.empresaxyz.empresaxyz.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author apuello
 */
@Repository
public interface UsuariosDao extends JpaRepository<Usuarios, Long>{
    @Query(value = "{call authentication(:username,:password)}", nativeQuery = true)
    String authentication(@Param("username") String username, @Param("password") String password);
}
