package pl.pingwit.pingwitcarrental.service.client;


import java.util.List;

import pl.pingwit.pingwitcarrental.controller.client.dto.ClientDto;
import pl.pingwit.pingwitcarrental.controller.client.dto.CreateClientInputDto;

public interface ClientService {

    List<ClientDto> listClients();

    ClientDto getClientById(Integer id);

    Integer createClient(CreateClientInputDto createClientInputDto);
}
