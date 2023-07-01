package lab06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArquivoClientePF {
	public String lerArquivo(int numero_linha) { 
		String filename = "clientesPF.csv";
		String cliente = null;
		try (BufferedReader leitor = new BufferedReader(new FileReader(filename))) {
			String linha;
			int i = 0;
			while((linha = leitor.readLine()) != null) {
				i++;
				if (i == numero_linha) {
				    String[] campos = linha.split(",");
				    ClientePF clientepf = new ClientePF(campos[0], campos[1], campos[2], 
				    		campos[3], campos[4], campos[5], campos[6], campos[7], campos[8],
				    		null);
				    cliente = clientepf.toString();
				    break;
				}
			}
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		return cliente;
	}
	
	
	public boolean gravarArquivo(ClientePF cliente) {
		String filename = "clientesPF.csv";
		String clientepf = cliente.toString();
		 try (BufferedWriter escritor = new BufferedWriter(new FileWriter(filename))) {
			 escritor.write(clientepf);
			 escritor.newLine();
			 return true;
		 } catch(IOException ex) {
			 ex.printStackTrace();
			 return false;
		 }	
	}
}
