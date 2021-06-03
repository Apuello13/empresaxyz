package com.empresaxyz.empresaxyz.dao;

import com.empresaxyz.empresaxyz.entity.Cotizacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author apuello
 */
public interface CotizacionDao extends JpaRepository<Cotizacion, Long>{
    public boolean existsByTitulo(String titulo);
    
    public List<Cotizacion> findByTituloIsContaining(String titulo);
}
