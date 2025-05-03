package br.com.fuctura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import br.com.fuctura.dao.ClienteDAO;
import br.com.fuctura.dao.LojaDAO;
import br.com.fuctura.dao.VeiculoDAO;
import br.com.fuctura.dao.VendedorDAO;
import br.com.fuctura.entidade.ClienteEntidade;
import br.com.fuctura.entidade.EnderecoEntidade;
import br.com.fuctura.entidade.LojaEntidade;
import br.com.fuctura.entidade.VeiculoEntidade;
import br.com.fuctura.entidade.VendedorEntidade;

public class Menus {

	 public void menuPrincipal() {
	        Scanner sc = new Scanner(System.in);
	        int opcao = 0;

	        do {
	            System.out.println("######## CONCESSIONARIO FUCTURA ########\n");
	            System.out.println("1 ->  PARA GERENCIAMENTO CLIENTES");
	            System.out.println("2 ->  PARA GERENCIAMENTO VEICULOS");
	            System.out.println("3 ->  PARA GERENCIAMENTO DE VENDEDORES");
	            System.out.println("4 ->  PARA GERENCIAMENTO DE LOJA");
	            System.out.println("0 ->  PARA SAIR DO PROGRAMA");

	            System.out.print("Escolha uma opção: ");
	            opcao = sc.nextInt();
	            sc.nextLine();

	            switch (opcao) {
	                case 1:
	                     menuCliente();
	                    break;
	                case 2:
	                     menuVeiculo();
	                    break;
	                case 3:
	                     menuVendedor();
	                    break;
	                case 4:
	                    menuLoja();
	                    break;
	                case 0:
	                    System.out.println("Encerrando o programa...");
	                    break;
	                default:
	                    System.out.println("Opção Inválida!");
	            }

	        } while (opcao != 0);
	    }

	    public void menuCliente() {
	    	
	        String url = "jdbc:postgresql://localhost:5432/concessionaria";
	        String user = "postgres";
	        String password = "14011982";

	        try  {
	        	
	        	Connection conn = DriverManager.getConnection(url, user, password);
	            //System.out.println("Conectado com sucesso!");

	            ClienteDAO clienteDao = new ClienteDAO();
	            Scanner sc = new Scanner(System.in);
	            int opcao = 0;

	            do {
	                System.out.println("1 ->  PARA CADASTRAR CLIENTES");
	                System.out.println("2 ->  PARA LISTAR CLIENTES");
	                System.out.println("3 ->  PARA PESQUISAR CLIENTE POR CPF");
	                System.out.println("4 ->  PARA REMOVER CLIENTE");
	                System.out.println("0 ->  PARA VOLTAR AO MENU PRINCIPAL\n");

	                System.out.print("Escolha uma opção: ");
	                opcao = sc.nextInt();
	                sc.nextLine();

	                switch (opcao) {
	                case 1:
	                    ClienteEntidade cliente = new ClienteEntidade();
	                    EnderecoEntidade endereco = new EnderecoEntidade();

	                    // Coleta dados do cliente
	                    System.out.print("Nome do cliente: ");
	                    cliente.setNome(sc.nextLine());

	                    System.out.print("CPF do cliente: ");
	                    cliente.setCpf(sc.nextLine());

	                    System.out.print("Celular do cliente: ");
	                    cliente.setCelular(sc.nextLine());

	                    System.out.print("Email do cliente: ");
	                    cliente.setEmail(sc.nextLine());
    
	                    sc.nextLine(); // Limpa o buffer

	                    try {
	                        clienteDao.inserir(conn, cliente);
	                        System.out.println("Cliente cadastrado com sucesso!");
	                    } catch (SQLException e) {
	                        System.out.println("Erro ao inserir cliente.");
	                        e.printStackTrace();
	                    }
	                    
	                    break;


	                    case 2:
	                        List<ClienteEntidade> listaClientes = clienteDao.consultarTodos(conn);

	                        if (listaClientes != null && !listaClientes.isEmpty()) {
	                            System.out.println("\n### Lista de Clientes ###");

	                            for (ClienteEntidade c : listaClientes) {
	                                System.out.println("Código: " + c.getCodigo());
	                                System.out.println("Nome: " + c.getNome());
	                                System.out.println("CPF: " + c.getCpf());
	                                System.out.println("Celular: " + c.getCelular());
	                                System.out.println("Email: " + c.getEmail());
	                            }

	                        } else {
	                            System.out.println("Nenhum cliente encontrado.");
	                        }
	                        break;


	                    case 3:
	                    	System.out.print("Digite o CPF do cliente: ");
	                        String cpfBusca = sc.nextLine();

	                        List<ClienteEntidade> clientesEncontrados = clienteDao.consultarPorCpf(conn, cpfBusca);

	                        if (clientesEncontrados != null && !clientesEncontrados.isEmpty()) {
	                            System.out.println("\n### Cliente(s) Encontrado(s) ###");

	                            for (ClienteEntidade c : clientesEncontrados) {
	                                System.out.println("Código: " + c.getCodigo());
	                                System.out.println("Nome: " + c.getNome());
	                                System.out.println("CPF: " + c.getCpf());
	                                System.out.println("Celular: " + c.getCelular());
	                                System.out.println("Email: " + c.getEmail());
	                                System.out.println("-----------------------------");
	                            }

	                        } else {
	                            System.out.println("Nenhum cliente encontrado com o CPF informado.");
	                        }
	                        
	                        break;

	                    case 4:
	                        System.out.print("Digite o CPF do cliente que deseja remover: ");
	                        String cpfRemover = sc.nextLine();

	                        // Consulta primeiro pra confirmar que o cliente existe
	                        List<ClienteEntidade> clientesParaRemover = clienteDao.consultarPorCpf(conn, cpfRemover);

	                        if (clientesParaRemover != null && !clientesParaRemover.isEmpty()) {
	                            ClienteEntidade clienteParaRemover = clientesParaRemover.get(0); // Pegando o primeiro, se houver mais de um

	                            try {
	                                clienteDao.excluir(conn, clienteParaRemover);
	                                System.out.println("Cliente removido com sucesso.");
	                            } catch (SQLException e) {
	                                System.out.println("Erro ao remover o cliente.");
	                                e.printStackTrace();
	                            }

	                        } else {
	                            System.out.println("Nenhum cliente encontrado com o CPF informado.");
	                        }
	                        break;


	                    case 0:
	                        System.out.println("Voltando ao menu principal...");
	                        break;

	                    default:
	                        System.out.println("Opção inválida!");
	                }

	            } while (opcao != 0);

	        } catch (SQLException e) {
	            System.out.println("Erro na conexão com o banco de dados.");
	            e.printStackTrace();
	        }
	    }

