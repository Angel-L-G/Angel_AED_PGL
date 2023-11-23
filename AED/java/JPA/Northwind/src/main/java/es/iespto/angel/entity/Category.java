package es.iespto.angel.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categories database table.
 * 
 */
@Entity
@Table(name="categories")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CategoryID", unique=true, nullable=false)
	private byte categoryID;

	@Column(name="CategoryName", nullable=false, length=15)
	private String categoryName;

	@Lob
	@Column(name="Description", nullable=false)
	private String description;

	@Column(name="Picture", nullable=false, length=50)
	private String picture;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="category", fetch = FetchType.LAZY)
	private List<Product> products;

	public Category() {
	}

	public byte getCategoryID() {
		return this.categoryID;
	}

	public void setCategoryID(byte categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setCategory(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setCategory(null);

		return product;
	}

}