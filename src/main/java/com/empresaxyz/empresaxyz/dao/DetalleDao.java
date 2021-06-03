package com.empresaxyz.empresaxyz.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.empresaxyz.empresaxyz.entity.DetalleCotizacion;
/**
 *
 * @author apuello
 */
public interface DetalleDao extends JpaRepository<DetalleCotizacion, Long>{}