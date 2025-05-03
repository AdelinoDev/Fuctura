package br.com.fuctura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import br.com.fuctura.dao.ClienteDAO;
import br.com.fuctura.dao.VeiculoDAO;
import br.com.fuctura.entidade.ClienteEntidade;

public class Application {
	public static void main(String[] args) {
		
		Menus menus = new Menus();
		
		menus.menuPrincipal();
	}	

}
