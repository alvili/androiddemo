package com.abcsoft.medicdata.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LecturaServicesImpl implements LecturaServices {

    private static final Map<Integer,Lectura> LECTURAS;

    private static final LecturaServicesImpl INSTANCE = new LecturaServicesImpl();

    static{

        LECTURAS = new TreeMap<>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Date fecha0 = null;
        Date fecha1 = null;
        Date fecha2 = null;
        Date fecha3 = null;
        Date fecha4 = null;
        Date fecha5 = null;
        Date fecha6 = null;
        Date fecha7 = null;
        Date fecha8 = null;
        Date fecha9 = null;

        try { //parse tiene numeros de fallar, es necesario envolverlo con un try catch
            fecha0 = sdf.parse("01/01/2019 01:20:10");
            fecha1 = sdf.parse("02/01/2019 12:23:35");
            fecha2 = sdf.parse("03/01/2019 09:17:36");
            fecha3 = sdf.parse("04/01/2019 23:22:19");
            fecha4 = sdf.parse("05/01/2019 12:48:41");
            fecha5 = sdf.parse("06/01/2019 11:20:31");
            fecha6 = sdf.parse("07/01/2019 16:38:25");
            fecha7 = sdf.parse("08/01/2019 17:20:37");
            fecha8 = sdf.parse("09/01/2019 22:20:12");
            fecha9 = sdf.parse("10/01/2019 10:23:41");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Lectura l0 = new Lectura(fecha0,97.6,91.2,105.3,2.1589,41.3888);
        Lectura l1 = new Lectura(fecha1,97.3,90.2,105.3,2.1589,41.3888);
        Lectura l2 = new Lectura(fecha2,97.7,89.2,105.3,2.1589,41.3888);
        Lectura l3 = new Lectura(fecha3,96.9,88.2,105.3,2.1589,41.3888);
        Lectura l4 = new Lectura(fecha4,95.6,91.2,105.3,2.1589,41.3888);
        Lectura l5 = new Lectura(fecha5,96.6,91.2,105.3,2.1589,41.3888);
        Lectura l6 = new Lectura(fecha6,97.1,91.2,105.3,2.1589,41.3888);
        Lectura l7 = new Lectura(fecha7,97.2,91.2,105.3,2.1589,41.3888);
        Lectura l8 = new Lectura(fecha8,96.9,91.2,105.3,2.1589,41.3888);
        Lectura l9 = new Lectura(fecha9,97.1,91.2,105.3,2.1589,41.3888);


        l0.setCodigo(100);
        l1.setCodigo(101);
        l2.setCodigo(102);
        l3.setCodigo(103);
        l4.setCodigo(104);
        l5.setCodigo(105);
        l6.setCodigo(106);
        l7.setCodigo(107);
        l8.setCodigo(108);
        l9.setCodigo(109);

        LECTURAS.put(l0.getCodigo(),l0);
        LECTURAS.put(l1.getCodigo(),l1);
        LECTURAS.put(l2.getCodigo(),l2);
        LECTURAS.put(l3.getCodigo(),l3);
        LECTURAS.put(l4.getCodigo(),l4);
        LECTURAS.put(l5.getCodigo(),l5);
        LECTURAS.put(l6.getCodigo(),l6);
        LECTURAS.put(l7.getCodigo(),l7);
        LECTURAS.put(l8.getCodigo(),l8);
        LECTURAS.put(l9.getCodigo(),l9);

    }

    private LecturaServicesImpl(){

    }

    public static LecturaServicesImpl getInstance(){
        return INSTANCE;
    }

    @Override
    public Lectura create(Lectura lectura) {
        //La nueva lectura no tiene código
        Integer maxCode = ((TreeMap<Integer,Lectura>) LECTURAS).lastKey();  //LECTURAS creada com a Map, la casteo para tener acceso al metode lastKey, propio del TreeMap
        Integer newCode = maxCode++;
        lectura.setCodigo(newCode);

        return LECTURAS.put(newCode, lectura);
    }

    @Override
    public Lectura read(Integer codigo) {
        return LECTURAS.get(codigo);
    }

    @Override
    public Lectura update(Lectura lectura) {
        //Tiene que llegar una lectura con código
        if (lectura.getCodigo() == null || !LECTURAS.containsKey(lectura.getCodigo())){
            throw new IllegalArgumentException("No existe, no se puede actualizar");
        }
        return LECTURAS.put(lectura.getCodigo(),lectura);
    }

    /*
    @Override
    public boolean delete(Integer codigo) {
        //return LECTURAS.remove(codigo) == null ? false: true;
        Lectura lectura = LECTURAS.remove (codigo);
        //Si remove falla , lectura es null
        //si lectura es null he de devolver false...
        return (lectura == null) ? false : true;
    }
*/

    @Override
    public boolean delete(Integer codigo) {
        Lectura lectura = LECTURAS.remove(codigo);
        // se remove falla, lectura es null.
        // si lectura es null he de devolver false...
        return true;
    }

    @Override
    public List<Lectura> getAll() {
        return new ArrayList<Lectura>(LECTURAS.values());
    }

    @Override
    public List<Lectura> getBetweenDates(Date fecha1, Date fecha2) {
        List<Lectura> lecturas = new ArrayList<>();

        for(Lectura lectura:getAll()){
            if (lectura.getFechaHora().after(fecha1) && lectura.getFechaHora().before(fecha2)){
                lecturas.add(lectura);
            }
        }
        return lecturas;
    }

}
