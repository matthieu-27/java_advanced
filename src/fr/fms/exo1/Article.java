package fr.fms.exo1;

public class Article {
	
	protected int idArticle;
	protected String description;
	protected String brand;
	protected double unitaryPrice;
	
	public Article(int idArticle, String description, String brand, double unitaryPrice) {
		this.idArticle = idArticle;
		this.description = description;
		this.brand = brand;
		this.unitaryPrice = unitaryPrice;
	}
	
	/**
	 * @return the idArticle
	 */
	public int getIdArticle() {
		return idArticle;
	}

	/**
	 * @param idArticle the idArticle to set
	 */
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return the unitaryPrice
	 */
	public double getUnitaryPrice() {
		return unitaryPrice;
	}

	/**
	 * @param unitaryPrice the unitaryPrice to set
	 */
	public void setUnitaryPrice(double unitaryPrice) {
		this.unitaryPrice = unitaryPrice;
	}

}
