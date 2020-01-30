package com.sda.wzorce.systemy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PelnomocnikSystemuHotelowego {

    public static final PelnomocnikSystemuHotelowego INSTANCE = new PelnomocnikSystemuHotelowego();

    private int numerRezerwacji = 0;

    private List<PrzedzialCzasowyRezerwacjiHotelowej> ramyCzasoweInsteniacychRezerwacji = new ArrayList<>();

    private PelnomocnikSystemuHotelowego() {
    }

    public Potwierdzenie zarezerwujHotel(String miasto, LocalDate dataPrzybycia, LocalDate dataWymeldowania) {

        System.out.println("Podjęto próbę rezerwacji hotelu w mieście " + miasto);

        PrzedzialCzasowyRezerwacjiHotelowej ramyCzasowe = new PrzedzialCzasowyRezerwacjiHotelowej(dataPrzybycia, dataWymeldowania);
        for (PrzedzialCzasowyRezerwacjiHotelowej istniejaceRezerwacje : ramyCzasoweInsteniacychRezerwacji) {
            if (istniejaceRezerwacje.czyNakladaSieZ(ramyCzasowe)) {
                throw new IllegalArgumentException("Rezerwacja hotelu nieudana - terminy rezerwacji nakładają się!");
            }
        }

        Potwierdzenie potwierdzenie = SystemHotelowy.get().zarezerwujHotel(miasto, dataPrzybycia, dataWymeldowania);
        numerRezerwacji++;
        ramyCzasoweInsteniacychRezerwacji.add(ramyCzasowe);
        return new Potwierdzenie(potwierdzenie.getTresc() + "\nŻyczymy udanego pobytu!" + "\n" + "Rezerwacja nr: " + numerRezerwacji + "\n");

    }
}
