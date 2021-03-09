/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcdemo;

import jdbcdemo.Library.Book;
import jdbcdemo.Library.BookAuthors;
import jdbcdemo.Library.BookCopies;
import jdbcdemo.Library.BookLoans;
import jdbcdemo.Library.Borrower;
import jdbcdemo.Library.LibraryBranch;
import jdbcdemo.Library.Publisher;
import jdbcdemo.University.GradeFrame;

/**
 *
 * @author anuturlapati
 */
public class Jdbcdemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //new StudentFrame().setVisible(true);
        //new CourseFrame().setVisible(true);
        //new PrerequisiteFrame().setVisible(true);
        //new SectionFrame().setVisible(true);
        //new GradeFrame().setVisible(true);
        
        //new BookAuthors().setVisible(true);
        //new Book().setVisible(true);
        //new Publisher().setVisible(true);
        //new LibraryBranch().setVisible(true);
        //new Borrower().setVisible(true);
        //new BookCopies().setVisible(true);
        
        new BookLoans().setVisible(true);
    }
    
}
