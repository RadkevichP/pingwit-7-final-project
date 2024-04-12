package pl.pingwit.pingwitcarrental.service.client;

import org.springframework.stereotype.Component;
import pl.pingwit.pingwitcarrental.controller.client.dto.ClientDto;
import pl.pingwit.pingwitcarrental.controller.client.dto.CreateClientInputDto;
import pl.pingwit.pingwitcarrental.repository.client.Client;

@Component
public class ClientConverter {
    public ClientDto toDto(Client client) {
        ClientDto clientDto = new ClientDto();
        clientDto.setId(client.getId());
        clientDto.setName(client.getName());
        clientDto.setEmail(client.getEmail());
        return clientDto;
    }

    public Client toEntity(CreateClientInputDto inputDto) {
        Client client = new Client();
        client.setName(inputDto.getName());
        client.setSurname(inputDto.getSurname());
        client.setEmail(inputDto.getEmail());
        return client;
    }
}
