package org.jpa.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Book {
    @Id
    private Long id;
    private String title;
    private String description;
    private Float unitCost;
    private String isbn;
    private Integer nbOfPage;

    public Book() {
    }

    public Book(Long id) {
        this.id = id;
    }

    public Book(Long id, String title, String description, Float unitCost, String isbn, Integer nbOfPage) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.unitCost = unitCost;
        this.isbn = isbn;
        this.nbOfPage = nbOfPage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Float getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(Float unitCost) {
        this.unitCost = unitCost;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getNbOfPage() {
        return nbOfPage;
    }

    public void setNbOfPage(Integer nbOfPage) {
        this.nbOfPage = nbOfPage;
    }

    // ======================================
    // =    hashcode, equals & toString     =
    // ======================================

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!Objects.equals(description, book.description)) return false;
        if (!Objects.equals(id, book.id)) return false;
        if (!Objects.equals(isbn, book.isbn)) return false;
        if (!Objects.equals(nbOfPage, book.nbOfPage)) return false;
        if (!Objects.equals(title, book.title)) return false;
        return Objects.equals(unitCost, book.unitCost);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (unitCost != null ? unitCost.hashCode() : 0);
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        result = 31 * result + (nbOfPage != null ? nbOfPage.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", unitCost=" + unitCost +
                ", isbn='" + isbn + '\'' +
                ", nbOfPage=" + nbOfPage +
                '}';
    }

    //    @Override
//    public String toString() {
//        final StringBuilder sb = new StringBuilder("Book{");
//        sb.append("id=").append(id);
//        sb.append(", title='").append(title).append('\'');
//        sb.append(", description='").append(description).append('\'');
//        sb.append(", unitCost=").append(unitCost);
//        sb.append(", isbn='").append(isbn).append('\'');
//        sb.append(", nbOfPage=").append(nbOfPage);
//        sb.append('}');
//        return sb.toString();
//    }
}
