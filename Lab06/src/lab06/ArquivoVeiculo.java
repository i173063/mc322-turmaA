package lab06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArquivoVeiculo {
	public String lerArquivo(int numero_linha) { 
		String filename = "veiculos.csv";
		String v = null;
		try (BufferedReader leitor = new BufferedReader(new FileReader(filename))) {
			String linha;
			int i = 0;
			while((linha = leitor.readLine()) != null) {
				i++;
				if (i == numero_linha) {
				    String[] campos = linha.split(",");
				    Veiculo veiculo = new Veiculo(campos[0], campos[1], campos[2], campos[3]);
				    v = veiculo.toString();
				    break;
				}
			}
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		return v;
	}
	
	
	public boolean gravarArquivo(Veiculo veiculo) {
		String filename = "veiculos.csv";
		String v = veiculo.toString();
		 try (BufferedWriter escritor = new BufferedWriter(new FileWriter(filename))) {
			 escritor.write(v);
			 escritor.newLine();
			 return true;
		 } catch(IOException ex) {
			 ex.printStackTrace();
			 return false;
		 }	
	}
}
