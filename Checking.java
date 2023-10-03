public class Checking extends Account
{
    public Checking()
    {
        super();
    }




    public Checking(String name)
    {
        super(name);
    }




    @Override
    public boolean link(Account linkAcct)
    {

        if (linkAcct == null) return false;


        if (linkAcct instanceof Checking) return false;

        return super.link(linkAcct);
    }


    @Override
    public boolean accept()
    {
        return _link != null;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == null) return false;

        if (!(obj instanceof Checking)) return false;

        return super.equals(obj);
    }

    @Override
    public String toString()
    {
        return "Checking " + super.toString();
    }
}