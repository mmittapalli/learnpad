package lambdas;

public class Book {
	private String name;
	private int    pages;
	private String authFirstName;
	private String authLastName;

	Book(String name, int pages, String authFirstName, String authLastName) {
		this.name = name;
		this.pages = pages;
		this.authFirstName = authFirstName;
		this.authLastName = authLastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getAuthFirstName() {
		return authFirstName;
	}

	public void setAuthFirstName(String authFirstName) {
		this.authFirstName = authFirstName;
	}

	public String getAuthLastName() {
		return authLastName;
	}

	public void setAuthLastName(String authLastName) {
		this.authLastName = authLastName;
	}

	@Override
	public String toString() {
		return name;
	}
}
