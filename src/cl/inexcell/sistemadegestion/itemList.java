package cl.inexcell.sistemadegestion;

public class itemList {
	 private String title;
	 private String description;
	 
	public itemList(String title, String description) {
	    super();
	    this.setTitle(title);
	    this.setDescription(description);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
