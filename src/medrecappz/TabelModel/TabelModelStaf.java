/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package medrecappz.TabelModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import medrecappz.Entity.Staf;

/**
 *
 * @author YUANITA
 */
public class TabelModelStaf extends AbstractTableModel{

    public List<Staf> list = new ArrayList<Staf>();

    public void setData(List<Staf>listStaf){
        this.list = listStaf;
        fireTableDataChanged();
    }

    public Staf getStaf(int i){
        return list.get(i);
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "No. Staf";
            case 1:
                return "Nama Staf";
            case 2:
                return "Alamat";
        }
        return null;
    }
    public int getRowCount() {
        return list.size();
    }

    public int getColumnCount() {
        return 3;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getNoStaf();
            case 1:
                return list.get(rowIndex).getNmStaf();
            case 2:
                return list.get(rowIndex).getAlamatStaf();
            default:
                return null;
        }
    }

}
