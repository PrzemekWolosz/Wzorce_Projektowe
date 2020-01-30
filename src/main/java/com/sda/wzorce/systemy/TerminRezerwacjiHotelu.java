package com.sda.wzorce.systemy;

import java.time.LocalDate;

public class TerminRezerwacjiHotelu {
    private LocalDate dataPrzybycia;
    private LocalDate dataWyjazdu;

    public TerminRezerwacjiHotelu(LocalDate dataPrzybycia, LocalDate dataWyjazdu) {
        this.dataPrzybycia = dataPrzybycia;
        this.dataWyjazdu = dataWyjazdu;
    }

    public LocalDate getDataPrzybycia() {
        return dataPrzybycia;
    }

    public LocalDate getDataWyjazdu() {
        return dataWyjazdu;
    }

//    public boolean czyRezerwacjeSieNakladaja(TerminRezerwacjiHotelu ramyCzasowe){
//        if ()
//    }

}
