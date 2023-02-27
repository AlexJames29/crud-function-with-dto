package crudFunctionality.crudWithDto.service;

import crudFunctionality.crudWithDto.dto.BankDto;
import crudFunctionality.crudWithDto.exception.RecordNotFoundException;
import crudFunctionality.crudWithDto.model.Bank;
import crudFunctionality.crudWithDto.repository.BankRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankImpl implements BankService {

    @Autowired
    private BankRepository bankRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Bank createBank(Bank bank) {
        return bankRepository.save(bank);
    }

    @Override
    public Bank getBankById(Long bankId) {
        Optional<Bank> optionalBank =bankRepository.findById(bankId);
        return optionalBank.get();
    }

    @Override
    public List<BankDto> getAllBank() {
        List<Bank> bankList = bankRepository.findAll();
        return bankList.stream().map(data-> modelMapper.map(data,BankDto.class)).toList();
    }

    @Override
    public Bank updateBank(BankDto bankDto, Long id) {
        Bank bank = bankRepository.findById(id).orElseThrow(()-> new RecordNotFoundException("Record not found"));
        bank.setName(bankDto.getName());
        bank.setGender(bankDto.getGender());
        bank.setNationality(bankDto.getNationality());
        bank.setAge(bankDto.getAge());
        return bankRepository.save(bank);
    }

    @Override
    public void deleteBank(Long bankId) {
        Bank bank = bankRepository.findById(bankId).orElseThrow(()-> new RecordNotFoundException("Record not found"));
        bankRepository.save(bank);

    }
}
