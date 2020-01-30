package com.sda.wzorce;

import com.sda.wzorce.systemy.SystemBiuraPodrozy;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // TODO Ćwiczenie: Fasada
        // TODO -> DONE 1) stwórz fasadę i użyj jej do rezerwacji kompleksowej wycieczki (składającej się z lotu, hotelu i przejazdu taxi)

//        System.out.println(SystemBiuraPodrozy.INSTANCE.zarezerwujWycieczke("Dubai", LocalDate.of(2020, 6, 10), 30));
//        System.out.println(SystemBiuraPodrozy.INSTANCE.zarezerwujWycieczke("Dubai", LocalDate.of(2020, 6, 7), 5));


        // TODO -> DONE 2) pozwól na pozostałe sensowne warianty wycieczek (np. lot+hotel+wynajemAuta, lot+wynajemAuta, hotel+taxi)

//        System.out.println(SystemBiuraPodrozy.INSTANCE.zarezerwujLotHotelAuto("Nowy Jork", LocalDate.of(2020, 3, 18), 10));
//
//        SystemBiuraPodrozy.INSTANCE.anulujRezerwacje(2);
//        SystemBiuraPodrozy.INSTANCE.wyswietlRezerwacje(2);


//        System.out.println(SystemBiuraPodrozy.INSTANCE.zarezerwujLotAuto("Warszawa", LocalDate.of(2020, 4, 19), 1));
//        System.out.println();
//        System.out.println(SystemBiuraPodrozy.INSTANCE.zarezerwujPociagHotelTaxi("Warszawa", LocalDate.now().plusDays(1), 3));

        // TODO -> DONE 3) dodaj "integrację" z "innymi" systemami (np. system rezerwacji biletów PKP)
        // TODO -> DONE 4) dodaj możliwość odwoływania rezerwacji (podpowiedź: należałoby dodac w każdym systemie przechowywanie wydanych "potwierdzeń" i pozwolić na ich anulowanie)

        // TODO Ćwiczenie: Proxy (pełnomocnik)
        // TODO -> DONE 1) stwórz pełnomocnika "sprytne odwołanie", który będzie zliczał, ile rezerwacji zostało wykonanych w systemie hotelowym. Prawidłowo obsłuż również rezerwacje anulowane
        // TODO -> DONE 2) niech pełnomocnik monitoruje liczbę nakładających się rezerwacji. Jeżeli w systemie hotelowym będa w tym samym czasie dwie rezerwacje (które nakładają się chociaż jednym dniem), to rzuca wyjątek
        // TODO -> DONE  3) zmodyfikuj pełnomocnika tak, aby był również proxy ochraniającym - w sytuacji powyżej niech odmówi wywołania metody rezerwującej hotel

        // TODO Ćwiczenie: Obserwator
        // TODO 1) Rozbuduj system korporacji taxi o listę wszystkich taksówkarzy, któzy się w niej zarejestrowali.
        // TODO 2) W momencie przybycia nowego zlecenia - wyślij powiadomienie do wszystkich aktywnych taksówkarzy w korporacji


    }
}
