package com.lisa.demo.mappers;


import com.lisa.demo.dtos.transaction.TransactionGetDto;
import com.lisa.demo.entities.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TransactionMapper {

    TransactionGetDto fromEntity(Transaction transaction);
}
