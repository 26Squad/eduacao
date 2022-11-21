package br.com.EduAcao.model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table
public class Causa extends Entidade {

	@Column(nullable = false, length = 80)
    private String nome;
	
	@Column(nullable = false, length = 80)
    private String razaoSocia;

    @Column(nullable = true)
    private String cnpj;

    @Column(nullable = false, length = 15)
    private String telefone;

    @Column(nullable = false, length = 80, unique = true)
    private String email;

    @Column(name = "data_nascimento", nullable = false)
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dataNascimento;
    
    @Column(nullable = true)
    private String sobre;
    
    @Lob
	private byte[] imagem1;
    
    @Column(nullable = false, length = 80)
    private String nomeProjeto;
    
    @Column(nullable = false)
    private String sobreProjeto;
    
    @Lob
   	private byte[] imagem2;
    
    @Column(nullable = false)
    private String linkDoacao;
    
    @Column(nullable = false)
    private String linkInscricao;
    
    @Column(nullable = false)
    private String senha;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id_fk", nullable = false)
    private Endereco endereco;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRazaoSocia() {
		return razaoSocia;
	}

	public void setRazaoSocia(String razaoSocia) {
		this.razaoSocia = razaoSocia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSobre() {
		return sobre;
	}

	public void setSobre(String sobre) {
		this.sobre = sobre;
	}

	public byte[] getImagem1() {
		return imagem1;
	}

	public void setImagem1(byte[] imagem1) {
		this.imagem1 = imagem1;
	}

	public String getNomeProjeto() {
		return nomeProjeto;
	}

	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}

	public String getSobreProjeto() {
		return sobreProjeto;
	}

	public void setSobreProjeto(String sobreProjeto) {
		this.sobreProjeto = sobreProjeto;
	}

	public byte[] getImagem2() {
		return imagem2;
	}

	public void setImagem2(byte[] imagem2) {
		this.imagem2 = imagem2;
	}

	public String getLinkDoacao() {
		return linkDoacao;
	}

	public void setLinkDoacao(String linkDoacao) {
		this.linkDoacao = linkDoacao;
	}

	public String getLinkInscricao() {
		return linkInscricao;
	}

	public void setLinkInscricao(String linkInscricao) {
		this.linkInscricao = linkInscricao;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Arrays.hashCode(imagem1);
		result = prime * result + Arrays.hashCode(imagem2);
		result = prime * result + Objects.hash(cnpj, dataNascimento, email, endereco, linkDoacao, linkInscricao, nome,
				nomeProjeto, razaoSocia, senha, sobre, sobreProjeto, telefone);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Causa other = (Causa) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(dataNascimento, other.dataNascimento)
				&& Objects.equals(email, other.email) && Objects.equals(endereco, other.endereco)
				&& Arrays.equals(imagem1, other.imagem1) && Arrays.equals(imagem2, other.imagem2)
				&& Objects.equals(linkDoacao, other.linkDoacao) && Objects.equals(linkInscricao, other.linkInscricao)
				&& Objects.equals(nome, other.nome) && Objects.equals(nomeProjeto, other.nomeProjeto)
				&& Objects.equals(razaoSocia, other.razaoSocia) && Objects.equals(senha, other.senha)
				&& Objects.equals(sobre, other.sobre) && Objects.equals(sobreProjeto, other.sobreProjeto)
				&& Objects.equals(telefone, other.telefone);
	}

	@Override
	public String toString() {
		return "Causa [nome=" + nome + ", razaoSocia=" + razaoSocia + ", cnpj=" + cnpj + ", telefone=" + telefone
				+ ", email=" + email + ", dataNascimento=" + dataNascimento + ", sobre=" + sobre + ", imagem1="
				+ Arrays.toString(imagem1) + ", nomeProjeto=" + nomeProjeto + ", sobreProjeto=" + sobreProjeto
				+ ", imagem2=" + Arrays.toString(imagem2) + ", linkDoacao=" + linkDoacao + ", linkInscricao="
				+ linkInscricao + ", senha=" + senha + ", endereco=" + endereco + "]";
	}
    
    

}
