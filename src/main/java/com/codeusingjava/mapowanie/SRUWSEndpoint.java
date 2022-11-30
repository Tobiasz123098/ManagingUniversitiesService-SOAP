package com.codeusingjava.mapowanie;

import com.codeusingjava.prowadzacy.repozytoria.ProwadzacyRepozytorium;
import com.codeusingjava.prowadzacy.serwisy.ProwadzacySerwis;
import com.codeusingjava.uniwersytet.serwisy.UniwersytetSerwis;
import com.sruuniwersytet.DodajProwadzacegoDoUniwersytetuOdpowiedz;
import com.sruuniwersytet.DodajProwadzacegoDoUniwersytetuZapytanie;
import com.sruuniwersytet.UtworzUniwersytetOdpowiedz;
import com.sruuniwersytet.UtworzUniwersytetZapytanie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class SRUWSEndpoint {

    private static final String NAMESPACE_URI = "http://sruuniwersytet.com";

    private final UniwersytetSerwis uniwersytetSerwis;
    private final ProwadzacySerwis prowadzacySerwis;
    @Autowired
    public SRUWSEndpoint(UniwersytetSerwis uniwersytetSerwis, ProwadzacySerwis prowadzacySerwis) {
        this.uniwersytetSerwis = uniwersytetSerwis;
        this.prowadzacySerwis = prowadzacySerwis;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "utworzUniwersytetZapytanie")
    @ResponsePayload
    public UtworzUniwersytetOdpowiedz utworzUniwersytet(@RequestPayload UtworzUniwersytetZapytanie req){
        return uniwersytetSerwis.utworzUniwersytet(req);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "dodajProwadzacegoDoUniwersytetuZapytanie")
    @ResponsePayload
    public DodajProwadzacegoDoUniwersytetuOdpowiedz dodajProwadzacegoDoUniwersytetu(@RequestPayload DodajProwadzacegoDoUniwersytetuZapytanie req) {
        return prowadzacySerwis.dodajProwadzacegoDoUniwersytetu(req);
    }
}
