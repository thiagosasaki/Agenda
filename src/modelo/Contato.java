package modelo;

public class Contato {
	private int 	codigo;
	private String 	nome;
	private String 	telefone;
	private Grupo 	grupo;

	public Contato(int codigo, String nome, String telefone, Grupo grupo) {
		setCodigo(codigo);
		setNome(nome);
		setTelefone(telefone);
		setGrupo(grupo);
	}

	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	@Override
	public String toString() {
		return getCodigo() + " - " + getNome();
	}

}
