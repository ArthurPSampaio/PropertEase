package br.com.ByteNest.PropertEase.models.realty;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RealtyRepository extends JpaRepository<Realty, UUID> {
}
