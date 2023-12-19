package Service;

import entity.Afdeling;
import entity.Functie;
import entity.Werknemer;
import entity.WerknemerDetail;

import java.time.LocalDate;

public class CreateDateService {
    static AfdelingService afdelingService = new AfdelingService();
    static FunctieService functieService = new FunctieService();
    static DetailService werknemerDetailService = new DetailService();

    static WerknemerService werknemerService = new WerknemerService();

    public static void CreateData(){





        Afdeling afdeling1 = new Afdeling();
        afdeling1.setAfdelingNaam("Frontdesk");
        Afdeling fd = afdelingService.createAfdeling(afdeling1);

        Afdeling afdeling2 = new Afdeling();
        afdeling2.setAfdelingNaam("Finance");
        Afdeling fin = afdelingService.createAfdeling(afdeling2);

        Afdeling afdeling3 = new Afdeling();
        afdeling3.setAfdelingNaam("Marketing");
        Afdeling mark = afdelingService.createAfdeling(afdeling3);

        Afdeling afdeling4 = new Afdeling();
        afdeling4.setAfdelingNaam("Hrm");
        Afdeling hrm = afdelingService.createAfdeling(afdeling4);

        Afdeling afdeling5 = new Afdeling();
        afdeling5.setAfdelingNaam("Magazijn");
        Afdeling mag = afdelingService.createAfdeling(afdeling5);

        Afdeling afdeling6 = new Afdeling();
        afdeling6.setAfdelingNaam("Sales");
        Afdeling sale = afdelingService.createAfdeling(afdeling6);
//--------------------------------------------------------------------

        Functie functie1 = new Functie();
        functie1.setFunctieType("Directeur");
        functie1.setAfdeling(fin);
        Functie dirfin = functieService.createFunctie(functie1);

        Functie functie2 = new Functie();
        functie2.setFunctieType("Onder-Directeur");
        functie2.setAfdeling(fin);
        Functie odfin = functieService.createFunctie(functie2);

        Functie functie3 = new Functie();
        functie3.setFunctieType("Assistent");
        functie3.setAfdeling(fin);
        Functie assfin = functieService.createFunctie(functie3);

        Functie functie4 = new Functie();
        functie4.setFunctieType("Assistent");
        functie4.setAfdeling(mark);
        Functie assmark = functieService.createFunctie(functie4);

//--------------------------------------------------------------------------------

        Werknemer werknemer1 = new Werknemer();
        werknemer1.setIdNummer("FR001807");
        werknemer1.setVoorNamen("Dhiradj");
        werknemer1.setAchterNaam("Bechan");
        werknemer1.setGeboorteDatum(LocalDate.of(1999,5,24));
        werknemer1.setGeboortePlaats("Suriname");
        Werknemer w1 = werknemerService.createWerknemer(werknemer1);

        Werknemer werknemer2 = new Werknemer();
        werknemer2.setIdNummer("FR001657");
        werknemer2.setVoorNamen("jason");
        werknemer2.setAchterNaam("Momoa");
        werknemer2.setGeboorteDatum(LocalDate.of(1964,8,8));
        werknemer2.setGeboortePlaats("USA");
        Werknemer w2 = werknemerService.createWerknemer(werknemer2);

        Werknemer werknemer3 = new Werknemer();
        werknemer3.setIdNummer("FE005487");
        werknemer3.setVoorNamen("Arijit");
        werknemer3.setAchterNaam("Singh");
        werknemer3.setGeboorteDatum(LocalDate.of(1987,9,14));
        werknemer3.setGeboortePlaats("India");
        Werknemer w3 = werknemerService.createWerknemer(werknemer3);


        Werknemer werknemer4 = new Werknemer();
        werknemer4.setIdNummer("FN003894");
        werknemer4.setVoorNamen("Peter");
        werknemer4.setAchterNaam("Parker");
        werknemer4.setGeboorteDatum(LocalDate.of(1991,10,4));
        werknemer4.setGeboortePlaats("Nederland");
        Werknemer w4 = werknemerService.createWerknemer(werknemer4);



        werknemer1.setWerknemerFunctie(assfin);
        werknemer1.setWerknemerFunctie(assmark);
        werknemer2.setWerknemerFunctie(assfin);
        assfin.setWerknemers(werknemer1);
        assfin.setWerknemers(werknemer2);
        assmark.setWerknemers(werknemer1);
//-----------------------------------------------------------------------------------------
        WerknemerDetail adres1 = new WerknemerDetail();
        adres1.setAdres("Ramdasstraat#14");
        adres1.setTelefoonNummer("8874555");
        adres1.setEmail("dbechan@hotmail.com");
        adres1.setWerknemerId(w1);
        werknemerDetailService.createWerknemerDetail(adres1);

        WerknemerDetail adres2 = new WerknemerDetail();
        adres2.setAdres("Oranjestraat#5");
        adres2.setTelefoonNummer("8958862");
        adres2.setEmail("jmomoa@hotmail.com");
        adres2.setWerknemerId(w2);
        werknemerDetailService.createWerknemerDetail(adres2);

        WerknemerDetail adres3 = new WerknemerDetail();
        adres3.setAdres("Paarsstraat#74");
        adres3.setTelefoonNummer("8612565");
        adres3.setEmail("asingh@hotmail.com");
        adres3.setWerknemerId(w3);
        werknemerDetailService.createWerknemerDetail(adres3);

        WerknemerDetail adres4 = new WerknemerDetail();
        adres4.setAdres("Groenstraat#34");
        adres4.setTelefoonNummer("8651652");
        adres4.setEmail("parker@hotmail.com");
        adres4.setWerknemerId(w4);
        werknemerDetailService.createWerknemerDetail(adres4);

//---------------------------------------------------------------------------------

        /*WerkUren werkUren1 = new WerkUren();
        werkUren1.setMaand("Januari");
        werkUren1.setAantalUren(21.5);
        werkUren1.setUurloon(150);
        werkUren1.setWerknemerId(w1);
        werkUrenService.addWerkUren(werkUren1);

        WerkUren werkUren2 = new WerkUren();
        werkUren2.setMaand("Februari");
        werkUren2.setAantalUren(55);
        werkUren2.setUurloon(150);
        werkUren2.setWerknemerId(w1);
        werkUrenService.addWerkUren(werkUren2);

        InlogWerknemer inlog1 = new InlogWerknemer();
        inlog1.setUsername("dbechan");
        inlog1.setPassword("Bechan1234");
        //inlog1.setWerknemerId(w1);
        inlogService.addInlogGegevens(inlog1);*/

    }
    public static void getInfo(){
        System.out.println(werknemerService.getWerknemers());
    }

}
