package com.servicemesh.devops.demo.quickquote;

import com.servicemesh.devops.demo.quickquote.hibernate.ActionType;
import com.servicemesh.devops.demo.quickquote.hibernate.GenericDAO;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.core.Response;

import com.servicemesh.devops.demo.quickquote.hibernate.InsuranceType;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;

@Path("/quote")
public class QuoteResource {

    @Path("/1")
    @GET
    @Produces("text/html")
    public Response getInsuranceTypes() {
        return Response.ok(getInsuranceTypesData()).build();
    }

    public String getInsuranceTypesData() {
        GenericDAO<InsuranceType> dao = new GenericDAO(InsuranceType.class);

        StringBuilder buffer = new StringBuilder();
        String radio = "<input type=\"radio\" name=\"group1\" value=\"%s\">%s</input><br>";
        for (InsuranceType item : dao.list()) {
            buffer.append(String.format(radio, item.getValue(), item.getValue()));
        }
        return buffer.toString();
    }

    @Path("/2")
    @GET
    @Produces("text/html")
    public Response getActionTypes() {
        return Response.ok(getActionTypesData()).build();
    }

    public String getActionTypesData() {

        GenericDAO<ActionType> dao = new GenericDAO(ActionType.class);

        StringBuilder buffer = new StringBuilder();
        String line = "<li>%s</li>\r\n";

        for (ActionType item : dao.list()) {
            buffer.append(String.format(line, item.getValue()));
        }

        return buffer.toString();
    }

    @POST
    @Path("/add")
    public Response add(
            @FormParam("value") String value) {
        
        GenericDAO<ActionType> dao = new GenericDAO(ActionType.class);
        ActionType a = new ActionType();
        a.setValue(value);
        dao.save(a);
        try {
            return Response.seeOther(new URI("../index.jsp")).build();
        } catch (URISyntaxException ex) {
            Logger.getLogger(QuoteResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.serverError().build();
    }
}
