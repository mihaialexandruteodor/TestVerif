package app;// app.Transaction.java
// Abstract superclass app.Transaction represents an app.ATM transaction

public abstract class Transaction
{
   private int accountNumber; // indicates account involved
   protected Screen screen; // app.ATM's screen
   private BankDatabase bankDatabase; // account info database

   // app.Transaction constructor invoked by subclasses using super()
   public Transaction(int userAccountNumber, Screen atmScreen, 
      BankDatabase atmBankDatabase)
   {
      accountNumber = userAccountNumber;
      screen = atmScreen;
      bankDatabase = atmBankDatabase;
   } // end app.Transaction constructor

   // return account number 
   public int getAccountNumber()
   {
      return accountNumber; 
   } // end method getAccountNumber

   // return reference to screen
   public Screen getScreen()
   {
      return screen;
   } // end method getScreen

   // return reference to bank database
   public BankDatabase getBankDatabase()
   {
      return bankDatabase;
   } // end method getBankDatabase

   // perform the transaction (overridden by each subclass)
   abstract public void execute();
} // end class app.Transaction

