package com.sda.wzorce.systemy;

import java.time.LocalDate;

public class PelnomocnikSystemuHotelowego {

    public static final PelnomocnikSystemuHotelowego INSTANCE = new PelnomocnikSystemuHotelowego();

    private int numerRezerwacji = 0;

    private PelnomocnikSystemuHotelowego() {
    }

    public Potwierdzenie zarezerwujHotel(String miasto, LocalDate dataPrzybycia, LocalDate dataWymeldowania) {
        Potwierdzenie potwierdzenie = SystemHotelowy.get().zarezerwujHotel(miasto, dataPrzybycia, dataWymeldowania);
        numerRezerwacji++;
        return new Potwierdzenie(potwierdzenie.getTresc() + "\nŻyczymy udanego pobytu!" + "\n" + "Rezerwacja nr: " + numerRezerwacji + "\n");

    }

    public boolean sprawdzDate(LocalDate dataPrzybycia1, LocalDate dataWymeldowania1, LocalDate dataPrzybycia2, LocalDate dataWymeldowania2) {
        if (dataPrzybycia2.isBefore(dataWymeldowania1) || dataPrzybycia2.isAfter(dataPrzybycia1)) {
            return true;
        } else return dataWymeldowania2.isBefore(dataWymeldowania1) || dataWymeldowania2.isAfter(dataPrzybycia1);

    }
}
