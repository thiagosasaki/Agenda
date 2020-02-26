package modelo;

public class Grupo {
	private int 	codigo;
	private String 	nome;
	private String 	descricao;
	
	public Grupo(int codigo, String nome, String descricao) {
		setCodigo(codigo);
		setNome(nome);
		setDescricao(descricao);
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return getCodigo() + " - " + getNome();
	}
}
