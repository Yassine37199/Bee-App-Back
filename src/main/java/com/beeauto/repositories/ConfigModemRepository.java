package com.beeauto.repositories;

import com.beeauto.entities.Abonnement;
import com.beeauto.entities.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import com.beeauto.entities.ConfigModem;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConfigModemRepository extends JpaRepository<ConfigModem,Long> {

    @Query("SELECT m FROM  ConfigModem m " +
            "WHERE m.loginConfig = ?1")
    List<ConfigModem> getModemByLogin(String login);

}
