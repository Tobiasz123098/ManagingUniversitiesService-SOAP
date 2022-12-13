package com.codeusingjava.stypendium.serwisy;

import com.codeusingjava.student.domena.Student;
import com.codeusingjava.student.repozytoria.StudentRepozytorium;
import com.codeusingjava.stypendium.domena.RodzajStypendium;
import com.codeusingjava.stypendium.domena.Stypendium;
import com.codeusingjava.stypendium.repozytoria.StypendiumRepozytorium;
import com.sruuniwersytet.DodajStypendiumDoStudentaOdpowiedz;
import com.sruuniwersytet.DodajStypendiumDoStudentaZapytanie;
import com.sruuniwersytet.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class StypendiumSerwis {

    private final StypendiumRepozytorium stypendiumRepozytorium;

    private final StudentRepozytorium studentRepozytorium;

    @Autowired
    public StypendiumSerwis(StypendiumRepozytorium stypendiumRepozytorium,
                            StudentRepozytorium studentRepozytorium) {
        this.stypendiumRepozytorium = stypendiumRepozytorium;
        this.studentRepozytorium = studentRepozytorium;
    }

    @Transactional
    public DodajStypendiumDoStudentaOdpowiedz dodajStypendiumDoStudenta(DodajStypendiumDoStudentaZapytanie req) {

        ObjectFactory factory = new ObjectFactory();
        DodajStypendiumDoStudentaOdpowiedz response = factory.createDodajStypendiumDoStudentaOdpowiedz();

        Stypendium stypendium = new Stypendium();
        stypendium.setRodzajStypendium(RodzajStypendium.valueOf(req.getRodzajStypendium().toUpperCase()));

        try {
            Student student = studentRepozytorium.findOne(req.getIdStudenta());
            student.dodajStypendium(stypendium);

            stypendium.setStudent(student);
            stypendium = stypendiumRepozytorium.save(stypendium);

            response.setIdObiektu(stypendium.getId());
            response.setWynikWalidacji("Dodano stypendium do studenta");
        } catch (Exception e) {
            response.setWynikWalidacji(e.getMessage());
        }

        return response;
    }
}
