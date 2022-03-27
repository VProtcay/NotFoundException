package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    ProductManager manager = new ProductManager();
    Product first = new Product(1, "first", 100);
    Product second = new Product(2, "second", 300);
    Product third = new Product(3, "third", 270);


    @Test
    public void shouldRemoveByIdIfExists() {
        int idToRemove = 1;
        manager.save(first);
        manager.save(second);
        manager.save(third);

        manager.removeById(idToRemove);

        Product[] actual = manager.findAll();
        Product[] expected = new Product[]{second, third};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldThrowExceptionIfIdNotExists() {

        manager.save(first);
        manager.save(second);
        manager.save(third);

        assertThrows(NotFoundException.class, () -> {
            manager.removeById(10);
        });

    }

}