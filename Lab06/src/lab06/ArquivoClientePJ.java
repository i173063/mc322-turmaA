package lab06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArquivoClientePJ {
	public String lerArquivo(int numero_linha) { 
		String filename = "clientesPJ.csv";
		String cliente = null;
		try (BufferedReader leitor = new BufferedReader(new FileReader(filename))) {
			String linha;
			int i = 0;
			while((linha = leitor.readLine()) != null) {
				i++;
				if (i == numero_linha) {
				    String[] campos = linha.split(",");
				    ClientePJ clientepj = new ClientePJ(campos[0], campos[1], campos[2], 
				    		campos[3], campos[4], campos[5], campos[6], null);
				    cliente = clientepj.toString();
				    break;
				}
			}
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		return cliente;
	}
	
	
	public boolean gravarArquivo(ClientePJ cliente) {
		String filename = "clientesPF.csv";
		String clientepj = cliente.toString();
		 try (BufferedWriter escritor = new BufferedWriter(new FileWriter(filename))) {
			 escritor.write(clientepj);
			 escritor.newLine();
			 return true;
		 } catch(IOException ex) {
			 ex.printStackTrace();
			 return false;
		 }	
	}
}
