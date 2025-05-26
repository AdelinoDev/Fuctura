package br.com.fuctura.views;

import br.com.fuctura.controller.VeiculoController;
import br.com.fuctura.repository.VeiculoRepository;
import br.com.fuctura.service.VeiculoService;

public class MenuVeiculo {

	// Crie o repositório (pode ser um repositório fake para testes)
    VeiculoRepository repository = new VeiculoRepository(); // ou um mock/fake

    // Passe o repositório para o service
    VeiculoService service = new VeiculoService(repository);

    // Passe o service para o controller
    VeiculoController controller = new VeiculoController(service);

    // Chame o menu
    public void MenuVeiculo() {
    	controller.menuVeiculo();
    }
    
}
