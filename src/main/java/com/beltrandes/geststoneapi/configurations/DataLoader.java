package com.beltrandes.geststoneapi.configurations;

import com.beltrandes.geststoneapi.enums.EmployeeRole;
import com.beltrandes.geststoneapi.models.*;
import com.beltrandes.geststoneapi.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private StockItemRepository stockItemRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private StockEntryRepository stockEntryRepository;

    @Autowired
    private StockOutRepository stockOutRepository;

    @Override
    public void run(String... args) throws Exception {
        stockEntryRepository.deleteAll();
        stockOutRepository.deleteAll();
        stockItemRepository.deleteAll();
        stockRepository.deleteAll();
        employeeRepository.deleteAll();
        // Estoques
        Stock stock1 = new Stock("Produção");
        stockRepository.save(stock1);

        Stock stock2 = new Stock("Montagem");
        stockRepository.save(stock2);

        // Itens - produção
        var item1 = new StockItem("Disco de Maquita", "Porcelanato", stock1, 10, 3);
        stockItemRepository.save(item1);
        var item2 = new StockItem("PU40", "Branco", stock1, 10, 5);
        stockItemRepository.save(item2);
        var item3 = new StockItem("Massa Plástica", "Preta", stock1, 20, 5);
        stockItemRepository.save(item3);
        var item4 = new StockItem("Palha de Aço", stock1, 8, 3);
        stockItemRepository.save(item4);
        // Itens - montagem
        var item5 = new StockItem("PU40", "Branco", stock2, 15, 5);
        stockItemRepository.save(item5);
        var item6 = new StockItem("PU40", "Preto", stock2, 0, 3);
        stockItemRepository.save(item6);
        var item7 = new StockItem("Ferro T", "60CM", stock2, 10, 5);
        stockItemRepository.save(item7);
        var item8 = new StockItem("Talhadeira", stock2, 2, 2);
        stockItemRepository.save(item8);
        // Funcionários
        Employee employee1 = new Employee("Adailton Damasceno", "1234567890", EmployeeRole.PRODUTOR);
        employeeRepository.save(employee1);
        Employee employee2 = new Employee("Francisco Chagas", "1226417890", EmployeeRole.MONTADOR);
        employeeRepository.save(employee2);
        Employee employee3 = new Employee("Beltrandes Marques", "9876543210", EmployeeRole.GERENTE);
        employeeRepository.save(employee3);

        // Movimentações

        // Entrada de itens no estoque principal
        StockEntry stockEntry1 = new StockEntry(item1, stock1, item1.getQuantity(), 5);
        stockEntryRepository.save(stockEntry1);

        // Saída de itens do estoque principal
        StockOut stockOut1 = new StockOut(item1, employee1, stock1, null, item1.getQuantity(), 5);
        stockOutRepository.save(stockOut1);

    }

}

