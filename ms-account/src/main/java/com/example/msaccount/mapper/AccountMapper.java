package com.example.msaccount.mapper;



import com.example.msaccount.model.dto.AccountDto;
import com.example.msaccount.model.response.AccountResponse;
import com.example.msaccount.model.request.AccountTransferRequest;
import com.example.msaccount.dao.entity.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {
//    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    AccountDto entityToDto(AccountEntity accountEntity);

    List<AccountDto> entityListToDtoList(List<AccountEntity> accountEntities);

    AccountEntity dtoToEntity(AccountDto accountDto);

    void updateEntityFromDto(AccountDto accountDto, @MappingTarget AccountEntity accountEntity);

    AccountResponse entityToAccountResponse(AccountEntity accountEntity);

    List<AccountResponse> entityListToAccountResponseList(List<AccountEntity> accountEntity);


    AccountTransferRequest entityToAccountTransferRequest(AccountEntity accountEntity);
}
