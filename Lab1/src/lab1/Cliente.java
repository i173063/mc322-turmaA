package lab1;

public class Cliente {
	private String nome;
	private String cpf;
	private String dataNascimento;
	private int idade;
	private String endereco;
	
	//Construtor
	public Cliente(String nome, String cpf, String dataNascimento, String endereco, int idade) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.idade = idade;
		this.endereco = endereco;
	}
	//Getters e setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	//validar cpf
	public boolean validarCpf(String cpf) {
		if(cpf == null) {
			return false;
		}
		cpf = cpf.replaceAll("[^0-9]+", "");//remover caract nao num
		int n = cpf.length();
		if(n != 11) { //verifica se tem 11 digitos
			return false;
		}
		//verifica digitos iguais
		int i = 0;
		while (i < n) {
			if(cpf.charAt(i) != cpf.charAt(n-1))
				break;
			i++;
		}
		if (i == n)
			return false;
		//calcular digito verificador
		int sm = 0;
		int peso = 10;
		int r, num;
		int digito1, digito2;
		//calculo do digito1
		for (int j = 0; j < 9; j++) {
			num = (int)(cpf.charAt(j)-48);
			sm = sm +(num*peso);
			peso = peso - 1;
		}
		r = 11 - (sm % 11);
		if((r == 10)||(r == 11))
			digito1 = '0';
		else digito1 = (char)(r+48);
		//calculo do digito2
		sm = 0;
		peso = 11;
		for (int w = 0; w < 10; w++) {
			num = (int)(cpf.charAt(w)-48);
			sm = sm +(num*peso);
			peso = peso - 1;
		}
		r = 11 - (sm % 11);
		if((r == 10)||(r == 11))
			digito2 = '0';
		else digito2 = (char)(r+48);
		//verificar os digitos calculados com os dados
		if((digito1 != cpf.charAt(9)||(digito2 != cpf.charAt(10))))
			return false;
		return true;
	}
}
