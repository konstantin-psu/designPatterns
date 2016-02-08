import pattpack.account.*;

public class Factory2 {

    public static AbstractFactoryIF createFactory(int loginId) {
	if (1000 < loginId && loginId <= 5000)
	    return new AbstractFactoryEconomy ();
//      Standard and professional factories haven't been code, yet
//	else if (5000 < loginId && loginId <= 8000)
//	    factory = new AbstractFactoryStandard ();
//	else if (8000 < loginId && loginId <= 9999)
//	    factory = new AbstractFactoryProfessonal ();
	else 
	    throw new IllegalStateException("Login id "+loginId+" out of range");
    }
}
