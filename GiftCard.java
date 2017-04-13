/**
 * This class gets and sets the values of balance and issuingStore, calculates a new value of balance,
 * and formats a String output.
 *
 */

public class GiftCard
{
  private static final int MAX_ID = 9999;

  private double balance;
  private int issuingStore;

  /**
   * This is a constructor that will set the attributes balance and issuingStore. 
   * 
   * @param storeID                       The value to set issuingStore to
   * @param openingBalance                The value to set balance to  
   * @throws IllegalArgumentException     Throws Illegal Argument Exception  
   */
  public GiftCard(int storeID, double openingBalance) throws IllegalArgumentException
  {
    //If the store ID is above 9999 or less than 0, throw an Illegal Argument exception
    //Else, set issuingStore to storeID
    if (storeID < 0 || storeID > MAX_ID)
    {
      throw new IllegalArgumentException("Illegal Store ID: " + storeID);
    }
    else
    {
      issuingStore = storeID;
    }

    //If the initial balance of the gift card is below $0.00, throw and Illegal Argument Exception
    //If the opening balance is greater than 0.00, set balance to openingBalance
    if (openingBalance < 0.00)
    {
      throw new IllegalArgumentException("Illegal Balance: " + openingBalance);
    }
    else
    {
      balance = openingBalance;
    }
  }

  /**
   * This method deducts a value from the balance variable. 
   * 
   * @param amount    The amount to deduct from the balance variable. 
   * @return          The new balance after an amount has been deducted from the initial balance
   *                  formatted as a string. 
   */
  public String deduct(double amount)
  {
    String result;

    //If the amount to deduct is less than 0.0, return the String "Invalid Transaction" 
    if (amount < 0.0)
    {
      result = "Invalid Transaction";
    }
    //Else deduct the amount and return the new balance in a formatted string. 
    else
    {
      balance -= amount;

      if (balance < 0.0)
      {
        result = "Amount Due: " + String.format("%6.2f", Math.abs(balance));
        balance = 0.0;
      }
      else
      {
        result = "Remaining Balance: " + String.format("%6.2f", Math.abs(balance));
      }
    }

    return result;
  }

  /**
   * This is the accessor method for the balance attribute. This method is how other classes would 
   * have access to the balance attribute. 
   * 
   * @return   The value of balance. 
   */
  public double getBalance()
  {
    return balance;
  }

  /**
   * This is the accessor method for the issuingStore attribute 
   * 
   * @return   The value of issuingStore. 
   */
  public int getIssuingStore()
  {
    return issuingStore;
  }
}
