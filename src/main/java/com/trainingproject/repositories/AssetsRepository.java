package com.trainingproject.repositories;

import com.trainingproject.domain.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetsRepository extends JpaRepository<Asset, Long> {
}
