package crudFunctionality.crudWithDto.controller;

import crudFunctionality.crudWithDto.dto.BankDto;
import crudFunctionality.crudWithDto.dto.CreateBankDto;
import crudFunctionality.crudWithDto.exception.RecordNotFoundException;
import crudFunctionality.crudWithDto.model.Bank;
import crudFunctionality.crudWithDto.service.BankService;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banking")
public class BankController {
    @Autowired
    BankService bankService;
    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<BankDto>> findAll() {
        List<BankDto> bankDtoList = bankService.getAllBank();
        return new ResponseEntity<>(bankDtoList, HttpStatus.OK);
    }

    @GetMapping("/bank/{id}")
    public ResponseEntity<BankDto> getBank(@PathVariable(name = "id") Long id) {
        Bank bank = bankService.getBankById(id);
        BankDto bankDto = modelMapper.map(bank, BankDto.class);
        return ResponseEntity.ok().body(bankDto);
    }

    @PostMapping
    public ResponseEntity<String> createBank(@RequestBody CreateBankDto createBankDto) {
        Bank bank = modelMapper.map(createBankDto, Bank.class);
        bankService.createBank(bank);
        return new ResponseEntity<>("Successfully created", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bank> update(@RequestBody BankDto bankDto, @PathVariable long id) throws RecordNotFoundException {
        return new ResponseEntity<>(bankService.updateBank(bankDto, id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long bankId) throws  RecordNotFoundException{
       bankService.deleteBank(bankId);
        return new ResponseEntity<>("Sucessfully deleted!",HttpStatus.OK);
    }
}
