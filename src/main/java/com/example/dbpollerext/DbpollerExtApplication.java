package com.example.dbpollerext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class DbpollerExtApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbpollerExtApplication.class, args);
    }

    @PostMapping("/echo")
    public String echo(@RequestBody String str) {
        return str + " from the other side";
    }

    @GetMapping("/items")
    public List<Item> getItems() throws InterruptedException {
        Item item = new Item("1", "Test Item", 0);
        Thread.sleep(getRandom());
        return List.of(item);
    }

    @PostMapping("/item")
    @ResponseStatus(HttpStatus.CREATED)
    public Item createItem(@RequestBody Item item) throws InterruptedException {
        Thread.sleep(getRandom());
        return item;
    }

    @PutMapping("/item")
    public Item updateItem(@RequestBody Item item) throws InterruptedException  {
        Thread.sleep(getRandom());
        return item;
    }

    private int getRandom() {
        int max = 2000;
        int min = 500;
        int range = max - min + 1;
        return (int)(Math.random() * range) + min;
    }

}
