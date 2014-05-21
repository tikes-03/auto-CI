/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package medrecappz.Services;

import medrecappz.Services.SpesialisService;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import java.sql.ResultSet;
import com.mysql.jdbc.Statement;
import java.util.ArrayList;
import medrecappz.TabelModel.TabelModelSpesialis;
import com.mysql.jdbc.Connection;
import java.util.List;
import medrecappz.Dao.SpesialisDao;
import medrecappz.Entity.Spesialis;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fachrul Pralienka BM
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class A_SpesialisServiceTest {

    private List<Spesialis> list;
    private Connection connection;
    private SpesialisService instance;
    private TabelModelSpesialis tabelModelSpesialis;
    private String ExpIdSpesialis;
    private String ExpNmSpesialis;
    private String ExpTarifKonsul;
    private Spesialis sp;
    private final String getAllSpesialis = "SELECT * FROM spesialis";

    public A_SpesialisServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        list = new ArrayList<Spesialis>();
        instance = new SpesialisService();
        tabelModelSpesialis = new TabelModelSpesialis();
        sp = new Spesialis();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void a_insertSpesialisNormal() {
        System.out.println("1. Insert Spesialis Normal");

        ExpIdSpesialis = "Sp.Mt";
        ExpNmSpesialis = "Spesialis Mata";
        ExpTarifKonsul = "70000";

        sp.setIdSpesialis(ExpIdSpesialis);
        sp.setNmSpesialis(ExpNmSpesialis);
        sp.setTarifKonsul(ExpTarifKonsul);
        instance.serviceInsertSpesialis(sp);

        tabelModelSpesialis.setData(instance.serviceGetAllSpesialisById(ExpIdSpesialis));
        assertEquals(ExpIdSpesialis, tabelModelSpesialis.getValueAt(0, 1));
        assertEquals(ExpNmSpesialis, tabelModelSpesialis.getValueAt(0, 2));
        assertEquals(ExpTarifKonsul, tabelModelSpesialis.getValueAt(0, 2));
    }

    @Test
    public void b_insertSpesialisKosong() {
        System.out.println("2. Insert Spesialis Kosong");

        ExpIdSpesialis = "";
        ExpNmSpesialis = "";
        ExpTarifKonsul = "";

        sp.setIdSpesialis(ExpIdSpesialis);
        sp.setNmSpesialis(ExpNmSpesialis);
        sp.setTarifKonsul(ExpTarifKonsul);
        instance.serviceInsertSpesialis(sp);
        assertNotEquals("ok", SpesialisDao.hasilInsert);
    }

    @Test
    public void c_insertSpesialisIdKosong() {
        System.out.println("3. Insert Spesialis Id Kosong");

        ExpIdSpesialis = "";
        ExpNmSpesialis = "asdasd";
        ExpTarifKonsul = "9000";

        sp.setIdSpesialis(ExpIdSpesialis);
        sp.setNmSpesialis(ExpNmSpesialis);
        sp.setTarifKonsul(ExpTarifKonsul);
        instance.serviceInsertSpesialis(sp);
        assertNotEquals("ok", SpesialisDao.hasilInsert);
    }

    @Test
    public void d_insertSpesialisNmKosong() {
        System.out.println("4. Insert Spesialis Nama Kosong");

        ExpIdSpesialis = "SP003";
        ExpNmSpesialis = "";
        ExpTarifKonsul = "9000";

        sp.setIdSpesialis(ExpIdSpesialis);
        sp.setNmSpesialis(ExpNmSpesialis);
        sp.setTarifKonsul(ExpTarifKonsul);
        instance.serviceInsertSpesialis(sp);
        assertNotEquals("ok", SpesialisDao.hasilInsert);
    }

    @Test
    public void e_insertSpesialisTarifKosong() {
        System.out.println("5. Insert Spesialis Tarif Kosong");

        ExpIdSpesialis = "SP003";
        ExpNmSpesialis = "Mata-mata";
        ExpTarifKonsul = "";

        sp.setIdSpesialis(ExpIdSpesialis);
        sp.setNmSpesialis(ExpNmSpesialis);
        sp.setTarifKonsul(ExpTarifKonsul);
        instance.serviceInsertSpesialis(sp);
        assertNotEquals("ok", SpesialisDao.hasilInsert);
    }

    @Test
    public void f_insertSpesialisIdLebih() {
        System.out.println("6. Insert Spesialis Id Lebih");

        ExpIdSpesialis = "abcdefghijk";
        ExpNmSpesialis = "Mata-mata";
        ExpTarifKonsul = "90000";

        sp.setIdSpesialis(ExpIdSpesialis);
        sp.setNmSpesialis(ExpNmSpesialis);
        sp.setTarifKonsul(ExpTarifKonsul);
        instance.serviceInsertSpesialis(sp);
        assertNotEquals("ok", SpesialisDao.hasilInsert);
    }

    @Test
    public void g_insertSpesialisNmLebih() {
        System.out.println("7. Insert Spesialis Nama Lebih");

        ExpIdSpesialis = "abcdefghij";
        ExpNmSpesialis = "UdinUdinUdinUdinUdinUdinUdinUdinUdinUdinUdinxx";
        ExpTarifKonsul = "90000";

        sp.setIdSpesialis(ExpIdSpesialis);
        sp.setNmSpesialis(ExpNmSpesialis);
        sp.setTarifKonsul(ExpTarifKonsul);
        instance.serviceInsertSpesialis(sp);
        assertNotEquals("ok", SpesialisDao.hasilInsert);
    }

    @Test
    public void h_insertSpesialisTarifLebih() {
        System.out.println("8. Insert Spesialis Tarif Lebih");

        ExpIdSpesialis = "abcdefghij";
        ExpNmSpesialis = "UdinUdinUdinUdinUdinUdinUdinUdinUdinUdinUdin";
        ExpTarifKonsul = "123456789011";

        sp.setIdSpesialis(ExpIdSpesialis);
        sp.setNmSpesialis(ExpNmSpesialis);
        sp.setTarifKonsul(ExpTarifKonsul);
        instance.serviceInsertSpesialis(sp);
        assertNotEquals("ok", SpesialisDao.hasilInsert);
    }

    @Test
    public void i_insertSpesialisTarifKacau() {
        System.out.println("9. Insert Spesialis Tarif Kacau");

        ExpIdSpesialis = "abcdefghij";
        ExpNmSpesialis = "UdinUdinUdinUdinUdinUdinUdinUdinUdinUdinUdin";
        ExpTarifKonsul = "123as45/6*78";
        //ExpTarifKonsul = "123.78";

        sp.setIdSpesialis(ExpIdSpesialis);
        sp.setNmSpesialis(ExpNmSpesialis);
        sp.setTarifKonsul(ExpTarifKonsul);
        instance.serviceInsertSpesialis(sp);
        assertNotEquals("ok", SpesialisDao.hasilInsert);
    }

    @Test
    public void j_insertSpesialisDuplikasi() {
        System.out.println("10. Insert Spesialis Duplikasi");

        ExpIdSpesialis = "Sp.Mt";
        ExpNmSpesialis = "Spesialis Mata";
        ExpTarifKonsul = "70000";

        sp.setIdSpesialis(ExpIdSpesialis);
        sp.setNmSpesialis(ExpNmSpesialis);
        sp.setTarifKonsul(ExpTarifKonsul);
        instance.serviceInsertSpesialis(sp);
        assertNotEquals("ok", SpesialisDao.hasilInsert);
    }

    @Test
    public void k_updateSpesialisNormal() {
        System.out.println("11. Update Spesialis Normal");

        ExpIdSpesialis = "Sp.Mt";
        ExpNmSpesialis = "Spesialis Penyakit Mata";
        ExpTarifKonsul = "75000";

        sp.setNmSpesialis(ExpNmSpesialis);
        sp.setTarifKonsul(ExpTarifKonsul);
        instance.serviceUpdateSpesialis(sp, ExpIdSpesialis);

        tabelModelSpesialis.setData(instance.serviceGetAllSpesialisById(ExpIdSpesialis));
        assertEquals(ExpIdSpesialis, tabelModelSpesialis.getValueAt(0, 0));
        assertEquals(ExpNmSpesialis, tabelModelSpesialis.getValueAt(0, 1));
        assertEquals(ExpTarifKonsul, tabelModelSpesialis.getValueAt(0, 2));
    }

    @Test
    public void l_updateSpesialisKosong() {
        System.out.println("12. Update Spesialis Kosong");

        ExpIdSpesialis = "Sp.Mt";
        ExpNmSpesialis = "";
        ExpTarifKonsul = "";

        sp.setNmSpesialis(ExpNmSpesialis);
        sp.setTarifKonsul(ExpTarifKonsul);
        instance.serviceUpdateSpesialis(sp, ExpIdSpesialis);
        assertNotEquals("ok", SpesialisDao.hasilUpdate);
    }

    @Test
    public void m_deleteSpesialisNormal() {
        System.out.println("13. Delete Spesialis Normal");

        ExpIdSpesialis = "Sp.Mt";
        instance.serviceDeleteSpesialis(ExpIdSpesialis);

        tabelModelSpesialis.setData(instance.serviceGetAllSpesialisById(ExpIdSpesialis));
        assertEquals(0, tabelModelSpesialis.getRowCount());
    }

    @Test
    public void n_getAllSpesialisNormal() {
        System.out.println("14. Get All Spesialis Normal");

        tabelModelSpesialis.setData(instance.serviceGetAllSpesialis());

        try{
            Statement stt = (Statement) connection.createStatement();
            ResultSet rs = stt.executeQuery(getAllSpesialis);
            while(rs.next()){
                sp.setIdSpesialis(rs.getString("id_spesialis"));
                sp.setNmSpesialis(rs.getString("nm_spesialis"));
                sp.setTarifKonsul(rs.getString("tarif_konsul"));
                list.add(sp);
            }
            rs.close();
            stt.close();
        }catch(Throwable t){
            // Sengaja dikosongin
        }

        for(int i=0; i<list.size(); i++){
            assertEquals(list.get(i).getIdSpesialis(), tabelModelSpesialis.getValueAt(i, 0));
            assertEquals(list.get(i).getNmSpesialis(), tabelModelSpesialis.getValueAt(i, 1));
            assertEquals(list.get(i).getTarifKonsul(), tabelModelSpesialis.getValueAt(i, 2));
        }
    }

}