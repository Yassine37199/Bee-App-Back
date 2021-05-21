package com.beeauto.Controllers;

import com.beeauto.entities.Abonnement;
import com.beeauto.entities.ConfigModem;
import com.beeauto.entities.Offre;
import com.beeauto.repositories.AbonnementRepository;
import com.beeauto.repositories.ConfigModemRepository;
import com.beeauto.repositories.OffreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class ConfigModemControllerTest {

    private ConfigModemController underTest;
    @Mock
    private ConfigModemRepository configModemRepository;
    @Mock
    private AbonnementRepository abonnementRepository;

    @BeforeEach
    void setUp() {
        underTest = new ConfigModemController(configModemRepository , abonnementRepository);
    }

    @Test
    void canGetListconfigmodem() {
        // when
        underTest.listconfigmodem();
        // then
        verify(configModemRepository).findAll();
    }

    @Test
    void addConfigModem() {
        // given
        ConfigModem configModem = new ConfigModem(
                1L,
                "123455698",
                "login",
                "123654478"
        );

        Abonnement abonnement = new Abonnement(
                Long.valueOf("1"),
                "121456",
                "en cours",
                "agence"

        );

        abonnementRepository.save(abonnement);
        configModem.setAbonnement(abonnement);


        underTest.addConfigModem(configModem , abonnement.getIdAbonnement());

        // then
        ArgumentCaptor<ConfigModem> modemArgumentCaptor =
                ArgumentCaptor.forClass(ConfigModem.class);

        ArgumentCaptor<Abonnement> abonnementArgumentCaptor =
                ArgumentCaptor.forClass(Abonnement.class);

        verify(abonnementRepository).save(abonnementArgumentCaptor.capture());
        verify(configModemRepository).save(modemArgumentCaptor.capture());

        ConfigModem capturedModem = modemArgumentCaptor.getValue();
        assertThat(capturedModem).isEqualTo(configModem);
    }
    }