package com.skilldistillery.eventtracker.entities;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Band {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@Column(name = "image_url")
	private String imageUrl;

	@JsonIgnore
	@OneToMany(mappedBy = "band")
	private List<Vinyl> vinyls; 

	public Band() {
		super();
	}

	public int getId() {
		
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<Vinyl> getVinyls() {
		return vinyls;
	}

	public void setVinyls(List<Vinyl> vinyls) {
		this.vinyls = vinyls;
	}
	
	@JsonProperty("numberOfVinyls")
	public int getNumberOfVinyls() {
		return this.vinyls.size();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Band other = (Band) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Band [id=" + id + ", name=" + name + ", imageUrl=" + imageUrl + "]";
	}

}
