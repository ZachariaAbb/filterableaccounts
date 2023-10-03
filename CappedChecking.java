public class CappedChecking extends Checking
{

    static final double max_Amount = 10000;


    public CappedChecking()
    {
        super();
    }




    public CappedChecking(String Name)
    {
        super(Name);
    }


    public void deposit(double amt) throws LinkAccountException
    {

        if (_balance + amt <= max_Amount)
        {
            _balance += amt;
        }


        else
        {

            if (_link == null) throw new LinkAccountException("Overflowed, no linked account");


            amt -= (max_Amount - _balance);
            _balance = max_Amount;
            _link.deposit(amt);
        }

    }



    @Override
    public boolean equals(Object obj)
    {
        if (obj == null) return false;

        if (!(obj instanceof CappedChecking)) return false;

        return super.equals(obj);
    }

    @Override
    public String toString()
    {
        return "Capped-Checking " + super.toString();
    }
}