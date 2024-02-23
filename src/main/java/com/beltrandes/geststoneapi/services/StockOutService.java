package com.beltrandes.geststoneapi.services;

import com.beltrandes.geststoneapi.dtos.StockOutDTO;
import com.beltrandes.geststoneapi.dtos.WithdrawStockItemQuantityDTO;
import com.beltrandes.geststoneapi.models.Employee;
import com.beltrandes.geststoneapi.models.StockItem;
import com.beltrandes.geststoneapi.models.StockOut;
import com.beltrandes.geststoneapi.repositories.StockOutRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockOutService {
    @Autowired
    private StockOutRepository stockOutRepository;
    @Autowired
    private StockItemService stockItemService;
    @Autowired
    private EmployeeService employeeService;
    ModelMapper modelMapper = new ModelMapper();

    public List<StockOutDTO> getAll() {
        return stockOutRepository.findAll().stream().map((result) -> modelMapper.map(result, StockOutDTO.class)).toList();
    }

    public void create(WithdrawStockItemQuantityDTO withdrawStockItemQuantityDTO) {
        var stockItem = modelMapper.map(stockItemService.getById(withdrawStockItemQuantityDTO.stockItemId()), StockItem.class);
        var employee = modelMapper.map(employeeService.getById(withdrawStockItemQuantityDTO.employeeId()), Employee.class);
        if (stockItem != null) {
            var stockOut = new StockOut();
            stockOut.setPreviousQuantity(stockItem.getQuantity());
            stockOut.setWithdrawnQuantity(withdrawStockItemQuantityDTO.quantity());
            if (employee != null) {
                stockOut.setEmployee(employee);
            }
            stockItemService.withdrawStockItemQuantity(stockItem, withdrawStockItemQuantityDTO.quantity());
            stockOut.setStockItem(stockItem);
            stockOut.setStock(stockItem.getStock());
            stockOutRepository.save(stockOut);
        }
    }
}
