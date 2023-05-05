package dao;

import java.util.List;

import registro.Horarios;

public interface DaoHorario {

    public List<Horarios> HorariosSel();
    
    public Horarios HorariosGet(Integer id);

    public String HorariosIns(Horarios Horarios);

    public String HorariosUpd(Horarios Horarios);

    public String HorariosDel(List<Integer> ids);

    public String getMessage();
}
