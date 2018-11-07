package Entity;

import javax.swing.JTable;

public interface MainData {

    public void add();

    public void update();

    public void delete();

    public String getAutoNumber();

    public void getAllRows(JTable table);

    public void getOneRows(JTable table);

    public void getCustomRows(String statment, JTable table);

    public String getValueByName(String name);

    public String getNameByValue(String value);

    public void add2();

    public void update2();

    public void delete2();

    public String getAutoNumber2();

    public void getAllRows2(JTable table);

    public void getOneRows2(JTable table);

    public void getCustomRows2(String statment, JTable table);

    public String getValueByName2(String name);

    public String getNameByValue2(String value);
    

}
