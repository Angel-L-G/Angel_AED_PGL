package es.iespto.angel.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the suppliers database table.
 * 
 */
@Entity
@Table(name="suppliers")
@NamedQuery(name="Supplier.findAll", query="SELECT s FROM Supplier s")
public class Supplier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SupplierID", unique=true, nullable=false)
	private int supplierID;

	@Column(name="Address", nullable=false, length=60)
	private String address;

	@Column(name="City", nullable=false, length=15)
	private String city;

	@Column(name="CompanyName", nullable=false, length=40)
	private String companyName;

	@Column(name="ContactName", nullable=false, length=30)
	private String contactName;

	@Column(name="ContactTitle", nullable=false, length=30)
	private String contactTitle;

	@Column(name="Country", nullable=false, length=15)
	private String country;

	@Column(name="Fax", nullable=false, length=24)
	private String fax;

	@Column(name="HomePage", nullable=false, length=255)
	private String homePage;

	@Column(name="Phone", nullable=false, length=24)
	private String phone;

	@Column(name="PostalCode", nullable=false, length=10)
	private String postalCode;

	@Column(name="Region", nullable=false, length=15)
	private String region;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="supplier")
	private List<Product> products;

	public Supplier() {
	}

	public int getSupplierID() {
		return this.supplierID;
	}

	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactTitle() {
		return this.contactTitle;
	}

	public void setContactTitle(String contactTitle) {
		this.contactTitle = contactTitle;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getHomePage() {
		return this.homePage;
	}

	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setSupplier(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setSupplier(null);

		return product;
	}

}