package com.javatpoint.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import Dao.*;
import Dao.DbConnection;

@Path("/CommentService")

public class CommentService {
		
	@POST
	 @Path("/Submitcomments")
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 public String comment(@FormParam("name") String username,
	 @FormParam("comments") String comments) {
		String flag;
		System.out.println(username);
		System.out.println(comments);
		try {
		String[] data= {username,comments};
		DbConnection dbConnect=new DbConnection();
		CommentHandler commentHandle=new CommentHandler();
		flag= commentHandle.InsercommentToDatabase(dbConnect.getConnection(), data, username,comments);
		System.out.println(flag);
		
		

		} catch(Exception e) {
			
			System.out.println("Comment Service Error found : "+e.getMessage());
			
			}
		return "success";
		
		}
	}
