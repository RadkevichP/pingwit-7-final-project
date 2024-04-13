package pl.pingwit.pingwitcarrental.service.client;

import java.util.List;

import org.springframework.stereotype.Service;
import pl.pingwit.pingwitcarrental.controller.client.dto.ClientDto;
import pl.pingwit.pingwitcarrental.controller.client.dto.CreateClientInputDto;
import pl.pingwit.pingwitcarrental.exceptionhandling.CarRentNotFoundException;
import pl.pingwit.pingwitcarrental.repository.client.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientConverter clientConverter;
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientConverter clientConverter, ClientRepository clientRepository) {
        this.clientConverter = clientConverter;
        this.clientRepository = clientRepository;
    }

    @Override
    public List<ClientDto> listClients() {
        return clientRepository.findAll().stream()
                .map(clientConverter::toDto)
                .toList();
    }

    @Override
    public ClientDto getClientById(Integer id) {
        return clientRepository.findById(id).map(clientConverter::toDto)
                .orElseThrow(() -> new CarRentNotFoundException("Client not found: " +id));
    }

    @Override
    public Integer createClient(CreateClientInputDto inputDto) {
        return clientRepository.save(clientConverter.toEntity(inputDto)).getId();
    }
}
