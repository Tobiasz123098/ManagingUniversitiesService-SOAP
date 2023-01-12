package com.codeusingjava.index;

import com.codeusingjava.grupa.domena.Grupa;
import com.codeusingjava.grupa.repozytoria.GrupaRepozytorium;
import com.codeusingjava.index.domena.Index;
import com.codeusingjava.index.repozytoria.IndexRepozytorium;
import com.codeusingjava.index.serwisy.IndexSerwis;
import com.sruuniwersytet.DodajIndexDoGrupyOdpowiedz;
import com.sruuniwersytet.DodajIndexDoGrupyZapytanie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
public class IndexSerwisTest {

    @InjectMocks
    private IndexSerwis indexSerwis;

    @Mock
    private IndexRepozytorium indexRepozytorium;

    @Mock
    private GrupaRepozytorium grupaRepozytorium;

    @Test
    void dodaj_index_do_grupy_test() {
        //given
        Index index = new Index();
        index.setId(2L);
        String msg = "Dodano index do grupy";
        DodajIndexDoGrupyZapytanie req = new DodajIndexDoGrupyZapytanie();

        //when
        Mockito.when(indexRepozytorium.save(any(Index.class))).thenReturn(index);
        Mockito.when(indexRepozytorium.findOne(anyLong())).thenReturn(new Index());
        //then
        DodajIndexDoGrupyOdpowiedz res = indexSerwis.dodajIndexDoGrupy(req);

        Assertions.assertNotNull(res);
        Assertions.assertEquals(msg, res.getWynikWalidacji());
    }

    @Test
    void dodaj_index_do_grupy_wyjatek_test() {
        //given
        DodajIndexDoGrupyZapytanie req = new DodajIndexDoGrupyZapytanie();
        //when
        Mockito.when(indexRepozytorium.save(any(Index.class))).thenThrow(new IllegalStateException("dupa"));
        Mockito.when(indexRepozytorium.findOne(anyLong())).thenReturn(new Index());
        Mockito.when(grupaRepozytorium.findOne(anyLong())).thenReturn(new Grupa());

        //then
        DodajIndexDoGrupyOdpowiedz res = indexSerwis.dodajIndexDoGrupy(req);

        Assertions.assertNotNull(res);
        Assertions.assertEquals("dupa", res.getWynikWalidacji());
    }
}
