package pl.pingwit.pingwitcarrental.controller.client;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pingwit.pingwitcarrental.controller.client.dto.ClientDto;
import pl.pingwit.pingwitcarrental.controller.client.dto.CreateClientInputDto;
import pl.pingwit.pingwitcarrental.service.client.ClientService;

@Tag(name = "Client API")
@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @Operation(description = "Get the list of clients")
    @GetMapping
    public List<ClientDto> listClients() {
        return clientService.listClients();
    }

    @Operation(description = "Get client by id")
    @GetMapping("/{id}")
    public ClientDto getClient(@PathVariable Integer id) {
        return clientService.getClientById(id);
    }

    @Operation(description = "Create a client")
    @PostMapping
    public Integer createClient(@RequestBody CreateClientInputDto inputDto) {
        return clientService.createClient(inputDto);
    }
}
