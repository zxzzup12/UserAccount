package kr.ac.shinhan.esp;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("UserAccount")
public class UserAccountService {
	private static PersistenceManagerFactory PMF;

	public UserAccountService()
	{
		PMF = JDOHelper.getPersistenceManagerFactory("transactions-optional");
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUserAccount(UserAccount  account)
	{
		PersistenceManager pm = PMF.getPersistenceManager();
		pm.makePersistent(account);
		
		
		Result result = new Result(true,"Success");
		Response response = Response.ok().entity(result).build();
		return response;

	}

	

}
