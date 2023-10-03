public class Account implements Filterable
{

    protected double _balance;
    public double getBalance() { return _balance; }


    protected String _name;
    public String getName() { return _name; }


    protected Account _link;
    public Account getLink() { return _link; }


    public Account()
    {
        this("");
    }


    public Account(String name)
    {
        _name = name;
        _balance = 0;
        _link = null;
    }


    public boolean link(Account linkAcct)
    {

        if (linkAcct == null) return false;


        if (this == linkAcct) return false;


        unlink();


        _link = linkAcct;
        linkAcct._link = this;
        return true;
    }



    public void deposit(double amt) throws LinkAccountException
    {
        _balance += amt;
    }


    public void withdraw(double amt) throws InsufficientFundsException
    {

        if (_balance >= amt)
        {
            _balance -= amt;
        }


        else
        {

            if (_link == null)
                throw new InsufficientFundsException("Overdraft with no linked account");


            if (_balance + _link._balance < amt)
                throw new InsufficientFundsException("Not enough funds in accounts");

            amt -= _balance;
            _balance = 0;
            _link.withdraw(amt);
        }
    }



    public void unlink()
    {

        if (_link == null)
            return;


        _link._link = null;
        _link = null;
    }



    public double getMinimum()
    {
        return 0;
    }

    public boolean accept()
    {
        return true;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
            return false;

        if (!(obj instanceof Account that))
            return false;

        if (Math.abs(_balance - that._balance) > 0.001)
            return false;

        if (!_name.equals(that._name))
            return false;

        if (_link != that._link)
            return false;

        return this == obj;
    }

    @Override
    public String toString()
    {
        String retS = "";

        retS += "account: " + _name + "\n";
        retS += "\tBalance: " + _balance + "\n";
        retS += "\tLink account name: " + _link._name;

        return retS;
    }
}