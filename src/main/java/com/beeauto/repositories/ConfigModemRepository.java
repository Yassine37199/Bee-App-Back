package com.beeauto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.beeauto.entities.ConfigModem;

@Repository
public interface ConfigModemRepository extends JpaRepository<ConfigModem , Long> {

}
