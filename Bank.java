import java.util.ArrayList;

public class Bank
{
    private ArrayList<Account> accounts = new ArrayList<Account>();




    public boolean addAccount(Account acct)
    {

        if (acct == null) return false;


        if (accounts.contains(acct)) return false;


        accounts.add(acct);
        return true;
    }




    public ArrayList<Account> getFiltered()
    {
        ArrayList<Account> filteredList = new ArrayList<Account>();


        for(Account acct : accounts)
        {
            if (acct.accept()) filteredList.add(acct);
        }


        return filteredList;
    }




    public int size()
    {
        return accounts.size();
    }
}


