package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class LibraryManagementSystem extends JFrame {
    private List<Book> books;
    private DefaultListModel<String> bookListModel;
    private JList<String> bookList;

    public LibraryManagementSystem() {
        books = new ArrayList<>();
        initializeBooks();

        setTitle("Library Management System");
        setSize(600, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        JButton viewBooksButton = new JButton("View Books");
        viewBooksButton.setFont(new Font("Arial", Font.PLAIN, 16));
        viewBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewBooks();
            }
        });

        JButton borrowBookButton = new JButton("Borrow Book");
        borrowBookButton.setFont(new Font("Arial", Font.PLAIN, 16));
        borrowBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borrowBook();
            }
        });

        JButton returnBookButton = new JButton("Return Book");
        returnBookButton.setFont(new Font("Arial", Font.PLAIN, 16));
        returnBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                returnBook();
            }
        });

        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.PLAIN, 16));
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panel.add(viewBooksButton);
        panel.add(borrowBookButton);
        panel.add(returnBookButton);
        panel.add(exitButton);

        add(panel);
    }

    private void initializeBooks() {
        books.add(new Book("Effective Java", "Joshua Bloch", "978-0134685991"));
        books.add(new Book("Clean Code", "Robert C. Martin", "978-0132350884"));
        books.add(new Book("Design Patterns", "Erich Gamma", "978-0201633610"));
    }

    private void updateBookListModel() {
        bookListModel.clear();
        for (Book book : books) {
            bookListModel.addElement(book.getTitle() + " by " + book.getAuthor());
        }
    }

    private void viewBooks() {
        bookListModel = new DefaultListModel<>();
        updateBookListModel();
        bookList = new JList<>(bookListModel);
        JOptionPane.showMessageDialog(this, new JScrollPane(bookList), "List of Available Books", JOptionPane.INFORMATION_MESSAGE);
    }

    private void borrowBook() {
        String title = JOptionPane.showInputDialog(this, "Enter the title of the book you want to borrow:");
        if (title != null && !title.trim().isEmpty()) {
            for (Book book : books) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    books.remove(book);
                    updateBookListModel();
                    JOptionPane.showMessageDialog(this, "You have borrowed: " + book.getTitle());
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Book not found.");
        }
    }

    private void returnBook() {
        JTextField titleField = new JTextField();
        JTextField authorField = new JTextField();
        JTextField isbnField = new JTextField();
        Object[] message = {
            "Title:", titleField,
            "Author:", authorField,
            "ISBN:", isbnField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Return Book", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String title = titleField.getText();
            String author = authorField.getText();
            String isbn = isbnField.getText();
            books.add(new Book(title, author, isbn));
            updateBookListModel();
            JOptionPane.showMessageDialog(this, "You have returned: " + title);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LibraryManagementSystem().setVisible(true);
            }
        });
    }

    public void initialize() {
        throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    }

    public Object getBooks() {
        throw new UnsupportedOperationException("Unimplemented method 'getBooks'");
    }

    public void addBook(String string, String string2) {
        throw new UnsupportedOperationException("Unimplemented method 'addBook'");
    }

    public void removeBook(String string) {
        throw new UnsupportedOperationException("Unimplemented method 'removeBook'");
    }

    public Object findBook(String string) {
        throw new UnsupportedOperationException("Unimplemented method 'findBook'");
    }
}