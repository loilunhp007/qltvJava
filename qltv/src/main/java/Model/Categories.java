package Model;

public class Categories {
    private String categoryID,categoryName;

    public Categories() {
    }

    public Categories(String categoryID) {
        this.categoryID = categoryID;
    }

    public Categories(String categoryID, String categoryName) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
