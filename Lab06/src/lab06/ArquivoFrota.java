package lab06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArquivoFrota {
	public String lerArquivo(int numero_linha) { 
		String filename = "frotas.csv";
		String frota = null;
		try (BufferedReader leitor = new BufferedReader(new FileReader(filename))) {
			String linha;
			int i = 0;
			while((linha = leitor.readLine()) != null) {
				i++;
				if (i == numero_linha) {
				    String[] campos = linha.split(",");
				    ArrayList<String> placas = new ArrayList<String>() ;
				    placas.add(campos[1]);
				    placas.add(campos[2]);
				    placas.add(campos[3]);
				    Frota f = new Frota(campos[0], placas, null);
				    frota = f.toString();
				    break;
				}
			}
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		return frota;
	}
	
	
	public boolean gravarArquivo(Frota frota) {
		String filename = "clientesPF.csv";
		String f = frota.toString();
		 try (BufferedWriter escritor = new BufferedWriter(new FileWriter(filename))) {
			 escritor.write(f);
			 escritor.newLine();
			 return true;
		 } catch(IOException ex) {
			 ex.printStackTrace();
			 return false;
		 }	
	}
}
