package com.codeusingjava.osiagniecie.serwisy;

import com.codeusingjava.osiagniecie.domena.Osiagniecie;
import com.codeusingjava.osiagniecie.domena.RodzajOsiagniecia;
import com.codeusingjava.osiagniecie.repozytoria.OsiagniecieRepozytorium;
import com.codeusingjava.student.domena.Student;
import com.codeusingjava.student.repozytoria.StudentRepozytorium;
import com.sruuniwersytet.DodajOsiagnieciaDoStudentaOdpowiedz;
import com.sruuniwersytet.DodajOsiagnieciaDoStudentaZapytanie;
import com.sruuniwersytet.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OsiagniecieSerwis {

    private final OsiagniecieRepozytorium osiagniecieRepozytorium;

    private final StudentRepozytorium studentRepozytorium;

    @Autowired
    public OsiagniecieSerwis(OsiagniecieRepozytorium osiagniecieRepozytorium,
                             StudentRepozytorium studentRepozytorium) {
        this.osiagniecieRepozytorium = osiagniecieRepozytorium;
        this.studentRepozytorium = studentRepozytorium;
    }

    @Transactional
    public DodajOsiagnieciaDoStudentaOdpowiedz dodajOsiagnieciaDoStudenta(DodajOsiagnieciaDoStudentaZapytanie req) {

        ObjectFactory factory = new ObjectFactory();
        DodajOsiagnieciaDoStudentaOdpowiedz response = factory.createDodajOsiagnieciaDoStudentaOdpowiedz();

        Osiagniecie osiagniecie = new Osiagniecie();
        osiagniecie.setOpis(req.getOpis());
        osiagniecie.setRodzajOsiagniecia(RodzajOsiagniecia.valueOf(req.getRodzajOsiagniecia().toUpperCase()));

        try {
            Student student = studentRepozytorium.findOne(req.getIdStudenta());
            student.dodajOsiagniecie(osiagniecie);

            osiagniecie.setStudent(student);
            osiagniecie = osiagniecieRepozytorium.save(osiagniecie);

            response.setIdObiektu(osiagniecie.getId());
            response.setWynikWalidacji("Dodano osiągnięcie do studenta");
        } catch (Exception e) {
            response.setWynikWalidacji(e.getMessage());
        }

        return response;
    }
}
