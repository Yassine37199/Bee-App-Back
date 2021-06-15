package com.beeauto.Controllers.Clients;

import com.beeauto.entities.Client;
import com.beeauto.repositories.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import com.beeauto.controllers.ClientController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ClientControllerTest {

    private ClientController underTest;
    @Mock private ClientRepository clientRepository;

    @BeforeEach
    void setUp() {
        underTest = new ClientController(clientRepository);
    }

    @Test
    void canGetListClients() {
        // when
        underTest.listClients();
        // then
        verify(clientRepository).findAll();
    }


    @Test
    void canAddClient() {
        // given
        Long idClient = 2L;
        Client client = new Client(
                2L,
                "Yassine Ouri",
                13021665,
                "yassine.ouri7319@outlook.com",
                "ville",
                "gouvernorat",
                "adresse",
                1001,
                Date.valueOf("1999-07-03"),
                28412507,
                isActive);

        underTest.addClient(client);

        // then
        ArgumentCaptor<Client> clientArgumentCaptor =
                ArgumentCaptor.forClass(Client.class);

        verify(clientRepository).save(clientArgumentCaptor.capture());

        Client capturedClient = clientArgumentCaptor.getValue();
        assertThat(capturedClient).isEqualTo(client);
    }


}