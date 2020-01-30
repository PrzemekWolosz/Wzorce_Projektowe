package com.sda.wzorce.systemy;

import java.time.LocalDate;

public class PrzedzialCzasowyRezerwacjiHotelowej {
    private LocalDate dataPrzybycia;
    private LocalDate dataWyjazdu;

    public PrzedzialCzasowyRezerwacjiHotelowej(LocalDate dataPrzybycia, LocalDate dataWyjazdu) {
        this.dataPrzybycia = dataPrzybycia;
        this.dataWyjazdu = dataWyjazdu;
    }

    public LocalDate getDataPrzybycia() {
        return dataPrzybycia;
    }

    public LocalDate getDataWyjazdu() {
        return dataWyjazdu;
    }

    public boolean czyNakladaSieZ(PrzedzialCzasowyRezerwacjiHotelowej ramyCzasowe) {

        if (this.dataWyjazdu.isAfter(ramyCzasowe.dataPrzybycia)) {
            return true;
        }
        if (this.dataPrzybycia.isBefore(ramyCzasowe.dataWyjazdu)) {
            return true;
        }
        return false;
    }
}
