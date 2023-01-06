package collectionpractice;

/**
 @author EddieZhang
 @create 2022-08-29 18:45
 */
public class MyBook {
    private String bookName;
    private String bookType;
    private double bookPrice;

    @Override
    public String toString() {
        return "book{" +
                "bookName='" + bookName + '\'' +
                ", bookType='" + bookType + '\'' +
                ", bookPrice=" + bookPrice +
                '}';
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public MyBook(String bookName, String bookType, double bookPrice) {
        this.bookName = bookName;
        this.bookType = bookType;
        this.bookPrice = bookPrice;
    }

    public MyBook() {
    }
}
