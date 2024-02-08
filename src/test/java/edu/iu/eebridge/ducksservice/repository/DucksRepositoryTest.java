package edu.iu.eebridge.ducksservice.repository;

import edu.iu.eebridge.ducksservice.model.DuckData;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DucksRepositoryTest {

    @Test
    void addDuck1() throws IOException {
        DucksRepository ducksRepository = new DucksRepository();
        ducksRepository.addDuck(new DuckData(1, "Mallard"));
        BufferedReader br = new BufferedReader(new FileReader("ducks/db.txt"));
        assertEquals(br.readLine(), "1,Mallard");
    }

    @Test
    void addDuck2() throws IOException {
        DucksRepository ducksRepository = new DucksRepository();
        ducksRepository.addDuck(new DuckData(2, "Decoy"));
        BufferedReader br = new BufferedReader(new FileReader("ducks/db.txt"));
        assertEquals(br.readLine(), "2,Decoy");
    }

    @Test
    void getDuck() throws IOException {
        DucksRepository ducksRepository = new DucksRepository();
        ducksRepository.addDuck(new DuckData(1, "Redhead"));
        ducksRepository.addDuck(new DuckData(2, "Rubber"));
        assertEquals("Redhead",ducksRepository.getDuck(1).type());
        assertEquals("Rubber",ducksRepository.getDuck(2).type());
    }

    @Test
    void getAllDucks() throws IOException {
        DucksRepository ducksRepository = new DucksRepository();
        ducksRepository.addDuck(new DuckData(1, "Redhead"));
        ducksRepository.addDuck(new DuckData(2, "Rubber"));
        List<DuckData> ducks = ducksRepository.getAllDucks();
        assertEquals(1, ducks.get(0).id());
        assertEquals(2, ducks.get(1).id());
        assertEquals("Redhead", ducks.get(0).type());
        assertEquals("Rubber", ducks.get(1).type());
    }

    @Test
    void search() throws IOException {
        DucksRepository ducksRepository = new DucksRepository();
        ducksRepository.addDuck(new DuckData(1, "Redhead"));
        ducksRepository.addDuck(new DuckData(2, "Rubber"));
        assertEquals(1,ducksRepository.search("Redhead").get(0).id());
        assertEquals(2,ducksRepository.search("Rubber").get(0).id());
    }
}