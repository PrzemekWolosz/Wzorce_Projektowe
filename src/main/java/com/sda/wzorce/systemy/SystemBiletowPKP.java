package com.sda.wzorce.systemy;

import java.time.LocalDateTime;

final class SystemBiletowPKP {
    private static final SystemBiletowPKP INSTANCE = new SystemBiletowPKP();

    public static SystemBiletowPKP get() {
        return INSTANCE;
    }

    private SystemBiletowPKP() {
    }

    public Potwierdzenie zarezerwujPociag(String kierunek, LocalDateTime dataWyjazdu) {
        if (kierunek == null || kierunek.length() <= 3) {
            throw new RuntimeException("Nieprawidłowa nazwa maista!");
        }
        if (dataWyjazdu == null || dataWyjazdu.compareTo(LocalDateTime.now()) <= 0) {
            throw new RuntimeException("Nieprawidłowa data wyjazdu!");
        }
        return new Potwierdzenie("Rezerwacja pociągu do " + kierunek.toUpperCase() + " na date " + dataWyjazdu);
    }
}
