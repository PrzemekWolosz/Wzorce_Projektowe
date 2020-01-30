package com.sda.wzorce.systemy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class SystemBiuraPodrozy {
    public static final SystemBiuraPodrozy INSTANCE = new SystemBiuraPodrozy();

    private Map<String, String> mapaLotnisk = new HashMap<>();
    private Map<String, Integer> dlugoscLotu = new HashMap<>();
    private Integer numerRezerwacji = 0;
    private Map<Integer, Potwierdzenie> rezerwacjeWSystemie = new HashMap<>();


    private SystemBiuraPodrozy() {
        mapaLotnisk.put("Dubai", "DXB");
        mapaLotnisk.put("Warszawa", "WAW");
        mapaLotnisk.put("Nowy Jork", "JFK");
        dlugoscLotu.put("Dubai", 7);
        dlugoscLotu.put("Warszawa", 1);
        dlugoscLotu.put("Nowy Jork", 12);

    }

    public Potwierdzenie zarezerwujWycieczke(String miastoDocelowe, LocalDate dataWyjazdu, int liczbaDni) {

        LocalDateTime dataIGodzinaWylotu = LocalDateTime.of(dataWyjazdu.getYear(), dataWyjazdu.getMonth(),
                dataWyjazdu.getDayOfMonth(), 8, 0);

        Potwierdzenie potwierdzenieLot = SystemLotow.get().zarezerwujLot(mapaLotnisk.get(miastoDocelowe), dataIGodzinaWylotu);
        Potwierdzenie potwierdzenieTaxi = SystemTaxi.get().zamowTaksowke(miastoDocelowe, dataIGodzinaWylotu.plusHours(dlugoscLotu.get(miastoDocelowe)));
        Potwierdzenie potwierdzenieHotel = PelnomocnikSystemuHotelowego.INSTANCE.zarezerwujHotel(miastoDocelowe, dataWyjazdu, dataWyjazdu.plusDays(liczbaDni));

//        PelnomocnikSystemuHotelowego.INSTANCE.sprawdzDate(dataWyjazdu)
        numerRezerwacji++;
        Potwierdzenie rezerwacja = new Potwierdzenie("Rezerwacja wycieczki:\n" + potwierdzenieLot + "\n" + potwierdzenieTaxi + "\n" + potwierdzenieHotel);
        rezerwacjeWSystemie.put(numerRezerwacji, rezerwacja);
        return rezerwacja;
    }

    public Potwierdzenie zarezerwujLotHotelAuto(String miastoDocelowe, LocalDate dataWyjazdu, int liczbaDni) {

        LocalDateTime dataIGodzinaWylotu = LocalDateTime.of(dataWyjazdu.getYear(), dataWyjazdu.getMonth(),
                dataWyjazdu.getDayOfMonth(), 8, 0);

        Potwierdzenie potwierdzenieLot = SystemLotow.get().zarezerwujLot(mapaLotnisk.get(miastoDocelowe), dataIGodzinaWylotu);
        Potwierdzenie potwierdzenieHotel = PelnomocnikSystemuHotelowego.INSTANCE.zarezerwujHotel(miastoDocelowe, dataWyjazdu, dataWyjazdu.plusDays(liczbaDni));
        Potwierdzenie potwierdzenieAuto = SystemWynajmuAut.get().wynajmijAuto(miastoDocelowe, dataIGodzinaWylotu.plusHours(dlugoscLotu.get(miastoDocelowe)), liczbaDni);

        numerRezerwacji++;
        Potwierdzenie rezerwacja = new Potwierdzenie("Rezerwacja wycieczki:\n" + potwierdzenieLot + "\n" + potwierdzenieAuto + "\n" + potwierdzenieHotel);
        rezerwacjeWSystemie.put(numerRezerwacji, rezerwacja);
        return rezerwacja;
    }

    public Potwierdzenie zarezerwujLotAuto(String miastoDocelowe, LocalDate dataWyjazdu, int liczbaDni) {

        LocalDateTime dataIGodzinaWylotu = LocalDateTime.of(dataWyjazdu.getYear(), dataWyjazdu.getMonth(),
                dataWyjazdu.getDayOfMonth(), 8, 0);

        Potwierdzenie potwierdzenieLot = SystemLotow.get().zarezerwujLot(mapaLotnisk.get(miastoDocelowe), dataIGodzinaWylotu);
        Potwierdzenie potwierdzenieAuto = SystemWynajmuAut.get().wynajmijAuto(miastoDocelowe, dataIGodzinaWylotu.plusHours(dlugoscLotu.get(miastoDocelowe)), liczbaDni);

        numerRezerwacji++;
        Potwierdzenie rezerwacja = new Potwierdzenie("Rezerwacja wycieczki:\n" + potwierdzenieLot + "\n" + potwierdzenieAuto);
        rezerwacjeWSystemie.put(numerRezerwacji, rezerwacja);
        return rezerwacja;
    }

    public Potwierdzenie zarezerwujPociagHotelTaxi(String miastoDocelowe, LocalDate dataWyjazdu, int liczbaDni) {

        LocalDateTime dataIGodzinaWyjazdu = LocalDateTime.of(dataWyjazdu.getYear(), dataWyjazdu.getMonth(),
                dataWyjazdu.getDayOfMonth(), 8, 0);

        Potwierdzenie potwierdzeniePociag = SystemBiletowPKP.get().zarezerwujPociag(miastoDocelowe, dataIGodzinaWyjazdu);
        Potwierdzenie potwierdzenieHotel = PelnomocnikSystemuHotelowego.INSTANCE.zarezerwujHotel(miastoDocelowe, dataWyjazdu, dataWyjazdu.plusDays(liczbaDni));
        Potwierdzenie potwierdzenieTaxi = SystemTaxi.get().zamowTaksowke(miastoDocelowe, dataIGodzinaWyjazdu.plusHours(5));

        numerRezerwacji++;
        Potwierdzenie rezerwacja = new Potwierdzenie("Rezerwacja wycieczki:\n" + potwierdzeniePociag + "\n" + potwierdzenieTaxi + "\n" + potwierdzenieHotel);
        rezerwacjeWSystemie.put(numerRezerwacji, rezerwacja);
        return rezerwacja;

    }

    public void anulujRezerwacje(Integer numerRezerwacji) {
        if (rezerwacjeWSystemie.containsKey(numerRezerwacji)) {
            rezerwacjeWSystemie.remove(numerRezerwacji);
            System.out.println("Rezerwacja numer " + numerRezerwacji + " została anulowana\n");
        } else {
            throw new IllegalArgumentException("Rezerwacja o podanym numerze nie istnieje");
        }
    }

    public void wyswietlRezerwacje(Integer numerRezerwacji) {
        if (rezerwacjeWSystemie.containsKey(numerRezerwacji)) {
            System.out.println(rezerwacjeWSystemie.get(numerRezerwacji));
        } else {
            throw new IllegalArgumentException("Rezerwacja o podanym numerze nie istnieje");
        }
    }
}
