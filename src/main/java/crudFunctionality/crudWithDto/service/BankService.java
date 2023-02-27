package crudFunctionality.crudWithDto.service;

import crudFunctionality.crudWithDto.dto.BankDto;
import crudFunctionality.crudWithDto.model.Bank;

import java.util.List;

public interface BankService {
    Bank createBank (Bank bank);
    Bank getBankById(Long bankId);
    List<BankDto> getAllBank();
    Bank updateBank(BankDto bankDto, Long id);
    void deleteBank(Long bankId);
}
