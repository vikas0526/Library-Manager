import java.util.EmptyStackException;

public class BooksStack {
    private int MAX = 1000;
    private Book[] books = new Book[MAX];
    private int top = -1;
    Book bookAccess = new Book();

    public void push(Book newBook) throws FullStackException, BookAlreadyExistsException {
        if (top == MAX - 1)
            throw new FullStackException();
        if (checkExistance(newBook))
            throw new BookAlreadyExistsException();
        top++;
        books[top] = newBook;

    }

    public boolean checkExistance(Book newBook) {
       if(isEmpty()){
           return false;
       }
        for (int i = 0; i < top; i++) {
            if (books[i].getName().equalsIgnoreCase(newBook.getName())) {
                return true;
            }
        }
        return false;
    }


    public Book pop() throws EmptyStackException {
        Book removeBook;
        if (isEmpty())
            throw new EmptyStackException();
        removeBook = books[top];
        books[top] = null;
        top--;
        return removeBook;

    }

    public Book peek() throws EmptyStackException {
        Book toCheck;
        if (isEmpty())
            throw new EmptyStackException();
        toCheck = books[top];
        return toCheck;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public int size() {

        return top;
    }
    public void seeBook(String name){
        for (int i = 0; i < books.length-1; i++) {
            if (books[i].getName().equalsIgnoreCase(name))
                System.out.println("name: "+books[i].getName()+" Author: "+books[i].getAuthor()+" Genre: "+books[i].getGenre()+" Year Published: "+books[i].getYearPublished()+" Condition: "+books[i].getCondition()+" ISBN Number: "+books[i].getISBN());
break;
        }
    }

    public void sortName() {

        Book temp;
        for (int i = 0; i < top; i++) {
            for (int j = i + 1; j <= top; j++) {
                if (books[i].compareToName(books[j]) > 0) {
                    temp = books[i];
                    books[i] = books[j];
                    books[j] = temp;
                }
            }
        }
    }

    public void sortAuthor() {

        Book temp;
        for (int i = 0; i < top; i++) {
            for (int j = i + 1; j <= top; j++) {
                if (books[i].compareToAuthor(books[j]) > 0) {
                    temp = books[i];
                    books[i] = books[j];
                    books[j] = temp;
                }
            }
        }
    }

    public void sortGenre() {


        for (int z = 0; z < top; z++) {
            for (int j = z + 1; j <= top; j++) {
                if (books[z].compareToGenre(books[j]) > 0) {
                    Book temp = books[z];
                    books[z] = books[j];
                    books[j] = temp;
                }
            }
        }
    }

    public void sortISBN() {

        for (int i = 0; i < top; i++) {
            for (int j = 0; j < top; j++)
                if (books[j].compareToISBN(books[j + 1]) > 0) {
                    Book temp2 = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp2;
                }
        }
    }

    public void sortYear() {

        for (int i = 0; i < top; i++)
            for (int j = 0; j < top; j++) {
                if (books[j].compareToYear(books[j + 1]) > 0) {
                    Book temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
    }

    public void sortCondition() {

        for (int i = 0; i < top; i++) {
            for (int j = 0; j < top; i++) {
                if (books[j].compareToCondition(books[j + 1]) > 0) {
                    Book temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }
    }

    public void printTable() {
        System.out.format("%10s%15s%18s%10s%15s%20s\n", "Name", "Author", "Genre", "Year", "ISBN Number","Condition");
        System.out.println("=======================================================================================");
        for (int i = 0; i <= top; i++) {
            System.out.format("%10s%15s%18s%10d%15d%20s\n", books[i].getName(), books[i].getAuthor(), books[i].getGenre(), books[i].getYearPublished(), books[i].getISBN(),books[i].getCondition());

        }
    }
}
