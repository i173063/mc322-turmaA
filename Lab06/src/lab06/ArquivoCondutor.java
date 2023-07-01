package lab06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArquivoCondutor {
	public String lerArquivo(int numero_linha) { 
		String filename = "condutores.csv";
		String condutor = null;
		try (BufferedReader leitor = new BufferedReader(new FileReader(filename))) {
			String linha;
			int i = 0;
			while((linha = leitor.readLine()) != null) {
				i++;
				if (i == numero_linha) {
				    String[] campos = linha.split(",");
				    Condutor c = new Condutor(campos[0], campos[1], campos[2], campos[3], 
				    		campos[4], campos[5], null);
				    condutor = c.toString();
				    break;
				}
			}
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		return condutor;
	}
	
	
	public boolean gravarArquivo(Condutor condutor) {
		String filename = "condutores.csv";
		String c = condutor.toString();
		 try (BufferedWriter escritor = new BufferedWriter(new FileWriter(filename))) {
			 escritor.write(c);
			 escritor.newLine();
			 return true;
		 } catch(IOException ex) {
			 ex.printStackTrace();
			 return false;
		 }	
	}
}