	    public void menuVeiculo() {

	        String url = "jdbc:postgresql://localhost:5432/concessionaria";
	        String user = "postgres";
	        String password = "14011982";

	        try {
	            Connection conn = DriverManager.getConnection(url, user, password);
	            System.out.println("Conectado com sucesso!");

	            VeiculoDAO veiculoDao = new VeiculoDAO();
	            Scanner sc = new Scanner(System.in);

	            int opcao = 0;

	            do {
	                System.out.println("\n#### GERENCIAMENTO DE VEÍCULOS ####");
	                System.out.println("1 -> CADASTRAR VEICULOS");
	                System.out.println("2 -> LISTAR TODOS OS VEICULOS");
	                System.out.println("3 -> BUSCAR VEICULO POR PLACA");
	                System.out.println("4 -> ATUALIZAR DADOS DO VEICULO");
	                System.out.println("5 -> REMOVER VEICULO");
	                System.out.println("0 -> VOLTAR PARA O MENU PRINCIPAL");
	                System.out.print("Escolha uma opção: ");
	                opcao = sc.nextInt();
	                sc.nextLine();

	                switch(opcao) {

	                    case 1:
	                        VeiculoEntidade veiculo = new VeiculoEntidade();

	                        System.out.print("Placa: ");
	                        veiculo.setPlaca(sc.nextLine());

	                        System.out.print("Modelo: ");
	                        veiculo.setModelo(sc.nextLine());

	                        System.out.print("Ano: ");
	                        veiculo.setAno(sc.nextInt());

	                        System.out.print("Valor: ");
	                        veiculo.setValor(sc.nextDouble());
	                        sc.nextLine();

	                        veiculoDao.inserirVeiculo(conn, veiculo);
	                        System.out.println("Veículo cadastrado com sucesso!");
	                        break;

	                    case 2:
	                        List<VeiculoEntidade> veiculos = veiculoDao.consultarTodosVeiculos(conn);

	                        if (veiculos != null && !veiculos.isEmpty()) {
	                            System.out.println("\n### Lista de Veículos ###");
	                            for (VeiculoEntidade v : veiculos) {
	                                System.out.println("Código: " + v.getCodigo());
	                                System.out.println("Placa: " + v.getPlaca());
	                                System.out.println("Modelo: " + v.getModelo());
	                                System.out.println("Ano: " + v.getAno());
	                                System.out.println("Valor: " + v.getValor());
	                                System.out.println("----------------------------");
	                            }
	                        } else {
	                            System.out.println("Nenhum veículo encontrado.");
	                        }
	                        break;

	                    case 3:
	                        System.out.print("Informe a placa do veículo: ");
	                        String placaBusca = sc.nextLine();

	                        List<VeiculoEntidade> resultadoBusca = veiculoDao.consultarVeiculosPorPlaca(conn, placaBusca);

	                        if (resultadoBusca != null && !resultadoBusca.isEmpty()) {
	                            for (VeiculoEntidade v : resultadoBusca) {
	                                System.out.println("Código: " + v.getCodigo());
	                                System.out.println("Placa: " + v.getPlaca());
	                                System.out.println("Modelo: " + v.getModelo());
	                                System.out.println("Ano: " + v.getAno());
	                                System.out.println("Valor: " + v.getValor());
	                                System.out.println("----------------------------");
	                            }
	                        } else {
	                            System.out.println("Veículo não encontrado.");
	                        }
	                        break;

	                    case 4:
	                        VeiculoEntidade veiculoAtualiza = new VeiculoEntidade();

	                        System.out.print("Placa do veículo a atualizar: ");
	                        veiculoAtualiza.setPlaca(sc.nextLine());

	                        System.out.print("Novo modelo: ");
	                        veiculoAtualiza.setModelo(sc.nextLine());

	                        System.out.print("Novo ano: ");
	                        veiculoAtualiza.setAno(sc.nextInt());

	                        System.out.print("Novo valor: ");
	                        veiculoAtualiza.setValor(sc.nextDouble());
	                        sc.nextLine();

	                        boolean atualizado = veiculoDao.atualizarDadosVeiculo(conn, veiculoAtualiza);

	                        if (atualizado) {
	                            System.out.println("Veículo atualizado com sucesso.");
	                        } else {
	                            System.out.println("Falha ao atualizar o veículo.");
	                        }
	                        break;

	                    case 5:
	                        System.out.print("Placa do veículo a remover: ");
	                        String placaRemover = sc.nextLine();

	                        VeiculoEntidade veiculoRemover = new VeiculoEntidade();
	                        veiculoRemover.setPlaca(placaRemover);

	                        veiculoDao.excluirVeiculo(conn, veiculoRemover);
	                        System.out.println("Veículo removido com sucesso.");
	                        break;

	                    case 0:
	                        System.out.println("Retornando ao menu principal...");
	                        break;

	                    default:
	                        System.out.println("Opção inválida.");
	                }

	            } while (opcao != 0);

	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println("Erro ao conectar com o banco de dados.");
	        }
	    }

