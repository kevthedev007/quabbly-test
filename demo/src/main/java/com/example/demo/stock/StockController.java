package com.example.demo.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/stocks")
public class StockController {

  private final StockService stockService;

  @Autowired
  public StockController(StockService stockService) {
    this.stockService = stockService;
  }

  @GetMapping
  public List<Stock> getAllStocks() {
    return stockService.getAllStocks();
  }

  @GetMapping(path = "{stockId}")
  public Stock getStockById(@PathVariable("stockId") Long stockId) {
    return stockService.getStockById(stockId);
  }

  @PostMapping
  public Stock createStock(@RequestBody Stock stock) {
    return stockService.createStock(stock);
  }

  @PutMapping(path = "{stockId}")
  public Stock updateStock(@PathVariable("stockId") Long stockId, @RequestBody Stock stock) {
    return stockService.updateStock(stockId, stock);
  }

  @DeleteMapping(path = "{stockId}")
  public void deleteStock(@PathVariable("stockId") Long stockId) {
    stockService.deleteStock(stockId);
  }

}
