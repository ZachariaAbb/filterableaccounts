/*
* @Zacharia Abboud
* <proj6> (File Name)
* <Project 6>
* <Bank account system with multiple account functionality>
*/
public class Main
{
	public static void main(String[] args)
    {
        AccountTester acctTester = new AccountTester();
        BankTester bankTester = new BankTester();

		System.out.println("\nAccount Tests:\n");
        acctTester.runAll();
        
		System.out.println("\nBank Tests:\n");
        bankTester.runAll();
	}
}
