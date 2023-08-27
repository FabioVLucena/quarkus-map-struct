package mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import dto.PeopleDTO;
import entity.PeopleEntity;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PeopleMapper {

  PeopleEntity toEntity(PeopleDTO peopleDTO);

  PeopleDTO toDto(PeopleEntity people);

  List<PeopleEntity> toEntityList(List<PeopleDTO> peopleDTOList);

  List<PeopleDTO> toDtoList(List<PeopleEntity> peopleList);

}