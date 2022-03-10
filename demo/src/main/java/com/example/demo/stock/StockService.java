package com.example.demo.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {

  private final StockRepository stockRepository;

  @Autowired
  public StockService(StockRepository stockRepository) {
    this.stockRepository = stockRepository;
  }

  public List<Stock> getAllStocks() {
    return (List<Stock>) stockRepository.findAll();
  }

  public Stock getStockById(Long stockId) {
    Optional<Stock> stock = stockRepository.findById(stockId);
    if (stock.isPresent()) {
      return stock.get();
    } else {
      throw new IllegalStateException("stock does not exist");
    }
  }

  public Stock createStock(Stock stock) {
    return stockRepository.save(stock);
  }

  public Stock updateStock(Long stockId, Stock stock) {
    Stock stockFromDb = stockRepository.findById(stockId).orElseThrow();
    stockFromDb.setName(stock.getName());
    stockFromDb.setCurrent_price(stock.getCurrent_price());
    return stockRepository.save(stockFromDb);
  }

  public void deleteStock(Long stockId) {
    stockRepository.deleteById(stockId);
  }
}