	    public void menuVendedor() {
	    	
	    	String url = "jdbc:postgresql://localhost:5432/concessionaria";
	        String user = "postgres";
	        String password = "14011982";

	        try {
	            Connection conn = DriverManager.getConnection(url, user, password);
	            System.out.println("Conectado com sucesso!");

	            VendedorDAO vendedorDao = new VendedorDAO();
	            Scanner sc = new Scanner(System.in);

	            int opcao = 0;

	            do {
	                System.out.println("\n#### GERENCIAMENTO DE VEÍCULOS ####");
	                System.out.println("1 -> CADASTRAR VENDEDOR");
	                System.out.println("2 -> LISTAR TODOS OS VENDEDORES");
	                System.out.println("3 -> BUSCAR VENDEDOR POR CPF");
	                System.out.println("4 -> ATUALIZAR VENDEDOR POR CODIGO");
	                System.out.println("5 -> REMOVER VENDEDOR");
	                System.out.println("0 -> VOLTAR PARA O MENU PRINCIPAL");
	                System.out.print("\nEscolha uma opção: ");
	                opcao = sc.nextInt();
	                sc.nextLine();

	                switch(opcao) {

	                    case 1:
	                    	VendedorEntidade vendedor = new VendedorEntidade();

	                        System.out.print("Nome: ");
	                        vendedor.setNome(sc.nextLine());

	                        System.out.print("CPF: ");
	                        vendedor.setCpf(sc.nextLine());

	                        System.out.print("Telefone: ");
	                        vendedor.setTelefone(sc.nextLine());

	                        System.out.print("endereco: ");
	                        vendedor.setEndereco(sc.nextLine());
	                        sc.nextLine();

	                        vendedorDao.inserirVendedor(conn, vendedor);
	                        System.out.println("Vendedor cadastrado com sucesso!");
	                        break;

	                    case 2:
	                        List<VendedorEntidade> vendedores = vendedorDao.consultarTodosVendedor(conn);

	                        if (vendedores != null && !vendedores.isEmpty()) {
	                            System.out.println("\n### Lista de Veículos ###");
	                            
	                            for (VendedorEntidade v : vendedores) {
	                                System.out.println("Código: " + v.getCodigo());
	                                System.out.println("Nome: " + v.getNome());
	                                System.out.println("CPF: " + v.getCpf());
	                                System.out.println("Endereço: " + v.getEndereco());
	                                System.out.println("Telefone: " + v.getTelefone());
	                                System.out.println("----------------------------");
	                            }
	                        } else {
	                            System.out.println("Nenhum vendedor encontrado.");
	                        }
	                        break;

	                    case 3:
	                        System.out.print("Informe o CPF do vendedor: ");
	                        String vendedorBusca = sc.nextLine();

	                        List<VendedorEntidade> resultadoBusca = vendedorDao.consultarVendedorPorCpf(conn, vendedorBusca);

	                        if (resultadoBusca != null && !resultadoBusca.isEmpty()) {
	                        	
	                            for (VendedorEntidade v : resultadoBusca) {
	                            	System.out.println("Código: " + v.getCodigo());
	                                System.out.println("Nome: " + v.getNome());
	                                System.out.println("CPF: " + v.getCpf());
	                                System.out.println("Endereço: " + v.getEndereco());
	                                System.out.println("Telefone: " + v.getTelefone());
	                                System.out.println("----------------------------");
	                            }
	                        } else {
	                            System.out.println("Vendedor não encontrado.");
	                        }
	                        break;

	                    case 4:
	                        VendedorEntidade vendedorAtualiza = new VendedorEntidade();

	                        System.out.print("Nome do vendedor atualizado: ");
	                        vendedorAtualiza.setNome(sc.nextLine());

	                        System.out.print("Novo CPF: ");
	                        vendedorAtualiza.setCpf(sc.nextLine());

	                        System.out.print("Novo endereço: ");
	                        vendedorAtualiza.setEndereco(sc.nextLine());

	                        System.out.print("Novo telefone: ");
	                        vendedorAtualiza.setTelefone(sc.nextLine());
	                        sc.nextLine();

	                        boolean atualizado = vendedorDao.atualizarVendedorPorCodigo(conn, vendedorAtualiza);

	                        if (atualizado) {
	                            System.out.println("Vendedor atualizado com sucesso.");
	                        } else {
	                            System.out.println("Falha ao atualizar o vendedor.");
	                        }
	                        break;

	                    case 5:
	                    	System.out.print("Cpf do vendedor para ser removido: ");
	                        String cpfRemover = sc.nextLine();

	                        VendedorEntidade vendedorRemover = new VendedorEntidade();
	                        vendedorRemover.setCpf(cpfRemover);

	                        vendedorDao.excluirVendedorPorCpf(conn, vendedorRemover);
	                        System.out.println("Vendedor removido com sucesso.");
	                        break;

	                    case 0:
	                        System.out.println("Retornando ao menu principal...");
	                        break;

	                    default:
	                        System.out.println("Opção inválida.");
	                }

	            } while (opcao != 0);

	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println("Erro ao conectar com o banco de dados.");
	        }
	    }

