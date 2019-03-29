public class Book {
    private long ISBN;
    private int yearPublished;

    private String name;
    private String author;
    private String genre;
    private  condition condition;

    protected enum condition {OLD, NEW}

    public Book() {
    }

    public Book(String name, String author, String genre, int yearPublished, long ISBN, condition condition) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.yearPublished = yearPublished;
        this.ISBN = ISBN;
        this.condition=condition;
    }

    public Book.condition getCondition() {
        return condition;
    }

    public void setCondition(Book.condition condition) {
        this.condition = condition;
    }
    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    public int compareToName(Book p) {
        int difference = this.name.compareToIgnoreCase(p.name);
        return difference;
    }
    public long compareToISBN(Book p) {
        Long thisISBN = new Long(this.ISBN);
        Long argISBN = new Long(p.ISBN);
        int difference = thisISBN.compareTo(argISBN);
        return difference;
    }
    public int compareToYear(Book p) {
        Integer thisYear = new Integer(this.yearPublished);
        Integer argYear = new Integer(p.yearPublished);
        int difference = thisYear.compareTo(p.yearPublished);
        return difference;
    }
    public int compareToGenre(Book p) {
        int difference = this.genre.compareToIgnoreCase(p.genre);
        return difference;
    }
    public int compareToAuthor(Book p) {
        int difference = this.author.compareToIgnoreCase(p.author);
        return difference;
    }
    public int compareToCondition(Book p){
        int difference = this.condition.compareTo(p.condition);
        return difference;
    }
    @Override
    public String toString() {
        return "Book{" +
                "ISBN=" + ISBN +
                ", yearPublished=" + yearPublished +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", condition=" + condition +
                '}';
    }
}
