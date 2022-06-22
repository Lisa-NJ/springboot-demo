package com.lisa.demo.mappers;

import com.lisa.demo.dtos.account.AccountGetDto;
import com.lisa.demo.entities.Account;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountMapper {

    AccountGetDto fromEntity(Account account);
}
