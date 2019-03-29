import java.util.EmptyStackException;
import java.util.Scanner;

public class LibraryManager {
 static BooksStack stackingBooks = new BooksStack();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Book b = new Book();
        System.out.println("Hi, Hope all is good with you?");
        System.out.println("Please begin using your program");
        String input = "";
        /**
         * while loop to help the user navigate
         * through the program, it is accompanied with a switch format.
         */
        while (!input.equalsIgnoreCase("Q")) {

            System.out.println("(A)-Add Book");
            System.out.println("(R)-Remove Book");
            System.out.println("(G)-See Book");
            System.out.println("(P)-Print Books");
            System.out.println("(S)-Sort Books");
            System.out.println("(Q)-Quit");
            System.out.println("Please select an option:");
            input = sc.nextLine();
            switch (input) {
                case "A":
                   try{
                       System.out.println("Please enter the name: ");
                       String name = sc.nextLine();
                       System.out.println("Please enter the author: ");
                       String author = sc.nextLine();
                       System.out.println("Please enter the genre: ");
                       String genre = sc.nextLine();
                       System.out.println("Please enter the year it was published: ");
                       int year = sc.nextInt();
                       System.out.println("Please enter the ISBN Number: ");
                       long ISBN = sc.nextInt();
                       System.out.println("Please enter the condition (OLD or NEW): ");
                       String v = sc.next();
                       Book newBook =  new Book(name,author, genre, year, ISBN,v.equalsIgnoreCase("OLD") ? Book.condition.OLD : Book.condition.NEW);
                       stackingBooks.push(newBook);
                   }
                   catch(BookAlreadyExistsException e ){
e.printStackTrace();
                   }
                   catch(FullStackException e ){
                       e.printStackTrace();
                   }
                    break;
                case"R":
                    try{
                    System.out.println("Please enter the name of the book at the end: ");
                    String name = sc.nextLine();
                        stackingBooks.pop();
                    System.out.println(name+" has been removed!");}
                    catch(EmptyStackException e){
                        e.printStackTrace();
                    }
                    break;
                case "G":
                    System.out.println("Please enter the name of the book: ");
                    String name = sc.nextLine();
stackingBooks.seeBook(name);
                    break;
                case"P":
                    stackingBooks.printTable();
                    System.out.println("Your table has been successfully printed");
                    break;
                case"S":
                    System.out.println("(N)-Name");
                    System.out.println("(A)-Author");
                    System.out.println("(G)-Genre");
                    System.out.println("(Y)-Year");
                    System.out.println("(C)-Condition");
                    System.out.println("(I)-ISBN Number");
                    System.out.println("Please select an option:");
                    input = sc.nextLine();
                    if(input.equals("N")){
                        stackingBooks.sortName();
                        System.out.println("Your table has been sorted by Name");
                    }
                   else if(input.equals("A")){
                        stackingBooks.sortAuthor();
                        System.out.println("Your table has been sorted by Author");

                    }
                    else if(input.equals("G")){
                        stackingBooks.sortGenre();
                        System.out.println("Your table has been sorted by Genre");

                    }
                    else if(input.equals("Y")){
                        stackingBooks.sortYear();
                        System.out.println("Your table has been sorted by Year");

                    }
                    else if(sc.nextLine().equals("C")){
                        stackingBooks.sortCondition();
                        System.out.println("Your table has been sorted by Condition");

                    }
                    else if(sc.nextLine().equals("I")){
                        stackingBooks.sortISBN();
                        System.out.println("Your table has been sorted by ISBN Number");
                    }
                    break;
                case"Q":
                    System.out.println("Your program is about to terminate, i hope you enjoyed your latest version of library manager");
                    System.exit(0);
                    break;
            }
        }
    }
}