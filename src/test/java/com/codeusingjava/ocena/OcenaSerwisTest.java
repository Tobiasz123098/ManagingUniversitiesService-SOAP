package com.codeusingjava.ocena;

import com.codeusingjava.dzien.domena.Dzien;
import com.codeusingjava.dzien.repozytoria.DzienRepozytorium;
import com.codeusingjava.index.domena.Index;
import com.codeusingjava.index.repozytoria.IndexRepozytorium;
import com.codeusingjava.ocena.domena.Ocena;
import com.codeusingjava.ocena.repozytoria.OcenaRepozytorium;
import com.codeusingjava.ocena.serwisy.OcenaSerwis;
import com.sruuniwersytet.UtworzOceneOdpowiedz;
import com.sruuniwersytet.UtworzOceneZapytanie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
public class OcenaSerwisTest {

    @InjectMocks
    private OcenaSerwis ocenaSerwis;

    @Mock
    private  OcenaRepozytorium ocenaRepozytorium;

    @Mock
    private  IndexRepozytorium indexRepozytorium;

    @Mock
    private  DzienRepozytorium dzienRepozytorium;

    @Test
    void utworz_ocene_test(){
        //given
        Ocena ocena = new Ocena();
        ocena.setId(-1L);
        String msg = "Utworzono ocenę o id: " + ocena.getId();
        UtworzOceneZapytanie req = new UtworzOceneZapytanie();
        // when
        Mockito.when(ocenaRepozytorium.save(any(Ocena.class))).thenReturn(ocena);
        Mockito.when(indexRepozytorium.findOne(anyLong())).thenReturn(new Index());

        //then
        UtworzOceneOdpowiedz res =  ocenaSerwis.utworzOcene(req);
        Assertions.assertNotNull(res);
        Assertions.assertEquals(msg, res.getWynikWalidacji());

    }

    @Test
    void utworz_ocene_wyjatek_przy_zapisie_test(){
        //given
        Ocena ocena = new Ocena();
        UtworzOceneZapytanie req = new UtworzOceneZapytanie();

        // when
        Mockito.when(ocenaRepozytorium.save(any(Ocena.class))).thenThrow(new IllegalStateException("dupa"));
        Mockito.when(indexRepozytorium.findOne(anyLong())).thenReturn(new Index());
        //then
        UtworzOceneOdpowiedz res =  ocenaSerwis.utworzOcene(req);
        Assertions.assertNotNull(res);
        Assertions.assertEquals("dupa", res.getWynikWalidacji());
    }
}
