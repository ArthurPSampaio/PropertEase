package br.com.ByteNest.PropertEase.models.schedules;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SchedulesRepository extends JpaRepository<Schedules, UUID> {
}
