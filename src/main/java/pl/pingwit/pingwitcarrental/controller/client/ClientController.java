package pl.pingwit.pingwitcarrental.controller.client;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pingwit.pingwitcarrental.controller.client.dto.ClientDto;
import pl.pingwit.pingwitcarrental.controller.client.dto.CreateClientInputDto;
import pl.pingwit.pingwitcarrental.service.client.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<ClientDto> listClients() {
        return clientService.listClients();
    }

    @GetMapping("/{id}")
    public ClientDto getClient(@PathVariable Integer id) {
        return clientService.getClientById(id);
    }

    @PostMapping
    public Integer createClient(@RequestBody CreateClientInputDto inputDto) {
        return clientService.createClient(inputDto);
    }
}
