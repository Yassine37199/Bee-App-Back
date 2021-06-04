package com.beeauto.Controllers;

import com.beeauto.entities.Client;
import com.beeauto.entities.Offre;
import com.beeauto.repositories.ClientRepository;
import com.beeauto.controllers.OffreController;
import com.beeauto.repositories.OffreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class OffreControllerTest {

    private OffreController underTest;
    @Mock
    private OffreRepository offreRepository;

    @BeforeEach
    void setUp() {
        underTest = new OffreController(offreRepository);
    }

    @Test
    void canGetListOffres() {
        // when
        underTest.listOffres();
        // then
        verify(offreRepository).findAll();
    }


}