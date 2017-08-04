package ro.teamnet.zerotohero.Proiect.Zoo;

import java.util.Date;

/**
 * Created by Alexandra.Traila on 7/28/2017.
 */
public class GradinaZoo {
   private final String denumireGradinaZoo;
    private final  Date dataDeschideriiGradinii;
    private final AnimalZooRar animalRar;
    private final IngrijitorZoo angajatulLunii;

    public GradinaZoo(String denumireGradinaZoo,Date dataDeschideriiGradinii,AnimalZooRar animalRar,IngrijitorZoo angajatulLunii)
    {
        this.denumireGradinaZoo=denumireGradinaZoo;
        this.dataDeschideriiGradinii=dataDeschideriiGradinii;
        this.animalRar=animalRar;
        this.angajatulLunii=angajatulLunii;
    }

    public String getDenumire()
    {
        return this.denumireGradinaZoo;
    }

    public Date getDataDeschideriiGradinii()
    {
        return this.dataDeschideriiGradinii;
    }

    public AnimalZooRar getAnimalRar()
    {
        return this.animalRar;
    }

    public IngrijitorZoo getAngajatulLunii()
    {
        return this.angajatulLunii;
    }
    /*Sa se creeze clasa GradinaZoo , cu urmatoarele campuri:
-	String : denumireGradinaZoo;
-	Date: dataDeschideriiGradinii;
-	AnimalZooRar : animalRar;
-	IngrijitorAnimale: angajatulLunii;
Sa se particularizeze clasa GradinaZoo pentru a fi immutabila. ATENTIE la campurile care sunt mutabile.
*/
}
