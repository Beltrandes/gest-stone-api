package com.beltrandes.geststoneapi.configurations;

import com.beltrandes.geststoneapi.enums.EmployeeRole;
import com.beltrandes.geststoneapi.enums.MaterialType;
import com.beltrandes.geststoneapi.models.*;
import com.beltrandes.geststoneapi.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

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
    @Autowired
    private MaterialRepository materialRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private QuotationRepository quotationRepository;
    @Autowired
    private  QuoteItemRepository quoteItemRepository;
    @Override
    public void run(String... args) throws Exception {
        stockEntryRepository.deleteAll();
        stockOutRepository.deleteAll();
        stockItemRepository.deleteAll();
        stockRepository.deleteAll();
        employeeRepository.deleteAll();
        quoteItemRepository.deleteAll();
        quotationRepository.deleteAll();
        materialRepository.deleteAll();
        clientRepository.deleteAll();



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

        // Materials

        var material1 = new Material(null, "Preto São Gabriel", 980.00, "Preto", false, true, MaterialType.GRANITE);
        var material2 = new Material(null, "Branco Prime", 1200.00, "Branco", false, false, MaterialType.SILESTONE);
        var material3= new Material(null, "Branco Itaúnas", 850.00, "Branco/Cinza", false, true, MaterialType.MARBLE);
        materialRepository.saveAll(Arrays.asList(material1, material2, material3));

        // Clients
        var client1 = new Client("Lilia Cunha", "11923042134", "liliacunha@gmail.com", "Av. Paulista, 10325");
        var client2 = new Client("André Marques", "11929164283", "andrevertente@gmail.com", "Av. Macuco, 1033");
        var client3 = new Client("Amanda Neves", "11921235623", "amandaarquiteta@gmail.com", "R. Nações Unidas, 325");
        clientRepository.saveAll(Arrays.asList(client1, client2, client3));

        var quotation1 = new Quotation(client1, 20, LocalDateTime.now());
        quotationRepository.save(quotation1);

        var quoteItem1 = new QuoteItem("Bancada", quotation1, material2, 1.20, 0.45, 2);
        quoteItem1.calculateAll();
        quoteItemRepository.save(quoteItem1);
        var quoteItem2 = new QuoteItem("Lavatório", quotation1, material1, 1.86, 0.50, 1);
        quoteItem2.calculateAll();
        quoteItemRepository.save(quoteItem2);

        quotation1.calculateTotalM2();
        quotation1.calculateTotalPrice();
        quotationRepository.save(quotation1);


    }





}