	    public void menuLoja() {
	    	
	    	String url = "jdbc:postgresql://localhost:5432/concessionaria";
	        String user = "postgres";
	        String password = "14011982";

	        try  {
	        	
	        	Connection conn = DriverManager.getConnection(url, user, password);
	            //System.out.println("Conectado com sucesso!");

	            LojaDAO lojaDao = new LojaDAO();
	            Scanner sc = new Scanner(System.in);
	            int opcao = 0;

	            do {
	                System.out.println("1 ->  PARA CADASTRAR LOJA");
	                System.out.println("2 ->  PARA LISTAR TODAS AS LOJAS");
	                System.out.println("3 ->  PARA CONSULTAR LOJAS POR CÓDIGO");
	                System.out.println("4 ->  PARA REMOVER LOJA");
	                System.out.println("5 ->  PARA ATUALIZAR LOJA POR CÓDIGO");
	                System.out.println("0 ->  PARA VOLTAR AO MENU PRINCIPAL\n");

	                System.out.print("Escolha uma opção: ");
	                opcao = sc.nextInt();
	                sc.nextLine();

	                switch (opcao) {
	                case 1:
	                    LojaEntidade loja = new LojaEntidade();

	                    // Coleta dados da loja
	                    System.out.print("Nome da loja: ");
	                    loja.setNome(sc.nextLine());

	                    System.out.print("CNPJ: ");
	                    loja.setCnpj(sc.nextLine());

	                    System.out.print("Endereço: ");
	                    loja.setEndereco(sc.nextLine());
	                    sc.nextLine(); // Limpa o buffer

	                    try {
	                        lojaDao.inserirLoja(conn, loja);
	                        System.out.println("Loja cadastrada com sucesso!");
	                    } catch (SQLException e) {
	                        System.out.println("Erro ao inserir loja.");
	                        e.printStackTrace();
	                    }
	                    
	                    break;


	                    case 2:
	                        List<LojaEntidade> listaLojas = lojaDao.consultarTodasLoja(conn);

	                        if (listaLojas != null && !listaLojas.isEmpty()) {
	                            System.out.println("\n### Lista de Clientes ###");

	                            for (LojaEntidade c : listaLojas) {
	                                System.out.println("Código: " + c.getCodigo());
	                                System.out.println("Nome: " + c.getNome());
	                                System.out.println("CNPJ: " + c.getCnpj());
	                                System.out.println("Endereco: " + c.getEndereco());
	                            }

	                        } else {
	                            System.out.println("Nenhuma loja encontrada.");
	                        }
	                        break;


	                    case 3:
	                    	System.out.print("Digite o código da loja: ");
	                        int codigoBusca = sc.nextInt();

	                        List<LojaEntidade> lojasEncontradas = lojaDao.consultarLojasPorCodigo(conn, codigoBusca);

	                        if (lojasEncontradas != null && !lojasEncontradas.isEmpty()) {
	                            System.out.println("\n### Lojas(s) Encontrado(s) ###");

	                            for (LojaEntidade c : lojasEncontradas) {
	                                System.out.println("Código: " + c.getCodigo());
	                                System.out.println("Nome: " + c.getNome());
	                                System.out.println("CNPJ: " + c.getCnpj());
	                                System.out.println("Endereço: " + c.getEndereco());
	                                System.out.println("-----------------------------");
	                            }

	                        } else {
	                            System.out.println("Nenhuma loja encontrado com o código informado.");
	                        }
	                        
	                        break;

	                    case 4:
	                        System.out.println("Digite o código da loja ao qual voce deseja excluir: ");
	                        int codigoRemover = sc.nextInt();
	                        
	                        List<LojaEntidade> lojasParaRemover = lojaDao.excluirLoja(conn, codigoRemover);
	                        
	                        if(lojasParaRemover != null && !lojasParaRemover.isEmpty()) {
	                        	
	                        	LojaEntidade lojaParaRemover = lojasParaRemover.get(0);
	                        	
	                        	try {
	                        		lojaDao.excluirLoja(conn, lojaParaRemover);
	                        		System.out.println("Loja removida com sucesso!");
	                        		
	                        	}catch(SQLException e) {
	                        		System.out.println("Erro ao remover a loja!");
	                        		e.printStackTrace();
	                        	}
	                        	
	                        } else {
	                        	System.out.println("Nenhuma loja foi encontrada!");
	                        }
	                        
	                        break;
	                        
	                    case 5:
	                        LojaEntidade atualizarLoja = new LojaEntidade();

	                        System.out.print("Nome da loja: ");
	                        atualizarLoja.setNome(sc.nextLine());

	                        System.out.print("CNPJ: ");
	                        atualizarLoja.setCnpj(sc.nextLine());

	                        System.out.print("Novo endereço: ");
	                        atualizarLoja.setEndereco(sc.nextLine());
	                        sc.nextLine();

	                        boolean atualizado = lojaDao.atualizarDadosLojaPorCodigo(conn, atualizarLoja);

	                        if (atualizado) {
	                            System.out.println("Loja atualizada com sucesso.");
	                        } else {
	                            System.out.println("Falha a atualizar loja.");
	                        }
	                        break;


	                    case 0:
	                        System.out.println("Voltando ao menu principal...");
	                        break;

	                    default:
	                        System.out.println("Opção inválida!");
	                }

	            } while (opcao != 0);

	        } catch (SQLException e) {
	            System.out.println("Erro na conexão com o banco de dados.");
	            e.printStackTrace();
	        }
	    }
}
