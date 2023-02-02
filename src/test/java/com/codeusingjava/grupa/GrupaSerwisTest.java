package com.codeusingjava.grupa;

import com.codeusingjava.grupa.domena.Grupa;
import com.codeusingjava.grupa.repozytoria.GrupaRepozytorium;
import com.codeusingjava.grupa.serwisy.GrupaSerwis;
import com.sruuniwersytet.UtworzGrupeOdpowiedz;
import com.sruuniwersytet.UtworzGrupeZapytanie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class GrupaSerwisTest {

    @InjectMocks
    private GrupaSerwis grupaSerwis;

    @Mock
    private GrupaRepozytorium grupaRepozytorium;

    @Test
    void utworz_grupe_test() {
        //given
        Grupa grupa = new Grupa();
        grupa.setId(1L);
        String msg = "Utworzono grupę o id: " + grupa.getId();
        UtworzGrupeZapytanie req = new UtworzGrupeZapytanie();
        //when
        Mockito.when(grupaRepozytorium.save(any(Grupa.class))).thenReturn(grupa);
        UtworzGrupeOdpowiedz response = grupaSerwis.utworzGrupe(req);
        //then
        Assertions.assertNotNull(response);
        Assertions.assertEquals(msg, response.getWynikWalidacji());
    }

    @Test
    void utworz_grupe_wyjatek_test() {
        //given
        UtworzGrupeZapytanie req = new UtworzGrupeZapytanie();
        //when
        Mockito.when(grupaRepozytorium.save(any(Grupa.class))).thenThrow(new IllegalStateException("dupa"));
        UtworzGrupeOdpowiedz response = grupaSerwis.utworzGrupe(req);
        //then
        Assertions.assertNotNull(response);
        Assertions.assertEquals("dupa", response.getWynikWalidacji());
    }
}