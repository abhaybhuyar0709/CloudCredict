package com.banking;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    private static double balance = 1000.0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Online Banking System");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Prompt user for name and bank account number
        String userName = JOptionPane.showInputDialog(frame, "Enter your name:");
        String accountNumber = JOptionPane.showInputDialog(frame, "Enter your bank account number:");

        JLabel welcomeLabel = new JLabel("Welcome to the Online Banking System, " + userName);
        welcomeLabel.setBounds(50, 20, 300, 30);
        frame.add(welcomeLabel);

        JLabel accountLabel = new JLabel("Account Number: " + accountNumber);
        accountLabel.setBounds(50, 50, 300, 30);
        frame.add(accountLabel);

        JButton checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.setBounds(50, 90, 300, 30);
        frame.add(checkBalanceButton);

        JButton depositButton = new JButton("Deposit");
        depositButton.setBounds(50, 130, 300, 30);
        frame.add(depositButton);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(50, 170, 300, 30);
        frame.add(withdrawButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(50, 210, 300, 30);
        frame.add(exitButton);

        JTextArea outputArea = new JTextArea();
        outputArea.setBounds(50, 250, 300, 30);
        outputArea.setEditable(false);
        frame.add(outputArea);

        checkBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputArea.setText("Your balance is $" + balance);
            }
        });

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String amountStr = JOptionPane.showInputDialog(frame, "Enter amount to deposit:");
                if (amountStr != null && !amountStr.isEmpty()) {
                    double depositAmount = Double.parseDouble(amountStr);
                    balance += depositAmount;
                    outputArea.setText("You have deposited $" + depositAmount);
                }
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String amountStr = JOptionPane.showInputDialog(frame, "Enter amount to withdraw:");
                if (amountStr != null && !amountStr.isEmpty()) {
                    double withdrawAmount = Double.parseDouble(amountStr);
                    if (withdrawAmount <= balance) {
                        balance -= withdrawAmount;
                        outputArea.setText("You have withdrawn $" + withdrawAmount);
                    } else {
                        outputArea.setText("Insufficient balance.");
                    }
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Thank you for using the Online Banking System. Goodbye!");
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }
}