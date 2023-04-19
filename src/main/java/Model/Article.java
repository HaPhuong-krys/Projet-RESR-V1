 package Model;

public class Article {
	
	private int id;
    private String libelle;
    private String marque;
    private double prix;
    private String categorie;
    private String photo;
    private String description;

    public Article(){

    }
    
    public Article (int id, String libelle, String marque, double prix, String categorie, String photo, String description){
        this.id = id;
    	this.libelle = libelle;
        this.marque = marque;
        this.prix = prix;
        this.categorie = categorie;
        this.photo = photo;
        this.description = description;
    }
    
    public int getId() {
    	return this.id;
    }
    
    public void setId(int id) {
    	this.id = id;
    }

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
    
	public String getPhoto() {
		return this.photo;
	}
	
	public void setPhoto(String photo) {
		this.photo = photo;
	}


}