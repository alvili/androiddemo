package com.abcsoft.medicdata.model;

import java.util.Date;
import java.util.List;

//Lista de las funcionalidades que deseo disponer
public interface LecturaServices {

    public Lectura create(Lectura lectura);
    public Lectura read(Integer codigo);
    public Lectura update(Lectura lectura);
    public boolean delete(Lectura lectura);

    public List<Lectura> getAll();
    public List<Lectura> getBetweenDates(Date fecha1, Date fecha2);
}
