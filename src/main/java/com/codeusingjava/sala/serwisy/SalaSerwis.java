package com.codeusingjava.sala.serwisy;

import com.codeusingjava.sala.domena.Sala;
import com.codeusingjava.sala.repozytoria.SalaRepozytorium;
import com.codeusingjava.uniwersytet.domena.Uniwersytet;
import com.codeusingjava.uniwersytet.repozytoria.UniwersytetRepozytorium;
import com.sruuniwersytet.DodajSaleDoUniwersytetuOdpowiedz;
import com.sruuniwersytet.DodajSaleDoUniwersytetuZapytanie;
import com.sruuniwersytet.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class SalaSerwis {

    private final SalaRepozytorium salaRepozytorium;

    private final UniwersytetRepozytorium uniwersytetRepozytorium;

    @Autowired
    public SalaSerwis(SalaRepozytorium salaRepozytorium, UniwersytetRepozytorium uniwersytetRepozytorium) {
        this.salaRepozytorium = salaRepozytorium;
        this.uniwersytetRepozytorium = uniwersytetRepozytorium;
    }

    @Transactional
    public DodajSaleDoUniwersytetuOdpowiedz dodajSaleDoUniwersytetu(DodajSaleDoUniwersytetuZapytanie req) {

        ObjectFactory factory = new ObjectFactory();
        DodajSaleDoUniwersytetuOdpowiedz response = factory.createDodajSaleDoUniwersytetuOdpowiedz();

        Sala sala = new Sala();
        sala.setNumerSali(req.getNumerSali());

        try {
            Uniwersytet uniwersytet = uniwersytetRepozytorium.findOne(req.getIdUniwersytetu());
            uniwersytet.dodajSale(sala);
            sala = salaRepozytorium.save(sala);
            response.setIdObiektu(sala.getId());
            response.setWynikWalidacji("Dodano salę do uniwersytetu");
        } catch (Exception e) {
            response.setWynikWalidacji("Wystąpił błąd: " + e.getMessage());
        }

        return response;
    }
}
