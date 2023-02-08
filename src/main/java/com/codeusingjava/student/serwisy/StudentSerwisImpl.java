package com.codeusingjava.student.serwisy;

import com.codeusingjava.index.domena.Index;
import com.codeusingjava.index.domena.KierunekStudiow;
import com.codeusingjava.index.repozytoria.IndexRepozytorium;
import com.codeusingjava.osiagniecie.domena.Osiagniecie;
import com.codeusingjava.osiagniecie.repozytoria.OsiagniecieRepozytorium;
import com.codeusingjava.student.domena.Student;
import com.codeusingjava.student.repozytoria.StudentRepozytorium;
import com.codeusingjava.student.wyjatki.NieMoznaWyswietlicStudentaPoIdException;
import com.codeusingjava.student.wyjatki.NieMoznaWyswietlicStudentowException;
import com.codeusingjava.stypendium.domena.Stypendium;
import com.codeusingjava.stypendium.repozytoria.StypendiumRepozytorium;
import com.codeusingjava.uniwersytet.domena.Uniwersytet;
import com.codeusingjava.uniwersytet.repozytoria.UniwersytetRepozytorium;
import com.sruuniwersytet.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentSerwisImpl implements StudentSerwis {
    private final StudentRepozytorium studentRepository;

    private final UniwersytetRepozytorium uniwersytetRepozytorium;
    private final StypendiumRepozytorium stypendiumRepozytorium;
    private final OsiagniecieRepozytorium osiagniecieRepozytorium;

    @Autowired
    public StudentSerwisImpl(StudentRepozytorium studentRepository, UniwersytetRepozytorium uniwersytetRepozytorium, IndexRepozytorium indexRepozytorium,
                             StypendiumRepozytorium stypendiumRepozytorium,
                             OsiagniecieRepozytorium osiagniecieRepozytorium) {
        this.studentRepository = studentRepository;
        this.uniwersytetRepozytorium = uniwersytetRepozytorium;
        this.stypendiumRepozytorium = stypendiumRepozytorium;
        this.osiagniecieRepozytorium = osiagniecieRepozytorium;
    }

    @Transactional
    public DodajStudentaDoUniwersytetuOdpowiedz dodajStudentaDoUniwersytetu(DodajStudentaDoUniwersytetuZapytanie req) {

        ObjectFactory factory = new ObjectFactory();
        DodajStudentaDoUniwersytetuOdpowiedz response = factory.createDodajStudentaDoUniwersytetuOdpowiedz();

        Student student = new Student();
        student.setImie(req.getImie());
        student.setNazwisko(req.getNazwisko());
        student.setEmail(req.getEmail());

        Index index = new Index();
        index.setStudent(student);
        index.setNumerIndexu(req.getNumerIndexu());
        index.setKierunekStudiow(KierunekStudiow.valueOf(req.getKierunekStudiow().toUpperCase()));

        student.setIndex(index);

        try {
            Uniwersytet uniwersytet = uniwersytetRepozytorium.findOne(req.getIdUniwersytetu());
            uniwersytet.dodajStudenta(student);

            student = studentRepository.save(student);
            response.setIdObiektu(student.getId());
            response.setWynikWalidacji("Dodano studenta do uniwersytetu i nadano mu index o nr: " + req.getNumerIndexu());
        } catch (Exception e) {
            response.setWynikWalidacji(e.getMessage());
        }

        return response;
    }

    public WyswietlStudentowOdpowiedz wyswietlStudentow(WyswietlStudentowZapytanie req) {

        ObjectFactory factory = new ObjectFactory();
        WyswietlStudentowOdpowiedz response = factory.createWyswietlStudentowOdpowiedz();

        try {
            List<Student> student = studentRepository.findByUniwersytetId(req.getIdUniwersytetu());
            student.stream()
                    .map((this::mapToStudent))
                    .forEach(studentElement -> response.getStudent().add(studentElement));
            return response;
        } catch (Exception e) {
            throw new NieMoznaWyswietlicStudentowException("Nie znaleziono żadnych studentów", e);
        }
    }


    public WyswietlStudentaPoIdOdpowiedz wyswietlStudentaPoId(WyswietlStudentaPoIdZapytanie req) {
        ObjectFactory factory = new ObjectFactory();
        WyswietlStudentaPoIdOdpowiedz response = factory.createWyswietlStudentaPoIdOdpowiedz();

        try {
            Student student = studentRepository.findOne(req.getIdStudenta());
            response.setId(student.getId());
            response.setName(student.getImie());
            response.setNazwisko(student.getNazwisko());
            response.setEmail(student.getEmail());

            List<Stypendium> stypendium = stypendiumRepozytorium.findByStudentId(student.getId());
            stypendium.stream()
                    .map((this::mapToStypendium))
                    .forEach(stypendiumElement -> response.getStypendium().add(stypendiumElement));
            List<Osiagniecie> osiagniecie = osiagniecieRepozytorium.findByStudentId(student.getId());
            osiagniecie.stream()
                    .map((this::mapToOsiagniecie))
                    .forEach(osiagniecieElement -> response.getOsiagniecie().add(osiagniecieElement));
            return response;
        } catch (Exception e) {
            throw new NieMoznaWyswietlicStudentaPoIdException("Nie znaleziono studenta po id", e);
        }
    }

    private StudentElement mapToStudent(Student student) {
        StudentElement studentElement = new StudentElement();
        studentElement.setId(student.getId());
        studentElement.setName(student.getImie());
        studentElement.setNazwisko(student.getNazwisko());
        studentElement.setEmail(student.getEmail());
        return studentElement;
    }

    private StypendiumElement mapToStypendium(Stypendium stypendium) {
        StypendiumElement stypendiumElement = new StypendiumElement();
        stypendiumElement.setId(stypendium.getId());
        stypendiumElement.setRodzajStypendium(String.valueOf(stypendium.getRodzajStypendium()));
        return stypendiumElement;
    }

    private OsiagniecieElement mapToOsiagniecie(Osiagniecie osiagniecie) {
        OsiagniecieElement osiagniecieElement = new OsiagniecieElement();
        osiagniecieElement.setId(osiagniecie.getId());
        osiagniecieElement.setRodzajOsiagniecia(String.valueOf(osiagniecie.getRodzajOsiagniecia()));
        osiagniecieElement.setOpis(osiagniecie.getOpis());
        return osiagniecieElement;
    }
}
