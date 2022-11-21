package br.com.EduAcao.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;



@Entity
@Table
public class Newsletter extends Entidade {
	
	 @Column(nullable = false, length = 80, unique = true)
	    private String emailNews;

	public String getEmailNews() {
		return emailNews;
	}

	public void setEmailNews(String emailNews) {
		this.emailNews = emailNews;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash( emailNews);
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
		Newsletter other = (Newsletter) obj;
		return  Objects.equals(emailNews, other.emailNews);
	}

	@Override
	public String toString() {
		return "Newsletter [emailNews=" + emailNews + "]";
	}
	 
	 

}
