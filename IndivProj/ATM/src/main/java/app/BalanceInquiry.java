package app;


// app.BalanceInquiry.java
// Represents a balance inquiry app.ATM transaction

public class BalanceInquiry extends Transaction
{
   // app.BalanceInquiry constructor
   public BalanceInquiry(int userAccountNumber, Screen atmScreen, 
      BankDatabase atmBankDatabase)
   {
      super(userAccountNumber, atmScreen, atmBankDatabase);
   } // end app.BalanceInquiry constructor

   // performs the transaction
   @Override
   public void execute()
   {
      // get references to bank database and screen
      BankDatabase bankDatabase = getBankDatabase();
      Screen screen = getScreen();

      // get the available balance for the account involved
      double availableBalance = 
         bankDatabase.getAvailableBalance(getAccountNumber());

      // get the total balance for the account involved
      double totalBalance = 
         bankDatabase.getTotalBalance(getAccountNumber());
      
      // display the balance information on the screen
      
      
      screen.creatBalanceGUI();
      screen.messageJLabel2.setText("Avaliable Balance: " + availableBalance);
      screen.messageJLabel3.setText("Total Balance: " + totalBalance);
      screen.Mainframe.revalidate();
      
   } // end method execute
   
  
} // end class app.BalanceInquiry

