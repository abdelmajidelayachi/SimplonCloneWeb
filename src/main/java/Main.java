import com.simplonclone.simploncloneweb.DAO.GenericDOAImpl;
import com.simplonclone.simploncloneweb.entity.AdminsEntity;

import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GenericDOAImpl<AdminsEntity> adminsEntityGenericDOA = new GenericDOAImpl<>();
        String jpaQuery = "SELECT a FROM AdminsEntity a WHERE a.email = ?1 and a.password = ?2" ;
        HashMap<String , Object> params = new HashMap<>();
        params.put("email","a@gmail.com");
        params.put("password","admin");
        params.forEach((k,v)->{
           System.out.println("Key: "+k+" Value: "+v);
       });
        List<AdminsEntity> admin  = adminsEntityGenericDOA.query(AdminsEntity.class, jpaQuery, params);

        System.out.println(admin.get(0).getIdAdmin());
    }
}
