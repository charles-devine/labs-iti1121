public class Book {

    // Your variables declaration here
    private String author; 
    private String title; 
    private int year;

    public Book(String author, String title, int year) {
        // Your code here
        this.author = author; 
        this.title = title; 
        this.year = year; 
    }

    public String getAuthor() {
        // Your code here
        return author; 
    }

    public String getTitle() {
        // Your code here
        return title; 
    }

    public int getYear() {
        // Your code here
        return year; 
    }

    @Override
    public boolean equals(Object other) {
        // Your code here
        if(other instanceof Book) { 
            Book book = (Book)other;

            if (this.author == null || this.title == null || this.year == 0) { 
                if(book.author == null || book.title == null || book.year == 0) { 
                    return (this.author == book.author) && (this.title == book.title) && (this.year == book.year); 
                } else { 
                    return false; 
                    }
                }

                return (this.getAuthor().equals(book.getAuthor())) && (this.getTitle().equals(book.getTitle())) && (this.getYear() == book.getYear()); 

            } else { 
                return false; 
            }

    }

    public String toString() {
        // Your code here
        return " " + author + " : " + title + " (" + year + ") "; 
    }
}