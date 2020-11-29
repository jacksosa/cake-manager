package com.waracle.cakemgr.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
@Table(name = "cakes")
public class Cake implements Serializable {

	private static final long serialVersionUID = 4640259886493684570L;

	@SerializedName("desc")
	@Expose
	@Column(name = "description", unique = false, nullable = false, length = 100)
	@Size(min = 1, max = 300, message = "Enter a desc less than 300 chars")
	private String description;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SerializedName("id")
	@Expose
	@Column(name = "id", unique = true, nullable = false)
	private long id;

	@SerializedName("image")
	@Expose
	@Column(name = "image", unique = false, nullable = false, length = 300)
	@Size(min = 1, max = 300, message = "Enter a url less than 300 chars")
	private String image;

	@SerializedName("title")
	@Expose
	@Column(name = "title", unique = true, nullable = false, length = 100)
	@Size(min = 1, max = 100, message = "Enter a title less than 100 chars")
	private String title;

	public Cake() {
	}

	public Cake(String title, String description, String image) {
		super();
		this.title = title;
		this.description = description;
		this.image = image;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Cake)) {
			return false;
		}
		Cake other = (Cake) obj;
		return Objects.equals(description, other.description) && this.id == other.id
				&& Objects.equals(image, other.image) && Objects.equals(title, other.title);
	}

	public String getDescription() {
		return description;
	}

	public long getId() {
		return this.id;
	}

	public String getImage() {
		return image;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, image, title);
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Cake [desc=" + this.description + ", id=" + this.id + ", image=" + this.image + ", title=" + this.title
				+ "]";
	}
}