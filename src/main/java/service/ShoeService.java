package service;

import model.Shoe;
import servlet.ShoeServlet;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ShoeService {
    private List<Shoe> shoes = new ArrayList<>();
    private AtomicInteger idCounter = new AtomicInteger(0);

    public ShoeService() {
        // Додаємо тестові дані (можна змінити чи видалити)
        shoes.add(new Shoe(idCounter.incrementAndGet(), "Nike", "Air Max", 120.99, "42", "src/assets/123.jpg"));
        shoes.add(new Shoe(idCounter.incrementAndGet(), "Adidas", "UltraBoost", 140.5, "41", "https://example.com/adidas-ultraboost.jpg"));
    }

    public List<Shoe> getAll() {
        return shoes;
    }

    public Shoe getById(int id) {
        return shoes.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Shoe add(Shoe shoe) {
        shoe.setId(idCounter.incrementAndGet());
        shoes.add(shoe);
        return shoe;
    }

    public boolean update(Shoe shoe) {
        Shoe existing = getById(shoe.getId());
        if (existing != null) {
            existing.setBrand(shoe.getBrand());
            existing.setModel(shoe.getModel());
            existing.setPrice(shoe.getPrice());
            existing.setSize(shoe.getSize());
            existing.setImageUrl(shoe.getImageUrl());
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        return shoes.removeIf(s -> s.getId() == id);
    }
}
