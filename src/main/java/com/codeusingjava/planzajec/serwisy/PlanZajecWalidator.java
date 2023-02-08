package com.codeusingjava.planzajec.serwisy;

import com.sruuniwersytet.PrzypiszPlanZajecDoGrupyOdpowiedz;
import com.sruuniwersytet.PrzypiszPlanZajecDoGrupyZapytanie;
import com.sruuniwersytet.UtworzPlanZajecOdpowiedz;
import com.sruuniwersytet.UtworzPlanZajecZapytanie;
import org.springframework.stereotype.Service;

@Service
public class PlanZajecWalidator {

    public static final String POLE_DZIEN_OD_NIE_MOŻE_BYĆ_PUSTE = "Pole 'dzien od' nie może być puste";
    public static final String POLE_DZIEN_DO_NIE_MOŻE_BYĆ_PUSTE = "Pole 'dzien do' nie może być puste";
    public static final String POLE_ID_GRUPY_NIE_MOŻE_BYĆ_PUSTE = "Pole 'id grupy' nie może być puste";
    public static final String POLE_ID_PLANU_ZAJEC_NIE_MOŻE_BYĆ_PUSTE = "Pole 'id planu zajec' nie może być puste";

    public boolean walidujUtworzPlanZajec(UtworzPlanZajecZapytanie req, UtworzPlanZajecOdpowiedz res) {

        if (req.getDzienOd() == null) {
            res.setWynikWalidacji(POLE_DZIEN_OD_NIE_MOŻE_BYĆ_PUSTE);
            return false;
        }

        if (req.getDzienDo() == null) {
            res.setWynikWalidacji(POLE_DZIEN_DO_NIE_MOŻE_BYĆ_PUSTE);
            return false;
        }

        return true;
    }

    public boolean walidujPrzypiszPlanZajecDoGrupy(PrzypiszPlanZajecDoGrupyZapytanie req, PrzypiszPlanZajecDoGrupyOdpowiedz res) {

        if (req.getIdGrupy() == null) {
            res.setWynikWalidacji(POLE_ID_GRUPY_NIE_MOŻE_BYĆ_PUSTE);
            return false;
        }

        if (req.getIdPlanuZajec() == null) {
            res.setWynikWalidacji(POLE_ID_PLANU_ZAJEC_NIE_MOŻE_BYĆ_PUSTE);
            return false;
        }

        return true;
    }
}
