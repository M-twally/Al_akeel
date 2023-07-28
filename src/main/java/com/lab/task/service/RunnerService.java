package com.lab.task.service;

import javax.ejb.EJBException;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.lab.task.model.Runner;
import com.lab.task.repo.RunnerRepo;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
@Path("/Runner")
public class RunnerService {
    @Inject
    private RunnerRepo repo;
    
    
	@Path("/signUP")
    @POST
	public String signUp(Runner runner) {
		try {
			if(repo.CheckUserExist(runner.getEmail(), runner.getPassword())) {
			  runner.setRole("Runner");
			  runner.setStatus(true);
			  repo.insert(runner);
			  return "SIGNUP SUCCESSFULLY ! " + runner.getName() +" Your id IS :"+runner.getId() + " Your Role: "+ runner.getRole();
			}
			return "User Already Exist!";
		} catch (Exception e) {
			throw new EJBException(e);
		}
  }
    
}
