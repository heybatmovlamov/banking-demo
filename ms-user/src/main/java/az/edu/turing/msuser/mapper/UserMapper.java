package az.edu.turing.msuser.mapper;

import az.edu.turing.msuser.model.dto.UserRegisterRequest;
import az.edu.turing.msuser.model.dto.UserRegisterResponse;
import az.edu.turing.msuser.domain.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    UserEntity toUserEntity(UserRegisterRequest userRegisterRequest);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "fin", target = "fin")
    @Mapping(source = "fullName", target = "fullName")
    @Mapping(source= "password", target = "password")
    @Mapping(source= "email", target = "email")
    UserRegisterResponse toUserDto(UserEntity userEntity);
}
