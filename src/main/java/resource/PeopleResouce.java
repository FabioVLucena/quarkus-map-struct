package resource;

import java.util.List;
import java.util.Objects;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import dto.PeopleDTO;
import entity.PeopleEntity;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;
import mapper.PeopleMapper;
import service.PeopleService;

@Path("/people")
public class PeopleResouce {

	private static final Logger log = Logger.getLogger(PeopleResouce.class);
	
	@Autowired
	private PeopleService peopleService;
	
	@Inject
	private PeopleMapper peopleMapper;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createEnterprise(PeopleEntity enterprisePeople, @Context UriInfo uriInfo) {
		enterprisePeople = peopleService.createPeople(enterprisePeople);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(enterprisePeople.getId().toString());
		log.info("New people created with URI " + builder.build().toString());
		return Response.created(builder.build()).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllEnterprises() {
		List<PeopleEntity> enterpriseEntityList = peopleService.findAllPeople();

		if (enterpriseEntityList.isEmpty() == false) {
			List<PeopleDTO> peopleDTOList = peopleMapper.toDtoList(enterpriseEntityList);
			return Response.ok(peopleDTOList).build();
		} else {
			return Response.noContent().build();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response getEnterprise(@PathParam("id") Long id) {
		if (Objects.nonNull(id)) {
			PeopleEntity enterpriseEntity = peopleService.findPeopleById(id);
			
			if (Objects.nonNull(enterpriseEntity)) {
				return Response.ok(enterpriseEntity).build();
			} else {
				return Response.noContent().build();
			}
		}

		return Response.status(Response.Status.BAD_REQUEST).build();
	}
}
