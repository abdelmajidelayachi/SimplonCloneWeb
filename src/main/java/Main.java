import com.simplonclone.simploncloneweb.DAO.GenericDOAImpl;
import com.simplonclone.simploncloneweb.entity.AdminsEntity;

public class Main {
    public static void main(String[] args) {
        AdminsEntity admin = new AdminsEntity();
        admin.setFirstName("Abdelmajid");
        admin.setLastName("El Ayachi");
        admin.setEmail("elayachiabdel2001@gmail.com");
        admin.setPassword("adminP123");
        System.out.println(new GenericDOAImpl<AdminsEntity>().get(AdminsEntity.class,17).getFirstName());
    }
}
