package com.beltrandes.geststoneapi.dtos;

import com.beltrandes.geststoneapi.models.StockEntry;
import com.beltrandes.geststoneapi.models.StockItem;
import com.beltrandes.geststoneapi.models.StockOut;

import java.util.List;

public class StockDTO {
    private String name;
    private List<StockItem> stockItems;
    private List<StockEntry> stockEntries;
    private List<StockOut> stockOuts;
}
