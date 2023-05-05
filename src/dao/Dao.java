package dao;

import java.util.List;

import registro.TablaMatricula;

public interface Dao {

    public List<TablaMatricula> TablaMatriculaSel();

    public TablaMatricula TablaMatriculaGet(Integer id);

    public String TablaMatriculaIns(TablaMatricula TablaMatricula);

    public String TablaMatriculaUpd(TablaMatricula TablaMatricula);

    public String TablaMatriculaDel(List<Integer> ids);

    public String getMessage();

}
